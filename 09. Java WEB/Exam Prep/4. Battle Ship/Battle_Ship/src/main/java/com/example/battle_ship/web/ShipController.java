package com.example.battle_ship.web;

import com.example.battle_ship.model.binding.ShipAddBindingModel;
import com.example.battle_ship.model.entity.CategoryEntity;
import com.example.battle_ship.model.service.ShipServiceModel;
import com.example.battle_ship.model.service.UserServiceModel;
import com.example.battle_ship.service.CategoryService;
import com.example.battle_ship.service.ShipService;
import com.example.battle_ship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("ships")
public class ShipController {

    private final ShipService shipService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public ShipController(ShipService shipService, CategoryService categoryService,
                          UserService userService, ModelMapper modelMapper,
                          HttpSession httpSession) {
        this.shipService = shipService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String addShip(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "ship-add";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }

    @PostMapping("/add")
    public String addShipConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:add";
        }

        ShipServiceModel serviceModel = modelMapper.map(shipAddBindingModel, ShipServiceModel.class);

        CategoryEntity category = categoryService.findCategory(shipAddBindingModel.getCategory());
        UserServiceModel currentUser = modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);

        serviceModel.setCategory(category);

        shipService.addShip(serviceModel, userService.
                findByUserNameAndPassword(currentUser.getUsername(), currentUser.getPassword()));


        return "redirect:/";
    }
}
