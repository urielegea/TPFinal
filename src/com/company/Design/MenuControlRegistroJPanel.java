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
public class MenuControlRegistroJPanel extends JPanel{
	
	private ArrayList<ButtonPaciente> pacienteListaButton;	
	private ButtonEdit volverMenuButton;
	
	public MenuControlRegistroJPanel(ArrayList<Paciente> pacienteLista, ArrayList<String> pacienteSinCumplirLista) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuControlRegistro = new JLabel("Registro de control de pacientes", SwingConstants.CENTER);
		lblMenuControlRegistro.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuControlRegistro.setBounds(0, 34, 484, 46);
		add(lblMenuControlRegistro);
		
		pacienteListaButton = new ArrayList<ButtonPaciente>();
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Paciente paciente : pacienteLista) {
			
			ButtonPaciente buttonPaciente = new ButtonPaciente (paciente);
			buttonPaciente.setForeground(Color.WHITE);
			
			boolean flag = false;
			for(String nombrePaciente : pacienteSinCumplirLista) {
				
				if(nombrePaciente.compareTo(paciente.getCuenta()) == 0){
					flag = true;
				}
				
			} if (flag) {
				buttonPaciente.setBackground(Color.RED);
				buttonPaciente.setHoverBackgroundColor(Color.RED);
				buttonPaciente.setPendientes(true);
				
			} else {
				buttonPaciente.setBackground(new Color(3, 59, 90));
				buttonPaciente.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			}
			
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
