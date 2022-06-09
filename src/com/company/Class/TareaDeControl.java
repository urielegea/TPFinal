package com.company.Class;

public class TareaDeControl {

    protected String nombre;
    protected boolean accion;
    protected String observacion;
    protected EstructuraTDC estructura;

    public TareaDeControl() {
    }

    public TareaDeControl(String nombre, boolean accion, String observacion, EstructuraTDC estruc){
        this.nombre = nombre;
        this.accion = accion;
        this.observacion = observacion;
        this.estructura=estruc;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public boolean getAccion() {
        return accion;
    }

    public void setAccion(boolean accion) {
        this.accion = accion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setToken(String token) {
        this.nombre = token;
    }

    public boolean isAccion() {
        return accion;
    }

    public EstructuraTDC getEstructura() {
        return estructura;
    }

    public void setEstructura(EstructuraTDC estructura) {
        this.estructura = estructura;
    }

    @Override
    public String toString() {
        return "TareaDeControl{" +
                "nombre='" + nombre + '\'' +
                ", accion=" + accion +
                ", observacion='" + observacion + '\'' +
                ", estructura=" + estructura +
                '}';
    }
}