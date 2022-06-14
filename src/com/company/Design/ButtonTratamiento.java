package com.company.Design;

import com.company.Class.Tratamiento;

@SuppressWarnings("serial")
public class ButtonTratamiento extends ButtonEdit{

	private Tratamiento tratamiento;
	
	public ButtonTratamiento(Tratamiento tratamiento){
		super();
		this.tratamiento = tratamiento;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}	
}
