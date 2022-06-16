package com.company.Design;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.company.Class.ControlDiario;
import com.company.Class.DecimalTDC;
import com.company.Class.EnteroTDC;
import com.company.Class.NotaTDC;
import com.company.Class.TareaDeControl;
import com.company.Class.VerdaderoFalsoTDC;

@SuppressWarnings("serial")
public class IngresarDatosAccionJPanel extends JPanel{
	
	private ButtonEdit cargarDatosButton;
	private ButtonEdit cancelarDatosButton;
	private ArrayList<Object> datoTDCLista;
	
	
	public IngresarDatosAccionJPanel(ControlDiario controlDiario) {
		
		setBackground(SystemColor.menu);		
		setLayout(null);

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		JLabel lblMenuDatos = new JLabel("Control diario " + format.format(controlDiario.getFecha()), SwingConstants.CENTER);
		lblMenuDatos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMenuDatos.setBounds(0, 34, 484, 46);
		add(lblMenuDatos);	
		
		int ubicacion = 110; // Ubicacion inicial.	
		
		datoTDCLista = new ArrayList<Object>();

		for (TareaDeControl tareaDeControl : controlDiario.getTareaDeControlLista()) {				
			
			JLabel label = new JLabel(tareaDeControl.getEstructura().getTextoDescriptivo());
			label.setFont(new Font("Tahoma", Font.PLAIN, 20));
			label.setBounds(60, ubicacion, 160, 30);
			label.setBackground(Color.WHITE);
			add(label);
			
			if ((tareaDeControl.getEstructura() instanceof DecimalTDC) || (tareaDeControl.getEstructura() instanceof EnteroTDC) || (tareaDeControl.getEstructura() instanceof NotaTDC)) {
							
				String texto = "";

				if (tareaDeControl.getEstructura() instanceof DecimalTDC) {
					
					DecimalTDC aux = (DecimalTDC) tareaDeControl.getEstructura();
				    if (aux.getDecimal() != null) {
				    	 texto = aux.getDecimal().toString();
				    }
					
				} else if (tareaDeControl.getEstructura() instanceof EnteroTDC){					
				    EnteroTDC aux = (EnteroTDC) tareaDeControl.getEstructura();
				    if (aux.getEntero() != null) {
				    	 texto = aux.getEntero().toString();				    	
				    }
				    
				} else if (tareaDeControl.getEstructura() instanceof NotaTDC) {
					
					NotaTDC aux = (NotaTDC) tareaDeControl.getEstructura();
				    if (aux.getNota() != null) {
				    	texto = aux.getNota();
				    }
				}
				
				JTextField datoTextField = new JTextField(texto);
				datoTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				datoTextField.setColumns(10);
				datoTextField.setBounds(220, ubicacion, 210, 30);
				add(datoTextField);	
				
				datoTDCLista.add(datoTextField);				
				
			} else if (tareaDeControl.getEstructura() instanceof VerdaderoFalsoTDC) {
								
				JCheckBox jCheckBox = new JCheckBox();
				jCheckBox.setForeground(Color.black);				
				jCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
				jCheckBox.setBackground(SystemColor.menu);
				jCheckBox.setText(" Si / No ");
				jCheckBox.setBounds(220, ubicacion, 210, 30);
				add(jCheckBox);		
				
				VerdaderoFalsoTDC verdaderoFalsoTDC = (VerdaderoFalsoTDC) tareaDeControl.getEstructura();
				if (verdaderoFalsoTDC.getVof() != null) {					
					jCheckBox.setSelected(verdaderoFalsoTDC.getVof());
				}
				
				datoTDCLista.add(jCheckBox);	
			}				
			ubicacion = ubicacion + 50;			
		
		}		
		
		ubicacion = ubicacion + 10;
		
		cancelarDatosButton = new ButtonEdit("Cancelar");
		cancelarDatosButton.setForeground(Color.WHITE);
		cancelarDatosButton.setBackground(new Color(3, 59, 90));
		cancelarDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cancelarDatosButton.setPressedBackgroundColor(Color.BLACK);
		cancelarDatosButton.setBounds(58, ubicacion, 180, 40);
		add(cancelarDatosButton);	
		
		cargarDatosButton = new ButtonEdit("Guardar datos");
		cargarDatosButton.setForeground(Color.WHITE);
		cargarDatosButton.setBackground(new Color(3, 59, 90));
		cargarDatosButton.setHoverBackgroundColor(new Color(3, 59, 90).brighter());
		cargarDatosButton.setPressedBackgroundColor(Color.BLACK);
		cargarDatosButton.setBounds(248, ubicacion, 180, 40);
		add(cargarDatosButton);	
	}

	public ButtonEdit getCargarDatosButton() {
		return cargarDatosButton;
	}

	public ButtonEdit getCancelarDatosButton() {
		return cancelarDatosButton;
	}

	public ArrayList<Object> getDatoTDCLista() {
		return datoTDCLista;
	}
}

