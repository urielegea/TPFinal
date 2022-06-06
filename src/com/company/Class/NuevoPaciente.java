package com.company.Class;

public interface NuevoPaciente {

    public default Paciente crearPaciente(String nombre, String apellido, String dni, String telefono, String cuenta,
                                          String clave, String fechaAlta, String numeroHistorial){
        return new Paciente(nombre,apellido,dni,telefono,cuenta,clave,fechaAlta,numeroHistorial);
    }
}
