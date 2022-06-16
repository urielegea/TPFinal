package com.company.Design;

import com.company.Class.EstructuraTDC;

@SuppressWarnings("serial")
public class ButtonEstructuraTDC extends ButtonEdit{
	private EstructuraTDC estructuraTDC;
	
	public ButtonEstructuraTDC(EstructuraTDC estructuraTDC){
		super();
		this.estructuraTDC = estructuraTDC;
	}

	public EstructuraTDC getEstructuraTDC() {
		return estructuraTDC;
	}

	public void setEstructuraTDC(EstructuraTDC estructuraTDC) {
		this.estructuraTDC = estructuraTDC;
	}
}
