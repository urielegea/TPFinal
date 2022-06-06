package com.company.Class;

import java.util.HashMap;

public interface NuevoProfesional {

    public default Profesional crearProfesional(String nombre, String apellido, String dni, String telefono, String cuenta,
                                                String clave, String fechaAlta, HashMap<String, Paciente> pacienteLista){
        return new Profesional(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,pacienteLista);
    }

}
