package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.binding.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUserConform(@Valid UserRegisterDTO userRegisterDTO,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:register";
        }

        //register User
        boolean isRegister= userService.registerUser(userRegisterDTO);

        if (!isRegister) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:register";
        }

        return "redirect:login";
    }
}



USERSERVICE METHOD

public boolean registerUser(UserRegisterDTO userRegisterDTO) {

        String username = userRegisterDTO.getUsername();
        String email = userRegisterDTO.getEmail();
        String password = userRegisterDTO.getPassword();
        String confirmPassword = userRegisterDTO.getConfirmPassword();

        //find by userName or Email
        if (userRepository.findByUsernameOrEmail(username, email).isPresent()) {
            return false;
        }

        if (!password.equals(confirmPassword)) {
            return false;
        }

        userRegisterDTO.setPassword(passwordEncoder.encode(userRegisterDTO.getConfirmPassword()));

        UserEntity newUser = modelMapper.map(userRegisterDTO, UserEntity.class);
        userRepository.save(newUser);

        initUserSession(newUser);

        return true;
}