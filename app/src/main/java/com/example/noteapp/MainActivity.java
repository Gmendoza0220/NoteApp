package com.example.noteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Definimos variables
    EditText txtTituloNote, txtCuerpoNote;
    Button btnGuardar;

    //Crear la lista
    ArrayList<Notas> listNotas = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gerardo

        btnGuardar = findViewById(R.id.btnGuardar);
        txtTituloNote = findViewById(R.id.txtTituloNota);
        txtCuerpoNote = findViewById(R.id.txtCuerpoNota);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Guardando Nota", Toast.LENGTH_SHORT).show();
                agregarNota(txtTituloNote.getText().toString(),txtCuerpoNote.getText().toString());

            }
        });


    }

    // Iniciando código ----
    private void agregarNota(String titulo, String cuerpo){
        if(!titulo.isEmpty() && cuerpo.isEmpty()){

            Notas nuevaNota = new Notas(titulo,cuerpo);
            listNotas.add(nuevaNota);
        } else {
            Toast.makeText(this, "Favor rellene los campos", Toast.LENGTH_SHORT).show();
        }


    }





}