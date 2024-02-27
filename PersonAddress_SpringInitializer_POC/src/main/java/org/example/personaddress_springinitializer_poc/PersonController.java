package org.example.personaddress_springinitializer_poc;

import org.example.personaddress_springinitializer_poc.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @ModelAttribute("person") // Pre-populate form object
    public Person person() {
        return new Person();
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("person", person()); // Add pre-populated object
        return "person_form"; // Name of Thymeleaf template
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute Person person, Model model) {
        // Process submitted data, save if needed
        model.addAttribute("submittedPerson", person); // Add submitted object
        return "person_display"; // Name of Thymeleaf template with display
    }
}

