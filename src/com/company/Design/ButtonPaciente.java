package com.company.Design;

import com.company.Class.Paciente;

@SuppressWarnings("serial")
public class ButtonPaciente extends ButtonEdit{

	private Paciente paciente;
	private boolean pendientes;
	
	public ButtonPaciente(Paciente paciente){
		super();
		this.paciente = paciente;
		this.pendientes = false;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public boolean isPendientes() {
		return pendientes;
	}

	public void setPendientes(boolean pendientes) {
		this.pendientes = pendientes;
	}	
}
