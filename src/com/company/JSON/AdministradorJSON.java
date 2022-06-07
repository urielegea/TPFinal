package com.company.JSON;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.text.ParseException;
import com.company.Class.Administrador;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdministradorJSON implements InterfazJSON<Administrador> {

	@Override
	public void cargarJSON(ArrayList<Administrador> objList) throws IOException, ParseException {
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, objList);		
	} 

	@Override
	public HashMap<String, Administrador> leerJSON() throws IOException, org.json.simple.parser.ParseException {
		 
		HashMap<String,Administrador> administradorHashMap = new HashMap<String,Administrador>();
		
		Object objectJSON = new JSONParser().parse(new FileReader(this.getUbicacion()));
		JSONArray arrayJSON = (JSONArray) objectJSON;
		Iterator<?> i = arrayJSON.iterator();		 
		
		while (i.hasNext()) {				 
			JSONObject administradorJSON = (JSONObject) i.next();
			String nombre = (String)administradorJSON.get("nombre");
			String apellido = (String)administradorJSON.get("apellido");
			String dni = (String)administradorJSON.get("dni");
			String telefono = (String)administradorJSON.get("telefono");
			String cuenta = (String)administradorJSON.get("cuenta");
			String clave = (String)administradorJSON.get("clave");
			String fechaAlta = (String)administradorJSON.get("fechaAlta");
			String ultimaSesion = (String)administradorJSON.get("ultimaSesion");
			 
			Administrador administrador = new Administrador(nombre, apellido, dni, telefono, cuenta,
					 clave, fechaAlta, ultimaSesion);
			administradorHashMap.put(cuenta ,administrador);
		}			 
		return administradorHashMap;
	}

	@Override
	public String getUbicacion() {		
		return "Administradores.json";
	} 
}