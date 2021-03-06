package com.company.Class.Interfaces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import com.company.Class.HistorialMedico;
import com.company.Class.Tratamiento;

public interface AsignarTratamiento {
	
	// Genera un nuevo tratamiento con el tipo de enfermedad y lo carga a un historial medico existente.
	
	public default HistorialMedico asignarTratamientoHistorialMedico(String numeroHistorialPaciente,
																	 String nombreEnfermedad,
																	 HashMap<String, HistorialMedico> historialMedicoHashMap,
																	 String cuentaProfesional ){

		Tratamiento tratamiento = new Tratamiento(generateTokenTratamiento(historialMedicoHashMap), nombreEnfermedad, cuentaProfesional);
		HistorialMedico historialMedico = historialMedicoHashMap.get(numeroHistorialPaciente);
		historialMedico.getTratamientoLista().add(tratamiento);
		return historialMedico;
	}
	
	// Genera un nuevo tratamiento con el tipo de enfermedad y lo carga a un nuevo historial medico.
	
	public default HistorialMedico asignarTratamientoHistorialMedico(String nombreEnfermedad,
																	 HashMap<String, HistorialMedico> historialMedicoHashMap,
																	 String cuentaProfesional){

		Tratamiento tratamiento = new Tratamiento(generateTokenTratamiento(historialMedicoHashMap), nombreEnfermedad, cuentaProfesional);
		ArrayList<Tratamiento> tratamientoLista = new ArrayList<Tratamiento>();
		tratamientoLista.add(tratamiento);
		HistorialMedico historialMedico = new HistorialMedico(generateTokenHistorialMedico(historialMedicoHashMap),tratamientoLista);
		return historialMedico;
	}
	
	// Genera un token unico para el historial medico. El mismo es de 10 caracteres.
	
	public default String generateTokenHistorialMedico(HashMap<String, HistorialMedico> historialMedicoHashMap) {
		String tokenHistorialMedico = "";
		boolean flag = true;
		while (flag){
			flag = false;
			tokenHistorialMedico = generateToken();
			for(HistorialMedico historialMedico : historialMedicoHashMap.values()){
				if(historialMedico.getNumeroHistorial().compareTo(tokenHistorialMedico) == 0){
					flag = true;
				}
			}
		}
		return tokenHistorialMedico;
	}
	
	// Genera un token unico para el tratamiento. El mismo es de 10 caracteres.
	
	public default String generateTokenTratamiento(HashMap<String, HistorialMedico> historialMedicoHashMap) {
		String tokenTratamiento = "";
		boolean flag = true;
		while (flag) {
			flag = false;
			tokenTratamiento = generateToken();
			for (HistorialMedico historialMedico : historialMedicoHashMap.values()) {
				for (Tratamiento tratamiento : historialMedico.getTratamientoLista()) {
					if (tratamiento.getToken().compareTo(tokenTratamiento) == 0) {
						flag = true;
					}
				}
			}
		}		
		return tokenTratamiento;
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
