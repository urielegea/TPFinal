package com.company.Class;

import java.util.ArrayList;

public class HistorialMedico {

    private String numeroHistorial;
    private ArrayList<Tratamiento> tratamientoLista;

    public HistorialMedico() {
    	
    }
    
    public HistorialMedico(String numeroHistorial, ArrayList<Tratamiento> tratamientoLista){
        this.numeroHistorial = numeroHistorial;
        this.tratamientoLista = tratamientoLista;
    }    
    
    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    public void setNumeroHistorial(String numeroHistorial) {
        this.numeroHistorial = numeroHistorial;
    }

    public ArrayList<Tratamiento> getTratamientoLista() {
        return tratamientoLista;
    }

    public void setTratamientoLista(ArrayList<Tratamiento> tratamientoLista) {
        this.tratamientoLista = tratamientoLista;
    }

	@Override
	public String toString() {
		return "HistorialMedico [numeroHistorial=" + numeroHistorial + ", tratamientoLista=" + tratamientoLista + "]";
	}   
    
}
