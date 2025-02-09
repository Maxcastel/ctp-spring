INSERT INTO Auteur(nom,prenom) VALUES('Hugo','Victor');
INSERT INTO Auteur(nom,prenom) VALUES('Kane','Bob');
INSERT INTO Auteur(nom,prenom) VALUES('Tolkien','JRR');
INSERT INTO Auteur(nom,prenom) VALUES('Collins','Suzanne');
INSERT INTO Livre(titre,id_auteur) VALUES ('Les misérables',1);

INSERT INTO users VALUES ('admin','{bcrypt}$2a$10$N6.2GMPa/sM49sj4doqpf.mhaa0p0xPqnMmM3R9Qba9jFKghJ1NYW',TRUE);
INSERT INTO users VALUES ('user1','{bcrypt}$2a$10$2K54uzgY46z2AHwq8aMcj.BW7uE6V9lX4WTQjHhfDkY2Aw5UUL6uu',TRUE);
INSERT INTO users VALUES ('user2','{bcrypt}$2a$10$yTyUdvEXY9f9oOlc4Tw2aO8xjw05o56rSA0gqetICLbqUX4EDbwAy',TRUE);
INSERT INTO users VALUES ('user3','{bcrypt}$2a$10$6SYig1.1ErSdgeVRHmd7zuNtFkUvOIXgDigrlWV6hTNoRunrG0Bnq',TRUE);

INSERT INTO authorities VALUES ('admin', 'ADMIN');
INSERT INTO authorities VALUES ('user1', 'USER');
INSERT INTO authorities VALUES ('user2', 'USER');
INSERT INTO authorities VALUES ('user3', 'USER');

-- ctp

-- changement libquest en libelle car dans mon entite Question le champ est libelle
-- rajout du champ active par defaut à false sinon erreur lors des insert
insert into question(libelle, active) values ('Date de la bataille de Marignan ?', false);
insert into question(libelle, active) values ('Quel est le président de la république actuel ?', false);
insert into question(libelle, active) values ('Qui a découvert la péniciline ?', false);


-- changement libchoix en libelle car dans mon entite Choix le champ est libelle
-- rajout du champs nb_choix par defaut à 0 sinon erreur lors des insert
insert into choix(qno,libelle,statut,nb_choix) values (1,'1313',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (1,'1414',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (1,'1515',true,0);
insert into choix(qno,libelle,statut,nb_choix) values (1,'1616',false,0);

insert into choix(qno,libelle,statut,nb_choix) values (2,'Chirac',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (2,'Sarkozy',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (2,'Hollande',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (2,'Macron',true,0);

insert into choix(qno,libelle,statut,nb_choix) values (3,'Darwin',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (3,'Pasteur',false,0);
insert into choix(qno,libelle,statut,nb_choix) values (3,'Fleming',true,0);
insert into choix(qno,libelle,statut,nb_choix) values (3,'Watson',false,0);
