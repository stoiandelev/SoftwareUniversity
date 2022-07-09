package com.example.jsonexercise;

import com.example.jsonexercise.model.dto.ProductNameAndPriceDto;
import com.example.jsonexercise.model.dto.UserSoldDto;
import com.example.jsonexercise.service.CategoryService;
import com.example.jsonexercise.service.ProductService;
import com.example.jsonexercise.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/files/out/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.json";
    private static final String SUCCESSES_FULLY_SOLD_PRODUCT = "success-fully-soldProducts.json";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService,
                                 UserService userService,
                                 ProductService productService,
                                 Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        System.out.println("Enter exercise: ");
        int exNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exNumber) {
            case 1 -> productsInRange();
            case 2 -> SuccessfullySoldProducts();
        }
    }

    private void SuccessfullySoldProducts() throws IOException {
       List<UserSoldDto> userSoldDtos = userService
               .findAllUsersWithMoreThanOneSoldProducts();

       String content = gson.toJson(userSoldDtos);

       writeToFile(OUTPUT_FILE_PATH + SUCCESSES_FULLY_SOLD_PRODUCT, content);
    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productDtos = productService
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc
                        (BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(productDtos);

        writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME, content);
    }

    private void writeToFile(String filePath, String contentJSON) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(contentJSON));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
