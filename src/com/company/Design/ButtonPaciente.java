package com.company.Design;

import com.company.Class.Paciente;

@SuppressWarnings("serial")
public class ButtonPaciente extends ButtonEdit{

	private Paciente paciente;
	
	public ButtonPaciente(Paciente paciente){
		super();
		this.paciente = paciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}	
}
