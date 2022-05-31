package com.company;

import java.util.Objects;
import java.util.UUID;

public abstract class Usuario extends Persona{
    
    protected String token;
    protected String cuenta;
    protected String clave;

    public Usuario(String nombre, String apellido, String dni, String telefono, String cuenta, 
    String clave){
        super(nombre, apellido, dni, telefono);
        UUID auxUUID = UUID.randomUUID();
        this.token = auxUUID.toString();
        this.cuenta = cuenta;
        this.clave = clave;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(token, usuario.token) && Objects.equals(clave, usuario.clave) && Objects.equals(cuenta, usuario.cuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, clave, cuenta);
    }
}
