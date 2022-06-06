package com.company.JSON;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface InterfazJSON {	
	
	public void cargarJSON(ArrayList<Object> objList) throws IOException, ParseException;
	
	public HashMap<String,Object> leerJSON() throws IOException, org.json.simple.parser.ParseException;   
	
	public String getUbicacion();	
}