DROP DATABASE IF EXISTS nicestocksdb;

CREATE DATABASE nicestocksdb;
USE nicestocksdb;
CREATE TABLE carteira (
  IDcarteira int NOT NULL AUTO_INCREMENT,
  nmTitulo varchar(10) NOT NULL,
  qtdTitulo int NOT NULL,
  valorPago double NOT NULL,
  fk_IDusuario int DEFAULT NULL,
  PRIMARY KEY (IDcarteira)
);
CREATE TABLE usuario (
  IDusuario int NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(50),
  email VARCHAR(100),
  passwd varchar(20),
  PRIMARY KEY (IDusuario)
);

INSERT INTO nicestocksdb.usuario
(IDusuario,
user_name,
email,
passwd)
VALUES
(
1,
'adm',
'adm@mail.com',
'adm'
);

INSERT INTO nicestocksdb.carteira
(IDcarteira,
nmTitulo,
qtdTitulo,
valorPago,
fk_IDusuario)
VALUES
(
1,
'PETR4',
5,
151.4,
1
);


SELECT * FROM usuario;
SELECT * FROM carteira;