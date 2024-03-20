package stanford.sp14springsecurity.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import stanford.sp14springsecurity.dto.UserDTO;
import stanford.sp14springsecurity.service.impl.UserServiceImpl;

@Controller
@Slf4j
public class UserController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private UserServiceImpl userDetailsService;

    @Autowired
    public UserController(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/")
    private String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("userDto", new UserDTO());
        return "sign-up";
    }

    @PostMapping("/signup-process")
    public String signupProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.warn("Wrong attempt");
            return "sign-up";
        }
        userDetailsService.create(userDTO);
        return "confirmation";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        log.info("Login page displayed");
        return "login";
    }

    @RequestMapping("/home")
    public String getHome() {
        log.info("home page displayed");
        return "home";
    }
}
