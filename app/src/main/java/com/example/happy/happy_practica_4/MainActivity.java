package com.example.happy.happy_practica_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText edt_nombre;
    private EditText edt_telefono;
    private Button btn_agregar;
    private ListView lv_contactos;
    private Switch swt_sexo;
    ContactoAdapter customeAdapter;

    private ArrayList<String> contactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nombre = findViewById(R.id.edt_nombre);
        edt_telefono = findViewById(R.id.edt_telefono);
        btn_agregar = findViewById(R.id.btn_agregar);
        swt_sexo = findViewById(R.id.swt_sexo);

        lv_contactos = findViewById(R.id.lv_contactos);
        customeAdapter = new ContactoAdapter(this);
        lv_contactos.setAdapter(customeAdapter);

        Contacto contacto1 = new Contacto("Tays", "3043719084", "Femenino");
        Contacto contacto2 = new Contacto("Nathan", "3128489423", "Masculino");
        Contacto contacto3 = new Contacto("Pau wapa", "3115529404", "Femenino");
        Contacto contacto4 = new Contacto("Calex", "3013519245", "Masculino");

        customeAdapter.agregarContacto(contacto1);
        customeAdapter.agregarContacto(contacto2);
        customeAdapter.agregarContacto(contacto3);
        customeAdapter.agregarContacto(contacto4);

        lv_contactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contacto contacto_click = (Contacto) customeAdapter.getItem(position);
                Toast.makeText(MainActivity.this, contacto_click.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = edt_nombre.getText().toString();
                String telefono = edt_telefono.getText().toString();
                String sexo;

                if(swt_sexo.isChecked()){
                    sexo = "Femenino";
                } else{
                    sexo = "Masculino";
                }

                Contacto newContacto = new Contacto(nombre,telefono,sexo);
                customeAdapter.agregarContacto(newContacto);
            }
        });



    }
}
