package com.company;

import java.time.LocalDate;

public class Administrador extends Usuario{

    public Administrador(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, LocalDate fechaAlta){
        super(nombre, apellido, dni, telefono, cuenta, clave, fechaAlta);
    }   
}
