package com.example.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {

    @GetMapping("/orders/{id}/details")
    public String showProductDetails(@PathVariable String id) {
        //retrieve product from repository
        //productRepository.findById(id).orElseThrow(new ProductNotFoundException());
        throw new ObjectNotFoundException("Object with id " + id + " was not found!");
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleDbExceptions(ObjectNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);

        return modelAndView;
    }



}
