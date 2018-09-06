package com.example.happy.happy_practica_4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
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

        ImageButton item_call = linea.findViewById(R.id.item_call);
        ImageButton item_delete = linea.findViewById(R.id.item_delete);

        String sexo = contactos.get(position).getSexo();

        if (sexo.toString().equals("Femenino")){
            //item_sexo.getImageResourse(R.drawable.femenino);
        }else{
            //item_sexo.getImageResourse(R.drawable.masculino);
        }

        item_nombre.setText(contactos.get(position).getNombre());
        item_telefono.setText(contactos.get(position).getTelefono());

        final String telefono = contactos.get(position).getTelefono();

        item_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int Request_phone_call = 1;
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: "+telefono));
                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},Request_phone_call);
                    }else {
                        activity.startActivity(call);
                    }
                }

            }
        });


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
