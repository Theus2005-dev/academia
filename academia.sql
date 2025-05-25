-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS academia;
USE academia;

-- Tabela de Alunos
CREATE TABLE IF NOT EXISTS aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Tabela de Planos
CREATE TABLE IF NOT EXISTS plano (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

-- Tabela de Fichas de Treino
CREATE TABLE IF NOT EXISTS ficha_treino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    descricao TEXT,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
);
