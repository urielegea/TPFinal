package com.company.Class.Interfaces;

import com.company.Class.Enfermedad;
import com.company.Class.TareaDeControl;

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
    
    public default Enfermedad asignarTareaDeControlEnfermedad(ArrayList<String> listaNombreTDC, String nombreEnfermedad, 
    		HashMap<String, Enfermedad> enfermedadHashMap){
    	
		Enfermedad auxEnfermedad = enfermedadHashMap.get(nombreEnfermedad);
		if(auxEnfermedad.getTareaDeControlLista() != null){
			for(String t: listaNombreTDC){
				auxEnfermedad.getTareaDeControlLista().add(t);
			}
		}else{
			ArrayList<String> listaTDC = new ArrayList<String>();
			auxEnfermedad.setTareaDeControlLista(listaTDC);
			for(String s: listaNombreTDC) {
				auxEnfermedad.getTareaDeControlLista().add(s);
			}
		}
		if(auxEnfermedad.getTareaDeControlLista() != null) {
			return auxEnfermedad;
		}
		return null;
	}

	public default ArrayList<String> retornarTareasDeControlLibre(ArrayList<TareaDeControl> tareasDeControlLista,
																  Enfermedad enfermedad){
		ArrayList<String> TDC = new ArrayList<String>();
		ArrayList<String> aux = new ArrayList<String>(); //ESTO LO HIZO URIEL POR VAGO//
		for (TareaDeControl t : tareasDeControlLista) {
			aux.add(t.getNombre());
		}
		for (String s : aux) {
			boolean flag = false;
			for (String e : enfermedad.getTareaDeControlLista()) {
				if (e.compareToIgnoreCase(s) == 0) {
					flag = true;
				}
			}
			if(!flag){
				TDC.add(s);
			}
		}

		return TDC;
	}
}
