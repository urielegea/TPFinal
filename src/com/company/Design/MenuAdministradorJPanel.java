package com.company.Design;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class MenuAdministradorJPanel extends JPanel {
	
	private ButtonEdit nuevoProfesionalButton;	
	private ButtonEdit nuevoPacienteButton;
	private ButtonEdit administrarEnfermedadButton;
	private ButtonEdit administrarTareaDeControlButton;
	private ButtonEdit cerrarMenuAdministradorButton;

	public MenuAdministradorJPanel() {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu administrador", SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuAdministrador.setBounds(0, 34, 484, 46);
		add(lblMenuAdministrador);
	
		nuevoProfesionalButton = new ButtonEdit("Generar profesional");
		nuevoProfesionalButton.setForeground(Color.WHITE);
		nuevoProfesionalButton.setBackground(new Color(3, 59, 90));
		nuevoProfesionalButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		nuevoProfesionalButton.setPressedBackgroundColor(Color.BLACK);
		nuevoProfesionalButton.setBounds(60, 110, 360, 40);
		add(nuevoProfesionalButton);	
		
		nuevoPacienteButton = new ButtonEdit("Generar paciente");
		nuevoPacienteButton.setForeground(Color.WHITE);
		nuevoPacienteButton.setBackground(new Color(3, 59, 90));
		nuevoPacienteButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		nuevoPacienteButton.setPressedBackgroundColor(Color.BLACK);
		nuevoPacienteButton.setBounds(60, 170, 360, 40);
		add(nuevoPacienteButton);	
		
		administrarEnfermedadButton = new ButtonEdit("Administrar enfermedades");
		administrarEnfermedadButton.setForeground(Color.WHITE);
		administrarEnfermedadButton.setBackground(new Color(3, 59, 90));
		administrarEnfermedadButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		administrarEnfermedadButton.setPressedBackgroundColor(Color.BLACK);
		administrarEnfermedadButton.setBounds(60, 230, 360, 40);
		add(administrarEnfermedadButton);	
		
		administrarTareaDeControlButton = new ButtonEdit("Administrar tratamientos");
		administrarTareaDeControlButton.setForeground(Color.WHITE);
		administrarTareaDeControlButton.setBackground(new Color(3, 59, 90));
		administrarTareaDeControlButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		administrarTareaDeControlButton.setPressedBackgroundColor(Color.BLACK);
		administrarTareaDeControlButton.setBounds(60, 290, 360, 40);
		add(administrarTareaDeControlButton);
		
		cerrarMenuAdministradorButton = new ButtonEdit("Cerrar sesión");
		cerrarMenuAdministradorButton.setForeground(Color.WHITE);
		cerrarMenuAdministradorButton.setBackground(new Color(3, 59, 90));
		cerrarMenuAdministradorButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cerrarMenuAdministradorButton.setPressedBackgroundColor(Color.BLACK);
		cerrarMenuAdministradorButton.setBounds(60, 350, 360, 40);
		add(cerrarMenuAdministradorButton);
	}

	public ButtonEdit getNuevoPacienteButton() {
		return nuevoPacienteButton;
	}

	public ButtonEdit getNuevoProfesionalButton() {
		return nuevoProfesionalButton;
	}

	public ButtonEdit getAdministrarEnfermedadButton() {
		return administrarEnfermedadButton;
	}

	public ButtonEdit getAdministrarTareaDeControlButton() {
		return administrarTareaDeControlButton;
	}

	public ButtonEdit getCerrarMenuAdministradorButton() {
		return cerrarMenuAdministradorButton;
	}	
}