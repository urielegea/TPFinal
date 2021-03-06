package com.company.Design;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class GenerarProfesionalJPanel extends JPanel {
	
	private JPanel panel_1;	
	
	// Genera el profesional y vuelve al menu.
	private ButtonEdit buttonGenerarProfesional;
	
	// Cancela la generacion de un nuevo profesional y vuelve al menu.
	private ButtonEdit buttonGenerarProfesionalCancelar;
	
	private JLabel cuentaLabel;
	private JTextField cuentaTextField;
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel apellidoLabel;
	private JTextField apellidoTextField;
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
		
		passwordLabel = new JLabel("Clave:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(67, 52, 67, 30);
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
		
		nombreTextField = new JTextField();
		nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(171, 91, 200, 30);
		panel_1.add(nombreTextField);
		
		apellidoLabel = new JLabel("Apellido:");
		apellidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoLabel.setBounds(52, 131, 109, 30);
		panel_1.add(apellidoLabel);
		
		apellidoTextField = new JTextField();
		apellidoTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apellidoTextField.setColumns(10);
		apellidoTextField.setBounds(171, 131, 200, 30);
		panel_1.add(apellidoTextField);
		
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
		
		buttonGenerarProfesionalCancelar = new ButtonEdit("Cancelar");
		buttonGenerarProfesionalCancelar.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarProfesionalCancelar.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarProfesionalCancelar.setForeground(Color.WHITE);
		buttonGenerarProfesionalCancelar.setBackground(new Color(3, 59, 90));
		buttonGenerarProfesionalCancelar.setBounds(20, 283, 180, 40);
		panel_1.add(buttonGenerarProfesionalCancelar);
		
		buttonGenerarProfesional = new ButtonEdit("Generar");
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

	public String getCuenta() {
		return cuentaTextField.getText();
	}

	public String getNombre() {
		return nombreTextField.getText();
	}

	public String getApellido() {
		return apellidoTextField.getText();
	}

	public String getDni() {
		return dniTextField.getText();
	}

	public String getTelefono() {
		return telefonoTextField.getText();
	}

	public String getClave() {
		return String.valueOf(passwordField.getPassword());
	}	
}