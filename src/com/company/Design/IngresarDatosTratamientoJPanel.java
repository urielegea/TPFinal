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
public class IngresarDatosTratamientoJPanel extends JPanel {
	
	private ArrayList<ButtonTratamiento> tratamientoIngresarDatosListaButton;
	private ButtonEdit volverIngresarDatosButton;

	public IngresarDatosTratamientoJPanel(ArrayList<Tratamiento> tratamientoLista) {
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuTratamientoSeleccionar = new JLabel("Seleccionar tratamiento personal", SwingConstants.CENTER);
		lblMenuTratamientoSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuTratamientoSeleccionar.setBounds(0, 34, 484, 46);
		add(lblMenuTratamientoSeleccionar);	
		
		tratamientoIngresarDatosListaButton = new ArrayList<ButtonTratamiento>();
		
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
			tratamientoIngresarDatosListaButton.add(buttonTratamiento);			
			ubicacion = ubicacion + 50;						
		}	
		
		volverIngresarDatosButton = new ButtonEdit("Volver al menu");
		volverIngresarDatosButton.setForeground(Color.WHITE);
		volverIngresarDatosButton.setBackground(new Color(3, 59, 90));
		volverIngresarDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverIngresarDatosButton.setPressedBackgroundColor(Color.BLACK);
		volverIngresarDatosButton.setBounds(60, ubicacion, 360, 40);
		add(volverIngresarDatosButton);	
	}

	public ArrayList<ButtonTratamiento> getTratamientoIngresarDatosListaButton() {
		return tratamientoIngresarDatosListaButton;
	}

	public ButtonEdit getVolverIngresarDatosButton() {
		return volverIngresarDatosButton;
	}
}