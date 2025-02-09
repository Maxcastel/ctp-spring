package fr.but3.revision.models;

// // import java.util.List;

// // import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
// // import jakarta.validation.constraints.Max;
// // import jakarta.validation.constraints.Min;
// // import jakarta.validation.constraints.NotNull;
// // import jakarta.validation.constraints.Size;
import lombok.Data;

// CORRECTION
// deux fois // // pour ce que j'ai mis en commentaire suite à la correction

@Entity
@Data
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @Column(nullable = false) // rajout (correction) 
    private String libelle;
    
    @Column(nullable = false) // rajout (correction) 
    private boolean statut;

    @Column(nullable = false) // rajout (correction) 
    private int nbChoix = 0;

    @ManyToOne
    @JoinColumn(name = "qno", nullable = false)
    private Question question;
}