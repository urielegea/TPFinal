package com.company.Class.Interfaces;

import com.company.Class.HistorialMedico;
import com.company.Class.Paciente;
import com.company.Class.TareaDeControl;
import com.company.Class.Tratamiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface AdministrarTratamiento {


    public default HistorialMedico actualizarTratamiento(Paciente paciente, String tokenTratamiento,
                                                         int diasDuracion, ArrayList<TareaDeControl> tareaDeControlLista,
                                                         Date diaInicial,
                                                         HashMap<String, HistorialMedico> historialMedicoHashMap){
        Tratamiento tratamiento = new Tratamiento();
        ArrayList<Tratamiento> aux = new ArrayList<Tratamiento>();
        ArrayList<Tratamiento> tratamientoLista = historialMedicoHashMap.get(paciente.getNumeroHistorial()).getTratamientoLista();
        for (Tratamiento t : tratamientoLista){
            if(t.getToken().compareTo(tokenTratamiento)==0){
                tratamiento = t;
                break;
            }
        }
        tratamiento.setTareaDeControlListado(tareaDeControlLista);
        tratamiento.setDuracionDias(diasDuracion);
        tratamiento.setDiaInicial(diaInicial);
        
        HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());
        for(Tratamiento y : historialMedico.getTratamientoLista()){
            if (tratamiento.getToken().compareTo(y.getToken())==0){
                aux.add(tratamiento);
            } else{
                aux.add(y);
            }
        }
        historialMedico.setTratamientoLista(aux);
        return historialMedico;
    }

    public default HistorialMedico actualizarTratamiento(HashMap<String,HistorialMedico> historialMedicoHashMap,
                                                              String numeroHistorial, String tokenTratamiento, Paciente paciente){

        Tratamiento tratamiento = new Tratamiento();
        ArrayList<Tratamiento> aux = new ArrayList<Tratamiento>();
        ArrayList<Tratamiento> tratamientoLista = historialMedicoHashMap.get(paciente.getNumeroHistorial()).getTratamientoLista();
        for (Tratamiento t : tratamientoLista){
            if(t.getToken().compareTo(tokenTratamiento)==0){
                tratamiento = t;
                break;
            }
        }
        tratamiento.setDiaFinal(new Date());

        HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());
        for(Tratamiento y : historialMedico.getTratamientoLista()){
            if (tratamiento.getToken().compareTo(y.getToken())==0){
                aux.add(tratamiento);
            } else{
                aux.add(y);
            }
        }
        historialMedico.setTratamientoLista(aux);

        return historialMedico;
    }

}
