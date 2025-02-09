package fr.but3.revision.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                '}';
    }
}
