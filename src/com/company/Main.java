package com.company;

import java.awt.EventQueue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.company.Class.*;
import com.company.JSON.*;

public class Main {	
	
	public static void main(String[] args) {
		
		cargarAdministradorJSON();		
		//leerAdministradorJSON();
		cargarProfesionalJSON();
		//leerProfesionalJSON();
		cargarPacienteJSON();
		//leerPacienteJSON();
		cargarEnfermedadJSON();
		//leerEnfermedadJSON();
		cargarTareaDeControlJSON();
		//leerTareaDeControlJSON();
		cargarHistorialMedicoJSON();
		//leerHistorialMedicoJSON();
		
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
		
		ArrayList<Administrador> administradorLista = new ArrayList<Administrador>();	
		
		String fecha="03-06-2022";  
		Date fechaAlta = new Date();
		try {
			fechaAlta = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		Administrador uri = new Administrador("Uriel", "Egea","42.901.369","223 783-4651",
				"uriel@gmail.com","1234", fechaAlta);	
		administradorLista.add(uri);	
		
		Administrador mati = new Administrador("Matias", "Valenzisi","40.060.005","251 030-3456", 
				"matias@gmail.com","1234", fechaAlta);		
		administradorLista.add(mati);		
		
		Administrador gas = new Administrador("Gaspar", "Almaraz","42345603","239 423-45603",
				"gaspar@gmail.com","1234", fechaAlta);		
		administradorLista.add(gas);
		
		try {
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			administradorJSON.cargarJSON(administradorLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		} 		
	}
	
	public static void leerAdministradorJSON() {
		try {			
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			HashMap<String,Administrador> administradorHashMap = administradorJSON.leerJSON();				
			for (HashMap.Entry<String, Administrador> obj : administradorHashMap.entrySet()) {
			    Administrador administrador = obj.getValue();
				System.out.println(administrador.toString());
			}			
		} catch (IOException e1) {
			System.out.print(e1.toString());			
		}
	}
	
	public static void cargarProfesionalJSON() {	
		
		ArrayList<Profesional> profesionalLista = new ArrayList<Profesional>();
		String fecha="03-06-2022";  
		Date fechaAlta = new Date();
		try {
			fechaAlta = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		Profesional roberto = new Profesional("Roberto", "Perez","18.365.560","222 674-8532",
				"roberto@gmail.com","1234", fechaAlta, null);	
		profesionalLista.add(roberto);	
		
		Profesional emilio = new Profesional("Emilio", "Sanchez","22.001.258","110 968-8328",
				"emilio@gmail.com","1234", fechaAlta, null);	
		profesionalLista.add(emilio);	
		
		try {
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			profesionalJSON.cargarJSON(profesionalLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		} 		
	}
	
    public static void leerProfesionalJSON() {
        try {
            ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
            HashMap<String,Profesional> profesionalHashMap = profesionalJSON.leerJSON();
            for (HashMap.Entry<String, Profesional> obj : profesionalHashMap.entrySet()) {
                Profesional profesional = obj.getValue();
                System.out.println(profesional.toString());
            }
        } catch (IOException e1) {
            System.out.print(e1.toString());
        }
    }
    
	public static void cargarPacienteJSON() {	
		
		ArrayList<Paciente> pacienteLista = new ArrayList<Paciente>();	
		String fecha="03-06-2022";  
		Date fechaAlta = new Date();
		try {
			fechaAlta = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		
		Paciente jaime = new Paciente("Jaime", "Lopez","27.528.562","112 565-2825",
				"jaime@gmail.com","1234", fechaAlta, "0000000000");	
		pacienteLista.add(jaime);
		
		Paciente romina = new Paciente("Romina", "Sanchez","18.902.120","223 542-7565",
				"romina@gmail.com","1234", fechaAlta, null);	
		pacienteLista.add(romina);
		
		try {
			PacienteJSON pacienteJSON =  new PacienteJSON();
			pacienteJSON.cargarJSON(pacienteLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		} 		
	}
	
    public static void leerPacienteJSON() {
        try {
            PacienteJSON pacienteJSON =  new PacienteJSON();
            HashMap<String,Paciente> pacienteHashMap = pacienteJSON.leerJSON();
            for (HashMap.Entry<String, Paciente> obj : pacienteHashMap.entrySet()) {
                Paciente paciente = obj.getValue();
                System.out.println(paciente.toString());
            }
        } catch (IOException e1) {
            System.out.print(e1.toString());
        }
    }

	public static void cargarEnfermedadJSON() {

		ArrayList<Enfermedad> enfermedadLista = new ArrayList<>();

		Enfermedad tos = new Enfermedad("Gripe A", null, "Mucha tos", 2);
		enfermedadLista.add(tos);

		Enfermedad fiebre = new Enfermedad("Covid", null, "Fiebre de mas de 38 grados, contagioso", 6);
		enfermedadLista.add(fiebre);

		try {
			EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
			enfermedadJSON.cargarJSON(enfermedadLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		} 
	}

	public static void leerEnfermedadJSON() {
		try {
			EnfermedadJSON enfermedadJSON =  new EnfermedadJSON();
			HashMap<String,Enfermedad> enfermedadHashMap = enfermedadJSON.leerJSON();
			for (HashMap.Entry<String, Enfermedad> obj : enfermedadHashMap.entrySet()) {
				Enfermedad enfermedad = obj.getValue();
				System.out.println(enfermedad.toString());
			}
		} catch (IOException e1) {
			System.out.print(e1.toString());
		}
	}

	public static void cargarTareaDeControlJSON(){

		ArrayList<TareaDeControl> tdcLista = new ArrayList<>();
		
		DecimalTDC decimal1 = new DecimalTDC("Temperatura:");
		EnteroTDC entero1 = new EnteroTDC("Presion:");
		VerdaderoFalsoTDC verdaderoFalso1 = new VerdaderoFalsoTDC("Fiebre:");

		TareaDeControl tareaDeControl1 = new TareaDeControl("Tomar Temperatura",false,
													"Observacion de temperatura.", decimal1);
		
		TareaDeControl tareaDeControl2 = new TareaDeControl("Tomar Presion",false,
														"Se toma la presion.",entero1);
		
		TareaDeControl tareaDeControl3 = new TareaDeControl("Tomar Fiebre",false,
														"Se comprueba la fiebre.",verdaderoFalso1);
		tdcLista.add(tareaDeControl1);
		tdcLista.add(tareaDeControl2);
		tdcLista.add(tareaDeControl3);

		try {
			TareaDeControlJSON tareaDeControlJSON = new TareaDeControlJSON();
			tareaDeControlJSON.cargarJSON(tdcLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		}
	}

	public static void leerTareaDeControlJSON(){
		try {
			TareaDeControlJSON tareaDeControlJSON = new TareaDeControlJSON();
			HashMap<String,TareaDeControl> tareaDeControlHashMap = tareaDeControlJSON.leerJSON();
			for (HashMap.Entry<String, TareaDeControl> obj : tareaDeControlHashMap.entrySet()) {
				TareaDeControl tareaDeControl = obj.getValue();
				System.out.println(tareaDeControl.toString());
			}
		} catch (IOException e1) {
			System.out.print(e1.toString());
		}
	}

	public static void cargarHistorialMedicoJSON(){
		
		ArrayList<HistorialMedico> historialMedicoLista = new ArrayList<HistorialMedico>();
		
		ArrayList<Tratamiento> tratamientoLista = new ArrayList<>();
		Tratamiento tratamiento = new Tratamiento("1111111111","Gripe A","roberto@gmail.com");
		tratamientoLista.add(tratamiento);

		HistorialMedico historialMedico = new HistorialMedico("0000000000", tratamientoLista);
		historialMedicoLista.add(historialMedico);
		
		try {
			HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
			historialMedicoJSON.cargarJSON(historialMedicoLista);
		} catch (IOException e) {
			System.out.print(e.toString());
		}
	}
	
	public static void leerHistorialMedicoJSON(){
		try {
			HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
			HashMap<String,HistorialMedico> historialMedicoHashMap = historialMedicoJSON.leerJSON();
			for (HashMap.Entry<String, HistorialMedico> obj : historialMedicoHashMap.entrySet()) {
				HistorialMedico historialMedico = obj.getValue();
				System.out.println(historialMedico.toString());
			}
		} catch (IOException e1) {
			System.out.print(e1.toString());
		}
	}
}