package fr.but3.revision.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "is required")
    @NotEmpty(message = "Le nom ne peut pas être vide")
    // @Size(min = 1, max = 5, message = " must be between 1 and 50 characters")
    private String nom;
    
    @NotNull(message = "is required")
    private String prenom;

    @OneToMany(mappedBy = "auteur",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Livre> livres;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
