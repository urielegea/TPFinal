package com.company.Class;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DecimalTDC.class, name = "DecimalTDC"),
        @JsonSubTypes.Type(value = NotaTDC.class, name = "NotaTDC"),
        @JsonSubTypes.Type(value = VerdaderoFalsoTDC.class, name = "VerdaderoFalsoTDC"),
        @JsonSubTypes.Type(value = EnteroTDC.class, name = "EnteroTDC") }
)

public abstract class EstructuraTDC {

    //Atributos
    protected String textoDescriptivo;

    //Constructor
    public EstructuraTDC() {
    }

    public EstructuraTDC(String textoDescriptivo){
        this.textoDescriptivo=textoDescriptivo;
    }

    //Metodos
    public String getTextoDescriptivo() {
        return textoDescriptivo;
    }

    public void setTextoDescriptivo(String textoDescriptivo) {
        this.textoDescriptivo = textoDescriptivo;
    }

    @Override
    public String toString() {
        return "EstructuraTDC{" +
                "textoDescriptivo='" + textoDescriptivo + '\'' +
                '}';
    }
}
