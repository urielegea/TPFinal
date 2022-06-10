package com.company.JSON;

import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.company.Class.Profesional;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProfesionalJSON implements InterfazJSON <Profesional>{

    @Override
    public void cargarJSON(ArrayList<Profesional> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Profesional> leerJSON() throws IOException {
		HashMap<String,Profesional> profesionalHashMap = new HashMap<String,Profesional>();		
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();		
		List<Profesional> profesionalList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Profesional.class));		
        for (Profesional p : profesionalList) {
			profesionalHashMap.put(p.getCuenta(), p);
        }	 
        return profesionalHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Profesional.json";
    }
}