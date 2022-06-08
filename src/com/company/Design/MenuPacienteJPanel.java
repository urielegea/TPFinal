package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuPacienteJPanel extends JPanel {
	
	private ButtonEdit ingresarDatosDeControl;	
	private ButtonEdit cerrarMenuPacienteButton;

	public MenuPacienteJPanel() {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuPaciente = new JLabel("Menu paciente", SwingConstants.CENTER);
		lblMenuPaciente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPaciente.setBounds(0, 34, 484, 46);
		add(lblMenuPaciente);
	
		ingresarDatosDeControl = new ButtonEdit("Ingresar datos de control");
		ingresarDatosDeControl.setForeground(Color.WHITE);
		ingresarDatosDeControl.setBackground(new Color(3, 59, 90));
		ingresarDatosDeControl.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		ingresarDatosDeControl.setPressedBackgroundColor(Color.BLACK);
		ingresarDatosDeControl.setBounds(60, 110, 360, 40);
		add(ingresarDatosDeControl);	
		
		cerrarMenuPacienteButton = new ButtonEdit("Cerrar sesión");
		cerrarMenuPacienteButton.setForeground(Color.WHITE);
		cerrarMenuPacienteButton.setBackground(new Color(3, 59, 90));
		cerrarMenuPacienteButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cerrarMenuPacienteButton.setPressedBackgroundColor(Color.BLACK);
		cerrarMenuPacienteButton.setBounds(60, 160, 360, 40);
		add(cerrarMenuPacienteButton);
	}

	public ButtonEdit getIngresarDatosDeControl() {
		return ingresarDatosDeControl;
	}

	public ButtonEdit getCerrarMenuPacienteButton() {
		return cerrarMenuPacienteButton;
	}	
}