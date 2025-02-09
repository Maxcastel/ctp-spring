package fr.but3.revision.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/choix")
public class ChoixController {
    @GetMapping("/home")
    private String home(@RequestParam(defaultValue="World", required=false) String name ,
                        ModelMap modelmap){
        modelmap.put("cle",name);
        return "home";
    }
}
