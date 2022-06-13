package com.company.JSON;

import com.company.Class.Tratamiento;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TratamientoJSON implements InterfazJSON<Tratamiento>{


    @Override
    public void cargarJSON(ArrayList<Tratamiento> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Tratamiento> leerJSON() throws IOException {
        HashMap<String,Tratamiento> tratamientoHashMap = new HashMap<String,Tratamiento>();
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        List<Tratamiento> tratamientoList = mapper.readValue(file, mapper.getTypeFactory().
                                                                constructCollectionType(List.class, Tratamiento.class));
        for (Tratamiento a : tratamientoList) {
            tratamientoHashMap.put(a.getToken(), a);
        }
        return tratamientoHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Tratamiento.json";
    }
}
