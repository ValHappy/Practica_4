package com.example.happy.happy_practica_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText edt_nombre;
    private EditText edt_telefono;
    private Button btn_agregar;
    private ListView lv_contactos;

    ContactoAdapter customeAdapter;

    private ArrayList<String> contactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre = findViewById(R.id.edt_nombre);
        edt_telefono = findViewById(R.id.edt_telefono);
        btn_agregar = findViewById(R.id.btn_agregar);

        lv_contactos = findViewById(R.id.lv_contactos);
        customeAdapter = new ContactoAdapter(this);
        lv_contactos.setAdapter(customeAdapter);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = edt_nombre.getText().toString();
                String telefono = edt_telefono.getText().toString();

                Contacto newContacto = new Contacto(nombre,telefono);
                customeAdapter.agregarContacto(newContacto);
            }
        });



    }
}
