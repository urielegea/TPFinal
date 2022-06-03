package com.company;

public class DecimalTDC extends EstructuraTDC{

    //Atributos

    private double decimal;

    //Constructor
    public DecimalTDC(String texto, double decimal){
        super(texto);
        this.decimal=decimal;
    }

    //Metodos


    public double getDecimal() {
        return decimal;
    }

    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "DecimalTDC{" +
                "decimal=" + decimal +
                ", textoDescriptivo='" + textoDescriptivo + '\'' +
                '}';
    }
}
