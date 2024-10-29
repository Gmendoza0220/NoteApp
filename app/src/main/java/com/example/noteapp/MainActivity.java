package com.example.noteapp;

// Se importan los elementos
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // Definimos variables
    EditText txtTituloNote, txtCuerpoNote, txtNotaEliminar;
    Button btnGuardar, btnEliminar;

    RecyclerView rvNotes;

    // Crear la lista
    ArrayList<Notas> listNotas = new ArrayList<>();

    //  Se crea el adapter
    NotasAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculamos los elementos de la interfaz con las variables creadas

        btnGuardar = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnEliminarNota);
        txtTituloNote = findViewById(R.id.txtTituloNota);
        txtCuerpoNote = findViewById(R.id.txtCuerpoNota);
        txtNotaEliminar = findViewById(R.id.txtNotaEliminar);
        rvNotes = findViewById(R.id.rvNotas);

        // Configurar el LayoutManager para el recyclerView
        // LinearLayoutManager organiza los elementos en una lista vertical
        rvNotes.setLayoutManager(new LinearLayoutManager(this));

        // Inicialización del adaptador con la lista de notas vacía
        adapter = new NotasAdapter(listNotas);
        rvNotes.setAdapter(adapter); // Inicialización del adaptador con la lista de notas vacía

        // Evento onClick del botón
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se llama al método para agregar la nota
                agregarNota(txtTituloNote.getText().toString(),txtCuerpoNote.getText().toString());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarNota(txtNotaEliminar.getText().toString());
            }
        });


    }

    // Guardar Notas 1)
    private void agregarNota(String titulo, String cuerpo){
        //  Se verifica que los campos no esten vacíos
        if(!titulo.isEmpty() && !cuerpo.isEmpty()){
            Toast.makeText(MainActivity.this, "Nota guardada", Toast.LENGTH_SHORT).show();
            Notas nuevaNota = new Notas(titulo,cuerpo); // Se crea la nueva nota
            listNotas.add(nuevaNota); // Se añade la nueva nota a la lista

            adapter.notifyDataSetChanged(); // Notifica al adaptador para actualizar el RecyclerView

        } else {
            Toast.makeText(this, "`PorFavor rellene los campos", Toast.LENGTH_SHORT).show();
        }

    }

    // Mostrar Notas 2)
    // Creamos la clase Adaptador de notas para el recycler view
    // Adaptador para el RecyclerView
    public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder> {

        // Lista de nostas para mostrar en el RecyclerView
        private ArrayList<Notas> listaNotas;

        // Constructor del adaptador que recibe la lista de notas
        public NotasAdapter(ArrayList<Notas> listaNotas) {
            this.listaNotas = listaNotas;
        }

        // Obtenemos una View con el diseño presente en el archivo "item_nota.xml".
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Usamos LayoutInflater para convertir el archivo XML item_nota en un objeto View
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
            return new ViewHolder(view); // Retornamos una nueva instancia de ViewHolder que contiene la vista inflada
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // Vincula los datos de cada nota a los elementos de la vista
            Notas nota = listaNotas.get(position); // Asigna el título de la nota
            holder.tvTitulo.setText(nota.getTitulo()); // Asigna el título de la nota
            holder.tvCuerpo.setText(nota.getCuerpo()); // Asigna el cuerpo de la nota
        }

        @Override
        public int getItemCount() {
            // Retorna el tamaño de la lista de notas (número de elementos en el RecyclerView)
            return listaNotas.size();
        }

        // ViewHolder define los elementos de la interfaz para cada nota en el RecyclerView
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvTitulo, tvCuerpo; // Elementos de título y cuerpo de cada nota

            public ViewHolder(View itemView) {
                super(itemView);
                // Vinculación de los TextViews con los IDs en item_nota.xml
                tvTitulo = itemView.findViewById(R.id.tvTitulo);
                tvCuerpo = itemView.findViewById(R.id.tvCuerpo);
            }
        }
    }

    // Eliminar notas

    public void eliminarNota(String titulo){

        // Verifica que los campos no estén vacíos.
        if(!titulo.isEmpty()){
            boolean eliminado = false; // Permitirá saber si se eliminó correctamente la nota
            for(int i = 0; i < listNotas.size(); i++){
                Notas n = listNotas.get(i); // Obtenemos la instancia nota en la posicion i.
                if(n.getTitulo().equals(titulo)){
                    listNotas.remove(n); // Removemos la nota extraía en el bucle for mediante el indice.

                    adapter.notifyDataSetChanged(); // Notifica al adaptador para actualizar el RecyclerView
                    eliminado = true; // Indica que si se eliminó la nota ingresada
                    break; // Rompemos el bucle por tema de rendimiento
                }
            }
            // En caso de que SI se haya eliminado, se mostrará un mensaje
            if(eliminado){
                Toast.makeText(this, "Nota eliminada con éxito", Toast.LENGTH_SHORT).show();
            } else {
                // En caso de que NO se haya eliminado, se motrará un mensaje de igual manera.
                Toast.makeText(this, "No se encontró la nota ingresada", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Complete el campo", Toast.LENGTH_SHORT).show();
        }

    }







}