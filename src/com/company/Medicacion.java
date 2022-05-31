package com.company;

public class Medicacion extends TareaDeControl{

    private String medicamento;

    public Medicacion(String token, String medicamento){
        super(token, false, "");
        this.medicamento = medicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
}
