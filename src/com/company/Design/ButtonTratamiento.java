package com.company.Design;

import com.company.Class.Tratamiento;

@SuppressWarnings("serial")
public class ButtonTratamiento extends ButtonEdit{

	private Tratamiento tratamiento;
	private boolean pendientes;
	
	public ButtonTratamiento(Tratamiento tratamiento){
		super();
		this.tratamiento = tratamiento;
		this.pendientes = false;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public boolean isPendientes() {
		return pendientes;
	}

	public void setPendientes(boolean pendientes) {
		this.pendientes = pendientes;
	}
	
}
