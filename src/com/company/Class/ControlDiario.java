package com.company.Class;

import java.util.ArrayList;
import java.util.Date;

public class ControlDiario {
    
    private Date fecha;
    private ArrayList<TareaDeControl> tareaDeControlLista;   
    
    public ControlDiario(Date fecha, ArrayList<TareaDeControl> tareaDeControlLista){
        this.fecha = fecha;
        this.tareaDeControlLista = tareaDeControlLista;
    }  
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<TareaDeControl> getTareaDeControlLista() {
        return tareaDeControlLista;
    }

    public void setTareaDeControlLista(ArrayList<TareaDeControl> tareaDeControlLista) {
        this.tareaDeControlLista = tareaDeControlLista;
    }

	@Override
	public String toString() {
		return "ControlDiario [fecha=" + fecha + ", tareaDeControlLista=" + tareaDeControlLista + "]";
	}   
}