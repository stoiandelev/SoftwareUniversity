package hiberspring.service.impl;

import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.ProductSeedRootDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;
import static hiberspring.common.GlobalConstants.PRODUCTS_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final BranchService branchService;


    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper,
                              ValidationUtil validationUtil,
                              XmlParser xmlParser,
                              BranchService branchService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
    }

    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files
                .readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

//        ProductSeedRootDto productSeedRootDto = xmlParser
//                .fromFile(PRODUCTS_FILE_PATH, ProductSeedRootDto.class);

        xmlParser
                .fromFile(PRODUCTS_FILE_PATH, ProductSeedRootDto.class)
                .getProducts()
                .stream()
                .filter(productSeedDto -> {
                    boolean isValid = validationUtil.isValid(productSeedDto);
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Product %s.",
                                    productSeedDto.getName())
                                    : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);

                    Branch branch = branchService.getBranchByName(productSeedDto.getBranch());
                    product.setBranch(branch);

                    return product;
                })
                .forEach(productRepository::save);


        return sb.toString();
    }
}
