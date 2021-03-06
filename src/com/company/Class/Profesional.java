package com.company.Class;

import com.company.Class.Interfaces.AdministrarTratamiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Profesional extends Usuario implements AdministrarTratamiento {

    private ArrayList<String> pacienteLista;
    
    public Profesional() {
    	super();
    }

    public Profesional(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, Date fechaAlta, ArrayList<String> pacienteLista) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
        this.pacienteLista = pacienteLista;
    }
    
    public Profesional(String nombre, String apellido, String dni, String telefono, String cuenta,
    String clave, Date fechaAlta, Date ultimaSesion, ArrayList<String> pacienteLista) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta, ultimaSesion);
        this.pacienteLista = pacienteLista;
    }

    public ArrayList<String> getPacienteLista() {
        return pacienteLista;
    }
    public void setPacienteLista(ArrayList<String> lista){
        this.pacienteLista = lista;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pacienteLista=" + pacienteLista +
                ", cuenta='" + cuenta + '\'' +
                ", clave='" + clave + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", ultimaSesion='" + ultimaSesion + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesional that = (Profesional) o;
        return Objects.equals(pacienteLista, that.pacienteLista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacienteLista);
    }
}