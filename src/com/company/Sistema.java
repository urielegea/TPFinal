package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Design.ButtonEdit;
import Design.LoginJPanel;
import Design.MenuAdministradorJPanel;
import Design.MenuPacienteJPanel;
import Design.MenuProfesionalJPanel;

public class Sistema extends JFrame {

	private JPanel contentPane;
	
	private LoginJPanel loginPane;
	private ButtonEdit loginButton;
	private ButtonEdit loginResetButton;
	
	private MenuAdministradorJPanel menuAdministradorPane;
	private ButtonEdit nuevoProfesionalButton;
	private ButtonEdit nuevoPacienteButton;
	private ButtonEdit administrarEnfermedadButton;
	private ButtonEdit administrarTareaDeControlButton;
	private ButtonEdit cerrarMenuAdministradorButton;
	
	private MenuProfesionalJPanel menuProfesionalPane;
	private ButtonEdit asignarPlanesDeControl;	
	private ButtonEdit controlRegistroDePacientes;
	private ButtonEdit finalizarPlanesDeControl;
	private ButtonEdit cerrarMenuProfesionalButton;
	
	private MenuPacienteJPanel menuPacientePane;
	private ButtonEdit ingresarDatosDeControl;	
	private ButtonEdit cerrarMenuPacienteButton;
	
	public Sistema() {				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 500, 500);
		setLocationRelativeTo(null);
		setTitle("Centro de salud");		
		this.configContentPane();
		this.configLoginPane();
		this.configMenuAdministrador();
		this.configMenuProfesional();
		this.configMenuPaciente();
	}
	
	// Inicializaci?n y configuraci?n del panel contenedor.
	
	public void configContentPane(){
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	// Inicializaci?n, configuraci?n y eventos del panel login.
	
	public void configLoginPane() {
		loginPane = new LoginJPanel();
		loginPane.setBounds(0, 0, 484, 461);		
		loginButton = loginPane.getLoginButton();
		loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int PERFILPRUEBA = 1;
            	
            	switch(PERFILPRUEBA) {
            	  case 0:
            		  System.out.println("ERROR");
            	  	break;            		  
            	  case 1:
            		loginPane.setVisible(false);
            		menuAdministradorPane.setVisible(true);
            	    break;
            	  case 2:
              		loginPane.setVisible(false);
              		menuProfesionalPane.setVisible(true);
            	    break;
            	  case 3:
                	loginPane.setVisible(false);
                  	menuPacientePane.setVisible(true);
            	    break;
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
	
	// Inicializaci?n, configuraci?n y eventos del panel menu administrador.
	
	public void configMenuAdministrador() {		
		menuAdministradorPane = new MenuAdministradorJPanel();
		menuAdministradorPane.setBounds(0, 0, 484, 461);		
		nuevoProfesionalButton = menuAdministradorPane.getNuevoProfesionalButton();
		nuevoProfesionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("nuevoProfesionalButton...");
            }
        }); 		
		nuevoPacienteButton = menuAdministradorPane.getNuevoPacienteButton();
		nuevoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("nuevoPacienteButton...");
            }
        }); 
		administrarEnfermedadButton = menuAdministradorPane.getAdministrarEnfermedadButton();
		administrarEnfermedadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("administrarEnfermedadButton...");
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
		menuAdministradorPane.setVisible(false);
	}
	
	// Inicializaci?n, configuraci?n y eventos del panel menu profesional.
	
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
		menuProfesionalPane.setVisible(false);	
	}
	
	// Inicializaci?n, configuraci?n y eventos del panel menu paciente.
	
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
		menuPacientePane.setVisible(false);			
	}	
}
