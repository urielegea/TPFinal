package com.company.Class.Interfaces;

import java.util.HashMap;

import com.company.Class.HistorialMedico;

public interface AsignarTratamiento {
	
	// Genera un nuevo tratamiento con el tipo de enfermedad y lo carga a un historial medico existente.
	
	public default HistorialMedico asignarTratamientoHistorialMedico(String numeroHistorialPaciente, String nombreEnfermedad,  HashMap<String, HistorialMedico> historialMedicoHashMap ){		
		return null;
	}
	
	// Genera un nuevo tratamiento con el tipo de enfermedad y lo carga a un nuevo historial medico.
	
	public default HistorialMedico asignarTratamientoHistorialMedico(String nombreEnfermedad,  HashMap<String, HistorialMedico> historialMedicoHashMap ){		
		return null;
	}
	
	// Genera un token unico para el historial medico. El mismo es de 10 caracteres.
	
	public default String generateTokenHistorialMedico(HashMap<String, HistorialMedico> historialMedicoHashMap) {
		return null;
	}
	
	// Genera un token unico para el tratamiento. El mismo es de 10 caracteres.
	
	public default String generateTokenTratamiento(HashMap<String, HistorialMedico> historialMedicoHashMap) {
		return null;
	}
	
}
