package com.example.happy.happy_practica_4;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdapter extends BaseAdapter{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter(Activity activity){
        this.activity = activity;
        contactos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int i) {
        return contactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        View linea = inflater.inflate(R.layout.linea,null, false);

        TextView item_nombre = linea.findViewById(R.id.item_nombre);
        TextView item_telefono = linea.findViewById(R.id.item_telefono);
        TextView item_call = linea.findViewById(R.id.item_call);
        TextView item_delete = linea.findViewById(R.id.item_delete);

        item_nombre.setText(contactos.get(position).getNombre());
        item_telefono.setText(contactos.get(position).getTelefono());

        item_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactos.remove(position);
                notifyDataSetChanged();
            }
        });

        return linea;
    }

    public void agregarContacto(Contacto contacto){
        contactos.add(contacto);
        notifyDataSetChanged();
    }
}
