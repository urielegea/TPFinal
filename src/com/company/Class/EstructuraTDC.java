package com.company.Class;

public abstract class EstructuraTDC {

    //Atributos
    protected String textoDescriptivo;

    //Constructor
    public EstructuraTDC() {
    }

    public EstructuraTDC(String textoDescriptivo){
        this.textoDescriptivo=textoDescriptivo;
    }

    //Metodos
    public String getTextoDescriptivo() {
        return textoDescriptivo;
    }

    public void setTextoDescriptivo(String textoDescriptivo) {
        this.textoDescriptivo = textoDescriptivo;
    }

    @Override
    public String toString() {
        return "EstructuraTDC{" +
                "textoDescriptivo='" + textoDescriptivo + '\'' +
                '}';
    }
}
