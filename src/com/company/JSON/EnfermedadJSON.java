package com.company.JSON;

import com.company.Class.Enfermedad;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnfermedadJSON implements InterfazJSON <Enfermedad>{

    @Override
    public void cargarJSON(ArrayList<Enfermedad> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Enfermedad> leerJSON() throws IOException {
        HashMap<String,Enfermedad> enfermedadHashMap = new HashMap<String,Enfermedad>();
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();		
		List<Enfermedad> enfermedadList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Enfermedad.class));		
        for (Enfermedad e : enfermedadList) {
        	enfermedadHashMap.put(e.getNombre(), e);
        }	 
        return enfermedadHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Enfermedad.json";
    }
}