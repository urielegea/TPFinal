package com.company.Class;

import java.util.ArrayList;

public interface AdministrarEnfermedades {

    public default Enfermedad crearEnfermedad(String nombre, ArrayList<String> tareaDeControlLista,
                                              String descripcion, int duracionDias){
        return new Enfermedad(nombre,tareaDeControlLista,descripcion,duracionDias);
    }



}
