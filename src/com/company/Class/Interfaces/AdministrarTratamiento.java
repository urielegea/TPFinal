package com.company.Class.Interfaces;

import com.company.Class.HistorialMedico;
import com.company.Class.Paciente;
import com.company.Class.TareaDeControl;
import com.company.Class.Tratamiento;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface AdministrarTratamiento {


    //Carga los nuevos datos en el tratamiento.

    public default HistorialMedico actualizarTratamiento(Paciente paciente, String tokenTratamiento,
                                                         int diasDuracion, ArrayList<TareaDeControl> tareaDeControlLista,
                                                         Date diaInicial,
                                                         HashMap<String, HistorialMedico> historialMedicoHashMap){


        Tratamiento tratamiento = buscarTratamiento(historialMedicoHashMap, paciente, tokenTratamiento);

        tratamiento.setTareaDeControlListado(tareaDeControlLista);
        tratamiento.setDuracionDias(diasDuracion);
        tratamiento.setDiaInicial(diaInicial);
        
        HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());

        historialMedico.setTratamientoLista(generarTratamientoLista(historialMedico,tratamiento));

        return historialMedico;
    }

    //Finaliza el tratamiento.

    public default HistorialMedico actualizarTratamiento(HashMap<String,HistorialMedico> historialMedicoHashMap,
                                                              String numeroHistorial, String tokenTratamiento, Paciente paciente){

        Tratamiento tratamiento = buscarTratamiento(historialMedicoHashMap, paciente, tokenTratamiento);

        tratamiento.setDiaFinal(new Date());

        HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());

        historialMedico.setTratamientoLista(generarTratamientoLista(historialMedico,tratamiento));

        return historialMedico;
    }

    //Busca un tratamiento a base del Token de este para asignarle los nuevos datos.

    public default Tratamiento buscarTratamiento(HashMap<String,HistorialMedico> historialMedicoHashMap, Paciente paciente,
                                                 String tokenTratamiento){

        Tratamiento tratamiento = new Tratamiento();
        ArrayList<Tratamiento> tratamientoLista = historialMedicoHashMap.get(paciente.getNumeroHistorial()).getTratamientoLista();
        for (Tratamiento t : tratamientoLista){
            if(t.getToken().compareTo(tokenTratamiento)==0){
                tratamiento = t;
                break;
            }
        }
        return tratamiento;
    }

    //Genera y retorna un ArrayList de Tratamientos actualizado teniendo en cuenta los tratamientos que poseia el Historial Medico

    public default ArrayList<Tratamiento> generarTratamientoLista(HistorialMedico historialMedico, Tratamiento tratamiento){
        ArrayList<Tratamiento> aux = new ArrayList<Tratamiento>();
        for(Tratamiento y : historialMedico.getTratamientoLista()){
            if (tratamiento.getToken().compareTo(y.getToken())==0){
                aux.add(tratamiento);
            } else{
                aux.add(y);
            }
        }

        return aux;
    }


}
