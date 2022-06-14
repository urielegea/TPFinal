package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GenerarEnfermedadJPanel extends JPanel {
	
	private JPanel panel_1;	
	
	// Genera la enfermedad y vuelve al administrar enfermedad.
	private ButtonEdit buttonGenerarEnfermedad;
	
	// Cancela la generacion de una nueva enfermedad y vuelve al menu.
	private ButtonEdit buttonGenerarEnfermedadCancelar;
	
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel descripcionLabel;
	private JTextField descripcionTextField;
	private JLabel duracionDiasLabel;
	private JTextField duracionDiasTextField;

	public GenerarEnfermedadJPanel() {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblgenerarEnfermedad = new JLabel("Generar enfermedad", SwingConstants.CENTER);
		lblgenerarEnfermedad.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblgenerarEnfermedad.setBounds(0, 34, 484, 46);
		add(lblgenerarEnfermedad);
		
		panel_1 = new JPanel();
		panel_1.setBounds(27, 108, 428, 335);
		panel_1.setLayout(null);
		add(panel_1);
		
		nombreLabel = new JLabel("Enfermedad:");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreLabel.setBounds(50, 10, 116, 30);
		panel_1.add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(182, 10, 201, 30);
		panel_1.add(nombreTextField);
		
		duracionDiasLabel = new JLabel("Dias de duracion:");
		duracionDiasLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasLabel.setBounds(50, 60, 172, 30);
		panel_1.add(duracionDiasLabel);
		
		duracionDiasTextField = new JTextField();
		duracionDiasTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasTextField.setColumns(10);
		duracionDiasTextField.setBounds(221, 60, 160, 30);
		panel_1.add(duracionDiasTextField);
		
		descripcionLabel = new JLabel("Descripcion:");
		descripcionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descripcionLabel.setBounds(50, 110, 116, 30);
		panel_1.add(descripcionLabel);
		
		descripcionTextField = new JTextField();
		descripcionTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descripcionTextField.setBounds(176, 110, 207, 30);
		panel_1.add(descripcionTextField);
		
		buttonGenerarEnfermedadCancelar = new ButtonEdit("Cancelar");
		buttonGenerarEnfermedadCancelar.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarEnfermedadCancelar.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarEnfermedadCancelar.setForeground(Color.WHITE);
		buttonGenerarEnfermedadCancelar.setBackground(new Color(3, 59, 90));
		buttonGenerarEnfermedadCancelar.setBounds(20, 191, 180, 40);
		panel_1.add(buttonGenerarEnfermedadCancelar);
		
		buttonGenerarEnfermedad = new ButtonEdit("Generar");
		buttonGenerarEnfermedad.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarEnfermedad.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarEnfermedad.setForeground(Color.WHITE);
		buttonGenerarEnfermedad.setBackground(new Color(3, 59, 90));
		buttonGenerarEnfermedad.setBounds(238, 191, 180, 40);
		panel_1.add(buttonGenerarEnfermedad);			
	}

	public ButtonEdit getButtonGenerarEnfermedad() {
		return buttonGenerarEnfermedad;
	}

	public ButtonEdit getButtonGenerarEnfermedadCancelar() {
		return buttonGenerarEnfermedadCancelar;
	}

	public String getNombre() {
		return nombreTextField.getText();
	}
	public String getDescripcion() {
		return descripcionTextField.getText();
	}

	public String getDuracionDias() {
		return duracionDiasTextField.getText();
	}		
}