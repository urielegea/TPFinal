package com.company;

import java.util.HashMap;
import java.util.Objects;

public class Profesional extends Usuario{

    //Atributos
    private HashMap<Integer, Paciente> pacienteLista;

    //Constructor
    public Profesional(String nombre, String apellido, double dni, double telefono, String clave, String cuenta, HashMap<Integer, Paciente> pacienteLista) {
        super(nombre, apellido, dni, telefono, clave, cuenta);
        this.pacienteLista = pacienteLista;
    }

    public HashMap<Integer, Paciente> getPacienteLista() {
        return pacienteLista;
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
