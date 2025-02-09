package fr.but3.revision.models;

import java.util.List;

// // import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
// // import jakarta.validation.constraints.Max;
// // import jakarta.validation.constraints.Min;
// // import jakarta.validation.constraints.NotNull;
// // import jakarta.validation.constraints.Size;
import lombok.Data;
// // import lombok.Setter;

// CORRECTION
// deux fois // // pour ce que j'ai mis en commentaire suite à la correction

@Entity
@Data
// // @Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qno;

    @Column(nullable = false) // rajout (correction) 
    private String libelle;
    
    @Column(nullable = false) // rajout (correction) 
    private boolean active = false;

    // // public String getStatus(){
    // //     return active ? "active" : "non active";
    // // }

    // // public String getLibelle(){
    // //     return libelle;
    // // }

    // public String getStatus(){
    //     return active ? "active" : "non active";
    // }

    // public void getLibelle(){
    //     return libelle;
    // }

    @OneToMany(mappedBy="question")
    private List<Choix> choix;
}