package com.company;

public class EnteroTDC extends EstructuraTDC{

    //Atributos
    private int entero;

    //Constructor
    public EnteroTDC(String texto, int entero){
        super(texto);
        this.entero=entero;
    }

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
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
