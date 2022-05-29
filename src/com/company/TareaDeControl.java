package com.company;

public abstract class TareaDeControl {

    //Atributos
    protected String token;
    protected boolean accion;
    protected String observacion;

    //Constructor
    public TareaDeControl(String token, boolean accion, String observacion){
        this.token=token;
        this.accion=accion;
        this.observacion=observacion;
    }
}
