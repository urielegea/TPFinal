package com.company;

import java.util.Objects;
import java.util.UUID;

public abstract class Usuario extends Persona{

    //Atributos
    protected String uuid;
    protected String clave;
    protected String cuenta;

    //Constructor

    public Usuario(String nombre, String apellido, double dni, double telefono, String clave,
                   String cuenta){

        super(nombre, apellido, dni,telefono);

        UUID auxUUID = UUID.randomUUID();
        this.uuid= auxUUID.toString();
        this.clave=clave;
        this.cuenta=cuenta;
    }

    //Metodos


    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(uuid, usuario.uuid) && Objects.equals(clave, usuario.clave) && Objects.equals(cuenta, usuario.cuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, clave, cuenta);
    }
}
