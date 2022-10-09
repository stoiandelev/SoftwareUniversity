package com.example.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/products/{id}/details")
    public String showProductDetails(@PathVariable String id) {
        //retrieve product from repository
        //productRepository.findById(id).orElseThrow(new ProductNotFoundException());
        throw new ProductNotFoundException("Product with id " + id + " was not found!");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleDbExceptions(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);

        return modelAndView;
    }


//When we use forlder error and inside 404.html, 500.html and etc.
//    @GetMapping("/products/{id}/error")
//    public String boom(@PathVariable String id) {
//        // i am doing something wrong here
//        throw new NullPointerException();
//    }


}
