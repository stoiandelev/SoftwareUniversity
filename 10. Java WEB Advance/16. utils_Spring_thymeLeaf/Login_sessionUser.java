package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.binding.UserLoginDTO;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String loginUser(Model model) {
        if (!model.containsAttribute("notFound")) {
            model.addAttribute("notFound", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginUserConf(@Valid UserLoginDTO userLoginDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:login";
        }

        boolean isLogin = userService.loginUser(userLoginDTO);

        if (!isLogin) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutUser(){
        userService.logoutUser();
        return "redirect:/";
    }
}



    USERSERVICE METHODS

    private void initUserSession(UserEntity userEntity) {
        userSession.setId(userEntity.getId());
        userSession.setUsername(userEntity.getUsername());
        userSession.setEmail(userEntity.getEmail());
    }


    public boolean loginUser(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //if no user in DB
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            return false;
        }

        //take the user properties
        UserEntity loginUser = optionalUser.get();
        if (!passwordEncoder.matches(password, loginUser.getPassword())) {
            return false;
        }

        initUserSession(loginUser);
        return true;
    }

    public void logoutUser() {
        userSession.setId(null);
        userSession.setUsername(null);
        userSession.setEmail(null);
    }