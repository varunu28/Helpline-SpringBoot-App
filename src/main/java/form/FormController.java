package form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("case", new Case());
        return "case";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute Case caseReceived) {
        return "result";
    }
}
