package com.company.JSON;

import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import com.company.Class.Administrador;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdministradorJSON implements InterfazJSON<Administrador> {

	@Override
	public void cargarJSON(ArrayList<Administrador> objList) throws IOException {
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, objList);		
	} 

	@Override
	public HashMap<String, Administrador> leerJSON() throws IOException{		 
		HashMap<String,Administrador> administradorHashMap = new HashMap<String,Administrador>();		
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();		
		List<Administrador> administradorList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Administrador.class));		
        for (Administrador a : administradorList) {
			administradorHashMap.put(a.getCuenta(), a);
        }	 
		return administradorHashMap;
	}

	@Override
	public String getUbicacion() {		
		return "Administradores.json";
	} 
}