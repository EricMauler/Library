-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;

-- -----------------------------------------------------------------------------
-- - Construction de la table des livres en vente                         ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Books (
	IdArticle			int(4)		PRIMARY KEY AUTO_INCREMENT,
	Title   		    varchar(30)	NOT NULL,
	Author				varchar(30)	NOT NULL,
	Edition             varchar(30)	NOT NULL,
	UnitaryPrice		float(8)	NOT NULL DEFAULT 0
) ENGINE = InnoDB;

INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice ) VALUES ('Ainsi parlait zarathoustra', 'Friedrich Nietzsche', 'Le livre De Poche', '5.99');
INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice ) VALUES ('L'ombilic des limbes', 'Antonin Artaud', 'Galimard', '7.60');