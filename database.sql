
CREATE TABLE contact (
                contact_id INT AUTO_INCREMENT NOT NULL,
                first_name VARCHAR(300) NOT NULL,
                email VARCHAR(300) NOT NULL,
                problems VARCHAR(300) NOT NULL,
                PRIMARY KEY (contact_id)
);


CREATE TABLE porte_monnaie (
                porte_monnaie_id INT AUTO_INCREMENT NOT NULL,
                soldes DOUBLE PRECISION NOT NULL,
                bankaccount VARCHAR(11) DEFAULT 0 NOT NULL,
                available BOOLEAN DEFAULT 1 NOT NULL,
                PRIMARY KEY (porte_monnaie_id)
);


CREATE TABLE utilisateurs (
                utilisateur_id INT AUTO_INCREMENT NOT NULL,
                mail VARCHAR(300) NOT NULL,
                password VARCHAR(300) NOT NULL,
                nom VARCHAR(300) NOT NULL,
                prenom VARCHAR(300) NOT NULL,
                soldes_id INT NOT NULL,
                PRIMARY KEY (utilisateur_id)
);


CREATE TABLE reseau (
                reseau_id INT AUTO_INCREMENT NOT NULL,
                userA_id INT NOT NULL,
                userB_id INT NOT NULL,
                PRIMARY KEY (reseau_id)
);


CREATE TABLE historique_transaction (
                historique_transactions_id INT AUTO_INCREMENT NOT NULL,
                utilisateur_id INT NOT NULL,
                userAorB INT NOT NULL,
                description VARCHAR(300) NOT NULL,
                sommes INT NOT NULL,
                PRIMARY KEY (historique_transactions_id)
);


ALTER TABLE utilisateurs ADD CONSTRAINT porte_monnaie_utilisateurs_fk
FOREIGN KEY (soldes_id)
REFERENCES porte_monnaie (porte_monnaie_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE reseau ADD CONSTRAINT utilisateurs_reseau_fk
FOREIGN KEY (userA_id)
REFERENCES utilisateurs (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE reseau ADD CONSTRAINT utilisateurs_reseau_fk1
FOREIGN KEY (userB_id)
REFERENCES utilisateurs (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE historique_transaction ADD CONSTRAINT utilisateurs_historique_transaction_fk
FOREIGN KEY (utilisateur_id)
REFERENCES utilisateurs (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE historique_transaction ADD CONSTRAINT reseau_historique_transaction_fk
FOREIGN KEY (userAorB)
REFERENCES reseau (reseau_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
