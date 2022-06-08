package com.company.Class;

public class Administrador extends Usuario implements NuevoPaciente, NuevoProfesional, AdministrarEnfermedades, AdministrarTareaDeControl, AsignarProfesional{

    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, String fechaAlta){
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
    }   
    
    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta,
    String clave, String fechaAlta, String ultimaSesion) {
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
