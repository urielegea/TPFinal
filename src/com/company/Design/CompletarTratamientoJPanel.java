package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CompletarTratamientoJPanel extends JPanel{
	
	private JLabel duracionDiasLabel;
	private JTextField duracionDiasTextField;
	private ArrayList<JCheckBoxTDC> jComboBoxTDCLista;
	private ButtonEdit cancelarCompletarTratamientoButton;
	private ButtonEdit completarTratamientoButton;	
	
	public CompletarTratamientoJPanel(String nombreEnfermedad ,ArrayList<String>tareaDeControlNombreLista) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuCompletarTratamiento = new JLabel("Tratamiento para " + nombreEnfermedad, SwingConstants.CENTER);
		lblMenuCompletarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuCompletarTratamiento.setBounds(0, 34, 484, 46);
		add(lblMenuCompletarTratamiento);			
		int ubicacion = 110; // Ubicacion inicial.	 
		
		duracionDiasLabel = new JLabel("Dias de duraci\u00F3n");
		duracionDiasLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasLabel.setBounds(50, ubicacion, 172, 30);
		add(duracionDiasLabel);
		
		ubicacion = 110 + 50;
		
		duracionDiasTextField = new JTextField();
		duracionDiasTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasTextField.setColumns(10);
		duracionDiasTextField.setBounds(50, 152, 385, 30);
		add(duracionDiasTextField);
		
		ubicacion = 110 + 50;
		
		jComboBoxTDCLista = new ArrayList<JCheckBoxTDC>();
		
		for (String nombreTDC : tareaDeControlNombreLista) {			
			JCheckBoxTDC jCheckBoxTDC = new JCheckBoxTDC (nombreTDC);
			jCheckBoxTDC.setForeground(Color.WHITE);
			jCheckBoxTDC.setBackground(new Color(3, 59, 90));
			jCheckBoxTDC.setBounds(60, ubicacion, 360, 40);
			jCheckBoxTDC.setText(" Tarea de control: "+nombreTDC+".");
			add(jCheckBoxTDC);			
			jComboBoxTDCLista.add(jCheckBoxTDC);			
			ubicacion = ubicacion + 50;
		}			

	}
	
}
