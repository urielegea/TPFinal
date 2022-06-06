package com.company.Class;

public class Administrador extends Usuario{

    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, String fechaAlta){
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
    }   
    
    public Administrador(String nombre, String apellido, String dni, String telefono, String token, String cuenta, 
    String clave, String fechaAlta, String ultimaSesion) {
        super(nombre, apellido, dni, telefono, token, cuenta, clave, fechaAlta, ultimaSesion);
    }

	@Override
	public String toString() {
		return "Administrador [token=" + token + ", cuenta=" + cuenta + ", clave=" + clave + ", fechaAlta=" + fechaAlta
				+ ", ultimaSesion=" + ultimaSesion + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", telefono=" + telefono + "]";
	}
}
