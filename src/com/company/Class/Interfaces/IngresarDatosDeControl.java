package com.company.Class.Interfaces;

import com.company.Class.*;

import java.util.ArrayList;
import java.util.Date;

public interface IngresarDatosDeControl {


    // Retorna el control diario en caso de existir en el tratamiento, y en caso contrario lo genera.

    public default ControlDiario retornarControlDiarioTratamiento (Tratamiento tratamiento, Date fecha) {
        ControlDiario controlDiario = getControlDiario(tratamiento.getControlDiarioLista(), fecha);
        if(controlDiario == null){
            controlDiario = crearControlDiario(tratamiento.getTareaDeControlListado(), fecha);
        }
        return controlDiario;
    }

    // Genera un control diario con sus tareas de control inicializadas segun su clase hija.

    public default ControlDiario crearControlDiario(ArrayList<TareaDeControl> tareaDeControlLista, Date fecha) {
        ArrayList<TareaDeControl> nuevaListaTDC = new ArrayList<TareaDeControl>();
        for(TareaDeControl t: tareaDeControlLista){
            String s = t.getEstructura().getTextoDescriptivo();
            if(t.getEstructura() instanceof DecimalTDC){
                nuevaListaTDC.add(new TareaDeControl(t.getNombre(),t.getAccion(),t.getObservacion(),new DecimalTDC(s)));
            }else if(t.getEstructura() instanceof EnteroTDC){
                nuevaListaTDC.add(new TareaDeControl(t.getNombre(),t.getAccion(),t.getObservacion(),new EnteroTDC(s)));
            }else if(t.getEstructura() instanceof NotaTDC){
                nuevaListaTDC.add(new TareaDeControl(t.getNombre(),t.getAccion(),t.getObservacion(),new NotaTDC(s)));
            }else if(t.getEstructura() instanceof VerdaderoFalsoTDC){
                nuevaListaTDC.add(new TareaDeControl(t.getNombre(),t.getAccion(),t.getObservacion(),new VerdaderoFalsoTDC(s)));
            }
        }
        return new ControlDiario(fecha, nuevaListaTDC);
    }

    // Retorna el controlDiario segun la fecha del mismo.

    public default ControlDiario getControlDiario(ArrayList<ControlDiario> controlDiarioLista, Date fecha) {
        ControlDiario controlDiario = null;
        if(controlDiarioLista!=null) {
            for (ControlDiario c : controlDiarioLista) {
                if (c.getFecha().compareTo(fecha) == 0) {
                    controlDiario = c;
                    return controlDiario;
                }
            }
        }
        return controlDiario;
    }


    // Guarda el control diario en la lista. En caso de no encontrarlo lo agrega, en caso contrario lo edita en base a la fecha.

    public default ArrayList<ControlDiario> guardarControlDiario(ArrayList<ControlDiario> controlDiarioLista, ControlDiario controlDiarioEdited){
        if(controlDiarioLista.isEmpty()){
            int last = controlDiarioLista.size() - 1;
            controlDiarioLista.remove(last);
            controlDiarioLista.add(last, controlDiarioEdited);

            return controlDiarioLista;
        }
        return null;
    }

}
