package com.company.Design;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GenerarProfesionalJPanel extends JPanel {
	
	private JPanel panel_1;	
	
	// Genera el profesional y vuelve al menu.
	private ButtonEdit buttonGenerarProfesional;
	
	// Cancela la generacion de un nuevo profesional y vuelve al menu.
	private ButtonEdit buttonGenerarProfesionalCancelar;
	
	private JLabel cuentaLabel;
	private JTextField cuentaTextField;
	private JLabel nombreLabel;
	private JTextField NombreTextField;
	private JLabel apellidoLabel;
	private JTextField ApellidoTextField;
	private JLabel dniLabel;
	private JTextField dniTextField;
	private JLabel telefonoLabel;
	private JTextField telefonoTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	public GenerarProfesionalJPanel() {		
		setLayout(null);		
		JLabel lblMenuAdministrador = new JLabel("Generar profesional", SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuAdministrador.setBounds(0, 18, 484, 46);
		add(lblMenuAdministrador);				
		
		panel_1 = new JPanel();
		panel_1.setBounds(27, 86, 428, 357);
		panel_1.setLayout(null);
		add(panel_1);
		
		cuentaLabel = new JLabel("Cuenta:");
		cuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cuentaLabel.setBounds(57, 11, 116, 30);
		panel_1.add(cuentaLabel);
		
		cuentaTextField = new JTextField();
		cuentaTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cuentaTextField.setColumns(10);
		cuentaTextField.setBounds(171, 11, 200, 30);
		panel_1.add(cuentaTextField);
		
		passwordLabel = new JLabel("Contrase\u00F1a:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(20, 51, 141, 30);
		panel_1.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setColumns(10);
		passwordField.setBounds(171, 51, 200, 30);
		panel_1.add(passwordField);
		
		nombreLabel = new JLabel("Nombre:");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreLabel.setBounds(52, 91, 109, 30);
		panel_1.add(nombreLabel);
		
		NombreTextField = new JTextField();
		NombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NombreTextField.setColumns(10);
		NombreTextField.setBounds(171, 91, 200, 30);
		panel_1.add(NombreTextField);
		
		apellidoLabel = new JLabel("Apellido:");
		apellidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoLabel.setBounds(52, 131, 109, 30);
		panel_1.add(apellidoLabel);
		
		ApellidoTextField = new JTextField();
		ApellidoTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ApellidoTextField.setColumns(10);
		ApellidoTextField.setBounds(171, 131, 200, 30);
		panel_1.add(ApellidoTextField);
		
		dniLabel = new JLabel("Dni:");
		dniLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dniLabel.setBounds(91, 171, 78, 30);
		panel_1.add(dniLabel);
		
		dniTextField = new JTextField();
		dniTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dniTextField.setColumns(10);
		dniTextField.setBounds(171, 171, 200, 30);
		panel_1.add(dniTextField);
		
		telefonoLabel = new JLabel("Telefono:");
		telefonoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefonoLabel.setBounds(45, 211, 116, 30);
		panel_1.add(telefonoLabel);
		
		telefonoTextField = new JTextField();
		telefonoTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		telefonoTextField.setColumns(10);
		telefonoTextField.setBounds(171, 211, 200, 30);
		panel_1.add(telefonoTextField);
		
		buttonGenerarProfesionalCancelar = new ButtonEdit("Iniciar sesi\u00F3n");
		buttonGenerarProfesionalCancelar.setText("Cancelar");
		buttonGenerarProfesionalCancelar.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarProfesionalCancelar.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarProfesionalCancelar.setForeground(Color.WHITE);
		buttonGenerarProfesionalCancelar.setBackground(new Color(3, 59, 90));
		buttonGenerarProfesionalCancelar.setBounds(20, 283, 180, 40);
		panel_1.add(buttonGenerarProfesionalCancelar);
		
		buttonGenerarProfesional = new ButtonEdit("Resetear");
		buttonGenerarProfesional.setText("Generar");
		buttonGenerarProfesional.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarProfesional.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarProfesional.setForeground(Color.WHITE);
		buttonGenerarProfesional.setBackground(new Color(3, 59, 90));
		buttonGenerarProfesional.setBounds(238, 283, 180, 40);
		panel_1.add(buttonGenerarProfesional);
	}

	public ButtonEdit getButtonGenerarProfesional() {
		return buttonGenerarProfesional;
	}

	public ButtonEdit getButtonGenerarProfesionalCancelar() {
		return buttonGenerarProfesionalCancelar;
	}

	public JTextField getCuentaTextField() {
		return cuentaTextField;
	}

	public JTextField getNombreTextField() {
		return NombreTextField;
	}

	public JTextField getApellidoTextField() {
		return ApellidoTextField;
	}

	public JTextField getDniTextField() {
		return dniTextField;
	}

	public JTextField getTelefonoTextField() {
		return telefonoTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}	
}