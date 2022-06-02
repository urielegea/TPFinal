package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tratamiento {

    private String token;
    private String enfermedadNombre;
    private int duracionDias;
    private LocalDate diaInicial;
    private LocalDate diaFinal;
    private ArrayList<ControlDiario> controlDiarioLista;

    public Tratamiento(String token, String enfermedadNombre, int duracionDias, LocalDate diaInicial,
			LocalDate diaFinal, ArrayList<ControlDiario> controlDiarioLista) {
		this.token = token;
		this.enfermedadNombre = enfermedadNombre;
		this.duracionDias = duracionDias;
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.controlDiarioLista = controlDiarioLista;
	}

    public String getToken() {
		return token;
	}

	public String getEnfermedadNombre() {
		return enfermedadNombre;
	}

	public void setEnfermedadNombre(String enfermedadNombre) {
		this.enfermedadNombre = enfermedadNombre;
	}

	public int getDuracionDias() {
		return duracionDias;
	}

	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}

	public LocalDate getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(LocalDate diaInicial) {
		this.diaInicial = diaInicial;
	}

	public LocalDate getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(LocalDate diaFinal) {
		this.diaFinal = diaFinal;
	}

	public ArrayList<ControlDiario> getControlDiarioLista() {
		return controlDiarioLista;
	}

	public void setControlDiarioLista(ArrayList<ControlDiario> controlDiarioLista) {
		this.controlDiarioLista = controlDiarioLista;
	}    
}
