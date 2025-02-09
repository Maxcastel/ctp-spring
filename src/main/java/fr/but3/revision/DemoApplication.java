package fr.but3.revision;

// // import java.util.ArrayList;
// // import java.util.List;

// // import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// // import fr.but3.revision.models.Choix;
// // import fr.but3.revision.models.Question;
// // import fr.but3.revision.repository.ChoixRepository;
// // import fr.but3.revision.repository.QuestionRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	// CORRECTION
	// deux fois // // pour ce que j'ai mis en commentaire suite à la correction

	// // @Autowired
	// // QuestionRepository qr;

	// // @Autowired
	// // ChoixRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception{

		// // Question q = new Question();
		// // q.setLibelle("1+1 ?");
		// // q.setActive(true);
		// // qr.save(q);

		// // Choix c = new Choix();
		// // c.setQuestion(q);
		// // c.setLibchoix("2");
		// // c.setStatut(true);
		// // cr.save(c);

		// // Choix c2 = new Choix();
		// // c.setQuestion(q);
		// // c.setLibchoix("50");
		// // c.setStatut(false);
		// // cr.save(c2);

		// cr.saveAll(c,c2);

		// Etudiant etudiant1 = new Etudiant();
		// // etudiant.setId(10);
		// etudiant1.setNom("Bernard");
		// etudiant1.setPrenom("Paul");
		// etudiant1.setGroupe("Groupe C");
		// //repository.save(etudiant);

		// Etudiant etudiant2 = new Etudiant();
		// // etudiant.setId(2);
        // etudiant2.setNom("Bernard");
        // etudiant2.setPrenom("Paul");
        // etudiant2.setGroupe("Groupe C");

        // Etudiant etudiant3 = new Etudiant();
		// // etudiant.setId(3);
        // etudiant3.setNom("Morel");
        // etudiant3.setPrenom("Alice");
        // etudiant3.setGroupe("Groupe A");

        // Etudiant etudiant4 = new Etudiant();
		// // etudiant.setId(4);
        // etudiant4.setNom("Fournier");
        // etudiant4.setPrenom("Luc");
        // etudiant4.setGroupe("Groupe B");

		// Etudiant etudiant5 = new Etudiant();
		// // etudiant.setId(5);
        // etudiant5.setNom("Baaaa");
        // etudiant5.setPrenom("Luc");
        // etudiant5.setGroupe("Groupe B");

        // repository.saveAll(Arrays.asList(etudiant1, etudiant2, etudiant3, etudiant4, etudiant5));
	}

}
