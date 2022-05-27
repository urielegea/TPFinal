package com.company;

public abstract class Usuario extends Persona{

    String uuid;
    String clave;
    String cuenta;

    //Constructor

    public Usuario(String nombre, String apellido, double dni, double telefono, String uuid,String clave,
                   String cuenta){
        super(nombre, apellido, dni,telefono);
        this.uuid=uuid;
        this.clave=clave;
        this.cuenta=cuenta;
    }



}
