
!!!SPRING SECURITY!!!

//first we implemetn in Service

package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileleUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // The purpose of this method is to map our user representation (UserEntity)
        // to the user presentation in the Spring Security world -> UserDetails
        // The only thing that will provide to us is the username.
        // The username will come from the HTML login form

        UserEntity userEntity = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with this email" + email + "not found!"));

        return mapToUserDetails(userEntity);
    }

    private static UserDetails mapToUserDetails(UserEntity userEntity) {
        
        // GrantedAuthority is the representation of the user role in the Spring world
        // SimpleGrantedAuthority is REQUIRED to be ROLE_ + role is an implementation of GrantedAuthority which spring provides
        // for our convenience
        // Out representation role is UserRoleEntity

        List<GrantedAuthority> authorities = userEntity
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().name()))
                .collect(Collectors.toList());
        
        // User is the Spring implementation of UserDetails interface.
        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                authorities
                );
    }
}


//second Application Security Configuration

package com.example.mobilele.conf;

import com.example.mobilele.model.enums.UserRoleEnum;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfiguration(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // with this line we allow access to all static resources.
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // with this line we allow access to the home, login and register page for everyone.
                .antMatchers("/", "/users/login", "/users/register").permitAll()
                // we permit page only for admin users
                .antMatchers("/statistics").hasRole(UserRoleEnum.ADMIN.name())
                // next we forbid all other pages for unauthenticated users
                .antMatchers("/**").authenticated()

                .and()
                // configure login with HTML form with two input fields
                .formLogin()
                // our login page is located at http://<serverAddress>:<port>/users/login
                .loginPage("/users/login")
                // this is the name of the <input...> in the login form where user enters her email/username
                // the value of this input will be presented to our User details service.
                // default value of this parameter is username
                //.usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .usernameParameter("email")
                // this is the name of the <input...> in the login form where user enters her password
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // The place where we should land in case that login is successfully
                .defaultSuccessUrl("/")
                // The place where we should land in case that login is unsuccessfully
                .failureForwardUrl("/users/login-error")

                .and()
                .logout()
                // This is the URL which Spring will implement for me and will log the user out
                .logoutUrl("/users/logout")
                // Where to go after log out
                .logoutSuccessUrl("/")
                // Remove the session from server
                .invalidateHttpSession(true)
                // Delete the cookie that references my session
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * This give Spring two important components.
         * 1. Our userDetails service, that translates username/email to UserDetails.
         * 2. Password Encoder the component that can decide if the user password matches.
         */
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}


//UserLoginController

package com.example.mobilele.web;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("users")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }


    @PostMapping("/login-error")
    public String failedLogin(
            @ModelAttribute
                    (UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
            String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("username", userName);

        return "redirect:login";
    }



//UserRegisterController

package com.example.mobilele.web;

import com.example.mobilele.model.dto.UserRegisterDTO;
import com.example.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDTO userRegisterDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:register";
        }

        userService.registerAndLogin(userRegisterDTO);

        return "redirect:/";
    }

    @ModelAttribute()
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }
}


//Methods for registerController with email for LOG!!!!

package com.example.mobilele.service.impl;

import com.example.mobilele.model.dto.UserRegisterDTO;
import com.example.mobilele.model.entity.UserEntity;
import com.example.mobilele.model.entity.RoleEntity;
import com.example.mobilele.model.enums.UserRoleEnum;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.repository.UserRoleRepository;
import com.example.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final MobileleUserServiceImpl mobileleUserService;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder,
                           MobileleUserServiceImpl mobileleUserService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mobileleUserService = mobileleUserService;
    }

    @Override
    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        RoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);

        UserEntity newUser = new UserEntity();

        newUser
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setRoles(Set.of(userRole))
                .setActive(true);

        userRepository.save(newUser);

        //this is Spring representation of user; principal is userDetails
        UserDetails principal = mobileleUserService.loadUserByUsername(newUser.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);
    }
}










