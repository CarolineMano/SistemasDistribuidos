CREATE TABLE estoque (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80) NOT NULL,
quantidade INT,
valor DECIMAL,
id_usuario  INT,
FOREIGN KEY (id_usuario) REFERENCES usuarios (id)
);


INSERT INTO estoque (nome, quantidade, valor, id_usuario) VALUES ('nutella', 6, 12.50, 1);
INSERT INTO estoque (nome, quantidade, valor, id_usuario) VALUES ('ruffles', 15, 8.20, 1);
INSERT INTO estoque (nome, quantidade, valor, id_usuario) VALUES ('budwiser', 30, 2.29, 1);