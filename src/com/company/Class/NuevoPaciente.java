package com.company.Class;

import java.util.HashMap;

public interface NuevoPaciente {

    public default Paciente crearPaciente(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String cuenta,
            String clave,
            String fechaAlta,
            String numeroHistorial,
            HashMap<String, Usuario> usuarioHashMap){

        if(!buscarPacienteConstructor(usuarioHashMap,cuenta)){
            return new Paciente(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,numeroHistorial);
        }else{
            return null;
        }
    }

    public default boolean buscarPacienteConstructor(HashMap<String, Usuario> usuarioHashMap, String cuenta){
        boolean flag = false;
        if(usuarioHashMap.containsKey(cuenta)){
            flag = true;
        }
        return flag;
    }
}
