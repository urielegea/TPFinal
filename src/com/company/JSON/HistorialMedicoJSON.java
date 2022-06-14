package com.company.JSON;

import com.company.Class.HistorialMedico;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistorialMedicoJSON implements InterfazJSON<HistorialMedico>{

    @Override
    public void cargarJSON(ArrayList<HistorialMedico> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, HistorialMedico> leerJSON() throws IOException {
        HashMap<String,HistorialMedico> historialMedicoHashMap = new HashMap<String,HistorialMedico>();
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        List<HistorialMedico> historialMedicoList = mapper.readValue(file, mapper.getTypeFactory().
                                                                constructCollectionType(List.class, HistorialMedico.class));
        for (HistorialMedico hm : historialMedicoList) {
        	historialMedicoHashMap.put(hm.getNumeroHistorial(), hm);
        }
        return historialMedicoHashMap;
    }

    @Override
    public String getUbicacion() {
        return "HistorialMedico.json";
    }
}
