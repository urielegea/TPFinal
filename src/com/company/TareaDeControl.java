package com.company;

public abstract class TareaDeControl {

    protected String token;
    protected boolean accion;
    protected String observacion;

    public TareaDeControl(String token, boolean accion, String observacion){
        this.token = token;
        this.accion = accion;
        this.observacion = observacion;
    }  
    
    public String getToken() {
        return token;
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
}
