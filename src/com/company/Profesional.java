package com.company;

import java.util.HashMap;
import java.util.Objects;

public class Profesional extends Usuario{

    private HashMap<String, Paciente> pacienteLista;

    public Profesional(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, HashMap<String, Paciente> pacienteLista) {
        super(nombre, apellido, dni, telefono, cuenta, clave);
        this.pacienteLista = pacienteLista;
    }

    public HashMap<String, Paciente> getPacienteLista() {
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
