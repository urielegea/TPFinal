package com.company.Class;

public class NotaTDC extends EstructuraTDC{

    //Atributos

    private String nota;

    //Constructor
    public NotaTDC(String texto){
        super(texto);
        this.nota=null;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "NotaTDC{" +
                "textoDescriptivo='" + textoDescriptivo + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
