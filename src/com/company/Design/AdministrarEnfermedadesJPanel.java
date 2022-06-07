package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdministrarEnfermedadesJPanel extends JPanel {
	
	private ButtonEdit nuevaEnfermedadButton;	
	private ButtonEdit editarEnfermedadButton;
	private ButtonEdit atrasEnfermedadButton;

	public AdministrarEnfermedadesJPanel() {
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuAdministrarEnfermedades = new JLabel("Administrar enfermedades", SwingConstants.CENTER);
		lblMenuAdministrarEnfermedades.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuAdministrarEnfermedades.setBounds(0, 34, 484, 46);
		add(lblMenuAdministrarEnfermedades);
		
		nuevaEnfermedadButton = new ButtonEdit("Generar nueva enfermedad");
		nuevaEnfermedadButton.setForeground(Color.WHITE);
		nuevaEnfermedadButton.setBackground(new Color(3, 59, 90));
		nuevaEnfermedadButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		nuevaEnfermedadButton.setPressedBackgroundColor(Color.BLACK);
		nuevaEnfermedadButton.setBounds(60, 110, 360, 40);
		add(nuevaEnfermedadButton);	
		
		editarEnfermedadButton = new ButtonEdit("Editar enfermedad");
		editarEnfermedadButton.setForeground(Color.WHITE);
		editarEnfermedadButton.setBackground(new Color(3, 59, 90));
		editarEnfermedadButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		editarEnfermedadButton.setPressedBackgroundColor(Color.BLACK);
		editarEnfermedadButton.setBounds(60, 170, 360, 40);
		add(editarEnfermedadButton);	
		
		atrasEnfermedadButton = new ButtonEdit("Volver al menu");
		atrasEnfermedadButton.setForeground(Color.WHITE);
		atrasEnfermedadButton.setBackground(new Color(3, 59, 90));
		atrasEnfermedadButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		atrasEnfermedadButton.setPressedBackgroundColor(Color.BLACK);
		atrasEnfermedadButton.setBounds(60, 230, 360, 40);
		add(atrasEnfermedadButton);	
	}

	public ButtonEdit getNuevaEnfermedadButton() {
		return nuevaEnfermedadButton;
	}

	public ButtonEdit getEditarEnfermedadButton() {
		return editarEnfermedadButton;
	}

	public ButtonEdit getAtrasEnfermedadButton() {
		return atrasEnfermedadButton;
	}		
}