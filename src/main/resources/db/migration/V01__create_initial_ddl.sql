CREATE TABLE cliente (
	id 		INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nome_completo 	VARCHAR(255) NOT NULL,
	sexo 		EMUM('M','F') NOT NULL,
	data_nascimento DATE NOT NULL, 
	idade 		SMALLINT NOT NULL,
	cidade_id 	INT NOT NULL

) ENGINE=InnoDB;


CREATE TABLE cidade (
	id 	    INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nome_cidade VARCHAR(255) NOT NULL,
	estado	    ENUM(AC, 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO') NOT NULL

) ENGINE=InnoDB;


ALTER TABLE cliente ADD CONSTRAINT fk_cidade FOREING KEY (cidade_id) REFERENCES cidade (id);