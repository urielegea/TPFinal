package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.company.Class.ControlDiario;
import com.company.Class.DecimalTDC;
import com.company.Class.EnteroTDC;
import com.company.Class.NotaTDC;
import com.company.Class.Paciente;
import com.company.Class.TareaDeControl;
import com.company.Class.Tratamiento;
import com.company.Class.VerdaderoFalsoTDC;

import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class MenuControlRegistroDatosJPanel extends JPanel {
	
	private ButtonEdit menuControlRegistroDatosButton;

	public MenuControlRegistroDatosJPanel(Tratamiento tratamiento, Paciente paciente) {
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		JLabel lblMenuControlDiario = new JLabel("Datos de control diario", SwingConstants.CENTER);
		lblMenuControlDiario.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuControlDiario.setBounds(0, 34, 484, 46);
		add(lblMenuControlDiario);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(60, 105, 360, 238);
		textPane.setText(mostrarTexto(tratamiento, paciente));
		add(textPane);
		
		menuControlRegistroDatosButton = new ButtonEdit("Atras");
		menuControlRegistroDatosButton.setForeground(Color.WHITE);
		menuControlRegistroDatosButton.setBackground(new Color(3, 59, 90));
		menuControlRegistroDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		menuControlRegistroDatosButton.setPressedBackgroundColor(Color.BLACK);
		menuControlRegistroDatosButton.setBounds(60, 364, 360, 40);
		add(menuControlRegistroDatosButton);	
	}
	
	public String mostrarTexto(Tratamiento tratamiento, Paciente paciente) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		String texto = " * Tratamiento de " + tratamiento.getEnfermedadNombre() + ".\n * " + "Paciente " + paciente.getNombre() + " " + paciente.getApellido() + ".\n";
		
		if (tratamiento.getControlDiarioLista() != null) {
			
			texto = texto + " * Registro de tareas de control: \n";
			
			for (ControlDiario controlDiario : tratamiento.getControlDiarioLista()) {
				
				texto = texto + " - " + format.format(controlDiario.getFecha()) + " \n";
				
				for (TareaDeControl tareaDeControl : controlDiario.getTareaDeControlLista()) {
					
					texto = texto + " " + tareaDeControl.getNombre() + " " + tareaDeControl.getEstructura().getTextoDescriptivo() + " ";
				
					if (tareaDeControl.getEstructura() instanceof EnteroTDC) {	
						
						EnteroTDC enteroTDC = (EnteroTDC) tareaDeControl.getEstructura();						
						texto = texto + enteroTDC.getEntero().toString();
						
					} else if (tareaDeControl.getEstructura() instanceof VerdaderoFalsoTDC) {
						
						VerdaderoFalsoTDC verdaderoFalsoTDC = (VerdaderoFalsoTDC) tareaDeControl.getEstructura();		
						
						if (verdaderoFalsoTDC.getVof()) {
							texto = texto + "si";
							
						} else {
							texto = texto + "no";
						}						
						
					} else if (tareaDeControl.getEstructura() instanceof DecimalTDC) {
						
						DecimalTDC decimalTDC = (DecimalTDC) tareaDeControl.getEstructura();						
						texto = texto + decimalTDC.getDecimal().toString();
						
					} else if (tareaDeControl.getEstructura() instanceof NotaTDC) {
						
						NotaTDC notaTDC = (NotaTDC) tareaDeControl.getEstructura();						
						texto = texto + notaTDC.getNota();
					}	
					
					texto = texto + ". \n";
				}				
			}	
		} else {
			texto = texto + " * No se registraron tareas de control actualmente. \n";
		}
		return texto;
	}

	public ButtonEdit getMenuControlRegistroDatosButton() {
		return menuControlRegistroDatosButton;
	}		
}
