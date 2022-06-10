package com.company.Design;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class JCheckBoxTDC extends JCheckBox{
	
	private String nombreTDC;
	
	public JCheckBoxTDC(String nombreTDC){
		super();
		this.nombreTDC = nombreTDC;
	}

	public String getNombreTDC() {
		return nombreTDC;
	}

	public void setNombreTDC(String nombreTDC) {
		this.nombreTDC = nombreTDC;
	}
}
