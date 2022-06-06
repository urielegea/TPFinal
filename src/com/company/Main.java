package com.company;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.company.Class.Paciente;
import com.company.Class.Profesional;
import com.company.JSON.ProfesionalJSON;
import org.json.simple.parser.ParseException;
import com.company.Class.Administrador;
import com.company.JSON.AdministradorJSON;

public class Main {	
	
	public static void main(String[] args) {
		
		/*cargarAdministradorJSON();
		leerAdministradorJSON();*/
		cargarProfesionalJSON();
		leerProfesionalJSON();
		
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
				"uriel@gmail.com","1234", "03-06-2022");	
		administradorLista.add(uri);	
		
		Administrador mati = new Administrador("Matias", "Valenzisi","42000000","223 0303456", 
				"matias@gmail.com","1234", "03-06-2022");		
		administradorLista.add(mati);		
		
		Administrador gas = new Administrador("Gaspar", "Almaraz","42345603","223 42345603",
				"gaspar@gmail.com","1234", "03-06-2022");		
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

	public static void cargarProfesionalJSON() {

		ArrayList<String> listaPacientes1 = new ArrayList<>();
		ArrayList<String> listaPacientes2 = new ArrayList<>();

		String email1 = "agaggini@gmail.com";
		String email2 = "correo2@gmail.com";
		String email3 = "correo3@gmail.com";
		String email4 = "correo4@gmail.com";

		listaPacientes1.add(email1);
		listaPacientes1.add(email2);
		listaPacientes2.add(email3);
		listaPacientes2.add(email4);



		ArrayList<Object> profesionalLista = new ArrayList<Object>();

		Profesional pepe = new Profesional("Pepe", "Pistolas","12345678","223 1234567",
				"pistolas@gmail.com","1234", "03-06-2022", null);
		profesionalLista.add(pepe);

		Profesional cosme = new Profesional("Cosme", "Fulanito","87654321","223 6668888",
				"fulanito@gmail.com","1234", "03-06-2022", listaPacientes2);
		profesionalLista.add(cosme);


		try {
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			profesionalJSON.cargarJSON(profesionalLista);
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
			HashMap<String,Object> administradorHashMap = administradorJSON.leerJSON();				
			for (HashMap.Entry<String, Object> obj : administradorHashMap.entrySet()) {
			    Administrador administrador = (Administrador)obj.getValue();
				System.out.println(administrador.toString());
			}			
		} catch (IOException | ParseException e1) {
			System.out.print(e1.toString());
			
		}
	}

	public static void leerProfesionalJSON() {
		try {
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			HashMap<String,Object> profesionalHashMap = profesionalJSON.leerJSON();
			for (HashMap.Entry<String, Object> obj : profesionalHashMap.entrySet()) {
				Profesional profesional = (Profesional) obj.getValue();
				System.out.println(profesional.toString());
			}
		} catch (IOException | ParseException e1) {
			System.out.print(e1.toString());

		}
	}
}