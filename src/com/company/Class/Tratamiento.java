package com.company.Class;

import java.util.ArrayList;
import java.util.Date;

public class Tratamiento {

    private String token;
    private String enfermedadNombre;
    private int duracionDias;
    private Date diaInicial;
    private Date diaFinal;
    private ArrayList<ControlDiario> controlDiarioLista;
	private ArrayList<TareaDeControl> tareaDeControlListado;
	private String profesionalCuenta;
	
	public Tratamiento() {
		
	}
	
    public Tratamiento(String token, String enfermedadNombre, String profesionalCuenta) {
		this.token = token;
		this.enfermedadNombre = enfermedadNombre;
		this.profesionalCuenta = profesionalCuenta;
	}

    public Tratamiento(String token, String enfermedadNombre, int duracionDias, Date diaInicial,
					   Date diaFinal, ArrayList<ControlDiario> controlDiarioLista, String profesionalCuenta,
					   ArrayList<TareaDeControl> tareaDeControlListado) {
		this.token = token;
		this.enfermedadNombre = enfermedadNombre;
		this.duracionDias = duracionDias;
		this.diaInicial = diaInicial;
		this.diaFinal = diaFinal;
		this.controlDiarioLista = controlDiarioLista;
		this.profesionalCuenta = profesionalCuenta;
		this.tareaDeControlListado = tareaDeControlListado;
	}

    public String getToken() {
		return token;
	}
    
	public void setToken(String token) {
		this.token = token;
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

	public Date getDiaInicial() {
		return diaInicial;
	}

	public void setDiaInicial(Date diaInicial) {
		this.diaInicial = diaInicial;
	}

	public Date getDiaFinal() {
		return diaFinal;
	}

	public void setDiaFinal(Date diaFinal) {
		this.diaFinal = diaFinal;
	}

	public ArrayList<ControlDiario> getControlDiarioLista() {
		return controlDiarioLista;
	}

	public void setControlDiarioLista(ArrayList<ControlDiario> controlDiarioLista) {
		this.controlDiarioLista = controlDiarioLista;
	}

	public String getProfesionalCuenta() {
		return profesionalCuenta;
	}

	public void setProfesionalCuenta(String profesionalCuenta) {
		this.profesionalCuenta = profesionalCuenta;
	}

	public ArrayList<TareaDeControl> getTareaDeControlListado() {
		return tareaDeControlListado;
	}

	public void setTareaDeControlListado(ArrayList<TareaDeControl> tareaDeControlListado) {
		this.tareaDeControlListado = tareaDeControlListado;
	}

	@Override
	public String toString() {
		return "Tratamiento{" +
				"token='" + token + '\'' +
				", profesionalCuenta='" + profesionalCuenta + '\'' +
				", enfermedadNombre='" + enfermedadNombre + '\'' +
				", duracionDias=" + duracionDias +
				", diaInicial=" + diaInicial +
				", diaFinal=" + diaFinal +
				", controlDiarioLista=" + controlDiarioLista +
				'}';
	}
}