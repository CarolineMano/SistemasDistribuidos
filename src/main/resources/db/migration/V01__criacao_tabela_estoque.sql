CREATE TABLE estoque (
id_lote INT PRIMARY KEY,
nome VARCHAR(80) NOT NULL,
quantidade INT,
valorUnitario DECIMAL,
id_usuarios  INT,
FOREIGN KEY (id_usuarios) REFERENCES usuarios (id)
);