package com.company.JSON;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface InterfazJSON <T>{	
	
	public void cargarJSON(ArrayList<T> objList) throws IOException, ParseException;
	
	public HashMap<String,T> leerJSON() throws IOException;   
	
	public String getUbicacion();	
}