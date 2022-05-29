package com.company;

public class Medicacion extends TareaDeControl{

    //Atributos
    private String medicamento;

    //Constructor
    public Medicacion(String token, String medicamento){
        super(token, false, "");
        this.medicamento=medicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
}
