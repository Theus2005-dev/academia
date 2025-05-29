CREATE DATABASE academia_db;
USE academia_db;

select * from aluno;
select * from plano;
select * from ficha_treino;

CREATE TABLE aluno (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE plano (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  descricao TEXT
);

CREATE TABLE ficha_treino (
  id INT AUTO_INCREMENT PRIMARY KEY,
  aluno_id INT,
  descricao TEXT,
  FOREIGN KEY (aluno_id) REFERENCES aluno(id)
)
