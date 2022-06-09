package com.company.Class.Interfaces;

import com.company.Class.Profesional;
import com.company.Class.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public interface AsignarProfesional {

    public default Profesional asignarProfesional(String cuentaProfesional, String cuentaPaciente, HashMap<String, Usuario> usuarioHashMap ){
        Profesional auxProfesional = (Profesional) usuarioHashMap.get(cuentaProfesional);
        if(auxProfesional.getPacienteLista()!=null){
            boolean flag = false;
            for (String s: auxProfesional.getPacienteLista()){
                if(s.compareTo(cuentaPaciente)==0){
                    flag = true;
                }
            }
            if(!flag) {
                auxProfesional.getPacienteLista().add(cuentaPaciente);
            }
        }else{
            ArrayList<String> listaPaciente = new ArrayList<String>();
            auxProfesional.setPacienteLista(listaPaciente);
            auxProfesional.getPacienteLista().add(cuentaPaciente);
        }
        for(String s: auxProfesional.getPacienteLista()){
            if(s.compareTo(cuentaPaciente)==0){
                return auxProfesional;
            }
        }
        return null;
    }
}
