package com.company.Class;

import java.util.Date;

public class Administrador extends Usuario implements NuevoPaciente, NuevoProfesional, AdministrarEnfermedades, AdministrarTareaDeControl, AsignarProfesional{

	public Administrador() {
		super();
	}
	
    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, Date fechaAlta){
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
    }   
    
    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta,
    String clave, Date fechaAlta, Date ultimaSesion) {
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta, ultimaSesion);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuenta='" + cuenta + '\'' +
                ", clave='" + clave + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", ultimaSesion='" + ultimaSesion + '\'' +
                "} " + super.toString();
    }
}
