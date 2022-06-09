package com.company.Class;

import java.util.Date;
import java.util.HashMap;

public interface NuevoPaciente {

    public default Paciente crearPaciente(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, 
    		Date fechaAlta, String numeroHistorial, HashMap<String, Usuario> usuariosHashMap){    	
    	Paciente nuevoPaciente = null;
        if(!buscarPacienteConstructor(usuariosHashMap,cuenta)){
            nuevoPaciente = new Paciente(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,numeroHistorial);
        }
        return nuevoPaciente;
    }

    public default boolean buscarPacienteConstructor(HashMap<String, Usuario> usuariosHashMap, String cuenta){
        boolean flag = false;
        if(usuariosHashMap.containsKey(cuenta)){
            flag = true;
        }
        return flag;
    }
}
