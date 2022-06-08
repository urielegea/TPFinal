package com.company.Design;

import com.company.Class.Profesional;

@SuppressWarnings("serial")
public class ButtonProfesional extends ButtonEdit{

	private Profesional profesional;
	
	public ButtonProfesional(Profesional profesional){
		super();
		this.profesional = profesional;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
}
