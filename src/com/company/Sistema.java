package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.company.Design.*;
import com.company.JSON.AdministradorJSON;
import com.company.JSON.EnfermedadJSON;
import com.company.JSON.HistorialMedicoJSON;
import com.company.JSON.PacienteJSON;
import com.company.JSON.ProfesionalJSON;
import com.company.JSON.TareaDeControlJSON;
import com.company.Class.*;

@SuppressWarnings("serial")
public class Sistema extends JFrame {

	private JPanel contentPane;

	// Perfil administrador - profesional - paciente.
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
	private MenuAsignarEnfermedadTratamientoJPanel menuAsignarEnfermedadTratamientoJPanel;
	private ArrayList<ButtonEnfermedad> enfermedadTratamientoListaButton;
	private ButtonEdit volverMenuButtonEnfermedadTratamiento;
	
	// Perfil administrador.
	private AdministrarEnfermedadesJPanel administrarEnfermedadesJPane;
	private ButtonEdit nuevaEnfermedadButton;	
	private ButtonEdit asignarTareaDeControlButton;
	private ButtonEdit atrasEnfermedadButton;
		
	// Perfil administrador.
	private GenerarEnfermedadJPanel generarEnfermedadJPane;
	private ButtonEdit buttonGenerarEnfermedad;
	private ButtonEdit buttonGenerarEnfermedadCancelar;
	
	// Perfil administrador.
	private MenuAsignarEnfermedadJPanel menuAsignarEnfermedadJPane;
	private ArrayList<ButtonEnfermedad> enfermedadListaButton;
	private ButtonEdit volverMenuButtonEnfermedad;
	
	// Perfil administrador.
	private MenuAsignarTDCJPanel menuAsignarTDCJPane;
	private ButtonEdit buttonAsignarTDC;
	private ButtonEdit buttonAsignarTDCCancelar;
	
	// Perfil administrador.
	private GenerarTareaDeControlJPanel generarTareaDeControlJPane;
	private ButtonEdit buttonGenerarTDC;
	private ButtonEdit buttonGenerarTDCCancelar;
	
	// Perfil profesional.
	private InformarNuevoPacienteJPanel informarNuevoPacienteJPane;
	private ArrayList<ButtonPaciente> pacientePendienteListaButton;
	private ButtonEdit pacientePendienteButton;
	
	// Perfil profesional.
	private TratamientoEditarJPanel tratamientoEditarJPane;
	private ArrayList<ButtonTratamiento> tratamientoEditarListaButton;
	private ButtonEdit atrasTratamientoEditarButton;
	
	// Perfil profesional.	
	private CompletarTratamientoJPanel completarTratamientoJPane;
	private ButtonEdit cancelarCompletarTratamientoButton;	
	private ButtonEdit completarTratamientoButton;
	
	// Perfil profesional.	
	private MenuControlRegistroJPanel menuControlRegistroJPane;
	private ArrayList<ButtonPaciente> pacienteRegistroListaButton;
	private ButtonEdit volverRegistroButton;
	
	// Perfil profesional.
	private MenuControlRegistroTratamientoJPanel menuControlRegistroTratamientoJPane;
	private ArrayList<ButtonTratamiento> tratamientoRegistroListaButton;
	private ButtonEdit volverTratamientoRegistrotButton;
		
	// Perfil profesional.
	private MenuControlRegistroDatosJPanel menuControlRegistroDatosJPane;
	private ButtonEdit menuControlRegistroDatosButton;
	
	// Perfil profesional .
	private FinalizarTratamientoPacienteJPanel finalizarTratamientoPacienteJPane;
	private ArrayList<ButtonPaciente> pacienteListaFinalizarButton;	
	private ButtonEdit volverMenuFinalizarButton;
	
	// Perfil profesional.
	private FinalizarTratamientoSeleccionarJPanel finalizarTratamientoSeleccionarJPane;
	private ArrayList<ButtonTratamiento> tratamientoFinalizarListaButton;
	private ButtonEdit volverFinalizartButton;
	
	// Perfil profesional.
	private FinalizarTratamientoAccionJPanel finalizarTratamientoAccionJPane;
	private ButtonEdit finalizarTratamientoButton;
	private ButtonEdit finalizarTratamientoCancelarButton;
	
	// Perfil paciente.
	private IngresarDatosTratamientoJPanel ingresarDatosTratamientoJPane;
	private ArrayList<ButtonTratamiento> tratamientoIngresarDatosListaButton;
	private ButtonEdit volverIngresarDatosButton;
	
	// Perfil paciente.
	private IngresarDatosAccionJPanel ingresarDatosAccionJPane;
	private ButtonEdit cargarDatosButton;
	private ButtonEdit cancelarDatosButton;
	
	// ================================================
	
	private HashMap<String,Usuario> usuariosHashMap;
	private HashMap<String,Enfermedad> enfermedadesHashMap;
	private HashMap<String,TareaDeControl> tareaDeControlHashMap;
	private HashMap<String, HistorialMedico> historialMedicoHashMap;
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
		cargarEnfermedades();
		cargarTareasDeControl();
		cargarHistorialMedico();
	}
	
	public void configContentPane(){
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
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
            	configGenerarTareaDeControlJPanel();
        		menuAdministradorPane.setVisible(false);
            }
        }); 		
		cerrarMenuAdministradorButton = menuAdministradorPane.getCerrarMenuAdministradorButton();
		cerrarMenuAdministradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	usuarioActivo = null;
            	menuAdministradorPane.setVisible(false);
            	loginPane.setVisible(true);
            }
        }); 		
		contentPane.add(menuAdministradorPane);
		menuAdministradorPane.setVisible(true);
	}
	
	public void configMenuProfesional() {
		menuProfesionalPane = new MenuProfesionalJPanel();
		menuProfesionalPane.setBounds(0, 0, 484, 461);			
		controlRegistroDePacientes = menuProfesionalPane.getControlRegistroDePacientes();
		controlRegistroDePacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configMenuControlRegistroJPanel();
            	menuProfesionalPane.setVisible(false);   
            }
        }); 
		finalizarPlanesDeControl = menuProfesionalPane.getFinalizarPlanesDeControl();
		finalizarPlanesDeControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configFinalizarTratamientoPacienteJPanel();
            	menuProfesionalPane.setVisible(false);   
            }
        }); 		
		cerrarMenuProfesionalButton = menuProfesionalPane.getCerrarMenuProfesionalButton();
		cerrarMenuProfesionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	usuarioActivo = null;
            	menuProfesionalPane.setVisible(false);
            	loginPane.setVisible(true);
            }
        }); 		
		contentPane.add(menuProfesionalPane);
		menuProfesionalPane.setVisible(true);	
	}
	
	public void configMenuPaciente() {
		menuPacientePane = new MenuPacienteJPanel();
		menuPacientePane.setBounds(0, 0, 484, 461);		
		ingresarDatosDeControl = menuPacientePane.getIngresarDatosDeControl();
		ingresarDatosDeControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	configIngresarDatosTratamientoJPanel();
            	menuPacientePane.setVisible(false); 
            }
        }); 		
		cerrarMenuPacienteButton = menuPacientePane.getCerrarMenuPacienteButton();
		cerrarMenuPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	usuarioActivo = null;
            	menuPacientePane.setVisible(false);
            	loginPane.setVisible(true);
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
                		
                		mensajeLeer("Se ha generado el profesional con exito.");
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
	
	public void configMenuAsignarProfesionalJPanel(String cuentaPaciente){
		menuAsignarProfesionalJPane = new MenuAsignarProfesionalJPanel(getListaProfesional());
		menuAsignarProfesionalJPane.setBounds(0, 0, 484, 461);			
		profesionalListaButton = menuAsignarProfesionalJPane.getProfesionalListaButton();		
		for (ButtonProfesional buttonProfesional : profesionalListaButton) {
			buttonProfesional.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	menuAsignarProfesionalJPane.setVisible(false);
	            	configMenuAsignarEnfermedadTratamientoJPanel(cuentaPaciente, buttonProfesional.getProfesional().getCuenta());  
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
	
	public void configMenuAsignarEnfermedadTratamientoJPanel(String cuentaPaciente, String cuentaProfesional) {
		
		ArrayList<Enfermedad> enfermedadLista = enfermedadLiberadas(cuentaPaciente);
		
		menuAsignarEnfermedadTratamientoJPanel = new MenuAsignarEnfermedadTratamientoJPanel(enfermedadLista);
		menuAsignarEnfermedadTratamientoJPanel.setBounds(0, 0, 484, 461);			
		enfermedadTratamientoListaButton = menuAsignarEnfermedadTratamientoJPanel.getEnfermedadTratamientoListaButton();		
		
		if (enfermedadLista != null) {
			for (ButtonEnfermedad buttonEnfermedad : enfermedadTratamientoListaButton) {
				buttonEnfermedad.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	if(asignarProfesionalEnfermedadTratamiento(cuentaPaciente, cuentaProfesional, buttonEnfermedad.getEnfermedad().getNombre())) {
			        		mensajeLeer("Se asigno al paciente un profesional y un nuevo tratamiento con su enfermedad con exito.");
			        		menuAsignarEnfermedadTratamientoJPanel.setVisible(false);
			        		menuAdministradorPane.setVisible(true);
		        		} else {
		        			mensajeLeer("Algo salio mal.");
		        		} 
		            }
		        }); 
			}	
		}
		volverMenuButtonEnfermedadTratamiento = menuAsignarEnfermedadTratamientoJPanel.getVolverMenuButton();
		volverMenuButtonEnfermedadTratamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            	
            	menuAsignarEnfermedadTratamientoJPanel.setVisible(false);
            	configMenuAsignarProfesionalJPanel(cuentaPaciente);
            }
        }); 		
		contentPane.add(menuAsignarEnfermedadTratamientoJPanel);
		menuAsignarEnfermedadTratamientoJPanel.setVisible(true);	
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
            	configMenuAsignarEnfermedadJPanel();
            	administrarEnfermedadesJPane.setVisible(false);
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
            		
            		int duracionDias = controlEntero(generarEnfermedadJPane.getDuracionDias());
            		
            		if (duracionDias < 1){
            			mensajeLeer("Error al cargar los dias de duracion de la enfermedad.");
            		} else {
    	            	if(nuevaEnfermedad(generarEnfermedadJPane.getNombre(), generarEnfermedadJPane.getDescripcion(), duracionDias)) {
    	            		mensajeLeer("Se genero una nueva enfermedad con exito.");
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
	
	public void configMenuAsignarEnfermedadJPanel() {
		menuAsignarEnfermedadJPane = new MenuAsignarEnfermedadJPanel(getListaEnfermedad());
		menuAsignarEnfermedadJPane.setBounds(0, 0, 484, 461);			
		enfermedadListaButton = menuAsignarEnfermedadJPane.getEnfermedadListaButton();		
		for (ButtonEnfermedad buttonEnfermedad : enfermedadListaButton) {
			buttonEnfermedad.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	menuAsignarEnfermedadJPane.setVisible(false);
	            	configMenuAsignarTDCJPanel(buttonEnfermedad.getEnfermedad().getNombre());
	            }
	        }); 
		}		
		volverMenuButtonEnfermedad = menuAsignarEnfermedadJPane.getVolverMenuButton();
		volverMenuButtonEnfermedad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		menuAsignarEnfermedadJPane.setVisible(false);
            }
        }); 		
		contentPane.add(menuAsignarEnfermedadJPane);
		menuAsignarEnfermedadJPane.setVisible(true);
	}
	
	public void configMenuAsignarTDCJPanel(String nombreEnfermedad) {			
		ArrayList<String> tareaDeControlLista = tareaDeControlLiberadas(nombreEnfermedad);		
		menuAsignarTDCJPane = new MenuAsignarTDCJPanel(tareaDeControlLista, nombreEnfermedad);
		menuAsignarTDCJPane.setBounds(0, 0, 484, 461);	
		buttonAsignarTDC = menuAsignarTDCJPane.getButtonAsignarTDC();
		buttonAsignarTDC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     
            	if (asignarTareaDeControlEnfermedad(nombreEnfermedad, menuAsignarTDCJPane.getAsignarTDCLista())) {
            		mensajeLeer("Se asigno la tarea de control con exito.");
            		menuAsignarTDCJPane.setVisible(false);
            		administrarEnfermedadesJPane.setVisible(true);
            	} else {
            		mensajeLeer("Algo salio mal.");
            	}            	
            }
        }); 			
		buttonAsignarTDCCancelar = menuAsignarTDCJPane.getButtonAsignarTDCCancelar();
		buttonAsignarTDCCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        		
        		menuAsignarEnfermedadJPane.setVisible(true);
        		menuAsignarTDCJPane.setVisible(false);
            }
        }); 		
		contentPane.add(menuAsignarTDCJPane);
		menuAsignarTDCJPane.setVisible(true);
	}
	
	public void configGenerarTareaDeControlJPanel()	{ 	
		generarTareaDeControlJPane = new GenerarTareaDeControlJPanel();
		generarTareaDeControlJPane.setBounds(0, 0, 484, 461);		
		buttonGenerarTDC = generarTareaDeControlJPane.getButtonGenerarTDC();
		buttonGenerarTDC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
            	
            	if (!generarTareaDeControlJPane.getNombre().isEmpty() && !generarTareaDeControlJPane.getObservacion().isEmpty() && 
            			!generarTareaDeControlJPane.getDescripcion().isEmpty() && !generarTareaDeControlJPane.getTipoAccion().isEmpty()) {
            		
            		EstructuraTDC estructuraTDC = null;
            		
            		if (generarTareaDeControlJPane.getTipoAccion().compareTo(" Entero") == 0) {
            			
            			estructuraTDC = new EnteroTDC(generarTareaDeControlJPane.getDescripcion());
            			
            		} else if (generarTareaDeControlJPane.getTipoAccion().compareTo(" Decimal") == 0) {
            			
            			estructuraTDC = new DecimalTDC(generarTareaDeControlJPane.getDescripcion());
            			
            		} else if (generarTareaDeControlJPane.getTipoAccion().compareTo(" Nota") == 0) {
            			
            			estructuraTDC = new NotaTDC(generarTareaDeControlJPane.getDescripcion());
            			
            		} else if (generarTareaDeControlJPane.getTipoAccion().compareTo(" Verdadero/Falso") == 0) {
            			
            			estructuraTDC = new VerdaderoFalsoTDC(generarTareaDeControlJPane.getDescripcion());
            			
            		} else {
            			
            			mensajeLeer("Algo salio mal.");
            		}
            		
            		if (nuevaTareaDeControl(generarTareaDeControlJPane.getNombre(), false, generarTareaDeControlJPane.getObservacion(), estructuraTDC)) { 

                		mensajeLeer("Se ha generado la tarea de control con exito.");
                		menuAdministradorPane.setVisible(true);
                		generarTareaDeControlJPane.setVisible(false);
                		
                	} else {
                		mensajeLeer("No se pudo generar la tarea de control.");
                	}  
            		
            	} else {
            		mensajeLeer("Faltan datos obligatorios para la tarea de control.");
            	}
            }
        }); 
		buttonGenerarTDCCancelar = generarTareaDeControlJPane.getButtonGenerarTDCCancelar();
		buttonGenerarTDCCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuAdministradorPane.setVisible(true);
        		generarTareaDeControlJPane.setVisible(false);
            }
        }); 
		contentPane.add(generarTareaDeControlJPane);
		generarTareaDeControlJPane.setVisible(true);		
		
	}	
	
	public void configInformarNuevoPaciente() {		
		informarNuevoPacienteJPane = new InformarNuevoPacienteJPanel(retornarPacientesPendientes());
		informarNuevoPacienteJPane.setBounds(0, 0, 484, 461);			
		pacientePendienteListaButton = informarNuevoPacienteJPane.getPacienteListaButton();		
		for (ButtonPaciente buttonPaciente : pacientePendienteListaButton) {
			buttonPaciente.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	informarNuevoPacienteJPane.setVisible(false);
	            	configTratamientoEditar(buttonPaciente.getPaciente().getCuenta());
	            }
	        }); 
		}		
		pacientePendienteButton = informarNuevoPacienteJPane.getCerrarSesionButton();
		pacientePendienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	usuarioActivo = null;
            	informarNuevoPacienteJPane.setVisible(false);
            	loginPane.setVisible(true);
            }
        }); 		
		contentPane.add(informarNuevoPacienteJPane);
		informarNuevoPacienteJPane.setVisible(true);	
	}
	
	public void iniciarSesionProfesional() {
		ArrayList<Paciente> pacientesPendientesLista = retornarPacientesPendientes();		
		if (!pacientesPendientesLista.isEmpty()) {			
			this.configInformarNuevoPaciente();			
		} else {
			this.configMenuProfesional();
		}			
	}
	
	public void configTratamientoEditar(String cuentaPaciente){
		tratamientoEditarJPane = new TratamientoEditarJPanel(retornarTratamientosPacienteProfesional(cuentaPaciente));
		tratamientoEditarJPane.setBounds(0, 0, 484, 461);			
		tratamientoEditarListaButton = tratamientoEditarJPane.getTratamientoListaButton();		
		for (ButtonTratamiento buttonTratamiento : tratamientoEditarListaButton) {
			buttonTratamiento.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	tratamientoEditarJPane.setVisible(false);
	            	configCompletarTratamiento(buttonTratamiento.getTratamiento().getEnfermedadNombre(), cuentaPaciente, buttonTratamiento.getTratamiento().getToken());
	            }
	        }); 
		}		
		atrasTratamientoEditarButton = tratamientoEditarJPane.getAtrasButton();
		atrasTratamientoEditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tratamientoEditarJPane.setVisible(false);
            	iniciarSesionProfesional();
            }
        }); 		
		contentPane.add(tratamientoEditarJPane);
		tratamientoEditarJPane.setVisible(true);	
	}
	
	public void configCompletarTratamiento(String nombreEnfermedad, String cuentaPaciente, String tokenTratamiento) {		
		int duracionDias = enfermedadesHashMap.get(nombreEnfermedad).getDuracionDias();
		ArrayList<String> tareaDeControlEnfermedadNombreLista = enfermedadesHashMap.get(nombreEnfermedad).getTareaDeControlLista();
		completarTratamientoJPane = new CompletarTratamientoJPanel(nombreEnfermedad, duracionDias, tareaDeControlEnfermedadNombreLista, getListaTareaDeControl());
		completarTratamientoJPane.setBounds(0, 0, 484, 461);			
		completarTratamientoButton = completarTratamientoJPane.getCompletarTratamientoButton();		
		completarTratamientoButton.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) { 
				
				int diasDuracion = controlEntero(completarTratamientoJPane.getDuracionDias());
	            if (diasDuracion > 0) {
	            	ArrayList<String> tareaDeControlLista = completarTratamientoJPane.tareaDeControlLista();	            	
	            	if (!tareaDeControlLista.isEmpty()) {
						if (actualizarTratamiento(cuentaPaciente, tokenTratamiento, diasDuracion, tareaDeControlLista, new Date())) {
	                		mensajeLeer("Se actualizo el tratamiento con exito.");
	                		completarTratamientoJPane.setVisible(false);
	                		iniciarSesionProfesional();
	                	} else {
	                		mensajeLeer("Algo salio mal.");
	                	} 
	            	} else {
	            		mensajeLeer("Se debe seleciconar aunque sea una tarea de control.");
	            	}
	            } else {
	            	mensajeLeer("Error al leer la duracion de dias.");
	            }
	        }
	     }); 		
		cancelarCompletarTratamientoButton = completarTratamientoJPane.getCancelarCompletarTratamientoButton();
		cancelarCompletarTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	completarTratamientoJPane.setVisible(false);
            	tratamientoEditarJPane.setVisible(true);
            }
        }); 		
		contentPane.add(completarTratamientoJPane);
		completarTratamientoJPane.setVisible(true);			
	}
	
	public void configMenuControlRegistroJPanel(){
		ArrayList<Paciente> pacienteLista = pacienteTratamientoLista();
		ArrayList<String> pacienteSinCumplirLista = pacienteSinCumplirLista(pacienteLista);
		menuControlRegistroJPane = new MenuControlRegistroJPanel(pacienteLista, pacienteSinCumplirLista);
		menuControlRegistroJPane.setBounds(0, 0, 484, 461);		
		pacienteRegistroListaButton = menuControlRegistroJPane.getPacienteListaButton();		
		for (ButtonPaciente buttonPaciente : pacienteRegistroListaButton) {
			buttonPaciente.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	menuControlRegistroJPane.setVisible(false);
	            	configMenuControlRegistroTratamientoJPanel(buttonPaciente.isPendientes(), buttonPaciente.getPaciente().getCuenta());
	            }
	        }); 
		}		
		volverRegistroButton = menuControlRegistroJPane.getVolverMenuButton();
		volverRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		menuControlRegistroJPane.setVisible(false);
        		menuProfesionalPane.setVisible(true);
            }
        }); 
		contentPane.add(menuControlRegistroJPane);
		menuControlRegistroJPane.setVisible(true);	
	}
	
	// El parametro "pendiente" da el dato de si ese paciente tiene tratamientos pendientes o no.
	
	public void configMenuControlRegistroTratamientoJPanel(boolean pendiente, String cuentaPaciente) {				
		ArrayList<Tratamiento> tratamientoLista = retornarTratamientosPacienteProfesional(cuentaPaciente);
		ArrayList<String> tratamientoSinCumplirLista = tratamientoSinCumplirLista(tratamientoLista);
		
		menuControlRegistroTratamientoJPane = new MenuControlRegistroTratamientoJPanel(tratamientoLista, tratamientoSinCumplirLista);
		menuControlRegistroTratamientoJPane.setBounds(0, 0, 484, 461);		
		tratamientoRegistroListaButton = menuControlRegistroTratamientoJPane.getTratamientoRegistroListaButton();		
		for (ButtonTratamiento buttonTratamiento : tratamientoRegistroListaButton) {
			buttonTratamiento.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	menuControlRegistroTratamientoJPane.setVisible(false);
	            	configMenuControlRegistroControlDiarioJPanel(buttonTratamiento.getTratamiento(), (Paciente) usuariosHashMap.get(cuentaPaciente));
	            }
	        }); 
		}		
		volverTratamientoRegistrotButton = menuControlRegistroTratamientoJPane.getVolverTratamientoRegistrotButton();
		volverTratamientoRegistrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menuControlRegistroTratamientoJPane.setVisible(false);
        		menuProfesionalPane.setVisible(true);
            }
        }); 
		contentPane.add(menuControlRegistroTratamientoJPane);
		menuControlRegistroTratamientoJPane.setVisible(true);	
	}
	
	public void configMenuControlRegistroControlDiarioJPanel(Tratamiento tratamiento, Paciente paciente){
		menuControlRegistroDatosJPane = new MenuControlRegistroDatosJPanel(tratamiento, paciente);
		menuControlRegistroDatosJPane.setBounds(0, 0, 484, 461);
		menuControlRegistroDatosButton = menuControlRegistroDatosJPane.getMenuControlRegistroDatosButton();
		menuControlRegistroDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     
            	menuControlRegistroDatosButton.setVisible(false);
            	menuControlRegistroTratamientoJPane.setVisible(true);
            }
        }); 		
		contentPane.add(menuControlRegistroDatosJPane);
		menuControlRegistroDatosJPane.setVisible(true);	
	}
	
	public void configFinalizarTratamientoPacienteJPanel(){
		ArrayList<Paciente> pacienteLista = pacienteTratamientoLista();		
		finalizarTratamientoPacienteJPane = new FinalizarTratamientoPacienteJPanel(pacienteLista);
		finalizarTratamientoPacienteJPane.setBounds(0, 0, 484, 461);		
		pacienteListaFinalizarButton = finalizarTratamientoPacienteJPane.getPacienteListaButton();		
		for (ButtonPaciente buttonPaciente : pacienteListaFinalizarButton) {
			buttonPaciente.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	finalizarTratamientoPacienteJPane.setVisible(false);
	            	configFinalizarTratamientoSeleccionarJPanel(buttonPaciente.getPaciente().getCuenta());
	            }
	        }); 
		}		
		volverMenuFinalizarButton = finalizarTratamientoPacienteJPane.getVolverMenuButton();
		volverMenuFinalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	finalizarTratamientoPacienteJPane.setVisible(false);
        		menuProfesionalPane.setVisible(true);
            }
        }); 
		contentPane.add(finalizarTratamientoPacienteJPane);
		finalizarTratamientoPacienteJPane.setVisible(true);	
	}
	
	public void configFinalizarTratamientoSeleccionarJPanel(String cuentaPaciente) {
		ArrayList<Tratamiento> tratamientoLista = retornarTratamientosPacienteProfesional(cuentaPaciente);		
		finalizarTratamientoSeleccionarJPane = new FinalizarTratamientoSeleccionarJPanel(tratamientoLista);
		finalizarTratamientoSeleccionarJPane.setBounds(0, 0, 484, 461);		
		tratamientoFinalizarListaButton = finalizarTratamientoSeleccionarJPane.getTratamientoFinalizarListaButton();		
		for (ButtonTratamiento buttonTratamiento : tratamientoFinalizarListaButton) {
			buttonTratamiento.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	finalizarTratamientoSeleccionarJPane.setVisible(false);
	            	configFinalizarTratamientoAccionJPanel(buttonTratamiento.getTratamiento(), (Paciente) usuariosHashMap.get(cuentaPaciente));
	            }
	        }); 
		}		
		volverFinalizartButton = finalizarTratamientoSeleccionarJPane.getVolverFinalizarButton();
		volverFinalizartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	finalizarTratamientoSeleccionarJPane.setVisible(false);
            	finalizarTratamientoPacienteJPane.setVisible(true);
            }
        }); 
		contentPane.add(finalizarTratamientoSeleccionarJPane);
		finalizarTratamientoSeleccionarJPane.setVisible(true);	
	}
	
	public void configFinalizarTratamientoAccionJPanel(Tratamiento tratamiento, Paciente paciente) {
		finalizarTratamientoAccionJPane = new FinalizarTratamientoAccionJPanel(tratamiento, paciente, (Profesional)usuariosHashMap.get(tratamiento.getProfesionalCuenta()));
		finalizarTratamientoAccionJPane.setBounds(0, 0, 484, 461);		
	
		finalizarTratamientoButton = finalizarTratamientoAccionJPane.getFinalizarTratamientoButton();
		finalizarTratamientoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        
            	if (finalizarTratamiento(tratamiento, paciente)) {
            		finalizarTratamientoAccionJPane.setVisible(false);
            		menuProfesionalPane.setVisible(true);
            		mensajeLeer("Se finalizo el tratamiento con exito.");
            	} else {
            		mensajeLeer("Algo salio mal.");
            	}
            }
        }); 		
		finalizarTratamientoCancelarButton = finalizarTratamientoAccionJPane.getFinalizarTratamientoCancelarButton();
		finalizarTratamientoCancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	finalizarTratamientoAccionJPane.setVisible(false);
            	finalizarTratamientoSeleccionarJPane.setVisible(true);
            }
        }); 
		contentPane.add(finalizarTratamientoAccionJPane);
		finalizarTratamientoAccionJPane.setVisible(true);			
	}
	
	public void configIngresarDatosTratamientoJPanel() {		
		ArrayList<Tratamiento> tratamientoLista = retornarTratamientosPacienteActivo();		
		ingresarDatosTratamientoJPane = new IngresarDatosTratamientoJPanel(tratamientoLista);
		ingresarDatosTratamientoJPane.setBounds(0, 0, 484, 461);		
		tratamientoIngresarDatosListaButton = ingresarDatosTratamientoJPane.getTratamientoIngresarDatosListaButton();		
		for (ButtonTratamiento buttonTratamiento : tratamientoIngresarDatosListaButton) {
			buttonTratamiento.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) { 
	            	ingresarDatosTratamientoJPane.setVisible(false);
	            	configIngresarDatosAccionJPanel(buttonTratamiento.getTratamiento());
	            }
	        }); 
		}		
		volverIngresarDatosButton = ingresarDatosTratamientoJPane.getVolverIngresarDatosButton();
		volverIngresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ingresarDatosTratamientoJPane.setVisible(false);
            	menuPacientePane.setVisible(true);
            }
        }); 
		contentPane.add(ingresarDatosTratamientoJPane);
		ingresarDatosTratamientoJPane.setVisible(true);	
	}
	
	public void configIngresarDatosAccionJPanel(Tratamiento tratamiento) {			
		ControlDiario controlDiario = getControlDiarioFecha(tratamiento, new Date());
		ingresarDatosAccionJPane = new IngresarDatosAccionJPanel(controlDiario);		
		ingresarDatosAccionJPane.setBounds(0, 0, 484, 461);			
		cargarDatosButton = ingresarDatosAccionJPane.getCargarDatosButton();
		cargarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	boolean control = true;
            	
            	ArrayList<Object> dataTDCLista = ingresarDatosAccionJPane.getDatoTDCLista();
            	ControlDiario controlDiarioAux = controlDiario;
            	ArrayList<TareaDeControl> estructuraTDCLista = new ArrayList<TareaDeControl>();
            	int index = 0;
            	for (TareaDeControl tareaDeControl : controlDiarioAux.getTareaDeControlLista()) {
            		
            		TareaDeControl tareaDeControlAux = tareaDeControl;
            		
            		if (tareaDeControl.getEstructura() instanceof DecimalTDC) {
            			
            			JTextField jTextField = (JTextField) dataTDCLista.get(index);
            			Double controlDouble = controlDouble(jTextField.getText());
            			if (controlDouble > 0) {            				
            				DecimalTDC estructuraAux = new DecimalTDC(tareaDeControlAux.getEstructura().getTextoDescriptivo());
            				estructuraAux.setDecimal(controlDouble);            				
            				tareaDeControlAux.setEstructura(estructuraAux);  
            				
            			} else {
            				control = false;
            			}
            			
            		} else if(tareaDeControl.getEstructura() instanceof EnteroTDC) {
            			
            		    JTextField jTextField = (JTextField) dataTDCLista.get(index);
            		    Integer controlInt = controlEntero(jTextField.getText());
            		    if (controlInt > 0) {
            		        EnteroTDC estructuraAux = new EnteroTDC(tareaDeControlAux.getEstructura().getTextoDescriptivo());
            		        estructuraAux.setEntero(controlInt);
            		        tareaDeControlAux.setEstructura(estructuraAux);
            		    } else {
            		        control = false;
            		    }

					} else if(tareaDeControl.getEstructura() instanceof NotaTDC){
						
						JTextField jTextField = (JTextField) dataTDCLista.get(index);  
						String controlNota = jTextField.getText();
						
						if (!controlNota.isEmpty()) {
							NotaTDC estructuraAux = new NotaTDC(tareaDeControlAux.getEstructura().getTextoDescriptivo());
							estructuraAux.setNota(controlNota);            				
	        				tareaDeControlAux.setEstructura(estructuraAux); 	
	        				
						} else {
							control = false;
						}
						
					} else if(tareaDeControl.getEstructura() instanceof VerdaderoFalsoTDC){
					
						JCheckBox jCheckBox = (JCheckBox) dataTDCLista.get(index); 
						boolean controlVF = jCheckBox.isSelected();						
						VerdaderoFalsoTDC estructuraAux = new VerdaderoFalsoTDC(tareaDeControlAux.getEstructura().getTextoDescriptivo());						
						estructuraAux.setVof(controlVF);
						tareaDeControlAux.setEstructura(estructuraAux); 
					}
            		
            		index++;
            		
            		estructuraTDCLista.add(tareaDeControlAux);
            		
            	}            	
            	controlDiarioAux.setTareaDeControlLista(estructuraTDCLista);
            	
            	if (control) {
            		
            		if (guardarDatosDeControl(tratamiento.getControlDiarioLista(),controlDiarioAux, tratamiento.getToken())) {
            			
            			ingresarDatosAccionJPane.setVisible(false);
                		menuPacientePane.setVisible(true);
                		mensajeLeer("Se guardaron los datos de control con exito.");
                		
            		} else {
            			mensajeLeer("Algo salio mal.");
            		} 
            		
            	} else {
            		mensajeLeer("Se han ingresado tipo de datos incorrectos.");
            	}
            }
        }); 		
		cancelarDatosButton = ingresarDatosAccionJPane.getCancelarDatosButton();
		cancelarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ingresarDatosAccionJPane.setVisible(false);
            	ingresarDatosTratamientoJPane.setVisible(true);
            }
        }); 
		contentPane.add(ingresarDatosAccionJPane);
		ingresarDatosAccionJPane.setVisible(true);			
	}
	
	/* ==================================================== ================================================================ */
	
	// Carga los usuarios administradores, profesionales y los pacientes, dentro del hashMap de usuarios.
	
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
	
	// Retorna un hashMap con los administradores dentro del JSON.
	
	public HashMap<String,Administrador> leerAdministradorJSON() {
		try {			
			AdministradorJSON administradorJSON =  new AdministradorJSON();
			return administradorJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	// Retorna un hashMap con los profesionales dentro del JSON.
	
	public HashMap<String,Profesional> leerProfesionalJSON() {
		try {			
			ProfesionalJSON profesionalJSON =  new ProfesionalJSON();
			return profesionalJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	// Retorna un hashMap con los pacientes dentro del JSON.
	
	public HashMap<String,Paciente> leerPacienteJSON() {
		try {			
			PacienteJSON pacienteJSON =  new PacienteJSON();
			return pacienteJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	// Carga las enfermedades dentro del hashMap del mismo.

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
	
	// Retorna un hashMap con las enfermedades dentro del JSON.

	public HashMap<String, Enfermedad> leerEnfermedadJSON(){
		try{
			EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
			return enfermedadJSON.leerJSON();
		}catch (IOException e1){
			mensajeLeer(e1.toString());
			return null;
		}
	}
	
	// Carga las tareas de control dentro del hashMap del mismo.
	
	public void cargarTareasDeControl(){
		HashMap<String, TareaDeControl> tareaDeControlHashMap = leerTareaDeControlJSON();
		if(tareaDeControlHashMap != null){
			for(HashMap.Entry<String, TareaDeControl> obj : tareaDeControlHashMap.entrySet()){
				TareaDeControl tareaDeControl = obj.getValue();
				tareaDeControlHashMap.put(tareaDeControl.getNombre(), tareaDeControl);
			}
		}
		this.tareaDeControlHashMap = tareaDeControlHashMap;
	}
	
	// Retorna un hashMap con las tareas de control dentro del JSON.

	public HashMap<String, TareaDeControl> leerTareaDeControlJSON(){
		try {
			TareaDeControlJSON tareaDeControlJSON = new TareaDeControlJSON();
			return tareaDeControlJSON.leerJSON();
		}catch (IOException e1){
			mensajeLeer(e1.toString());
			return null;
		}
	}
	
	// Carga el usuario ingresado en caso correcto en el atributo usuarioActivo, luego lo redirige a su perfil.
	
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
				iniciarSesionProfesional();
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
	
	// Retorna el usuario buscado, en caso contrario retorna nulo.
			
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
	
	// Retorna una lista de usuarios profesionales cargados en el hashMap de usuarios.
	
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
	
	// Retorna una lista de usuarios administradores cargados en el hashMap de usuarios.

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
	
	// Retorna una lista de enfermedades cargados en el hashMap de enfermedades.

	public ArrayList<Enfermedad> getListaEnfermedad(){
		ArrayList<Enfermedad> enfermedadLista = new ArrayList<Enfermedad>();
		for(Enfermedad enfermedad : this.enfermedadesHashMap.values()){
			enfermedadLista.add(enfermedad);
		}
		return enfermedadLista;
	}
	
	// Retorna una lista de tareas de control cargados en el hashMap de tareas de control.
	
	public ArrayList<TareaDeControl> getListaTareaDeControl(){
		ArrayList<TareaDeControl> tareaDeControlLista = new ArrayList<TareaDeControl>();
		for(TareaDeControl tareaDeControl : this.tareaDeControlHashMap.values()){
			tareaDeControlLista.add(tareaDeControl);
		}
		return tareaDeControlLista;
	}
	
	// Genera un nuevo profesional y retorna verdadero en caso de que se haga guardado correctamente en el hashmap y JSON del mismo.
	
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
	
	// Retorna una lista de pacientes cargados en el hashMap de pacientes.
	
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
	
	// Genera un nuevo paciente, lo agrega al hashMap de usuarios y luego lo guarda en el JSON.

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
	
	// Retorna un hashMap con los historiales medicos del JSON.
	
	public HashMap<String, HistorialMedico> leerHistorialMedicoJSON(){
		try {			
			HistorialMedicoJSON historialMedicoJSON =  new HistorialMedicoJSON();
			return historialMedicoJSON.leerJSON();
		} catch (IOException e1) {
			mensajeLeer(e1.toString());
			return null;			
		}
	}
	
	// Carga el historial medico en el atributo de la clase historialMedicoHashMap.
		
	public void cargarHistorialMedico(){
		HashMap<String, HistorialMedico> historialMedicoHashMap = leerHistorialMedicoJSON();
		if(historialMedicoHashMap != null){
			for(HashMap.Entry<String, HistorialMedico> obj : historialMedicoHashMap.entrySet()){
				HistorialMedico historialMedico = obj.getValue();
				historialMedicoHashMap.put(historialMedico.getNumeroHistorial(), historialMedico);
			}
		}
		this.historialMedicoHashMap = historialMedicoHashMap;
	}
	
	// Retorna una lista de enfermedades que no esten siendo tratadas actualmente en un paciente.
	
	public ArrayList<Enfermedad> enfermedadLiberadas(String cuentaPaciente){					
		ArrayList<Enfermedad> enfermedadListaLibre = new ArrayList<Enfermedad>();
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente);
			HistorialMedico historialMedicoPaciente =  getHistorialMedicoPaciente(paciente);
			enfermedadListaLibre = admin.retornarEnfermedadesLibre(getListaEnfermedad(), historialMedicoPaciente);
		}
		return enfermedadListaLibre;	
	}
	
	// Retorna si es posible el historial medico de un paciente enviado por parametro.
	
	public HistorialMedico getHistorialMedicoPaciente(Paciente paciente) {
		HistorialMedico historialMedico = null;		
		if (paciente.getNumeroHistorial() != null) {
			historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());
		}
		return historialMedico;
	}
	
	// Asigna el paciente al profesional y genera el tratamiento con el profesional y la enfermedad. En caso correcto retorna verdadero, en caso contrario falso.
	
	public boolean asignarProfesionalEnfermedadTratamiento(String cuentaPaciente, String cuentaProfesional, String nombreEnfermedad){		
		boolean flag = false;		
		if (asignarProfesional(cuentaPaciente, cuentaProfesional) && asignarEnfermedadTratamiento(cuentaPaciente, nombreEnfermedad, cuentaProfesional)) {
			flag = true;
		}		
		return flag;
	}
	
	// Asigna un nuevo paciente al profesional, lo guarda en el hashmap y JSON del mismo, y retorna verdadero si todo salio correcto.

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
	
	// Asigna un nuevo tratamiento con su enfermedad al historialMedico del paciente. En caso de no tener historial medico se genera un nuevo automaticamente.
	
	public boolean asignarEnfermedadTratamiento(String cuentaPaciente, String nombreEnfermedad, String cuentaProfesional) {
		boolean flag = false;
		if(usuarioActivo instanceof Administrador){	
			
			Administrador admin = (Administrador) usuarioActivo;			
			Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente); 
			HistorialMedico historialMedicoEditado = null;
			
			if (paciente.getNumeroHistorial() == null) {
				historialMedicoEditado = admin.asignarTratamientoHistorialMedico(nombreEnfermedad, historialMedicoHashMap, cuentaProfesional);
				paciente.setNumeroHistorial(historialMedicoEditado.getNumeroHistorial());
				try {
					usuariosHashMap.put(cuentaPaciente, paciente);
					ArrayList<Paciente> pacienteLista = getListaPaciente();
					PacienteJSON pacienteJSON = new PacienteJSON();
					pacienteJSON.cargarJSON(pacienteLista);	
					
				} catch(IOException e){
					mensajeLeer(e.toString());
				}				
				
			} else {				
				historialMedicoEditado = admin.asignarTratamientoHistorialMedico(paciente.getNumeroHistorial(), nombreEnfermedad, historialMedicoHashMap, cuentaProfesional);	
			}
			
			if(historialMedicoEditado != null){
				try {
					historialMedicoHashMap.put(paciente.getNumeroHistorial(), historialMedicoEditado);
					ArrayList<HistorialMedico> historialMedicolLista = getListaHistorialMedico();
					HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
					historialMedicoJSON.cargarJSON(historialMedicolLista);
					flag = true;
					
				} catch(IOException e){
					mensajeLeer(e.toString());
				}
			}	
		}
		return flag;
	}
	
	// Retorna una lista del historial medico.
	
	public ArrayList<HistorialMedico> getListaHistorialMedico(){
		ArrayList<HistorialMedico> historialMedicoLista = new ArrayList<HistorialMedico>();
		for (HistorialMedico historialMedico : this.historialMedicoHashMap.values()) {
			historialMedicoLista.add(historialMedico);			
		}
		return historialMedicoLista;
	}
	
	// Genera una nueva enfermedad en el hashmap y JSON del mismo, y retorna verdadero si todo salio correcto o falso en caso contrario.
	
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
	
	// Actualiza la ultima sesion del usuario activo.

	public void actualizarUltimaSesion(){
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

	// Actualiza la ultima sesion del administrador activo.
	
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
	
	// Actualiza la ultima sesion del profesional activo.

	public void actualizarUltimaSesionProfesional(){
		usuarioActivo.setUltimaSesion(new Date());
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
	
	// Actualiza la ultima sesion del paciente activo.
	
	public void actualizarUltimaSesionPaciente(){
		if(usuarioActivo != null){
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
	
	// Asigna una o mas tareas de control al hashmap de enfermedades y al JSON del mismo.
	
	public boolean asignarTareaDeControlEnfermedad(String nombreEnfermedad, ArrayList<String> nombreTareaDeControl) {
		boolean flag = false;
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			Enfermedad enfermedadEditada = admin.asignarTareaDeControlEnfermedad(nombreTareaDeControl, nombreEnfermedad, enfermedadesHashMap);
			if(enfermedadEditada != null){
				try {
					enfermedadesHashMap.put(nombreEnfermedad, enfermedadEditada);
					ArrayList<Enfermedad> enfermedadLista = getListaEnfermedad();
					EnfermedadJSON enfermedadJSON = new EnfermedadJSON();
					enfermedadJSON.cargarJSON(enfermedadLista);
					flag = true;
				}catch (IOException e){
					mensajeLeer(e.toString());
				}
			}
		}
		return flag;
	}
	
	// Genera una nueva tarea de control y la guarda en el hashmap de tareas de control y en el JSON del mismo.
	
	public boolean nuevaTareaDeControl(String nombre, boolean accion, String observacion, EstructuraTDC estructuraTDC) {
		boolean flag = false;
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			ArrayList<TareaDeControl> tareaDeControlLista = getListaTareaDeControl();
			TareaDeControl tareaDeControlNueva = admin.crearTareaDeControl(nombre, accion, observacion, estructuraTDC, tareaDeControlLista);
			if(tareaDeControlNueva != null){
				try{
					tareaDeControlHashMap.put(nombre, tareaDeControlNueva);
					tareaDeControlLista = getListaTareaDeControl();
					TareaDeControlJSON tareaDeControlJSON = new TareaDeControlJSON();
					tareaDeControlJSON.cargarJSON(tareaDeControlLista);
					flag = true;
				}catch (IOException e){
					mensajeLeer(e.toString());
				}
			}
		}
		return flag;
	}
	
	// Retorna una lista de los nombres de las tareas de control no asignadas a la enfermedad enviada por parametro.
	
	public ArrayList<String> tareaDeControlLiberadas(String nombreEnfermedad){
		ArrayList<String> tareaDeControlListaLibre = new ArrayList<String>();
		if(usuarioActivo instanceof Administrador){
			Administrador admin = (Administrador) usuarioActivo;
			Enfermedad enfermedad = enfermedadesHashMap.get(nombreEnfermedad);
			tareaDeControlListaLibre = admin.retornarTareasDeControlLibre(getListaTareaDeControl(),enfermedad);
		}
		return tareaDeControlListaLibre;
	}
	
	// Retorna los pacientes asignados al profesional (usuario activo), en caso de no encontrar ninguno retorna vacio.
	
	public ArrayList<Paciente> retornarPacientesPendientes() {
		ArrayList<Paciente> pacientePendienteLista = new ArrayList<Paciente>();
		Profesional profesional = (Profesional) usuarioActivo;
		if (profesional.getPacienteLista() != null) {
			for(String cuentaPaciente: profesional.getPacienteLista()){
				Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente);
				HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());
				if (historialMedico != null) {
					boolean flag = false;
					for (Tratamiento tratamiento : historialMedico.getTratamientoLista()) {
						if (tratamiento.getDiaInicial() == null && tratamiento.getDuracionDias() == 0 && tratamiento.getTareaDeControlListado() == null && !flag) {
							pacientePendienteLista.add(paciente);
							flag = true;
						}
					}
				}				
			}
		}	
		return pacientePendienteLista;		
	}

	// Retorna los tratamientos en comun de un paciente y profesional (usuario activo)
	
	public ArrayList<Tratamiento> retornarTratamientosPacienteProfesional(String cuentaPaciente) {
		ArrayList<Tratamiento> tratamientoLista = new ArrayList<Tratamiento>();
		Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente);
		for(Tratamiento t: historialMedicoHashMap.get(paciente.getNumeroHistorial()).getTratamientoLista()){
			tratamientoLista.add(t);			
		} 
		return tratamientoLista;		
	}	
	
	// Actualizar el tratamiento con los datos nuevos ingresados por el profesional.
	
	public boolean actualizarTratamiento(String cuentaPaciente, String tokenTratamiento, int diasDuracion,
										 ArrayList<String> tareaDeControlLista, Date diaInicial) {
		boolean flag = false;
		boolean flog;
		if(usuarioActivo instanceof Profesional){
			Profesional profesional = (Profesional) usuarioActivo;
			Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente);
			ArrayList<TareaDeControl> tareaDeControlListado = new ArrayList<TareaDeControl>() ;
			for(TareaDeControl t : getListaTareaDeControl()){
				flog = false;
				for(String s : tareaDeControlLista) {
					if (t.getNombre().compareTo(s)==0){
						flog=true;
					}
				}
				if(flog){
					tareaDeControlListado.add(t);				
				}
			}			
			HistorialMedico historialMedico = profesional.actualizarTratamiento(paciente, tokenTratamiento, diasDuracion, tareaDeControlListado, 
					diaInicial, historialMedicoHashMap);
			try{
				historialMedicoHashMap.put(historialMedico.getNumeroHistorial(),historialMedico);
				ArrayList<HistorialMedico> historialMedicoLista = getListaHistorialMedico();
				HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
				historialMedicoJSON.cargarJSON(historialMedicoLista);
				flag = true;
			}catch (IOException e){
				mensajeLeer(e.toString());
			}

		}

		return flag;
	}
	
	// Retorna los pacientes asignados al profesional que tengan tratamientos sin finalizar.
	
	public ArrayList<Paciente> pacienteTratamientoLista(){
		ArrayList<Paciente> pacienteTratamientoLista = new ArrayList<Paciente>();
		Profesional profesional = (Profesional) usuarioActivo;
		if (profesional.getPacienteLista() != null) {
			for(String cuentaPaciente: profesional.getPacienteLista()){
				Paciente paciente = (Paciente) usuariosHashMap.get(cuentaPaciente);
				HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());
				if (historialMedico != null) {
					boolean flag = false;
					for (Tratamiento tratamiento : historialMedico.getTratamientoLista()) {
						if (tratamiento.getDiaInicial() != null && tratamiento.getDuracionDias() != 0 && tratamiento.getTareaDeControlListado() != null 
								&& tratamiento.getDiaFinal() == null && !flag) {
							pacienteTratamientoLista.add(paciente);
							flag = true;
						}
					}
				}				
			}
		}	
		return pacienteTratamientoLista;	
	}
	
	// Retorna los pacientes que tenga el tratamiento con las tareas del dia anterior sin cumplir.
	
	public ArrayList<String> pacienteSinCumplirLista(ArrayList<Paciente> pacienteTratamientolLista){
		
		ArrayList<String> pacienteSinCumplirLista = new ArrayList<String>();
		
		for (Paciente paciente : pacienteTratamientolLista) {			
			HistorialMedico historialMedico = historialMedicoHashMap.get(paciente.getNumeroHistorial());			
			if (historialMedico != null) {
				boolean flag = false;
				for (Tratamiento tratamiento : historialMedico.getTratamientoLista()) {					
					if (!flag) {
						if (tratamientoSinCumplir(tratamiento)) {
							pacienteSinCumplirLista.add(paciente.getCuenta());	
							flag = true;
						}	
					}
				}
			}	
		}		
		return pacienteSinCumplirLista;
	}
	
	// Retorna true si el tratamiento tiene controles diarios anteriores sin completar del dia anterior.
	
	public boolean tratamientoSinCumplir (Tratamiento tratamiento) {	
		
		boolean flag = false;				
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");  	
		
		 // .getTime()-86400000 para simular que el tratamiento se inicio un dia antes.
		
	    String fechaInicialTratamiento = format.format(tratamiento.getDiaInicial());  
	    String fechaActual = format.format(new Date());	       

	    // Revisa que el tratamiento tenga mas de un dia antes de buscar controles diarios realizados.
	    
	    if (fechaInicialTratamiento.compareTo(fechaActual) != 0) {
	    	
	    	 String fechaDiaAnterior = format.format(new Date().getTime()-86400000);	
	    	
	    	// Por defecto el control diario es nulo.
	    	
	    	ControlDiario controlDiarioFechaAnterior = null;
	    	
	    	// Revisa que el tratamiento tenga controles diarios.
	    	
	    	if (tratamiento.getControlDiarioLista() != null) {
	    		
		    	// Busca un control diario en el tratamiento con la fecha del dia anterior.
		    	
		    	for (ControlDiario controlDiario : tratamiento.getControlDiarioLista()){
		    		
		    		String fechaControlDiario =  format.format(controlDiario.getFecha());
		    		
		    		// En caso de encontrarla la guarda en una variable llamada controlDiarioFechaAnterior.
		    		
		    		if (fechaControlDiario.compareTo(fechaDiaAnterior) == 0) {	    			
		    			controlDiarioFechaAnterior = controlDiario;	    			
		    		}	    		        
		    	}
	    		
	    	}
	    	
	    	// En caso de que controlDiarioFechaAnterior sea nulo, significa que no fue cargado el control diario en el tratamiento por lo tanto esta pendiente.
	    	
	    	if (controlDiarioFechaAnterior == null) {	    		
	    		flag = true;
	    		
	    	} else {
	    		
	    		// En caso contrario revisa si todos los controles diarios fueron realizados correctamente mediante el metodo tareasDeControlSinCumplir.
	    		
	    		flag = tareasDeControlSinCumplir(tratamiento.getTareaDeControlListado(), controlDiarioFechaAnterior.getTareaDeControlLista());
	    	}
	    	
	    }
	    
		return flag;
	}
	
	// Revisa las tareas de control realizadas y se asegura que no haya alguna sin cumplir de las obligatorias.
	
	public boolean tareasDeControlSinCumplir(ArrayList<TareaDeControl> tareasDeControlObligatorias, ArrayList<TareaDeControl> tareasDeControlRealizadas) {
		
		boolean flag = false;
		
		// Se recorren las tareas obligatorias y luego se buscan entre las tareas realizadas en el control diario.
		
		for (TareaDeControl tareaDeControlObligatoria : tareasDeControlObligatorias) {			
			
			boolean flog = true;
			
			for (TareaDeControl tareaDeControlRealizada : tareasDeControlRealizadas) {
				
				// Si se encuentra la tarea de control se verifica que este tambien realizada con el atributo accion.
				
				if (tareaDeControlObligatoria.getNombre().compareTo(tareaDeControlRealizada.getNombre()) == 0 && tareaDeControlRealizada.getAccion()) {
					flog = false;
				}				
			}
			
			// Si no se encuentra la tarea obligatoria o no aparece como realizada en el atributo accion, se retorna que hay aunque sea una tarea sin.
			
			if (flog) {
				
				flag = true;
			}
		}
		
		return flag;
	}
	
	// Retornar una lista con tratamientos con tareas de control sin cumplir.
	
	public ArrayList<String> tratamientoSinCumplirLista(ArrayList<Tratamiento>tratamientoLista){

		ArrayList<String>  nombreTratamientosSinCumplir = new ArrayList<>();
		for (Tratamiento tratamiento : tratamientoLista) {
			if(tratamientoSinCumplir(tratamiento)){
				nombreTratamientosSinCumplir.add(tratamiento.getToken());
			}
		}
		return nombreTratamientosSinCumplir;
	}	
		
	// Verifica que el String pueda ser parseado a un entero, en caso contrario retorna 0.
	
	public int controlEntero(String str){
		try {
			int integer = Integer.parseInt(str);	
	        return integer;
	    } catch(NumberFormatException nfe) {  
	        return 0;
	    }	      
	}
	
	// Verifica que el String pueda ser parseado a un double, en caso contrario retorna 0.
	
	public double controlDouble(String str){
        try {
            double doble = Double.parseDouble(str);
            return doble;
        } catch(NumberFormatException nfe){
            return 0;
        }
    }
	
	// Metodo para introducir en el tratamiento del historial el control diario nuevo.
	
    public boolean actualizarHistorialMedico(Tratamiento tratamiento) {
        boolean flag = false;
        if(usuarioActivo instanceof Paciente){
            Paciente paciente = (Paciente) usuarioActivo;
            ControlDiario controlDiarioNuevo = paciente.retornarControlDiarioTratamiento(tratamiento,new Date());
			boolean flog = controlDiarioExiste(controlDiarioNuevo, tratamiento.getControlDiarioLista());
            if(!flog){
				HistorialMedico historialMedico = cargarControlDiarioInHistorialMedico(paciente, controlDiarioNuevo, tratamiento.getToken());
                try{
					historialMedicoHashMap.put(historialMedico.getNumeroHistorial(),historialMedico);
					ArrayList<HistorialMedico> historialMedicoLista = getListaHistorialMedico();
					HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
					historialMedicoJSON.cargarJSON(historialMedicoLista);
                    flag = true;
                }catch (IOException e){
                    mensajeLeer(e.toString());
                }
            }
        }
        return flag;
    }

	// Metodo complementario para verificar si dicho control diario no existe en el tratamiento.
    
	public boolean controlDiarioExiste(ControlDiario controlDiarioNuevo, ArrayList<ControlDiario> controlDiarioLista){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		for(ControlDiario controlDiario : controlDiarioLista) {
			if (format.format(controlDiario.getFecha()).compareTo(format.format(controlDiarioNuevo.getFecha())) == 0) {
				return true;
			}
		}
		return false;
	}

	// Metodo complementario para cargar el control diario nuevo en la lista de controles diarios del tratamiento del paciente.
	
	public HistorialMedico cargarControlDiarioInHistorialMedico(Paciente paciente, ControlDiario controlDiarioNuevo, String tokenTratamiento){
		HistorialMedico historialMedicoActualizado = historialMedicoHashMap.get(paciente.getNumeroHistorial());
		ArrayList<Tratamiento> auxTratamiento = new ArrayList<Tratamiento>();
		for(Tratamiento tratamiento : historialMedicoActualizado.getTratamientoLista()){
			if(tratamiento.getToken().compareTo(tokenTratamiento) == 0){
				tratamiento.setControlDiarioLista(paciente.guardarControlDiario(tratamiento.getControlDiarioLista(),controlDiarioNuevo));
			}
			auxTratamiento.add(tratamiento);
		}
		historialMedicoActualizado.setTratamientoLista(auxTratamiento);
		return historialMedicoActualizado;
	}
	
	// Retorna una lista con los tratamientos sin finalizar del paciente activo.
	
	public ArrayList<Tratamiento> retornarTratamientosPacienteActivo(){
		ArrayList<Tratamiento> tratamientoArrayList = new ArrayList<Tratamiento>();
		if(usuarioActivo instanceof Paciente){
			Paciente paciente = (Paciente) usuarioActivo;
			String numeroHistorial = paciente.getNumeroHistorial();
			ArrayList<Tratamiento> tratamientoSinVerificarLista = historialMedicoHashMap.get(numeroHistorial).getTratamientoLista();
			for(Tratamiento aux : tratamientoSinVerificarLista){
				if(aux.getDiaFinal() == null && aux.getDiaInicial() != null){
					tratamientoArrayList.add(aux);
				}
			}
		}
		return tratamientoArrayList;
	}
	
	// Actualizar el tratamiento a finalizado y lo guarda en el hashMap y JSON de historial medicos.
	
	public boolean finalizarTratamiento(Tratamiento tratamiento, Paciente paciente){
		boolean flag = false;
		if(usuarioActivo instanceof Profesional){
			Profesional profesional = (Profesional) usuarioActivo;
			HistorialMedico historialMedico = profesional.actualizarTratamiento(historialMedicoHashMap,
																				paciente.getNumeroHistorial(),
																				tratamiento.getToken(), paciente);
			try{
				historialMedicoHashMap.put(historialMedico.getNumeroHistorial(),historialMedico);
				ArrayList<HistorialMedico> historialMedicoLista = getListaHistorialMedico();
				HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
				historialMedicoJSON.cargarJSON(historialMedicoLista);
				flag = true;
			}catch (IOException e){
				mensajeLeer(e.toString());
			}
		}
		return flag;
	}
	
	// Retorna el control diario del tratamiento en esa fecha si existe y en caso de que no, lo crea utilizando la interfaz IngresarDatosDeControl (retornarControlDiarioTratamiento).

	public ControlDiario getControlDiarioFecha(Tratamiento tratamiento, Date date) {
		if(usuarioActivo instanceof Paciente){
			Paciente paciente = (Paciente) usuarioActivo;
			ControlDiario controlDiario = paciente.retornarControlDiarioTratamiento(tratamiento,date);
			return controlDiario;
		}
		return null;
	}
	
	// Guarda el control diario editado dentro del historial medico. El mismo utiliza la interfaz IngresarDatosDeControl.
	
	public boolean guardarDatosDeControl(ArrayList<ControlDiario> controlDiarioLista , ControlDiario controlDiarioEditado, String tokenTratamiento) {
		boolean flag = false;
		if(usuarioActivo instanceof Paciente){
			Paciente paciente = (Paciente) usuarioActivo;
			HistorialMedico historialMedico = cargarControlDiarioInHistorialMedico(paciente,controlDiarioEditado,tokenTratamiento);
			try{
				historialMedicoHashMap.put(historialMedico.getNumeroHistorial(),historialMedico);
				ArrayList<HistorialMedico> historialMedicoLista = getListaHistorialMedico();
				HistorialMedicoJSON historialMedicoJSON = new HistorialMedicoJSON();
				historialMedicoJSON.cargarJSON(historialMedicoLista);
				flag = true;
			} catch (IOException e){
				mensajeLeer(e.toString());
			}
		}
		return flag;
	}
	
	// Metodo para contener los mensajes que se quieran mostrar.
	
	public void mensajeLeer(String mensaje) {
		System.out.println(mensaje);
	}
}