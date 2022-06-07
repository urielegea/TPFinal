package com.company.Class;

import java.util.HashMap;

public interface NuevoPaciente {

    public default Paciente crearPaciente(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, 
    		String fechaAlta, String numeroHistorial, HashMap<String, Usuario> usuarioHashMap){    	
    	Paciente nuevoPaciente = null;
        if(!buscarPacienteConstructor(usuarioHashMap,cuenta)){
            nuevoPaciente = new Paciente(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,numeroHistorial);
        }
        return nuevoPaciente;
    }

    public default boolean buscarPacienteConstructor(HashMap<String, Usuario> usuarioHashMap, String cuenta){
        boolean flag = false;
        if(usuarioHashMap.containsKey(cuenta)){
            flag = true;
        }
        return flag;
    }
}
