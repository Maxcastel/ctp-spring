package fr.but3.revision.controllers;

import fr.but3.revision.models.Auteur;
import fr.but3.revision.repository.AuteurRepository;
import fr.but3.revision.repository.QuestionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class AuteurController {
    @Autowired
    private AuteurRepository repository;

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(value = "/listeAuteur",method = RequestMethod.GET)
    private String listeAuteur(ModelMap modelMap){
        modelMap.put("auteurs",repository.findAll());
        return "listeAuteur";
    }

    @RequestMapping(value = "/activer",method = RequestMethod.GET)
    private String listeQuest(ModelMap modelMap){
        modelMap.put("questions",questionRepository.findAll());
        return "listeQuest";
    }

    // @RequestMapping(value = "/voir",method = RequestMethod.GET)
    // private String voir(ModelMap modelMap){
    //     modelMap.put("questions",questionRepository.findAll());
    //     return "listeQuest";
    // }

    @RequestMapping(value = "/changeStatut",method = RequestMethod.GET)
    private String changeStatut(ModelMap modelMap){
        modelMap.put("questions",questionRepository.findAll());
        return "listeQuest";
    }

    // @RequestMapping(value = "/activer",method = RequestMethod.GET)
    // private String listeAuteurs(ModelMap modelMap){
    //     modelMap.put("questions",questionRepository.findAll());
    //     return "listeQuest";
    // }

    @RequestMapping(value = "/addAuteur",method = RequestMethod.GET)
    private String auteurForm(){
        return "auteurForm";
    }

    @RequestMapping(value = "/pushAuteur",method = RequestMethod.POST)
    private String addAuteur(@Valid Auteur auteur, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("error", Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            return "redirect:/addAuteur";
        }

        repository.save(auteur);
        return "redirect:/listeAuteur";
    }

    // // Méthode pour traiter la soumission du formulaire
    // @RequestMapping(value = "/pushAuteur", method = RequestMethod.POST)
    // public String pushAuteur(@ModelAttribute Auteur auteur, BindingResult bindingResult) {
    //     if (bindingResult.hasErrors()) {
    //         // Retourner à la page de formulaire avec erreurs
    //         return "auteurForm";
    //     }

    //     repository.save(auteur);
    //     // Traitez l'objet auteur ici (par exemple, enregistrez-le dans la base de données)
    //     System.out.println("Auteur ajouté : " + auteur.getNom() + " " + auteur.getPrenom());
        
    //     // Redirigez vers une autre page ou retournez un message de succès
    //     return "redirect:/listeAuteur";  // Exemple : redirection vers une page d'accueil
    // }

}
