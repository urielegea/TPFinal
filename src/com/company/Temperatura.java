package com.company;

public class Temperatura extends TareaDeControl{

    //Atributos
    private double temperatura;

    //Constructor
    public Temperatura(String token, double temperatura){
        super(token, false, "");
        this.temperatura=temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }


}
