package com.company;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.company.Class.Enfermedad;
import com.company.Class.Profesional;
import com.company.JSON.EnfermedadJSON;
import com.company.JSON.ProfesionalJSON;
import org.json.simple.parser.ParseException;
import com.company.Class.Administrador;
import com.company.JSON.AdministradorJSON;

public class Main {	
	
	public static void main(String[] args) {
		
		cargarAdministradorJSON();
		//leerAdministradorJSON();
		cargarProfesionalJSON();
		//leerProfesionalJSON();
		cargarEnfermedadJSON();
		//leerEnfermedadJSON();
		
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
		
		ArrayList<Object> profesionalLista = new ArrayList<Object>();		
		
		Profesional roberto = new Profesional("Roberto", "Perez","265630","222 6748532",
				"roberto@gmail.com","1234", "07-06-2022", null);	
		profesionalLista.add(roberto);	
		
		Profesional emilio = new Profesional("Emilio", "Sanchez","546478","223 9688328",
				"emilio@gmail.com","1234", "07-06-2022", null);	
		profesionalLista.add(emilio);	
		
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

	public static void cargarEnfermedadJSON() {

		ArrayList<Object> enfermedadLista = new ArrayList<>();

		Enfermedad tos = new Enfermedad("Tos comun", null, "una simple tos", 2);
		enfermedadLista.add(tos);

		Enfermedad fiebre = new Enfermedad("Fiebre", null, "Fiebre de mas de 38 grados", 6);
		enfermedadLista.add(fiebre);

		try {
			EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
			enfermedadJSON.cargarJSON(enfermedadLista);
		} catch (IOException e) {
			System.out.print(e.toString());
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			System.out.print(e.toString());
		}
	}

	public static void leerEnfermedadJSON() {
		try {
			EnfermedadJSON enfermedadJSON =  new EnfermedadJSON();
			HashMap<String,Object> enfermedadHashMap = enfermedadJSON.leerJSON();
			for (HashMap.Entry<String, Object> obj : enfermedadHashMap.entrySet()) {
				Enfermedad enfermedad = (Enfermedad) obj.getValue();
				System.out.println(enfermedad.toString());
			}
		} catch (IOException | ParseException e1) {
			System.out.print(e1.toString());

		}
	}
}