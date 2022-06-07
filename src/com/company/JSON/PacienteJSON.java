package com.company.JSON;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.text.ParseException;
import com.company.Class.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PacienteJSON implements InterfazJSON {

    @Override
    public void cargarJSON(ArrayList<Object> objList) throws IOException, ParseException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Object> leerJSON() throws IOException, org.json.simple.parser.ParseException {

        HashMap<String,Object> pacienteHashMap = new HashMap<String,Object>();

        Object objectJSON = new JSONParser().parse(new FileReader(this.getUbicacion()));
        JSONArray arrayJSON = (JSONArray) objectJSON;
        Iterator<?> i = arrayJSON.iterator();

        while (i.hasNext()) {
            JSONObject pacienteJSON = (JSONObject) i.next();
            String nombre = (String)pacienteJSON.get("nombre");
            String apellido = (String)pacienteJSON.get("apellido");
            String dni = (String)pacienteJSON.get("dni");
            String telefono = (String)pacienteJSON.get("telefono");
            String cuenta = (String)pacienteJSON.get("cuenta");
            String clave = (String)pacienteJSON.get("clave");
            String fechaAlta = (String)pacienteJSON.get("fechaAlta");
            String ultimaSesion = (String)pacienteJSON.get("ultimaSesion");
            String numeroHistorial = (String)pacienteJSON.get("numeroHistorial");

            Paciente paciente = new Paciente(nombre, apellido, dni, telefono, cuenta,
                    clave, fechaAlta, ultimaSesion, numeroHistorial);
            pacienteHashMap.put(cuenta ,paciente);
        }
        return pacienteHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Pacientes.json";
    }
}