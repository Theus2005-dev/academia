/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.academia.model;

/**
 *
 * @author USUARIO
 */
public class FichaTreino {
     private int id;
    private int alunoId;
    private String descricao;

    // Construtor com ID
    public FichaTreino(int id, int alunoId, String descricao) {
        this.id = id;
        this.alunoId = alunoId;
        this.descricao = descricao;
    }

    // Construtor sem ID (útil para inserção no banco)
    public FichaTreino(int alunoId, String descricao) {
        this.alunoId = alunoId;
        this.descricao = descricao;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
