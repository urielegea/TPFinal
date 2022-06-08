package com.company.Class;

import java.util.HashMap;

public interface AsignarProfesional {

    public default boolean asignarProfesional(String cuentaProfesional, String cuentaPaciente, HashMap<String, Usuario> usuarioHashMap ){
        return false;
    }
}
