package com.company.Design;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.company.Class.Enfermedad;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MenuAsignarEnfermedadJPanel extends JPanel {
	
	private ArrayList<ButtonEnfermedad> enfermedadListaButton;	
	private ButtonEdit volverMenuButton;

	public MenuAsignarEnfermedadJPanel(ArrayList<Enfermedad> enfermedadLista) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuPaciente = new JLabel("Lista de enfermedades", SwingConstants.CENTER);
		lblMenuPaciente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPaciente.setBounds(0, 34, 484, 46);
		add(lblMenuPaciente);	
		
		enfermedadListaButton = new ArrayList<ButtonEnfermedad>();
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Enfermedad enfermedad : enfermedadLista) {
			
			ButtonEnfermedad buttonEnfermedad = new ButtonEnfermedad(enfermedad);
			buttonEnfermedad.setForeground(Color.WHITE);
			buttonEnfermedad.setBackground(new Color(3, 59, 90));
			buttonEnfermedad.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			buttonEnfermedad.setPressedBackgroundColor(Color.BLACK);
			buttonEnfermedad.setBounds(60, ubicacion, 360, 40);
			buttonEnfermedad.setText("Enfermedad: " + enfermedad.getNombre());
			add(buttonEnfermedad);			
			enfermedadListaButton.add(buttonEnfermedad);			
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

	public ArrayList<ButtonEnfermedad> getEnfermedadListaButton() {
		return enfermedadListaButton;
	}

	public ButtonEdit getVolverMenuButton() {
		return volverMenuButton;
	}	
}