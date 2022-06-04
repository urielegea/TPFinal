package com.company.Design;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class LoginJPanel extends JPanel {
	
	private JTextField userField;
	private JPasswordField passwordField;
	
	private ButtonEdit loginButton;
	private ButtonEdit resetButton;
	
	public LoginJPanel() {
		
		setBackground(SystemColor.menu);
		setLayout(null);
		
		JLabel tittleLabel = new JLabel("Iniciar sesi\u00F3n", SwingConstants.CENTER);
		tittleLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tittleLabel.setBounds(0, 34, 484, 46);
		add(tittleLabel);
		
		JLabel userLabel = new JLabel("Email:");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLabel.setBounds(52, 146, 116, 30);
		add(userLabel);
		
		JLabel passwordLabel = new JLabel("Contrase\u00F1a:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(52, 206, 131, 30);
		add(passwordLabel);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userField.setBounds(193, 146, 200, 30);
		add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(193, 206, 200, 30);
		add(passwordField);
		passwordField.setColumns(10);
		
		loginButton = new ButtonEdit("Iniciar sesi\u00F3n");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(3, 59, 90));
		loginButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		loginButton.setPressedBackgroundColor(Color.BLACK);
		loginButton.setBounds(45, 340, 180, 40);
		add(loginButton);		
		
		resetButton = new ButtonEdit("Resetear");	
		resetButton.setForeground(Color.WHITE);
		resetButton.setBackground(new Color(3, 59, 90));
		resetButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		resetButton.setPressedBackgroundColor(Color.BLACK);
		resetButton.setBounds(257, 340, 180, 40);
		add(resetButton);
	}

	public JTextField getUserField() {
		return userField;
	}

	public void setUserField(String userField) {
		this.userField.setText(userField);
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(String passwordField) {
		this.passwordField.setText(passwordField);
	}

	public ButtonEdit getLoginButton() {
		return loginButton;
	}

	public ButtonEdit getResetButton() {
		return resetButton;
	}	
}