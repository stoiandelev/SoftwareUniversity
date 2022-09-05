package com.example.shoppinglist.web;

import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import com.example.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());

        model.addAttribute("drinks",
                productService.findAllProductsByCategory(CategoryEnum.DRINK));

        model.addAttribute("foods",
                productService.findAllProductsByCategory(CategoryEnum.FOOD));

        model.addAttribute("households",
                productService.findAllProductsByCategory(CategoryEnum.HOUSEHOLD));

        model.addAttribute("others",
                productService.findAllProductsByCategory(CategoryEnum.OTHER));

        return "home";

//        return httpSession.getAttribute("user") == null
//                ? "index"
//                : "home";
    }


}
