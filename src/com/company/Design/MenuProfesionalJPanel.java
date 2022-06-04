package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuProfesionalJPanel extends JPanel {
	
	private ButtonEdit asignarPlanesDeControl;	
	private ButtonEdit controlRegistroDePacientes;
	private ButtonEdit finalizarPlanesDeControl;
	private ButtonEdit cerrarMenuProfesionalButton;

	public MenuProfesionalJPanel() {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuPaciente = new JLabel("Menu profesional", SwingConstants.CENTER);
		lblMenuPaciente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPaciente.setBounds(0, 34, 484, 46);
		add(lblMenuPaciente);
	
		asignarPlanesDeControl = new ButtonEdit("Asignar plan de control");
		asignarPlanesDeControl.setForeground(Color.WHITE);
		asignarPlanesDeControl.setBackground(new Color(3, 59, 90));
		asignarPlanesDeControl.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		asignarPlanesDeControl.setPressedBackgroundColor(Color.BLACK);
		asignarPlanesDeControl.setBounds(60, 110, 360, 40);
		add(asignarPlanesDeControl);	
		
		controlRegistroDePacientes = new ButtonEdit("Control de registro de pacientes");
		controlRegistroDePacientes.setForeground(Color.WHITE);
		controlRegistroDePacientes.setBackground(new Color(3, 59, 90));
		controlRegistroDePacientes.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		controlRegistroDePacientes.setPressedBackgroundColor(Color.BLACK);
		controlRegistroDePacientes.setBounds(60, 170, 360, 40);
		add(controlRegistroDePacientes);	
		
		finalizarPlanesDeControl = new ButtonEdit("Administrar enfermedades");
		finalizarPlanesDeControl.setForeground(Color.WHITE);
		finalizarPlanesDeControl.setBackground(new Color(3, 59, 90));
		finalizarPlanesDeControl.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		finalizarPlanesDeControl.setPressedBackgroundColor(Color.BLACK);
		finalizarPlanesDeControl.setBounds(60, 230, 360, 40);
		add(finalizarPlanesDeControl);	
		
		cerrarMenuProfesionalButton = new ButtonEdit("Cerrar sesiï¿½n");
		cerrarMenuProfesionalButton.setForeground(Color.WHITE);
		cerrarMenuProfesionalButton.setBackground(new Color(3, 59, 90));
		cerrarMenuProfesionalButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cerrarMenuProfesionalButton.setPressedBackgroundColor(Color.BLACK);
		cerrarMenuProfesionalButton.setBounds(60, 290, 360, 40);
		add(cerrarMenuProfesionalButton);
	}

	public ButtonEdit getAsignarPlanesDeControl() {
		return asignarPlanesDeControl;
	}

	public ButtonEdit getControlRegistroDePacientes() {
		return controlRegistroDePacientes;
	}

	public ButtonEdit getFinalizarPlanesDeControl() {
		return finalizarPlanesDeControl;
	}

	public ButtonEdit getCerrarMenuProfesionalButton() {
		return cerrarMenuProfesionalButton;
	}	
}