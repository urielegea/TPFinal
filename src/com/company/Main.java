package com.company;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {	
	
	public static void main(String[] args) throws IOException {

		//cargaAdministrador();
		leerAdministradores();

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



	public static void cargaAdministrador() throws IOException {

		//ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		Administrador uri = new Administrador("Uriel", "Egea","42901369","223 7834651",
				"egeauriel@gmail.com","1234", LocalDate.now());
		Administrador mati = new Administrador("Matias", "Valenzisi","42000000","223 0303456",
				"matiasvalenzisi@gmail.com","1234", LocalDate.now());
		Administrador gas = new Administrador("Gaspar", "Almaraz","42345603","223 42345603",
				"gasparalmaraz@gmail.com","1234", LocalDate.now());

		/*usuarios.add(uri);
		usuarios.add(mati);
		usuarios.add(gas);*/

		File file = new File("Administradores.json");

		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(file, uri);
	}

	public static void leerAdministradores() throws IOException {

		File file = new File("Administradores.json");

		ObjectMapper mapper = new ObjectMapper();
		Administrador p = mapper.readValue(file, Administrador.class);
		System.out.println(p);

	}
}
