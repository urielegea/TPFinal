package com.company;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.parser.ParseException;
import com.company.Class.Administrador;
import com.company.JSON.AdministradorJSON;

public class Main {	
	
	public static void main(String[] args) {
		
		cargarAdministradorJSON();
		leerAdministradorJSON();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void cargarAdministradorJSON() {	
		
		ArrayList<Object> administradorLista = new ArrayList<Object>();		
		
		Administrador uri = new Administrador("Uriel", "Egea","42901369","223 7834651",
				"egeauriel@gmail.com","1234", "03-06-2022");	
		administradorLista.add(uri);	
		
		Administrador mati = new Administrador("Matias", "Valenzisi","42000000","223 0303456", 
				"matiasvalenzisi@gmail.com","1234", "03-06-2022");		
		administradorLista.add(mati);		
		
		Administrador gas = new Administrador("Gaspar", "Almaraz","42345603","223 42345603",
				"gasparalmaraz@gmail.com","1234", "03-06-2022");		
		administradorLista.add(gas);
		
		try {
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			administradorJSON.cargarJSON(administradorLista);
		} catch (IOException e) {
			System.out.print(e.toString());
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			System.out.print(e.toString());
		}
		
	}
	
	public static void leerAdministradorJSON() {
		try {			
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			HashMap<String,Object> administradorLista = administradorJSON.leerJSON();				
			for (HashMap.Entry<String, Object> obj : administradorLista.entrySet()) {
			    Administrador administrador = (Administrador)obj.getValue();
				System.out.println(administrador.toString());
			}			
		} catch (IOException e1) {
			System.out.print(e1.toString());
			
		} catch (ParseException e1) {
			System.out.print(e1.toString());
		}
	}
}
