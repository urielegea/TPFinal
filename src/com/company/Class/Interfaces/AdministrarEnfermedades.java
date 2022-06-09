package com.company.Class.Interfaces;

import com.company.Class.Enfermedad;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdministrarEnfermedades {

    public default Enfermedad crearEnfermedad(String nombre, ArrayList<String> tareaDeControlLista,
                                              String descripcion, int duracionDias, ArrayList<Enfermedad> enfermedadLista){
        boolean flag = false;
        for(Enfermedad e : enfermedadLista) {
            if (e.getNombre().compareToIgnoreCase(nombre) == 0) {
                flag = true;
            }
        }
        if(!flag) {
            return new Enfermedad(nombre, tareaDeControlLista, descripcion, duracionDias);
        }
        return null;
    }


}
