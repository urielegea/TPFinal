package com.company.Class;

import java.util.Scanner;

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

    public default TareaDeControl crearTareaDeControl(String token, boolean accion, String observacion, EstructuraTDC estructura){
        return new TareaDeControl(token,accion,observacion,estructura);
    }

}
