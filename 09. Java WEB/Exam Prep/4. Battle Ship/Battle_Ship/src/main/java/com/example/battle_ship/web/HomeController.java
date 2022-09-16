package com.example.battle_ship.web;

import com.example.battle_ship.model.binding.HomeBindingModel;
import com.example.battle_ship.model.service.UserServiceModel;
import com.example.battle_ship.model.view.ShipViewModel;
import com.example.battle_ship.service.ShipService;
import com.example.battle_ship.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public HomeController(ShipService shipService, UserService userService,
                          ModelMapper modelMapper, HttpSession httpSession) {
        this.shipService = shipService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        // for information for currentUser
        UserServiceModel user = modelMapper.map(httpSession.getAttribute("user"), UserServiceModel.class);

        UserServiceModel currentUser = userService
                .findByUserNameAndPassword(user.getUsername(), user.getPassword());

        List<ShipViewModel> allShip = shipService.findAllShips();

        model.addAttribute("currentUser", currentUser);

        model.addAttribute("attacker", allShip.stream().filter(s -> s.getUser().getId().equals(currentUser.getId()))
                .collect(Collectors.toList()));

        model.addAttribute("defender", allShip.stream().filter(s -> !s.getUser().getId().equals(currentUser.getId()))
                .collect(Collectors.toList()));

        model.addAttribute("allShip", allShip);

        return "home";
    }

    @PostMapping("/home")
    public String shipFight(@Valid HomeBindingModel homeBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeBindingModel", homeBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeBindingModel", bindingResult);
            return "redirect:/";
        }

        shipService.fight(homeBindingModel);

        return "redirect:/";
    }

    @ModelAttribute
    public HomeBindingModel homeBindingModel() {
        return new HomeBindingModel();
    }


}
