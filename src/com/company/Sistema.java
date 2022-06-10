package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.company.Design.*;
import com.company.JSON.AdministradorJSON;
import com.company.JSON.EnfermedadJSON;
import com.company.JSON.PacienteJSON;
import com.company.JSON.ProfesionalJSON;
import com.company.Class.*;

@SuppressWarnings("serial")
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
	private ButtonEdit asignarProfesionalButton;
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
	private GenerarProfesionalJPanel generarProfesionalJPane;
	private ButtonEdit buttonGenerarProfesional;
	private ButtonEdit buttonGenerarProfesionalCancelar;	
	
	// Perfil administrador.
	private GenerarPacienteJPanel generarPacienteJPane;
	private ButtonEdit buttonGenerarPaciente;
	private ButtonEdit buttonGenerarPacienteCancelar;
	
	// Perfil administrador.
	private MenuAsignarPacienteJPanel menuAsignarPacienteJPane;
	private ArrayList<ButtonPaciente> pacienteListaButton;
	private ButtonEdit volverMenuButtonPaciente;
	
	// Perfil administrador.
	private MenuAsignarProfesionalJPanel menuAsignarProfesionalJPane;
	private ArrayList<ButtonProfesional> profesionalListaButton;
	private ButtonEdit volverMenuButtonProfesional;
	
	// Perfil administrador.
	private AdministrarEnfermedadesJPanel administrarEnfermedadesJPane;
	private ButtonEdit nuevaEnfermedadButton;	
	private ButtonEdit asignarTareaDeControlButton;
	private ButtonEdit atrasEnfermedadButton;
		
	// Perfil Administrador.
	private GenerarEnfermedadJPanel generarEnfermedadJPane;
	private ButtonEdit buttonGenerarEnfermedad;
	private ButtonEdit buttonGenerarEnfermedadCancelar;
	
	// ================================================
	
	private HashMap<String,Usuario> usuariosHashMap;
	private HashMap<String,Enfermedad> enfermedadesHashMap;
	private Usuario usuarioActivo = null;
	private Date sesionAnterior;
	
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
		cargarEnfermedades();
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
						sesionAnterior = usuarioActivo.getUltimaSesion();
						actualizarUltimaSesion();
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
		asignarProfesionalButton = menuAdministradorPane.getAsignarProfesionalButton();
		asignarProfesionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configMenuAsignarPacienteJPanel();
        		menuAdministradorPane.setVisible(false);
            }
        });
		administrarEnfermedadButton = menuAdministradorPane.getAdministrarEnfermedadButton();
		administrarEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configAdministrarEnfermedadesJPanel();
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
		generarProfesionalJPane = new GenerarProfesionalJPanel();
		generarProfesionalJPane.setBounds(0, 0, 484, 461);				
		buttonGenerarProfesional = generarProfesionalJPane.getButtonGenerarProfesional();
		buttonGenerarProfesional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (!generarProfesionalJPane.getNombre().isEmpty() && !generarProfesionalJPane.getApellido().isEmpty() && 
            			!generarProfesionalJPane.getDni().isEmpty() && !generarProfesionalJPane.getTelefono().isEmpty() &&
            			!generarProfesionalJPane.getCuenta().isEmpty() && !generarProfesionalJPane.getClave().isEmpty()) {
            		
            		Date fechaAlta = new Date();
                	
                	if (nuevoProfesional(generarProfesionalJPane.getNombre(), generarProfesionalJPane.getApellido(), generarProfesionalJPane.getDni(), 
                			generarProfesionalJPane.getTelefono(), generarProfesionalJPane.getCuenta(), generarProfesionalJPane.getClave(), fechaAlta)) {  
                		mensajeLeer("Se ha generado el profesional con ?xito.");
                		menuAdministradorPane.setVisible(true);
                		generarProfesionalJPane.setVisible(false);
                		
                	} else {
                		mensajeLeer("No se pudo generar el nuevo profesional.");
                	}    
                	
            	} else {
            		mensajeLeer("Faltan datos obligatorios para generar el nuevo profesional.");
            	}
            }
        }); 
		buttonGenerarProfesionalCancelar = generarProfesionalJPane.getButtonGenerarProfesionalCancelar();
		buttonGenerarProfesionalCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		generarProfesionalJPane.setVisible(false);
            }
        }); 
		contentPane.add(generarProfesionalJPane);
		generarProfesionalJPane.setVisible(true);			
	}
	
	public void configGenerarPacienteJPanel() {
		generarPacienteJPane = new GenerarPacienteJPanel();
		generarPacienteJPane.setBounds(0, 0, 484, 461);				
		buttonGenerarPaciente = generarPacienteJPane.getButtonGenerarPaciente();
		buttonGenerarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (!generarPacienteJPane.getNombre().isEmpty() && !generarPacienteJPane.getApellido().isEmpty() && 
            			!generarPacienteJPane.getDni().isEmpty() && !generarPacienteJPane.getTelefono().isEmpty() &&
            			!generarPacienteJPane.getCuenta().isEmpty() && !generarPacienteJPane.getClave().isEmpty()) {
            		               	
            		Date fechaAlta = new Date();
            		
                	if (nuevoPaciente(generarPacienteJPane.getNombre(), generarPacienteJPane.getApellido(), generarPacienteJPane.getDni(), 
                			generarPacienteJPane.getTelefono(), generarPacienteJPane.getCuenta(), generarPacienteJPane.getClave(), fechaAlta)) {  
                		mensajeLeer("Se ha generado el paciente con ?xito.");
                		menuAdministradorPane.setVisible(true);
                		generarPacienteJPane.setVisible(false);
                		
                	} else {
                		mensajeLeer("No se pudo generar el nuevo paciente.");
                	}    
                	
            	} else {
            		mensajeLeer("Faltan datos obligatorios para generar el nuevo paciente.");
            	}
            }
        }); 
		buttonGenerarPacienteCancelar = generarPacienteJPane.getButtonGenerarPacienteCancelar();
		buttonGenerarPacienteCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		generarPacienteJPane.setVisible(false);
            }
        }); 
		contentPane.add(generarPacienteJPane);
		generarPacienteJPane.setVisible(true);			
	}
	
	public void configMenuAsignarPacienteJPanel() {
		menuAsignarPacienteJPane = new MenuAsignarPacienteJPanel(getListaPaciente());
		menuAsignarPacienteJPane.setBounds(0, 0, 484, 461);			
		pacienteListaButton = menuAsignarPacienteJPane.getPacienteListaButton();		
		for (ButtonPaciente buttonPaciente : pacienteListaButton) {
			buttonPaciente.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	menuAsignarPacienteJPane.setVisible(false);
	            	configMenuAsignarProfesionalJPanel(buttonPaciente.getPaciente().getCuenta());
	            }
	        }); 
		}		
		volverMenuButtonPaciente = menuAsignarPacienteJPane.getVolverMenuButton();
		volverMenuButtonPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		menuAsignarPacienteJPane.setVisible(false);
            }
        }); 		
		contentPane.add(menuAsignarPacienteJPane);
		menuAsignarPacienteJPane.setVisible(true);
	}
	
	public void configMenuAsignarProfesionalJPanel(String cuenta){
		menuAsignarProfesionalJPane = new MenuAsignarProfesionalJPanel(getListaProfesional(),cuenta);
		menuAsignarProfesionalJPane.setBounds(0, 0, 484, 461);			
		profesionalListaButton = menuAsignarProfesionalJPane.getProfesionalListaButton();		
		for (ButtonProfesional buttonProfesional : profesionalListaButton) {
			buttonProfesional.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(asignarProfesional(cuenta, buttonProfesional.getProfesional().getCuenta())) {
	            		mensajeLeer("Se asigno el paciente con ?xito.");
	            		menuAsignarProfesionalJPane.setVisible(false);
	            		menuAdministradorPane.setVisible(true);
	            	} 	
	            }
	        }); 
		}		
		volverMenuButtonProfesional = menuAsignarProfesionalJPane.getVolverMenuButton();
		volverMenuButtonProfesional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configMenuAsignarPacienteJPanel();
        		menuAsignarProfesionalJPane.setVisible(false);
            }
        }); 		
		contentPane.add(menuAsignarProfesionalJPane);
		menuAsignarProfesionalJPane.setVisible(true);
	}
	
	public void configAdministrarEnfermedadesJPanel() {
		administrarEnfermedadesJPane = new AdministrarEnfermedadesJPanel();
		administrarEnfermedadesJPane.setBounds(0, 0, 484, 461);		
		nuevaEnfermedadButton = administrarEnfermedadesJPane.getNuevaEnfermedadButton();
		nuevaEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configGenerarEnfermedadJPanel();
            	administrarEnfermedadesJPane.setVisible(false);
            }
        }); 		
		asignarTareaDeControlButton = administrarEnfermedadesJPane.getAsignarTareaDeControlButton();
		asignarTareaDeControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("asignarTareaDeControlButton...");
            }
        }); 
		atrasEnfermedadButton = administrarEnfermedadesJPane.getAtrasEnfermedadButton();
		atrasEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		administrarEnfermedadesJPane.setVisible(false);
            }
        }); 		
		contentPane.add(administrarEnfermedadesJPane);
		administrarEnfermedadesJPane.setVisible(true);		
	}
	
	public void configGenerarEnfermedadJPanel() {
		generarEnfermedadJPane = new GenerarEnfermedadJPanel();
		generarEnfermedadJPane.setBounds(0, 0, 484, 461);		
		buttonGenerarEnfermedad = generarEnfermedadJPane.getButtonGenerarEnfermedad();
		buttonGenerarEnfermedad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (!generarEnfermedadJPane.getNombre().isEmpty() && !generarEnfermedadJPane.getDescripcion().isEmpty() && 
            			!generarEnfermedadJPane.getDuracionDias().isEmpty()) {
            		
            		int duracionDias = controEntero(generarEnfermedadJPane.getDuracionDias());
            		
            		if (duracionDias < 1){
            			mensajeLeer("Error al cargar los dias de duraci?n de la enfermedad.");
            		} else {
    	            	if(nuevaEnfermedad(generarEnfermedadJPane.getNombre(), generarEnfermedadJPane.getDescripcion(), duracionDias)) {
    	            		mensajeLeer("Se genero una nueva enfermedad con ?xito.");
    	            		generarEnfermedadJPane.setVisible(false);
    	            		administrarEnfermedadesJPane.setVisible(true);
    	            	} else {
    	            		mensajeLeer("No se pudo generar la nueva enfermedad.");
    	            	}
            		}            		
            	} else {
            		mensajeLeer("Faltan datos obligatorios para generar una nueva enfermedad.");
            	}
            }
        }); 
		buttonGenerarEnfermedadCancelar = generarEnfermedadJPane.getButtonGenerarEnfermedadCancelar();
		buttonGenerarEnfermedadCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		generarEnfermedadJPane.setVisible(false);
        		administrarEnfermedadesJPane.setVisible(true);
            }
        }); 
		contentPane.add(generarEnfermedadJPane);
		generarEnfermedadJPane.setVisible(true);	
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
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	public HashMap<String,Profesional> leerProfesionalJSON() {
		try {			
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			return profesionalJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	public HashMap<String,Paciente> leerPacienteJSON() {
		try {			
			PacienteJSON pacienteJSON =  new PacienteJSON();
			return pacienteJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}


	public void cargarEnfermedades(){
		HashMap<String,Enfermedad> enfermedadesHashMap = leerEnfermedadJSON();
		if(enfermedadesHashMap != null){
			for(HashMap.Entry<String,Enfermedad> obj : enfermedadesHashMap.entrySet()){
				Enfermedad enfermedad = obj.getValue();
				enfermedadesHashMap.put(enfermedad.getNombre(),enfermedad);
			}
		}
		this.enfermedadesHashMap = enfermedadesHashMap;
	}

	public HashMap<String, Enfermedad> leerEnfermedadJSON(){
		try{
			EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
			return enfermedadJSON.leerJSON();
		}catch (IOException e1){
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
	
	public ArrayList<Profesional> getListaProfesional(){
		ArrayList<Profesional> profesionalLista = new ArrayList<Profesional>();
		for (Usuario usuario : this.usuariosHashMap.values()) {
			if (usuario instanceof Profesional) {
				Profesional profesional = (Profesional) usuario;
				profesionalLista.add(profesional);
			}
		}
		return profesionalLista;
	}

	public ArrayList<Administrador> getListaAdministrador(){
		ArrayList<Administrador> adminLista = new ArrayList<Administrador>();
		for (Usuario usuario : this.usuariosHashMap.values()){
			if(usuario instanceof Administrador){
				Administrador admin = (Administrador) usuario;
				adminLista.add(admin);
			}
		}
		return adminLista;
	}

	public ArrayList<Enfermedad> getListaEnfermedad(){
		ArrayList<Enfermedad> enfermedadLista = new ArrayList<Enfermedad>();
		for(Enfermedad enfermedad : this.enfermedadesHashMap.values()){
			enfermedadLista.add(enfermedad);
		}
		return enfermedadLista;
	}
	
	public boolean nuevoProfesional(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, Date fechaAlta) {
		boolean flag = false;
		if (usuarioActivo instanceof Administrador) {			
			Administrador administrador = (Administrador) usuarioActivo;
	    	Profesional nuevoProfesional = administrador.crearProfesional(nombre, apellido, dni, telefono, cuenta, clave, 
	    			fechaAlta, null, this.usuariosHashMap);	    	
	    	if (nuevoProfesional != null) {
	    		try {
					usuariosHashMap.put(cuenta, nuevoProfesional);
		    		ArrayList <Profesional> profesionalLista = getListaProfesional();
		    		ProfesionalJSON profesionalJSON = new ProfesionalJSON();
					profesionalJSON.cargarJSON(profesionalLista);
					flag = true;					
				} catch (IOException e) {
					mensajeLeer(e.toString());
				}
	    	} 
		}
		return flag;
	}
	
	public ArrayList<Paciente> getListaPaciente(){
		ArrayList<Paciente> pacienteLista = new ArrayList<Paciente>();
		for (Usuario usuario : this.usuariosHashMap.values()) {
			if (usuario instanceof Paciente) {
				Paciente paciente = (Paciente) usuario;
				pacienteLista.add(paciente);
			}
		}
		return pacienteLista;
	}

	public boolean nuevoPaciente(String nombre, String apellido, String dni, String telefono, String cuenta, String clave, Date fechaAlta) {
		boolean flag = false;
		if (usuarioActivo instanceof Administrador) {			
			Administrador administrador = (Administrador) usuarioActivo;
	    	Paciente nuevoPaciente = administrador.crearPaciente(nombre, apellido, dni, telefono, cuenta, clave, 
	    			fechaAlta, null, this.usuariosHashMap);	    	
	    	if (nuevoPaciente != null) {
	    		try {
					usuariosHashMap.put(cuenta, nuevoPaciente);
		    		ArrayList <Paciente> pacienteLista = getListaPaciente();
		    		PacienteJSON pacienteJSON = new PacienteJSON();
		    		pacienteJSON.cargarJSON(pacienteLista);
					flag = true;					
				} catch (IOException e) {
					mensajeLeer(e.toString());
				}
	    	} 
		}
		return flag;
	}	
	
	public boolean asignarProfesional(String cuentaPaciente, String cuentaProfesional) {
		boolean flag = false;
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			Profesional profesionalEditado = admin.asignarProfesional(cuentaProfesional, cuentaPaciente, usuariosHashMap);
			if(profesionalEditado != null){
				try {
					usuariosHashMap.put(cuentaProfesional, profesionalEditado);
					ArrayList<Profesional> profesionalLista = getListaProfesional();
					ProfesionalJSON profesionalJSON = new ProfesionalJSON();
					profesionalJSON.cargarJSON(profesionalLista);
					flag = true;
				}catch(IOException e){
					mensajeLeer(e.toString());
				}
			}
		}
		return flag;
	}
	
	public boolean nuevaEnfermedad(String nombre, String descripcion, int duracionDias) {
		boolean flag = false;
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			ArrayList<Enfermedad> enfermedadLista = getListaEnfermedad();
			Enfermedad enfermedadNueva = admin.crearEnfermedad(nombre, null, descripcion, duracionDias, enfermedadLista);
			if(enfermedadNueva != null){
				try{
					enfermedadesHashMap.put(nombre, enfermedadNueva);
					enfermedadLista = getListaEnfermedad();
					EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
					enfermedadJSON.cargarJSON(enfermedadLista);
					flag = true;
 				} catch (IOException e){
					mensajeLeer(e.toString());
				}
			}
 		}
		return flag;
	}

	public void actualizarUltimaSesion(){
		usuarioActivo.setUltimaSesion(new Date());
		if (usuarioActivo instanceof Administrador){
			actualizarUltimaSesionAdministrador();
		} else if (usuarioActivo instanceof Profesional){
			actualizarUltimaSesionProfesional();
		} else if (usuarioActivo instanceof Paciente){
			actualizarUltimaSesionPaciente();
		} else {
			mensajeLeer("Error al buscar la instancia del usuario activo.");
		}
	}

	public void actualizarUltimaSesionAdministrador(){
		if(usuarioActivo!=null){
			try{
				usuariosHashMap.put(usuarioActivo.getCuenta(),usuarioActivo);
				ArrayList<Administrador> adminLista = getListaAdministrador();
				AdministradorJSON administradorJSON = new AdministradorJSON();
				administradorJSON.cargarJSON(adminLista);
			} catch (IOException e) {
				mensajeLeer(e.toString());
			}
		}
	}

	public void actualizarUltimaSesionProfesional(){
		if(usuarioActivo!=null){
			try{
				usuariosHashMap.put(usuarioActivo.getCuenta(),usuarioActivo);
				ArrayList<Profesional> profesionalLista = getListaProfesional();
				ProfesionalJSON profesionalJSON = new ProfesionalJSON();
				profesionalJSON.cargarJSON(profesionalLista);
			} catch (IOException e) {
				mensajeLeer(e.toString());
			}
		}
	}
	
	public void actualizarUltimaSesionPaciente(){
		if(usuarioActivo!=null){
			try{
				usuariosHashMap.put(usuarioActivo.getCuenta(),usuarioActivo);
				ArrayList<Paciente> pacienteLista = getListaPaciente();
				PacienteJSON pacienteJSON = new PacienteJSON();
				pacienteJSON.cargarJSON(pacienteLista);
			} catch (IOException e) {
				mensajeLeer(e.toString());
			}
		}
	}
	
	public int controEntero(String str){
		try {
			int integer = Integer.parseInt(str);	
	        return integer;
	    } catch(NumberFormatException nfe) {  
	        return 0;
	    }	      
	}
	
	public void mensajeLeer(String mensaje) {
		System.out.println(mensaje);
	}
}