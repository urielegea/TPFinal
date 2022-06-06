package com.company.Class;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControlDiario {
    
    private LocalDate fecha;
    private ArrayList<TareaDeControl> tareaDeControlLista;   
    
    public ControlDiario(LocalDate fecha, ArrayList<TareaDeControl> tareaDeControlLista){
        this.fecha = fecha;
        this.tareaDeControlLista = tareaDeControlLista;
    }  
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<TareaDeControl> getTareaDeControlLista() {
        return tareaDeControlLista;
    }

    public void setTareaDeControlLista(ArrayList<TareaDeControl> tareaDeControlLista) {
        this.tareaDeControlLista = tareaDeControlLista;
    }
}