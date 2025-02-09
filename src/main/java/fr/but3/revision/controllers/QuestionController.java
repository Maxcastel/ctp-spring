package fr.but3.revision.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;

import fr.but3.revision.models.Choix;
import fr.but3.revision.models.Question;
import fr.but3.revision.repository.ChoixRepository;
import fr.but3.revision.repository.QuestionRepository;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoixRepository choixRepository;

    @GetMapping("/activer")
    private String listeQuest(ModelMap modelMap){
        modelMap.put("questions",questionRepository.findAll());
        return "listeQuest";
    }

    @PostMapping("/activer")
    public String activerQuestion(@RequestParam int questionNum, ModelMap modelMap, Principal principal) {
        Optional<Question> questionToActiveOpt = questionRepository.findById(questionNum);

        List<Question> questions = questionRepository.findAll();

        if (!questionToActiveOpt.isPresent()) {
            modelMap.put("error", "La question numéro " + questionNum + " n'existe pas");
            modelMap.put("questions", questions);
            return "listeQuest";
        }
        
        for (Question question : questions) {
            question.setActive(false);
            for (Choix choix : question.getChoix()) {
                choix.setNbChoix(0);
                choixRepository.save(choix);
            }
            questionRepository.save(question); 
        }
        
        Question questionToActive = questionToActiveOpt.get();
        questionToActive.setActive(true);
        questionRepository.save(questionToActive);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loguedUserName = auth.getName();

        modelMap.addAttribute("loguedUserName", loguedUserName);
        modelMap.addAttribute("userViaPrincipal", principal.getName());
        modelMap.put("questions", questionRepository.findAll());
        modelMap.put("message", "La question <b>" + questionToActive.getLibelle() + "</b> vient d'être activée");

        return "listeQuest";
    }

    @PostMapping("/desactiver")
    public String desactiverQuestion(@RequestParam int questionNum, RedirectAttributes redirectAttributes) {
        Optional<Question> questionToDesactiveOpt = questionRepository.findById(questionNum);

        List<Question> questions = questionRepository.findAll();

        if (!questionToDesactiveOpt.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "La question numéro " + questionNum + " n'existe pas");
            return "redirect:/activer";
        }
        
        for (Question question : questions) {
            question.setActive(false);
            for (Choix choix : question.getChoix()) {
                choix.setNbChoix(0);
                choixRepository.save(choix);
            }
            questionRepository.save(question); 
        }

        redirectAttributes.addFlashAttribute("message", "La question <b>" + questionToDesactiveOpt.get().getLibelle() + "</b> vient d'être désactivée");

        return "redirect:/activer";
    }

    @GetMapping("/voter")
    private String showQuestion(ModelMap modelMap){
        Optional<Question> questionActiveOpt = questionRepository.findByActive(true);
        
        if (!questionActiveOpt.isPresent()) {
            modelMap.put("error", "Aucune question active");
            return "voter";
        }

        Question questionActive = questionActiveOpt.get();

        Optional<Choix> choixFromNotActiveQuestOpt = choixRepository.findFirstByQuestionNot(questionActive);
        
        if (!choixFromNotActiveQuestOpt.isPresent()) {
            modelMap.put("error", "Ce choix n'existe pas");
            return "voter";
        }

        modelMap.put("question", questionActive);
        modelMap.put("choix", questionActive.getChoix());
        modelMap.put("choixFromNotActiveQuest", choixFromNotActiveQuestOpt.get());

        return "voter";
    }

    @PostMapping("/voter")
    private String voteQuestion(@RequestParam int questionNum, @RequestParam int choixNum, ModelMap modelMap){
        Optional<Question> questionVoteOpt = questionRepository.findById(questionNum);

        if (!questionVoteOpt.isPresent()) {
            modelMap.put("error", "La question numéro " + questionNum + " n'existe pas");
            return "voter";
        }

        Question questionVote = questionVoteOpt.get();
        
        if (!questionVote.isActive()) {
            modelMap.put("error", "La question <b>" + questionVote.getLibelle() + "</b> n'est plus active");
            return "voter";
        }
        
        List<Choix> questionVoteChoix = questionVote.getChoix();

        Optional<Choix> userChoixOpt = choixRepository.findById(choixNum);
        if (!userChoixOpt.isPresent()) {
            modelMap.put("error", "Le choix numéro " + choixNum + " n'existe pas");
            return "voter";
        }

        Choix userChoix = userChoixOpt.get();

        if (!questionVoteChoix.contains(userChoix)) {
            modelMap.put("error", "Ce choix n'appartient pas à cette question");
            return "voter";
        }

        userChoix.setNbChoix(userChoix.getNbChoix() + 1);
        choixRepository.save(userChoix);

        modelMap.put("message", "Votre choix a bien été pris en compte !");
        return "voter";
    }

    @GetMapping("/voir")
    private String voirQuestion(@RequestParam int questionNum, ModelMap modelMap) {
        Optional<Question> questionOpt = questionRepository.findById(questionNum);

        if (!questionOpt.isPresent()) {
            modelMap.put("error", "La question n'existe pas");
            return "voir"; 
        }

        int nbVotesTotal = 0;
        int nbVotesCorrectTotal = 0;

        Question question = questionOpt.get();
        List<Choix> choix = question.getChoix();

        for (Choix c : choix) {
            nbVotesTotal += c.getNbChoix();
            if (c.isStatut()) {
                nbVotesCorrectTotal += c.getNbChoix();
            }
        }

        Double percentageCorrect = 0.0;
        if (nbVotesTotal > 0) {
            percentageCorrect = (double) nbVotesCorrectTotal / nbVotesTotal  * 100;
        } 

        modelMap.put("question", question);
        modelMap.put("choix", choix);
        modelMap.put("nbVotesTotal", nbVotesTotal);
        modelMap.put("percentageCorrect", percentageCorrect);

        return "voir";
    }

}
