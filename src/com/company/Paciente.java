package com.company;

import java.util.Objects;

public class Paciente extends Usuario{

    //Atributos
    String numeroHistorial;
    //Constructor


    public Paciente(String nombre, String apellido, double dni, double telefono, String clave, String cuenta, String numeroHistorial) {
        super(nombre, apellido, dni, telefono, clave, cuenta);
        this.numeroHistorial = numeroHistorial;
    }

    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    public void setNumeroHistorial(String numeroHistorial) {
        this.numeroHistorial = numeroHistorial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(numeroHistorial, paciente.numeroHistorial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroHistorial);
    }
}
