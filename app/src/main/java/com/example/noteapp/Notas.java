package com.example.noteapp;

public class Notas {
    private String titulo;
    private String cuerpo;

    //Constructor;
    public Notas() {
    }

    public Notas(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Override
    public String toString() {
        return "Notas\n" +
                "Titulo: " + this.titulo +
                "Cuerpo: " + this.cuerpo;
    }
}
