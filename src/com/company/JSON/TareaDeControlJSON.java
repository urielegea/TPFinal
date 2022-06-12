package com.company.JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.company.Class.TareaDeControl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TareaDeControlJSON implements InterfazJSON <TareaDeControl>{

	@Override
	public void cargarJSON(ArrayList<TareaDeControl> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);		
	}

	@Override
	public HashMap<String, TareaDeControl> leerJSON() throws IOException {
        HashMap<String,TareaDeControl> tareaDeControlHashMap = new HashMap<String,TareaDeControl>();
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();		
		List<TareaDeControl> tareaList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, TareaDeControl.class));		
        for (TareaDeControl t : tareaList) {
        	tareaDeControlHashMap.put(t.getNombre(), t);
        }
        return tareaDeControlHashMap;
	}
	
	@Override
	public String getUbicacion() {
		return "TareaDeControlTDC.json";
	}
}