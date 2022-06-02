package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Paciente extends Usuario{

    private String numeroHistorial;

    public Paciente(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, LocalDate fechaAlta, String numeroHistorial) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
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
