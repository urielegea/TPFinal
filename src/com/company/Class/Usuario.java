package com.company.Class;

import java.util.UUID;

public abstract class Usuario extends Persona {
    

    protected String cuenta;
    protected String clave;
    protected String fechaAlta;
    protected String ultimaSesion;
    
    public Usuario(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, String fechaAlta){        
    	super(nombre, apellido, dni, telefono);

        this.cuenta = cuenta;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
        this.ultimaSesion = null;  
    }
    
    public Usuario(String nombre, String apellido, String dni, String telefono,  String cuenta,
    String clave, String fechaAlta, String ultimaSesion){        
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

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getUltimaSesion() {
		return ultimaSesion;
	}

	public void setUltimaSesion(String ultimaSesion) {
		this.ultimaSesion = ultimaSesion;
	}
}