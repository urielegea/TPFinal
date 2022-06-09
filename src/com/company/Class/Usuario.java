package com.company.Class;

import java.util.Date;

public abstract class Usuario extends Persona {
    
    protected String cuenta;
    protected String clave;
    protected Date fechaAlta;
    protected Date ultimaSesion;
    
    public Usuario() {
    	super();
    }
    
    public Usuario(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, Date fechaAlta){        
    	super(nombre, apellido, dni, telefono);

        this.cuenta = cuenta;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
        this.ultimaSesion = null;  
    }
    
    public Usuario(String nombre, String apellido, String dni, String telefono,  String cuenta,
    String clave, Date fechaAlta, Date ultimaSesion){        
    	super(nombre, apellido, dni, telefono);        

        this.cuenta = cuenta;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
        this.ultimaSesion = ultimaSesion;  
    }

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getUltimaSesion() {
		return ultimaSesion;
	}

	public void setUltimaSesion(Date ultimaSesion) {
		this.ultimaSesion = ultimaSesion;
	}
}