package com.company.Class.Interfaces;

import com.company.Class.Profesional;
import com.company.Class.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface NuevoProfesional {

    public default Profesional crearProfesional(String nombre, String apellido, String dni, String telefono, String cuenta, String clave,
                                                Date fechaAlta, ArrayList<String> pacienteLista, HashMap<String, Usuario> usuariosHashMap){
    	Profesional nuevoProfesional = null;    	
    	if(!buscarProfesionalConstructor(usuariosHashMap, cuenta)){
            nuevoProfesional = new Profesional(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,pacienteLista);
        } 
    	return nuevoProfesional;
    }

    public default boolean buscarProfesionalConstructor(HashMap<String, Usuario> usuariosHashMap, String cuenta){
        boolean flag = false;
        if(usuariosHashMap.containsKey(cuenta)){
            flag = true;
        }
        return flag;
    }
}
