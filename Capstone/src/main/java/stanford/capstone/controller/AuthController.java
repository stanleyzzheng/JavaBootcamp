package stanford.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

// Shows index page which is also the login page
    @GetMapping("/")
    private String showIndex(@RequestParam(name = "error", required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password");
        }
        return "login";
    }
}
