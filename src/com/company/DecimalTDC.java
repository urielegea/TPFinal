package com.company;

public class DecimalTDC extends EstructuraTDC{

    //Atributos

    private Double decimal;

    //Constructor
    public DecimalTDC(String texto){
        super(texto);
        this.decimal=null;
    }

    //Metodos


    public Double getDecimal() {
        return decimal;
    }

    public void setDecimal(Double decimal) {
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
