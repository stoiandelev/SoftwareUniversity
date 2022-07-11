package com.example.xmlexercise;

import com.example.xmlexercise.model.dto.taskOneDto.ProductInRangeRootDto;
import com.example.xmlexercise.model.dto.categoriesSeeds.CategorySeedRootDto;
import com.example.xmlexercise.model.dto.productsSeeds.ProductSeedRootDto;
import com.example.xmlexercise.model.dto.taskTwoDto.SoldProductRootDto;
import com.example.xmlexercise.model.dto.usersSeeds.UserSeedRootDto;
import com.example.xmlexercise.service.CategoryService;
import com.example.xmlexercise.service.ProductService;
import com.example.xmlexercise.service.UserService;
import com.example.xmlexercise.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String RESOURCE_FILE_PATH = "src/main/resources/files/";
    private static final String CATEGORY_FILE_NAME = "categories.xml";
    private static final String USER_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/output/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
    private static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";


    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(XmlParser xmlParser,
                                 CategoryService categoryService,
                                 UserService userService,
                                 ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Select exercise: ");

        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exerciseNumber) {
            case 1 -> productsInRange();
            case 2 -> usersWithSoldProducts();

        }

    }

    private void usersWithSoldProducts() throws JAXBException {
        SoldProductRootDto soldProductRootDto = userService
                .findUserWithMoreThanOneProduct();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + SOLD_PRODUCTS_FILE_NAME,
                soldProductRootDto);

    }

    private void productsInRange() throws JAXBException {
        ProductInRangeRootDto productInRangeRootDto = productService
                .findProductInRangeWithNoBuyer();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME,
                productInRangeRootDto);
    }


    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + CATEGORY_FILE_NAME,
                            CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getEntityCount() == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + USER_FILE_NAME,
                            UserSeedRootDto.class);

            userService.seedUsers(userSeedRootDto.getUser());
        }

        if (productService.getEntityCount() == 0) {
            ProductSeedRootDto productSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + PRODUCTS_FILE_NAME,
                            ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());
        }


    }
}
