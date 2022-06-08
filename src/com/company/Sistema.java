package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.parser.ParseException;

import com.company.Design.*;
import com.company.JSON.AdministradorJSON;
import com.company.JSON.PacienteJSON;
import com.company.JSON.ProfesionalJSON;
import com.company.Class.*;

public class Sistema extends JFrame {

	private JPanel contentPane;
	
	// Perfil todos
	private LoginJPanel loginPane;
	private ButtonEdit loginButton;
	private ButtonEdit loginResetButton;
	
	// Perfil administrador.
	private MenuAdministradorJPanel menuAdministradorPane;
	private ButtonEdit nuevoProfesionalButton;
	private ButtonEdit nuevoPacienteButton;
	private ButtonEdit administrarEnfermedadButton;
	private ButtonEdit administrarTareaDeControlButton;
	private ButtonEdit cerrarMenuAdministradorButton;
	
	// Perfil profesional.
	private MenuProfesionalJPanel menuProfesionalPane;
	private ButtonEdit asignarPlanesDeControl;	
	private ButtonEdit controlRegistroDePacientes;
	private ButtonEdit finalizarPlanesDeControl;
	private ButtonEdit cerrarMenuProfesionalButton;
	
	// Perfil paciente.
	private MenuPacienteJPanel menuPacientePane;
	private ButtonEdit ingresarDatosDeControl;	
	private ButtonEdit cerrarMenuPacienteButton;
	
	// Perfil administrador.
	private GenerarProfesionalJPanel generarProfesionalJPanel;
	private ButtonEdit buttonGenerarProfesional;
	private ButtonEdit buttonGenerarProfesionalCancelar;	
	
	// Perfil administrador.
	private GenerarPacienteJPanel generarPacienteJPanel;
	private ButtonEdit buttonGenerarPaciente;
	private ButtonEdit buttonGenerarPacienteCancelar;	
	
	// Perfil administrador.
	private AdministrarEnfermedadesJPanel administrarEnfermedadesJPanel;
	private ButtonEdit nuevaEnfermedadButton;	
	private ButtonEdit editarEnfermedadButton;
	private ButtonEdit atrasEnfermedadButton;
	
	// ================================================
	
	private HashMap<String,Usuario> usuariosHashMap; 
	private Usuario usuarioActivo = null;
	
	public Sistema() {				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 500, 500);
		setLocationRelativeTo(null);
		setTitle("Centro de salud");		
		this.configContentPane();
		this.configLoginPane();		
		
		// =======================================	

		cargarUsuarios();
	}
	
	// Inicializacion y configuracion del panel contenedor.
	
	public void configContentPane(){
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	// Inicializacion, configuracion y eventos del panel login.
	
	public void configLoginPane() {
		loginPane = new LoginJPanel();
		loginPane.setBounds(0, 0, 484, 461);		
		loginButton = loginPane.getLoginButton();
		loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if (!loginPane.getUserField().getText().isEmpty() && !loginPane.getPasswordField().getText().isEmpty()) {        			
        			if (iniciarSesion(loginPane.getUserField().getText(),loginPane.getPasswordField().getText())) {
        				loginPane.setVisible(false);
        			}
        		}            	
            }
        }); 
		loginResetButton = loginPane.getResetButton();
		loginResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	loginPane.setUserField("");
            	loginPane.setPasswordField("");
            }
        }); 
		contentPane.add(loginPane);
	}
	
	// Inicializacion, configuracion y eventos del panel menu administrador.
	
	public void configMenuAdministrador() {		
		menuAdministradorPane = new MenuAdministradorJPanel();
		menuAdministradorPane.setBounds(0, 0, 484, 461);		
		nuevoProfesionalButton = menuAdministradorPane.getNuevoProfesionalButton();
		nuevoProfesionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configGenerarProfesionalJPanel();
        		menuAdministradorPane.setVisible(false);        		
            }
        }); 		
		nuevoPacienteButton = menuAdministradorPane.getNuevoPacienteButton();
		nuevoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configGenerarPacienteJPanel();
        		menuAdministradorPane.setVisible(false);
            }
        }); 
		administrarEnfermedadButton = menuAdministradorPane.getAdministrarEnfermedadButton();
		administrarEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configAdministrarEnfermedades();
            	menuAdministradorPane.setVisible(false);
            }
        }); 		
		administrarTareaDeControlButton = menuAdministradorPane.getAdministrarTareaDeControlButton();
		administrarTareaDeControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("administrarTareaDeControlButton...");
            }
        }); 		
		cerrarMenuAdministradorButton = menuAdministradorPane.getCerrarMenuAdministradorButton();
		cerrarMenuAdministradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("cerrarMenuAdministradorButton...");
            }
        }); 		
		contentPane.add(menuAdministradorPane);
		menuAdministradorPane.setVisible(true);
	}
	
	// Inicializacion, configuracion y eventos del panel menu profesional.
	
	public void configMenuProfesional() {
		menuProfesionalPane = new MenuProfesionalJPanel();
		menuProfesionalPane.setBounds(0, 0, 484, 461);		
		asignarPlanesDeControl = menuProfesionalPane.getAsignarPlanesDeControl();
		asignarPlanesDeControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("asignarPlanesDeControl...");
            }
        }); 		
		controlRegistroDePacientes = menuProfesionalPane.getControlRegistroDePacientes();
		controlRegistroDePacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("controlRegistroDePacientes...");
            }
        }); 
		finalizarPlanesDeControl = menuProfesionalPane.getFinalizarPlanesDeControl();
		finalizarPlanesDeControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("finalizarPlanesDeControl...");
            }
        }); 		
		cerrarMenuProfesionalButton = menuProfesionalPane.getCerrarMenuProfesionalButton();
		cerrarMenuProfesionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("cerrarMenuProfesionalButton...");
            }
        }); 		
		contentPane.add(menuProfesionalPane);
		menuProfesionalPane.setVisible(true);	
	}
	
	// Inicializacion, configuracion y eventos del panel menu paciente.
	
	public void configMenuPaciente() {
		menuPacientePane = new MenuPacienteJPanel();
		menuPacientePane.setBounds(0, 0, 484, 461);		
		ingresarDatosDeControl = menuPacientePane.getIngresarDatosDeControl();
		ingresarDatosDeControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("ingresarDatosDeControl...");
            }
        }); 		
		cerrarMenuPacienteButton = menuPacientePane.getCerrarMenuPacienteButton();
		cerrarMenuPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("cerrarMenuPacienteButton...");
            }
        }); 		
		contentPane.add(menuPacientePane);
		menuPacientePane.setVisible(true);			
	}	
	
	public void configGenerarProfesionalJPanel() {
		generarProfesionalJPanel = new GenerarProfesionalJPanel();
		generarProfesionalJPanel.setBounds(0, 0, 484, 461);				
		buttonGenerarProfesional = generarProfesionalJPanel.getButtonGenerarProfesional();
		buttonGenerarProfesional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (!generarProfesionalJPanel.getNombre().isEmpty() && !generarProfesionalJPanel.getApellido().isEmpty() && 
            			!generarProfesionalJPanel.getDni().isEmpty() && !generarProfesionalJPanel.getTelefono().isEmpty() &&
            			!generarProfesionalJPanel.getCuenta().isEmpty() && !generarProfesionalJPanel.getClave().isEmpty()) {
            		
                	String fechaAlta = "07-06-2022";
                	
                	if (nuevoProfesional(generarProfesionalJPanel.getNombre(), generarProfesionalJPanel.getApellido(), generarProfesionalJPanel.getDni(), 
                			generarProfesionalJPanel.getTelefono(), generarProfesionalJPanel.getCuenta(), generarProfesionalJPanel.getClave(), fechaAlta)) {  
                		
                		menuAdministradorPane.setVisible(true);
                		generarProfesionalJPanel.setVisible(false);
                		
                	} else {
                		mensajeLeer("No se pudo generar el nuevo profesional.");
                	}    
                	
            	} else {
            		mensajeLeer("Faltan datos obligatorios para generar el nuevo profesional.");
            	}
            }
        }); 
		buttonGenerarProfesionalCancelar = generarProfesionalJPanel.getButtonGenerarProfesionalCancelar();
		buttonGenerarProfesionalCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		generarProfesionalJPanel.setVisible(false);
            }
        }); 
		contentPane.add(generarProfesionalJPanel);
		generarProfesionalJPanel.setVisible(true);			
	}
	
	public void configGenerarPacienteJPanel() {
		generarPacienteJPanel = new GenerarPacienteJPanel();
		generarPacienteJPanel.setBounds(0, 0, 484, 461);				
		buttonGenerarPaciente = generarPacienteJPanel.getButtonGenerarPaciente();
		buttonGenerarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (!generarPacienteJPanel.getNombre().isEmpty() && !generarPacienteJPanel.getApellido().isEmpty() && 
            			!generarPacienteJPanel.getDni().isEmpty() && !generarPacienteJPanel.getTelefono().isEmpty() &&
            			!generarPacienteJPanel.getCuenta().isEmpty() && !generarPacienteJPanel.getClave().isEmpty()) {
            		
                	String fechaAlta = "07-06-2022";
                	
                	if (nuevoPaciente(generarPacienteJPanel.getNombre(), generarPacienteJPanel.getApellido(), generarPacienteJPanel.getDni(), 
                			generarPacienteJPanel.getTelefono(), generarPacienteJPanel.getCuenta(), generarPacienteJPanel.getClave(), fechaAlta)) {  
                		
                		menuAdministradorPane.setVisible(true);
                		generarPacienteJPanel.setVisible(false);
                		
                	} else {
                		mensajeLeer("No se pudo generar el nuevo paciente.");
                	}    
                	
            	} else {
            		mensajeLeer("Faltan datos obligatorios para generar el nuevo paciente.");
            	}
            }
        }); 
		buttonGenerarPacienteCancelar = generarPacienteJPanel.getButtonGenerarPacienteCancelar();
		buttonGenerarPacienteCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		generarPacienteJPanel.setVisible(false);
            }
        }); 
		contentPane.add(generarPacienteJPanel);
		generarPacienteJPanel.setVisible(true);			
	}
	
	public void configAdministrarEnfermedades() {
		administrarEnfermedadesJPanel = new AdministrarEnfermedadesJPanel();
		administrarEnfermedadesJPanel.setBounds(0, 0, 484, 461);		
		nuevaEnfermedadButton = administrarEnfermedadesJPanel.getNuevaEnfermedadButton();
		nuevaEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("nuevaEnfermedadButton...");
            }
        }); 		
		editarEnfermedadButton = administrarEnfermedadesJPanel.getEditarEnfermedadButton();
		editarEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("editarEnfermedadButton...");
            }
        }); 
		atrasEnfermedadButton = administrarEnfermedadesJPanel.getAtrasEnfermedadButton();
		atrasEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		administrarEnfermedadesJPanel.setVisible(false);
            }
        }); 		
		contentPane.add(administrarEnfermedadesJPanel);
		administrarEnfermedadesJPanel.setVisible(true);		
	}
	
	/* ============================================================================================================================== */
	/* ============================================================================================================================== */
	/* ============================================================================================================================== */
	
	public void cargarUsuarios() {		
		HashMap<String,Usuario> usuariosHashMap = new HashMap<String,Usuario>();
		HashMap<String,Administrador> administradorHashMap = leerAdministradorJSON();
		if (administradorHashMap != null) {
			for (HashMap.Entry<String, Administrador> obj : administradorHashMap.entrySet()) {
			    Administrador administrador = obj.getValue();
				usuariosHashMap.put(administrador.getCuenta(), administrador);
			}
		}
		HashMap<String,Profesional> profesionalHashMap = leerProfesionalJSON();
		if (profesionalHashMap != null) {
			for (HashMap.Entry<String, Profesional> obj : profesionalHashMap.entrySet()) {
			    Profesional profesional = obj.getValue();
				usuariosHashMap.put(profesional.getCuenta(), profesional);
			}
		}
		HashMap<String,Paciente> pacienteHashMap = leerPacienteJSON();
		if (pacienteHashMap != null) {
			for (HashMap.Entry<String, Paciente> obj : pacienteHashMap.entrySet()) {
			    Paciente paciente = obj.getValue();
				usuariosHashMap.put(paciente.getCuenta(), paciente);
			}
		}
		this.usuariosHashMap = usuariosHashMap;
	}
	
	public HashMap<String,Administrador> leerAdministradorJSON() {
		try {			
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			return administradorJSON.leerJSON();
		} catch (IOException | ParseException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	public HashMap<String,Profesional> leerProfesionalJSON() {
		try {			
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			return profesionalJSON.leerJSON();
		} catch (IOException | ParseException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	public HashMap<String,Paciente> leerPacienteJSON() {
		try {			
			PacienteJSON pacienteJSON =  new PacienteJSON();
			return pacienteJSON.leerJSON();
		} catch (IOException | ParseException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	public boolean iniciarSesion(String cuenta, String clave){		
		Usuario usuario = buscarUsuario(cuenta, clave);	
		boolean flag = false;
		if (usuario != null) {
			if (usuario instanceof Administrador) {
				usuarioActivo = usuario;
				this.configMenuAdministrador();
				flag = true;				
			} else if (usuario instanceof Profesional){
				usuarioActivo = usuario;
				this.configMenuProfesional();
				flag = true;				
			} else if (usuario instanceof Paciente) {
				usuarioActivo = usuario;
				this.configMenuPaciente();
				flag = true;
			} else {
				mensajeLeer("Lo siento, algo salido mal.");
			}
		}
		return flag;		
	}
			
	public Usuario buscarUsuario(String cuenta, String clave){
		Usuario usuario = null;
		if (this.usuariosHashMap.containsKey(cuenta)) {				
			if (this.usuariosHashMap.get(cuenta).getClave().compareTo(clave) == 0) {
				usuario = this.usuariosHashMap.get(cuenta);					
			} else {
				mensajeLeer("La clave es incorrecta.");
			}
		} else {
			mensajeLeer("No se encontraron coincidencias.");
		}	
		return usuario;
	}
	
	public boolean nuevoProfesional(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, String fechaAlta) {
		boolean flag = false;
		if (usuarioActivo instanceof Administrador) {			
			Administrador administrador = (Administrador) usuarioActivo;
	    	Profesional nuevoProfesional = administrador.crearProfesional(nombre, apellido, dni, telefono, cuenta, clave, 
	    			fechaAlta, null, this.usuariosHashMap);	    	
	    	if (nuevoProfesional != null) {
	    		try {
		    		ArrayList <Profesional> profesionalLista = new ArrayList<Profesional>();
		    		for (Usuario usuario : this.usuariosHashMap.values()) {
		    			if (usuario instanceof Profesional) {
		    				Profesional profesional = (Profesional) usuario;
		    				profesionalLista.add(profesional);
		    			}
		    		}
		    		profesionalLista.add(nuevoProfesional);	   		    	
		    		ProfesionalJSON profesionalJSON = new ProfesionalJSON();
					profesionalJSON.cargarJSON(profesionalLista);
					flag = true;					
				} catch (IOException | java.text.ParseException e) {
					mensajeLeer(e.toString());
				}
	    	} 
		}
		return flag;
	}
	
	public boolean nuevoPaciente(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, String fechaAlta) {
		boolean flag = false;
		if (usuarioActivo instanceof Administrador) {			
			Administrador administrador = (Administrador) usuarioActivo;
	    	Paciente nuevoPaciente = administrador.crearPaciente(nombre, apellido, dni, telefono, cuenta, clave, 
	    			fechaAlta, null, this.usuariosHashMap);	    	
	    	if (nuevoPaciente != null) {
	    		try {
		    		ArrayList <Paciente> pacienteLista = new ArrayList<Paciente>();
		    		for (Usuario usuario : this.usuariosHashMap.values()) {
		    			if (usuario instanceof Paciente) {
		    				Paciente paciente = (Paciente) usuario;
		    				pacienteLista.add(paciente);
		    			}
		    		}
		    		pacienteLista.add(nuevoPaciente);	   		    	
		    		PacienteJSON pacienteJSON = new PacienteJSON();
		    		pacienteJSON.cargarJSON(pacienteLista);
					flag = true;					
				} catch (IOException | java.text.ParseException e) {
					mensajeLeer(e.toString());
				}
	    	} 
		}
		return flag;
	}
	
	public void mensajeLeer(String mensaje) {
		System.out.println(mensaje);
	}
}