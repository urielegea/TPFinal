package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.company.Class.TareaDeControl;

@SuppressWarnings("serial")
public class CompletarTratamientoJPanel extends JPanel{
	
	private JLabel duracionDiasLabel;
	private JTextField duracionDiasTextField;
	private ArrayList<JCheckBoxTDC> jComboBoxTDCLista;
	private ButtonEdit cancelarCompletarTratamientoButton;
	private ButtonEdit completarTratamientoButton;	
	
	public CompletarTratamientoJPanel(String nombreEnfermedad, int duracionDias, ArrayList<String>tareaDeControlEnfermedadNombreLista, ArrayList<TareaDeControl>tareaDeControlNombreLista) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
				
		JLabel lblMenuCompletarTratamiento = new JLabel("Tratamiento para " + nombreEnfermedad, SwingConstants.CENTER);
		lblMenuCompletarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuCompletarTratamiento.setBounds(0, 34, 484, 46);
		add(lblMenuCompletarTratamiento);			
		int ubicacion = 110; // Ubicacion inicial.	 
		
		duracionDiasLabel = new JLabel("Dias de duracion:");
		duracionDiasLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasLabel.setBounds(60, 110, 164, 30);
		add(duracionDiasLabel);		
		
		String duracionDiasString = duracionDias + "";
		
		duracionDiasTextField = new JTextField();
		duracionDiasTextField.setText(duracionDiasString);
		duracionDiasTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duracionDiasTextField.setColumns(10);
		duracionDiasTextField.setBounds(227, 110, 195, 30);
		add(duracionDiasTextField);
		
		ubicacion = ubicacion + 50;
		
		jComboBoxTDCLista = new ArrayList<JCheckBoxTDC>();
		
		for (TareaDeControl tdc : tareaDeControlNombreLista) {		
			
			JCheckBoxTDC jCheckBoxTDC = new JCheckBoxTDC (tdc.getNombre());
			jCheckBoxTDC.setForeground(Color.WHITE);
			jCheckBoxTDC.setBackground(new Color(3, 59, 90));
			jCheckBoxTDC.setBounds(60, ubicacion, 360, 40);
			jCheckBoxTDC.setText(" Tarea de control: "+tdc.getNombre()+".");
			
			boolean flag = false;			
			for(String tareaDeControl : tareaDeControlEnfermedadNombreLista) {				
				if (tareaDeControl.compareTo(tdc.getNombre()) == 0) {
					flag = true;
				}				
			}				
			jCheckBoxTDC.setSelected(flag);
			add(jCheckBoxTDC);			
			jComboBoxTDCLista.add(jCheckBoxTDC);			
			ubicacion = ubicacion + 50;
		}		
		
		ubicacion = ubicacion + 10;
		
		completarTratamientoButton = new ButtonEdit("Comenzar tratamiento");
		completarTratamientoButton.setForeground(Color.WHITE);
		completarTratamientoButton.setBackground(new Color(3, 59, 90));
		completarTratamientoButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		completarTratamientoButton.setPressedBackgroundColor(Color.BLACK);
		completarTratamientoButton.setBounds(60, ubicacion, 180, 40);
		add(completarTratamientoButton);
		
		cancelarCompletarTratamientoButton = new ButtonEdit("Cancelar");
		cancelarCompletarTratamientoButton.setForeground(Color.WHITE);
		cancelarCompletarTratamientoButton.setBackground(new Color(3, 59, 90));
		cancelarCompletarTratamientoButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cancelarCompletarTratamientoButton.setPressedBackgroundColor(Color.BLACK);
		cancelarCompletarTratamientoButton.setBounds(250, ubicacion, 170, 40);
		add(cancelarCompletarTratamientoButton);
	}

	public String getDuracionDias() {
		return duracionDiasTextField.getText();
	}

	public ArrayList<String> tareaDeControlLista() {		
		ArrayList<String> tareaDeControlLista = new ArrayList<String>();
		
		for (JCheckBoxTDC jCheckBoxTDC : jComboBoxTDCLista) {
			if (jCheckBoxTDC.isSelected()) {
				tareaDeControlLista.add(jCheckBoxTDC.getNombreTDC());
			}
		}		
		return tareaDeControlLista;
	}

	public ButtonEdit getCancelarCompletarTratamientoButton() {
		return cancelarCompletarTratamientoButton;
	}

	public ButtonEdit getCompletarTratamientoButton() {
		return completarTratamientoButton;
	}
	
}
