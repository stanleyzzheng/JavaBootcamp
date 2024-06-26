package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SimpleController {
	
	   @GetMapping("/login")
	    public String loginForm(Model model) {

	        model.addAttribute("mylogin", new LoginPOJO());
	        return "create-login";
	    }
		@GetMapping("/register")
		public String registerForm(Model model){
		   model.addAttribute("myRegister", new RegisterPOJO());
		   return "create-register";
		}

	    @PostMapping("/save-login")
	    public String saveLoginSubmission(Model model, LoginPOJO mylogin) {
	    	System.out.println(">>>>>> IN saveLoginSubmission");
	    	System.out.println(">>>>>> uname="+mylogin.getUname());
	    	System.out.println(">>>>>> pass ="+mylogin.getPassword());
	        // TODO: 
	    	model.addAttribute("mylogin", mylogin);
	        return "login-result";
	    }

		@PostMapping("/save-register")
	public String saveRegisterSubmission(Model model, RegisterPOJO myRegister){
		   model.addAttribute("myRegister", myRegister);
		   return "register-result";
		}

}
