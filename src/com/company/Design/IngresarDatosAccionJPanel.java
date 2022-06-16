package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.company.Class.ControlDiario;
import com.company.Class.Tratamiento;

@SuppressWarnings("serial")
public class IngresarDatosAccionJPanel extends JPanel{
	
	private ArrayList<ButtonEstructuraTDC> estructuraTDCListaButton;
	private ButtonEdit cargarDatosButton;
	private ButtonEdit cancelarDatosButton;
	
	public IngresarDatosAccionJPanel(ControlDiario controlDiario) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);
		
		Date fecha = new Date();		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		JLabel lblMenuDatos = new JLabel("Control diariol fecha " + format.format(fecha), SwingConstants.CENTER);
		lblMenuDatos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuDatos.setBounds(0, 34, 484, 46);
		add(lblMenuDatos);	
		
		estructuraTDCListaButton = new ArrayList<ButtonEstructuraTDC>();
		
		int ubicacion = 110; // Ubicacion inicial.	
				
		//for (Tratamiento tratamiento : tratamientoLista) {
			
			/*ButtonTratamiento buttonTratamiento = new ButtonTratamiento (tratamiento);
			buttonTratamiento.setForeground(Color.WHITE);
			buttonTratamiento.setBackground(new Color(3, 59, 90));
			buttonTratamiento.setHoverBackgroundColor(new Color(3, 59, 90).brighter());	
			buttonTratamiento.setPressedBackgroundColor(Color.BLACK);
			buttonTratamiento.setBounds(60, ubicacion, 360, 40);
			buttonTratamiento.setText(" Tratamiento: " + tratamiento.getEnfermedadNombre() + ".");
			add(buttonTratamiento);			
			tratamientoIngresarDatosListaButton.add(buttonTratamiento);			
			ubicacion = ubicacion + 50;	*/					
		//}			
		
		cargarDatosButton = new ButtonEdit("Volver al menu");
		cargarDatosButton.setForeground(Color.WHITE);
		cargarDatosButton.setBackground(new Color(3, 59, 90));
		cargarDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cargarDatosButton.setPressedBackgroundColor(Color.BLACK);
		cargarDatosButton.setBounds(20, ubicacion, 180, 40);
		add(cargarDatosButton);	
		
		cancelarDatosButton = new ButtonEdit("Volver al menu");
		cancelarDatosButton.setForeground(Color.WHITE);
		cancelarDatosButton.setBackground(new Color(3, 59, 90));
		cancelarDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cancelarDatosButton.setPressedBackgroundColor(Color.BLACK);
		cancelarDatosButton.setBounds(283, ubicacion, 180, 40);
		add(cancelarDatosButton);	
	}

	public ArrayList<ButtonEstructuraTDC> getEstructuraTDCListaButton() {
		return estructuraTDCListaButton;
	}

	public ButtonEdit getCargarDatosButton() {
		return cargarDatosButton;
	}

	public ButtonEdit getCancelarDatosButton() {
		return cancelarDatosButton;
	}	
}
