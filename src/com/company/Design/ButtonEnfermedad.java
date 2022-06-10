package com.company.Design;

import com.company.Class.Enfermedad;

@SuppressWarnings("serial")
public class ButtonEnfermedad extends ButtonEdit{
	
	private Enfermedad enfermedad;
	
	public ButtonEnfermedad(Enfermedad enfermedad){
		super();
		this.enfermedad = enfermedad;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}	
}
