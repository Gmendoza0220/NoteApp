package com.example.noteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Definimos variables

    EditText txtTituloNote, txtCuerpoNote;
    Button btnGuardar;

    //Agregamos una lista
    ArrayList<Notas> listNotas = new ArrayList<>();
    private Notas notas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTituloNote = findViewById(R.id.txtTituloNota);
        txtCuerpoNote = findViewById(R.id.txtCuerpoNota);

    }

    // Iniciando código
    private void agregarNota(String titulo, String cuerpoo){
        notas.setTitulo(titulo);
        notas.setCuerpo(cuerpoo);

    }

    private void imprimir(){
        System.out.println("Hola");
    }





}