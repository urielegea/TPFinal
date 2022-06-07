package com.company.Class;

import java.util.ArrayList;
import java.util.HashMap;

public interface NuevoProfesional {

    public default Profesional crearProfesional(String nombre, String apellido, String dni, String telefono, String cuenta, String clave,
            String fechaAlta, ArrayList<String> pacienteLista, HashMap<String, Usuario> usuariosHashMap){    	
    	Profesional nuevoProfesional = null;    	
    	if(!buscarProfesionalConstructor(usuariosHashMap, cuenta)){
            nuevoProfesional = new Profesional(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,pacienteLista);
        }     	
    	return nuevoProfesional;
    }

    public default boolean buscarProfesionalConstructor(HashMap<String, Usuario> usuariosHashMap, String cuenta){
        boolean flag = false;
        if(!usuariosHashMap.containsKey(cuenta)){
            flag = true;
        }
        return flag;
    }
}
