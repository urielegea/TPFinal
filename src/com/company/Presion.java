package com.company;

public class Presion extends TareaDeControl{

    //Atributos
    double presion;

    //Constructor;
    public Presion(String token, double presion){
        super(token, false, "");
        this.presion=presion;
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }
}
