package com.company.Class.Interfaces;

import com.company.Class.*;

import java.util.ArrayList;

public interface AdministrarTareaDeControl {

    public default EnteroTDC crearEnteroTDC(String texto){
        return new EnteroTDC(texto);
    }

    public default NotaTDC crearNotaTDC(String texto){
        return new NotaTDC(texto);
    }

    public default DecimalTDC crearDecimalTDC(String texto){
        return new DecimalTDC(texto);
    }

    public default VerdaderoFalsoTDC crearVoFTDC(String texto){
        return new VerdaderoFalsoTDC(texto);
    }

    public default TareaDeControl crearTareaDeControl(String token, boolean accion, String observacion,
                                                      EstructuraTDC estructura, ArrayList<TareaDeControl> tareaDeControlLista){
        boolean flag = false;
        for (TareaDeControl t: tareaDeControlLista){
            if(t.getNombre().compareToIgnoreCase(token)==0){
                flag = true;
            }
        }
        if (!flag){
            return new TareaDeControl(token,accion,observacion,estructura);
        }
        return null;
    }

}
