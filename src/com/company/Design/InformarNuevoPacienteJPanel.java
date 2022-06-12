package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.company.Class.Paciente;

@SuppressWarnings("serial")
public class InformarNuevoPacienteJPanel extends JPanel {
	
	private ArrayList<ButtonPaciente> pacienteListaButton;	
	private ButtonEdit cerrarSesionButton;
	
	public InformarNuevoPacienteJPanel(ArrayList<Paciente> pacienteLista) {

		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuPaciente = new JLabel("Lista de pacientes nuevos", SwingConstants.CENTER);
		lblMenuPaciente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPaciente.setBounds(0, 34, 484, 46);
		add(lblMenuPaciente);	
		
		pacienteListaButton = new ArrayList<ButtonPaciente>();
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Paciente paciente : pacienteLista) {
			
			ButtonPaciente buttonPaciente = new ButtonPaciente (paciente);
			buttonPaciente.setForeground(Color.WHITE);
			buttonPaciente.setBackground(new Color(3, 59, 90));
			buttonPaciente.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			buttonPaciente.setPressedBackgroundColor(Color.BLACK);
			buttonPaciente.setBounds(60, ubicacion, 360, 40);
			buttonPaciente.setText("Paciente: " + paciente.getNombre() + " " + paciente.getApellido() + " - DNI: " + paciente.getDni());
			add(buttonPaciente);			
			pacienteListaButton.add(buttonPaciente);			
			ubicacion = ubicacion + 50;
		}	
		
		cerrarSesionButton = new ButtonEdit("Cerrar sesión");
		cerrarSesionButton.setForeground(Color.WHITE);
		cerrarSesionButton.setBackground(new Color(3, 59, 90));
		cerrarSesionButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cerrarSesionButton.setPressedBackgroundColor(Color.BLACK);
		cerrarSesionButton.setBounds(60, ubicacion, 360, 40);
		add(cerrarSesionButton);			
	}

	public ArrayList<ButtonPaciente> getPacienteListaButton() {
		return pacienteListaButton;
	}

	public ButtonEdit getCerrarSesionButton() {
		return cerrarSesionButton;
	}
}
