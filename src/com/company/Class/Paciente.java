package com.company.Class;

import java.util.Objects;

public class Paciente extends Usuario{

    private String numeroHistorial;

    public Paciente(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, String fechaAlta, String numeroHistorial) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
        this.numeroHistorial = numeroHistorial;
    }
    
    public Paciente(String nombre, String apellido, String dni, String telefono, String token, String cuenta, 
    String clave, String fechaAlta, String ultimaSesion, String numeroHistorial) {
        super(nombre, apellido, dni, telefono, token, cuenta, clave, fechaAlta, ultimaSesion);
        this.numeroHistorial = numeroHistorial;
    }

    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    public void setNumeroHistorial(String numeroHistorial) {
        this.numeroHistorial = numeroHistorial;
    }  

    @Override
	public String toString() {
		return "Paciente [numeroHistorial=" + numeroHistorial + ", token=" + token + ", cuenta=" + cuenta + ", clave="
				+ clave + ", fechaAlta=" + fechaAlta + ", ultimaSesion=" + ultimaSesion + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono + "]";
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