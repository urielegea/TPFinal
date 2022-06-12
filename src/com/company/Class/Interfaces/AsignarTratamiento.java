package com.company.Class.Interfaces;

import java.util.HashMap;
import java.util.Random;
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

	// Genera un numero con los digitos del 0 al 9 con una cantidad de 10 caracteres con retorno String.
	
	public default String generateToken() {				
		String token = "";
		int min = 0, max = 10, cant = 0;
		Random random = new Random();
		while (cant < 10) {
			int value = random.nextInt(max + min) + min;
			token = token+""+value;
			cant++;
		}
		return token;
	}	
	
}
