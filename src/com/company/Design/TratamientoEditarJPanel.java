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
public class TratamientoEditarJPanel extends JPanel {

	private ArrayList<ButtonTratamiento> tratamientoListaButton;	
	private ButtonEdit atrasButton;
	
	public TratamientoEditarJPanel(ArrayList<Tratamiento> tratamientoLista) {

		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuTratamiento = new JLabel("Seleccionar tratamiento", SwingConstants.CENTER);
		lblMenuTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuTratamiento.setBounds(0, 34, 484, 46);
		add(lblMenuTratamiento);	
		
		tratamientoListaButton = new ArrayList<ButtonTratamiento>();
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		for (Tratamiento tratamiento : tratamientoLista) {
			
			ButtonTratamiento buttonTratamiento = new ButtonTratamiento(tratamiento);
			buttonTratamiento.setForeground(Color.WHITE);
			buttonTratamiento.setBackground(new Color(3, 59, 90));
			buttonTratamiento.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			buttonTratamiento.setPressedBackgroundColor(Color.BLACK);
			buttonTratamiento.setBounds(60, ubicacion, 360, 40);
			buttonTratamiento.setText("Tratamiento para " + tratamiento.getEnfermedadNombre());
			add(buttonTratamiento);			
			tratamientoListaButton.add(buttonTratamiento);			
			ubicacion = ubicacion + 50;
		}	
		
		atrasButton = new ButtonEdit("Cerrar sesión");
		atrasButton.setForeground(Color.WHITE);
		atrasButton.setBackground(new Color(3, 59, 90));
		atrasButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		atrasButton.setPressedBackgroundColor(Color.BLACK);
		atrasButton.setBounds(60, ubicacion, 360, 40);
		add(atrasButton);	
	}

	public ArrayList<ButtonTratamiento> getTratamientoListaButton() {
		return tratamientoListaButton;
	}

	public ButtonEdit getAtrasButton() {
		return atrasButton;
	}
}
