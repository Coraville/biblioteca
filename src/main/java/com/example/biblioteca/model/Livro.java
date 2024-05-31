package com.example.biblioteca.model;

public class Livro {
    
    private int id;
    private String nome, categoria;

    //Sobrecarga de construtores
    public Livro(){

    }

    public Livro(String nome, String categoria){
        this.nome = nome;
        this.categoria = categoria;
    }

    public Livro(int id, String nome, String categoria){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public int getId(){
        return id;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getNome(){
        return nome;
    }

}