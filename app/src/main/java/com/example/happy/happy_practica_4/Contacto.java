package com.example.happy.happy_practica_4;

public class Contacto {

    private String nombre;
    private String telefono;
    private String sexo;

    public Contacto(String nombre, String telefono, String sexo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
