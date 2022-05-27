package com.company;

public class Paciente extends Usuario{

    //Atributos

    //Constructor
    public Paciente(String nombre, String apellido, double dni, double telefono, String uuid,String clave,
                    String cuenta){
        super(nombre, apellido, dni, telefono, uuid, clave, cuenta);
    }

}
