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
public class FinalizarTratamientoPacienteJPanel extends JPanel{
	
	private ArrayList<ButtonPaciente> pacienteListaButton;	
	private ButtonEdit volverMenuButton;
	
	public FinalizarTratamientoPacienteJPanel(ArrayList<Paciente> pacienteLista) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lbFinalizarTratamiento = new JLabel("Finalizar tratamiento del paciente", SwingConstants.CENTER);
		lbFinalizarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbFinalizarTratamiento.setBounds(0, 34, 484, 46);
		add(lbFinalizarTratamiento);
		
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
		
		volverMenuButton = new ButtonEdit("Volver al menu");
		volverMenuButton.setForeground(Color.WHITE);
		volverMenuButton.setBackground(new Color(3, 59, 90));
		volverMenuButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverMenuButton.setPressedBackgroundColor(Color.BLACK);
		volverMenuButton.setBounds(60, ubicacion, 360, 40);
		add(volverMenuButton);	
		
	}
	
	public ArrayList<ButtonPaciente> getPacienteListaButton() {
		return pacienteListaButton;
	}

	public ButtonEdit getVolverMenuButton() {
		return volverMenuButton;
	}	
}