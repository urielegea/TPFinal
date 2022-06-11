package com.company.Design;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.company.Class.Profesional;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MenuAsignarProfesionalJPanel extends JPanel {
	
	private ArrayList<ButtonProfesional> profesionalListaButton;	
	private ButtonEdit volverMenuButton;

	public MenuAsignarProfesionalJPanel(ArrayList<Profesional> profesionalLista) {
			
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuProfesional = new JLabel("Asignar un profesional al tratamiento", SwingConstants.CENTER);
		lblMenuProfesional.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuProfesional.setBounds(0, 34, 484, 46);
		add(lblMenuProfesional);	
		
		profesionalListaButton = new ArrayList<ButtonProfesional>();
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Profesional profesional : profesionalLista) {
			
			ButtonProfesional buttonProfesional = new ButtonProfesional (profesional);
			buttonProfesional.setForeground(Color.WHITE);
			buttonProfesional.setBackground(new Color(3, 59, 90));
			buttonProfesional.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			buttonProfesional.setPressedBackgroundColor(Color.BLACK);
			buttonProfesional.setBounds(60, ubicacion, 360, 40);
			buttonProfesional.setText("Profesional: " + profesional.getNombre() + " " + profesional.getApellido() + " - DNI: " + profesional.getDni());
			add(buttonProfesional);			
			profesionalListaButton.add(buttonProfesional);			
			ubicacion = ubicacion + 50;
		}	
		
		volverMenuButton = new ButtonEdit("Volver a seleccionar paciente del tratamiento");
		volverMenuButton.setForeground(Color.WHITE);
		volverMenuButton.setBackground(new Color(3, 59, 90));
		volverMenuButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverMenuButton.setPressedBackgroundColor(Color.BLACK);
		volverMenuButton.setBounds(60, ubicacion, 360, 40);
		add(volverMenuButton);	
	}

	public ArrayList<ButtonProfesional> getProfesionalListaButton() {
		return profesionalListaButton;
	}

	public ButtonEdit getVolverMenuButton() {
		return volverMenuButton;
	}
}