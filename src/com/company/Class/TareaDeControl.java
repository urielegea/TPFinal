package com.company.Class;

public class TareaDeControl {

    protected String token;
    protected boolean accion;
    protected String observacion;
    protected EstructuraTDC estructura;

    public TareaDeControl() {
    }

    public TareaDeControl(String token, boolean accion, String observacion, EstructuraTDC estruc){
        this.token = token;
        this.accion = accion;
        this.observacion = observacion;
        this.estructura=estruc;
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

    public void setToken(String token) {
        this.token = token;
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
                "token='" + token + '\'' +
                ", accion=" + accion +
                ", observacion='" + observacion + '\'' +
                ", estructura=" + estructura +
                '}';
    }
}