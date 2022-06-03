package com.company;

public class NotaTDC extends EstructuraTDC{

    //Atributos

    private String nota;

    //Constructor
    public NotaTDC(String texto, String nota){
        super(texto);
        this.nota=nota;
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
