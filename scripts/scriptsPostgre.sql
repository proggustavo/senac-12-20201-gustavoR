CREATE SCHEMA EXEMPLOS;

CREATE TABLE TELEFONE (
  id serial NOT NULL,
  codigoPais VARCHAR(2) NOT NULL,
  ddd VARCHAR(2) NOT NULL,
  numero VARCHAR(12) NOT NULL,
  movel INT NOT NULL,
  ativo INT NOT NULL,
  idCliente int null,
  PRIMARY KEY (id)
);
  
  CREATE TABLE ENDERECO (
  id serial NOT NULL,
  cep VARCHAR(8) NOT NULL,
  estado VARCHAR(255) NOT NULL,
  cidade VARCHAR(255) NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  numero VARCHAR(100) NOT NULL,
  rua VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  idCLIENTE INT NULL
);

  
  CREATE TABLE CLIENTE (
  id serial NOT NULL,
  nome VARCHAR(255) NOT NULL,
  sobrenome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL UNIQUE,
  idENDERECO INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idENDERECO) references ENDERECO (id) 
  );

-- ALTER TABLE CLIENTE ADD INDEX id_idx (idENDERECO);


-- INSERINDO ENDERECOS

INSERT INTO ENDERECO (id,cep,estado,cidade,bairro,numero,rua) VALUES (1,'38476242','SC','Lages','Centro','515','Rua  79');
INSERT INTO ENDERECO (id,cep,estado,cidade,bairro,numero,rua) VALUES (2,'78529663','SC','Florianópolis','Centro','804','Rua  81');
INSERT INTO ENDERECO (id,cep,estado,cidade,bairro,numero,rua) VALUES (3,'39152270','SC','Lages','Centro','640','Rua 28');
INSERT INTO ENDERECO (id,cep,estado,cidade,bairro,numero,rua) VALUES (4,'78015242','SC','Florianópolis','Centro','126','Rua  6');
INSERT INTO ENDERECO (id,cep,estado,cidade,bairro,numero,rua) VALUES (5,'41857751','SC','Chapecó','Centro','125','Rua 66');

-- INSERINDO CLIENTES 

INSERT INTO CLIENTE values(default, 'Gustavo', 'Rodrigues', '12345678901', 1);
INSERT INTO CLIENTE values(default, 'Amoedo', 'Borges', '09324585342', 2);
INSERT INTO CLIENTE values(default, 'Fátima', 'Bernardes', '09324585942', 3);
INSERT INTO CLIENTE values(default, 'Esperidião', 'Amim', '3456785942', 4);
INSERT INTO CLIENTE values(default, 'Daniel', 'Ricardo', '3456285942', 5);


-- INSERINDO TELEFONES

INSERT INTO TELEFONE (id, codigopais, ddd, numero, movel, ativo, idcliente) VALUES (default, '55', '48','997788888', 1, 1, 1);
INSERT INTO TELEFONE (id, codigopais, ddd, numero, movel, ativo, idcliente) VALUES (default, '53', '47','997788884', 1, 1, 2);
INSERT INTO TELEFONE (id, codigopais, ddd, numero, movel, ativo, idcliente) VALUES (default, '55', '41','997788885', 1, 1, 3);
INSERT INTO TELEFONE (id, codigopais, ddd, numero, movel, ativo, idcliente) VALUES (default, '57', '42','997788889', 1, 1, 4);
INSERT INTO TELEFONE (id, codigopais, ddd, numero, movel, ativo, idcliente) VALUES (default, '57', '42','997788829', 1, 1, null);
