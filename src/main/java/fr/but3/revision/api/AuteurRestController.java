package fr.but3.revision.api;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import fr.but3.revision.models.Auteur;
import fr.but3.revision.models.Livre;
import fr.but3.revision.repository.AuteurRepository;
import fr.but3.revision.repository.LivreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuteurRestController {
    @Autowired
    AuteurRepository auteurRepository;
    LivreRepository livreRepository;

    @GetMapping("/auteurs")
    private List<Auteur> getAll(){
        List<Auteur> auteurs = (List<Auteur>) auteurRepository.findAll();
        return auteurs;
    }

    @GetMapping("/livres")
    private List<Livre> getAllLivres(){
        List<Livre> livres = (List<Livre>) livreRepository.findAll();
        return livres;
    }

    @GetMapping("/auteurs/{id}")
    private Auteur getById(@RequestParam int id){
        Auteur auteur = auteurRepository.findById(id).orElse(null);
        return auteur;
    }

    @PostMapping("/auteurs")
    private Auteur addOneAuteur(@Valid @RequestBody Auteur auteur) {
        return auteurRepository.save(auteur);
    }

}
