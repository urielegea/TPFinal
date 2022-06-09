package com.company.Class;

public class EnteroTDC extends EstructuraTDC{

    //Atributos
    private Integer entero;

    //Constructor

    public EnteroTDC() {
    }

    public EnteroTDC(String texto){
        super(texto);
        this.entero=null;
    }

    public Integer getEntero() {
        return entero;
    }

    public void setEntero(Integer entero) {
        this.entero = entero;
    }

    @Override
    public String toString() {
        return "EnteroTDC{" +
                "entero=" + entero +
                ", textoDescriptivo='" + textoDescriptivo + '\'' +
                '}';
    }
}