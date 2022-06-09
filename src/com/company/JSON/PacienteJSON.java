package com.company.JSON;

import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.company.Class.Administrador;
import com.company.Class.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PacienteJSON implements InterfazJSON <Paciente> {

    @Override
    public void cargarJSON(ArrayList<Paciente> objList) throws IOException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Paciente> leerJSON() throws IOException {
        HashMap<String,Paciente> pacienteHashMap = new HashMap<String,Paciente>();
		File file = new File(this.getUbicacion());
		ObjectMapper mapper = new ObjectMapper();		
		List<Paciente> pacienteList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Paciente.class));		
        for (Paciente p : pacienteList) {
        	pacienteHashMap.put(p.getCuenta(), p);
        }	
        return pacienteHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Pacientes.json";
    }
}
