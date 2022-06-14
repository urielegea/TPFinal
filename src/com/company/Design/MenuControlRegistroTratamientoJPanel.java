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
public class MenuControlRegistroTratamientoJPanel extends JPanel {
	
	private ArrayList<ButtonTratamiento> tratamientoRegistroListaButton;
	private ButtonEdit volverTratamientoRegistrotButton;

	public MenuControlRegistroTratamientoJPanel(ArrayList<Tratamiento> tratamientoLista, ArrayList<String> tratamientoSinCumplirLista) {
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuControlRegistroTratamiento = new JLabel("Registro de control de tratamientos", SwingConstants.CENTER);
		lblMenuControlRegistroTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuControlRegistroTratamiento.setBounds(0, 34, 484, 46);
		add(lblMenuControlRegistroTratamiento);	
		
		tratamientoRegistroListaButton = new ArrayList<ButtonTratamiento>();
		
		int ubicacion = 110; // Ubicacion inicial.	
				
		for (Tratamiento tratamiento : tratamientoLista) {
			
			ButtonTratamiento buttonTratamiento = new ButtonTratamiento (tratamiento);
			buttonTratamiento.setForeground(Color.WHITE);
			
			boolean flag = false;		
			
			for(String tokenTratamiento : tratamientoSinCumplirLista) {
				
				if(tokenTratamiento.compareTo(tratamiento.getToken()) == 0){
					flag = true;
				}
				
			} if (flag) {
				buttonTratamiento.setBackground(Color.RED);
				buttonTratamiento.setHoverBackgroundColor(Color.RED);
				buttonTratamiento.setPendientes(true);
				
			} else {
				buttonTratamiento.setBackground(new Color(3, 59, 90));
				buttonTratamiento.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
			}
			
			buttonTratamiento.setPressedBackgroundColor(Color.BLACK);
			buttonTratamiento.setBounds(60, ubicacion, 360, 40);
			buttonTratamiento.setText(" Tratamiento: " + tratamiento.getEnfermedadNombre() + ".");
			add(buttonTratamiento);			
			tratamientoRegistroListaButton.add(buttonTratamiento);			
			ubicacion = ubicacion + 50;						
		}	
		
		volverTratamientoRegistrotButton = new ButtonEdit("Volver al menu");
		volverTratamientoRegistrotButton.setForeground(Color.WHITE);
		volverTratamientoRegistrotButton.setBackground(new Color(3, 59, 90));
		volverTratamientoRegistrotButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		volverTratamientoRegistrotButton.setPressedBackgroundColor(Color.BLACK);
		volverTratamientoRegistrotButton.setBounds(60, ubicacion, 360, 40);
		add(volverTratamientoRegistrotButton);	
	}

	public ArrayList<ButtonTratamiento> getTratamientoRegistroListaButton() {
		return tratamientoRegistroListaButton;
	}

	public ButtonEdit getVolverTratamientoRegistrotButton() {
		return volverTratamientoRegistrotButton;
	}	
}
