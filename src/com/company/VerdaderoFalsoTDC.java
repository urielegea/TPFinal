package com.company;

public class VerdaderoFalsoTDC extends EstructuraTDC{

    //Atributos
    private boolean vof;

    //Constructor
    public VerdaderoFalsoTDC(String texto, boolean vof){
        super(texto);
        this.vof=vof;
    }

    //Metodos


    public boolean getVof() {
        return this.vof;
    }

    public void setVof(boolean vof) {
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
