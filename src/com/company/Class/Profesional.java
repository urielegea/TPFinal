package com.company.Class;

import java.util.HashMap;
import java.util.Objects;

public class Profesional extends Usuario{

    private HashMap<String, Paciente> pacienteLista;

    public Profesional(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, String fechaAlta, HashMap<String, Paciente> pacienteLista) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
        this.pacienteLista = pacienteLista;
    }
    
    public Profesional(String nombre, String apellido, String dni, String telefono, String token, String cuenta, 
    String clave, String fechaAlta, String ultimaSesion, HashMap<String, Paciente> pacienteLista) {
        super(nombre, apellido, dni, telefono, token, cuenta, clave, fechaAlta, ultimaSesion);
        this.pacienteLista = pacienteLista;
    }

    public HashMap<String, Paciente> getPacienteLista() {
        return pacienteLista;
    }
    
    @Override
	public String toString() {
		return "Profesional [pacienteLista=" + pacienteLista + ", token=" + token + ", cuenta=" + cuenta + ", clave="
				+ clave + ", fechaAlta=" + fechaAlta + ", ultimaSesion=" + ultimaSesion + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + ", telefono=" + telefono + "]";
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