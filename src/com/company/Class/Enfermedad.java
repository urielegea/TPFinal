package com.company.Class;

import java.util.ArrayList;

public class Enfermedad {

    //Atributo que funciona como token
    private String nombre;
    private ArrayList<String> tareaDeControlLista;
    private String descripcion;
    private int duracionDias;
    
    public Enfermedad() {
    	
    }

    public Enfermedad(String nombre, ArrayList<String> tareaDeControlLista, String descripcion, int duracionDias) {
        this.nombre = nombre;
		this.tareaDeControlLista = tareaDeControlLista;
		this.descripcion = descripcion;
		this.duracionDias = duracionDias;
	}

    public String getNombre() {
		return nombre;
	}

	public ArrayList<String> getTareaDeControlLista() {
		return tareaDeControlLista;
	}

	public void setTareaDeControlLista(ArrayList<String> tareaDeControlLista) {
		this.tareaDeControlLista = tareaDeControlLista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracionDias() {
		return duracionDias;
	}

	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}

	@Override
	public String toString() {
		return "Enfermedad{" +
				"nombre='" + nombre + '\'' +
				", tareaDeControlLista=" + tareaDeControlLista +
				", descripcion='" + descripcion + '\'' +
				", duracionDias=" + duracionDias +
				'}';
	}
}