package com.company.Class;

public class VerdaderoFalsoTDC extends EstructuraTDC{

    //Atributos
    private Boolean vof;

    //Constructor

    public VerdaderoFalsoTDC() {
    }

    public VerdaderoFalsoTDC(String texto){
        super(texto);
        this.vof=null;
    }

    //Metodos


    public Boolean getVof() {
        return this.vof;
    }

    public void setVof(Boolean vof) {
        this.vof = vof;
    }

    @Override
    public String toString() {
        return "VerdaderoFalsoTDC{" +
                "textoDescriptivo='" + textoDescriptivo + '\'' +
                ", vof=" + vof +
                '}';
    }
}