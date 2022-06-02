package com.company;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Usuario extends Persona{
    
    protected String token;
    protected String cuenta;
    protected String clave;
    protected LocalDate fechaAlta;
    protected LocalDate ultimaSesion;

    public Usuario(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave, LocalDate fechaAlta){
        super(nombre, apellido, dni, telefono);
        UUID auxUUID = UUID.randomUUID();
        this.token = auxUUID.toString();
        this.cuenta = cuenta;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
        this.ultimaSesion = null;
    }

    public String getToken(){
        return token;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getClave(){
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public LocalDate getFechaAlta(){
        return fechaAlta;
    }

    public LocalDate getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(LocalDate ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(clave, usuario.clave) && Objects.equals(cuenta, usuario.cuenta)
        && Objects.equals(fechaAlta, usuario.fechaAlta) && Objects.equals(token, usuario.token)
        && Objects.equals(ultimaSesion, usuario.ultimaSesion);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(clave, cuenta, fechaAlta, token, ultimaSesion);
		return result;
	}
}
