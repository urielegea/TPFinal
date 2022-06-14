package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuAsignarTDCJPanel extends JPanel {

	private ButtonEdit buttonAsignarTDC;
	private ButtonEdit buttonAsignarTDCCancelar;
	private ArrayList<JCheckBoxTDC> jCheckBoxTDCLista;
	
	public MenuAsignarTDCJPanel(ArrayList<String> tareaDeControlNombreLista, String nombreEnfermedad) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuTDC = new JLabel("Asignar Tareas de control", SwingConstants.CENTER);
		lblMenuTDC.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuTDC.setBounds(0, 34, 484, 46);
		add(lblMenuTDC);			
		int ubicacion = 110; // Ubicacion inicial.	 
		
		jCheckBoxTDCLista = new ArrayList<JCheckBoxTDC>();
		
		for (String nombreTDC : tareaDeControlNombreLista) {
			
			JCheckBoxTDC jCheckBoxTDC = new JCheckBoxTDC (nombreTDC);
			jCheckBoxTDC.setForeground(Color.WHITE);
			jCheckBoxTDC.setBackground(new Color(3, 59, 90));
			jCheckBoxTDC.setBounds(60, ubicacion, 360, 40);
			jCheckBoxTDC.setText(" Tarea de control: "+nombreTDC+".");
			add(jCheckBoxTDC);			
			jCheckBoxTDCLista.add(jCheckBoxTDC);			
			ubicacion = ubicacion + 50;
		}	
		
		buttonAsignarTDCCancelar = new ButtonEdit();
		buttonAsignarTDCCancelar.setPressedBackgroundColor(Color.BLACK);
		buttonAsignarTDCCancelar.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonAsignarTDCCancelar.setForeground(Color.WHITE);
		buttonAsignarTDCCancelar.setBackground(new Color(3, 59, 90));
		add(buttonAsignarTDCCancelar);
		
		buttonAsignarTDC = new ButtonEdit("Asignar");		
		buttonAsignarTDC.setPressedBackgroundColor(Color.BLACK);
		buttonAsignarTDC.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonAsignarTDC.setForeground(Color.WHITE);
		buttonAsignarTDC.setBackground(new Color(3, 59, 90));
		
		if (!tareaDeControlNombreLista.isEmpty()) {			
			buttonAsignarTDCCancelar.setText("Atras");
			buttonAsignarTDCCancelar.setBounds(60, ubicacion+20, 163, 40);
			buttonAsignarTDC.setBounds(269, ubicacion+20, 154, 40);
		}
		
		else {			
			buttonAsignarTDCCancelar.setText("Volver al listado de enfermedades");
			buttonAsignarTDCCancelar.setBounds(51, ubicacion+20, 398, 40);
			buttonAsignarTDC.setVisible(false);
		}
		add(buttonAsignarTDC);
	}

	public ButtonEdit getButtonAsignarTDC() {
		return buttonAsignarTDC;
	}

	public ButtonEdit getButtonAsignarTDCCancelar() {
		return buttonAsignarTDCCancelar;
	}

	public ArrayList<String> getAsignarTDCLista() {		
		ArrayList<String> asignarTDCLista = new ArrayList<String>();		
		for (JCheckBoxTDC jCheckBoxTDC : jCheckBoxTDCLista) {
			if (jCheckBoxTDC.isSelected()) {
				asignarTDCLista.add(jCheckBoxTDC.getNombreTDC());
			}			
		}		
		return asignarTDCLista;
	}
}
