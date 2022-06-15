package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.company.Class.Paciente;
import com.company.Class.Profesional;
import com.company.Class.Tratamiento;

@SuppressWarnings("serial")
public class FinalizarTratamientoAccionJPanel extends JPanel {

	private JPanel panel_1;	
	
	private ButtonEdit finalizarTratamientoButton;
	private ButtonEdit finalizarTratamientoCancelarButton;
	
	private JLabel enfermedadLabel;
	private JLabel profesionalLabel;
	private JLabel pacienteLabel;
	private JLabel fechaDeInicioLabel;
	
	public FinalizarTratamientoAccionJPanel(Tratamiento tratamiento, Paciente paciente, Profesional profesional) {
		setLayout(null);		
		JLabel lblFinalizarTratamiento = new JLabel("Finalizar tratamiento", SwingConstants.CENTER);
		lblFinalizarTratamiento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblFinalizarTratamiento.setBounds(0, 18, 484, 46);
		add(lblFinalizarTratamiento);				
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(27, 102, 423, 248);
		panel_1.setLayout(null);
		add(panel_1);
		
		enfermedadLabel = new JLabel("Enfermedad: " + tratamiento.getEnfermedadNombre());
		enfermedadLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enfermedadLabel.setBounds(20, 11, 382, 30);
		panel_1.add(enfermedadLabel);
		
		profesionalLabel = new JLabel("Profesional: " + profesional.getNombre() + " " + profesional.getApellido());
		profesionalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profesionalLabel.setBounds(20, 52, 382, 30);
		panel_1.add(profesionalLabel);
		
		pacienteLabel = new JLabel("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());
		pacienteLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pacienteLabel.setBounds(20, 91, 382, 30);
		panel_1.add(pacienteLabel);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		fechaDeInicioLabel = new JLabel("Fecha de inicio: " + format.format(tratamiento.getDiaInicial()));
		fechaDeInicioLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fechaDeInicioLabel.setBounds(20, 131, 382, 30);
		panel_1.add(fechaDeInicioLabel);
		
		
		finalizarTratamientoCancelarButton = new ButtonEdit("Cancelar");
		finalizarTratamientoCancelarButton.setPressedBackgroundColor(Color.BLACK);
		finalizarTratamientoCancelarButton.setHoverBackgroundColor(new Color(4, 84, 128));
		finalizarTratamientoCancelarButton.setForeground(Color.WHITE);
		finalizarTratamientoCancelarButton.setBackground(new Color(3, 59, 90));
		finalizarTratamientoCancelarButton.setBounds(18, 189, 180, 40);
		panel_1.add(finalizarTratamientoCancelarButton);
		
		finalizarTratamientoButton = new ButtonEdit("Finalizar tratamiento");
		finalizarTratamientoButton.setPressedBackgroundColor(Color.BLACK);
		finalizarTratamientoButton.setHoverBackgroundColor(new Color(4, 84, 128));
		finalizarTratamientoButton.setForeground(Color.WHITE);
		finalizarTratamientoButton.setBackground(new Color(3, 59, 90));
		finalizarTratamientoButton.setBounds(222, 189, 180, 40);
		panel_1.add(finalizarTratamientoButton);
	}

	public ButtonEdit getFinalizarTratamientoButton() {
		return finalizarTratamientoButton;
	}

	public ButtonEdit getFinalizarTratamientoCancelarButton() {
		return finalizarTratamientoCancelarButton;
	}
}
