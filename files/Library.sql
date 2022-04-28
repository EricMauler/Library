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
	IdBook		int(4)		PRIMARY KEY AUTO_INCREMENT,
	Title   		    varchar(30)	NOT NULL,
	Author				varchar(30)	NOT NULL,
	Edition             varchar(30)	NOT NULL,
	UnitaryPrice		float(8)	NOT NULL DEFAULT 0
) ENGINE = InnoDB;

INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice ) VALUES ('Ainsi parlait...', 'Friedrich Nietzsche', 'Le livre De Poche', '5.99');
INSERT INTO T_Books (Title, Author, Edition, UnitaryPrice ) VALUES ("L'ombilic des limbes", "Antonin Artaud", "Galimard", "7.60");

CREATE TABLE T_Categories (
	IdCategory		int(4)		PRIMARY KEY AUTO_INCREMENT,
    Genre   		    varchar(30)	NOT NULL )
    ENGINE = InnoDB;
    
    INSERT INTO T_Categories (Genre) VALUES ("Poesie");
    INSERT INTO T_Categories (Genre) VALUES ("Philosophie");
    INSERT INTO T_Categories (Genre) VALUES ("Theatre");
    
    ALTER TABLE t_books ADD COLUMN idCategory INT(4);
    ALTER TABLE t_books ADD FOREIGN KEY (IdCategory) REFERENCES T_Categories(idCategory);
    
    update t_books set idCategory = 2 where idBook = 1;
    update t_books set idCategory = 3 where idBook = 2;
    
    select IdBook,T_Books.Title,Author,Edition,UnitaryPrice,Genre
from t_books join t_categories on t_books.IdCategory = t_categories.IdCategory;

CREATE TABLE T_Customers(
	IdCustomer		int(4)		PRIMARY KEY AUTO_INCREMENT,
    Login   	    varchar(30)	NOT NULL, 
    Password		varchar(30)	NOT NULL)
    ENGINE = InnoDB;
    
     INSERT INTO T_Customers (Login, Password) VALUES ("Toto", "123");
     
     CREATE TABLE T_Orders(
     IdOrder	int(4)		PRIMARY KEY AUTO_INCREMENT,
     TotalAmount	 varchar(30)	NOT NULL,
     IdCustomer varchar(30)	NOT NULL)
     ENGINE = InnoDB;