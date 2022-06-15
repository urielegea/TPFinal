package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.company.Class.Tratamiento;

@SuppressWarnings("serial")
public class FinalizarTratamientoSeleccionarJPanel extends JPanel {
	
	private ArrayList<ButtonTratamiento> tratamientoFinalizarListaButton;
	private ButtonEdit volverFinalizarButton;

	public FinalizarTratamientoSeleccionarJPanel(ArrayList<Tratamiento> tratamientoLista) {
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuTratamientoSeleccionar = new JLabel("Seleccionar tratamiento a finalizar", SwingConstants.CENTER);
		lblMenuTratamientoSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuTratamientoSeleccionar.setBounds(0, 34, 484, 46);
		add(lblMenuTratamientoSeleccionar);	
		
		tratamientoFinalizarListaButton = new ArrayList<ButtonTratamiento>();
		
		int ubicacion = 110; // Ubicacion inicial.	
				
		for (Tratamiento tratamiento : tratamientoLista) {
			
			ButtonTratamiento buttonTratamiento = new ButtonTratamiento (tratamiento);
			buttonTratamiento.setForeground(Color.WHITE);
			buttonTratamiento.setBackground(new Color(3, 59, 90));
			buttonTratamiento.setHoverBackgroundColor(new Color(3, 59, 90).brighter());	
			buttonTratamiento.setPressedBackgroundColor(Color.BLACK);
			buttonTratamiento.setBounds(60, ubicacion, 360, 40);
			buttonTratamiento.setText(" Tratamiento: " + tratamiento.getEnfermedadNombre() + ".");
			add(buttonTratamiento);			
			tratamientoFinalizarListaButton.add(buttonTratamiento);			
			ubicacion = ubicacion + 50;						
		}	
		
		volverFinalizarButton = new ButtonEdit("Volver al menu");
		volverFinalizarButton.setForeground(Color.WHITE);
		volverFinalizarButton.setBackground(new Color(3, 59, 90));
		volverFinalizarButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverFinalizarButton.setPressedBackgroundColor(Color.BLACK);
		volverFinalizarButton.setBounds(60, ubicacion, 360, 40);
		add(volverFinalizarButton);	
	}

	public ArrayList<ButtonTratamiento> getTratamientoFinalizarListaButton() {
		return tratamientoFinalizarListaButton;
	}

	public ButtonEdit getVolverFinalizarButton() {
		return volverFinalizarButton;
	}	
}