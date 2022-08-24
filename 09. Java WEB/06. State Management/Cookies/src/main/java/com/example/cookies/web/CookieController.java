package com.example.cookies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    private static final String LANG_COOKIE_NAME = "lang";

    @GetMapping("/cookies")
    public String cookies(@CookieValue(name = "lang", defaultValue = "en")
                          String lang, Model model) {
        model.addAttribute(LANG_COOKIE_NAME, lang);
        return "cookies";
    }

    @PostMapping("/cookies")
    public String submitCookies(@RequestParam(name = "lang") String lang,
                                HttpServletResponse response) {

        Cookie langCookie = new Cookie(LANG_COOKIE_NAME, lang);
        response.addCookie(langCookie);

        System.out.println("Preferred user language is " + lang);
        return "redirect:/cookies";
    }

}
