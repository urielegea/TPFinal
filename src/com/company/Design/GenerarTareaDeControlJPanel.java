package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GenerarTareaDeControlJPanel extends JPanel {		
	
	private JPanel panel_1;	
	private JLabel nombreLabel;
	private JTextField nombreTextField;
	private JLabel observacionLabel;
	private JTextField observacionTextField;
	private JLabel descripcionAccionLabel;
	private JTextField descripcionAccionTextField;
	private JLabel tipoAccionLabel;
	private JComboBox<String> tipoAccionJComboBox;
	
	private String tipoAccion = "Entero";
	
	// Genera la tarea de contro y vuelve al menu.
	private ButtonEdit buttonGenerarTDC;
	
	// Cancela la generacion de una nueva tarea de control y vuelve al menu.
	private ButtonEdit buttonGenerarTDCCancelar;
	
	public GenerarTareaDeControlJPanel() {
		
		setLayout(null);		
		JLabel lblMenuPaciente = new JLabel("Generar tarea de control", SwingConstants.CENTER);
		lblMenuPaciente.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuPaciente.setBounds(0, 18, 484, 46);
		add(lblMenuPaciente);				
		
		panel_1 = new JPanel();
		panel_1.setBounds(27, 75, 428, 368);
		panel_1.setLayout(null);
		add(panel_1);
				
		nombreLabel = new JLabel("Nombre de la tarea de control:");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreLabel.setBounds(10, 10, 408, 30);
		panel_1.add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(10, 40, 408, 30);
		panel_1.add(nombreTextField);
		
		observacionLabel = new JLabel("Observacion de la tarea de control:");
		observacionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		observacionLabel.setBounds(10, 70, 408, 30);
		panel_1.add(observacionLabel);
		
		observacionTextField = new JTextField();
		observacionTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		observacionTextField.setColumns(10);
		observacionTextField.setBounds(10, 100, 408, 30);
		panel_1.add(observacionTextField);
		
		descripcionAccionLabel = new JLabel("Descripcion de la tarea de control:");
		descripcionAccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descripcionAccionLabel.setBounds(10, 130, 408, 30);
		panel_1.add(descripcionAccionLabel);
		
		descripcionAccionTextField = new JTextField();
		descripcionAccionTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descripcionAccionTextField.setColumns(10);
		descripcionAccionTextField.setBounds(10, 160, 408, 30);
		panel_1.add(descripcionAccionTextField);
		
		tipoAccionLabel = new JLabel("Tipo de acción de la tarea de control:");
		tipoAccionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tipoAccionLabel.setBounds(10, 190, 408, 30);
		panel_1.add(tipoAccionLabel);
		
		String[] optionsToChoose = {" Entero", " Decimal", " Nota", " Verdadero/Falso"};
		
		tipoAccionJComboBox = new JComboBox<>(optionsToChoose);
		tipoAccionJComboBox.setBounds(10, 220, 408, 30);
		tipoAccionJComboBox.setBackground(SystemColor.white);
		tipoAccionJComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tipoAccionJComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipoAccion = tipoAccionJComboBox.getSelectedItem().toString();		
			}
		});
		panel_1.add(tipoAccionJComboBox);	
		
		buttonGenerarTDCCancelar = new ButtonEdit("Cancelar");
		buttonGenerarTDCCancelar.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarTDCCancelar.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarTDCCancelar.setForeground(Color.WHITE);
		buttonGenerarTDCCancelar.setBackground(new Color(3, 59, 90));
		buttonGenerarTDCCancelar.setBounds(20, 283, 180, 40);
		panel_1.add(buttonGenerarTDCCancelar);
		
		buttonGenerarTDC = new ButtonEdit("Generar");
		buttonGenerarTDC.setPressedBackgroundColor(Color.BLACK);
		buttonGenerarTDC.setHoverBackgroundColor(new Color(4, 84, 128));
		buttonGenerarTDC.setForeground(Color.WHITE);
		buttonGenerarTDC.setBackground(new Color(3, 59, 90));
		buttonGenerarTDC.setBounds(238, 283, 180, 40);
		panel_1.add(buttonGenerarTDC);
	}

	public String getNombre() {
		return nombreTextField.getText();
	}

	public String getObservacion() {
		return observacionTextField.getText();
	}

	public String getDescripcion() {
		return descripcionAccionTextField.getText();
	}

	public String getTipoAccion() {
		return tipoAccion;
	}

	public ButtonEdit getButtonGenerarTDC() {
		return buttonGenerarTDC;
	}

	public ButtonEdit getButtonGenerarTDCCancelar() {
		return buttonGenerarTDCCancelar;
	}
	
}
