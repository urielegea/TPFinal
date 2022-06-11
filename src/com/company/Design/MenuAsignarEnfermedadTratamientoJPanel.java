package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.company.Class.Enfermedad;
;

@SuppressWarnings("serial")
public class MenuAsignarEnfermedadTratamientoJPanel extends JPanel {

	private ArrayList<ButtonEnfermedad> enfermedadTratamientoListaButton;	
	private ButtonEdit volverMenuButton;
	
	public MenuAsignarEnfermedadTratamientoJPanel(ArrayList<Enfermedad> enfermedadLista) {

		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuEnfermedadTratamiento = new JLabel("Asignar enfermedad del tratamiento", SwingConstants.CENTER);
		lblMenuEnfermedadTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuEnfermedadTratamiento.setBounds(0, 34, 484, 46);
		add(lblMenuEnfermedadTratamiento);	
		
		enfermedadTratamientoListaButton = new ArrayList<ButtonEnfermedad>();	
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Enfermedad enfermedad : enfermedadLista) {
			
			ButtonEnfermedad buttonProfesional = new ButtonEnfermedad (enfermedad);
			buttonProfesional.setForeground(Color.WHITE);
			buttonProfesional.setBackground(new Color(3, 59, 90));
			buttonProfesional.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			buttonProfesional.setPressedBackgroundColor(Color.BLACK);
			buttonProfesional.setBounds(60, ubicacion, 360, 40);
			buttonProfesional.setText("Enfermedad: " + enfermedad.getNombre());
			add(buttonProfesional);			
			enfermedadTratamientoListaButton.add(buttonProfesional);			
			ubicacion = ubicacion + 50;
		}	
		
		volverMenuButton = new ButtonEdit("Volver a asignar un profesional al tratamiento");
		volverMenuButton.setForeground(Color.WHITE);
		volverMenuButton.setBackground(new Color(3, 59, 90));
		volverMenuButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverMenuButton.setPressedBackgroundColor(Color.BLACK);
		volverMenuButton.setBounds(60, ubicacion, 360, 40);
		add(volverMenuButton);	
	}
	
	public ArrayList<ButtonEnfermedad> getEnfermedadTratamientoListaButton() {
		return enfermedadTratamientoListaButton;
	}

	public ButtonEdit getVolverMenuButton() {
		return volverMenuButton;
	}
}
