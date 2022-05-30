CREATE TABLE estoque (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80) NOT NULL,
quantidade INT,
valorUnitario DECIMAL,
id_usuarios  INT,
FOREIGN KEY (id_usuarios) REFERENCES usuarios (id)
);