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
import com.company.Class.Profesional;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProfesionalJSON implements InterfazJSON {

    @Override
    public void cargarJSON(ArrayList<Object> objList) throws IOException, ParseException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Object> leerJSON() throws IOException, org.json.simple.parser.ParseException {

        HashMap<String,Object> profesionalHashMap = new HashMap<String,Object>();

        Object objectJSON = new JSONParser().parse(new FileReader(this.getUbicacion()));
        JSONArray arrayJSON = (JSONArray) objectJSON;
        Iterator i = arrayJSON.iterator();

        while (i.hasNext()) {

            ArrayList<String> pacienteLista = null;
            JSONObject profesionalJSON = (JSONObject) i.next();
            String nombre = (String) profesionalJSON.get("nombre");
            String apellido = (String) profesionalJSON.get("apellido");
            String dni = (String) profesionalJSON.get("dni");
            String telefono = (String) profesionalJSON.get("telefono");
            String cuenta = (String) profesionalJSON.get("cuenta");
            String clave = (String) profesionalJSON.get("clave");
            String fechaAlta = (String) profesionalJSON.get("fechaAlta");
            String ultimaSesion = (String) profesionalJSON.get("ultimaSesion");


            JSONArray pacienteArrayJSON = (JSONArray) profesionalJSON.get("pacienteLista");

            if(pacienteArrayJSON != null){
                Iterator p = pacienteArrayJSON.iterator();
                boolean flag = false;
                while (p.hasNext()) {
                    if(!flag){
                        pacienteLista = new ArrayList<String>();
                        flag = true;
                    }
                    pacienteLista.add(p.next().toString());
                }

            }

            Profesional profesional = new Profesional(nombre, apellido, dni, telefono, cuenta,
                                                    clave, fechaAlta, ultimaSesion, pacienteLista);
            profesionalHashMap.put(cuenta, profesional);
        }
        return profesionalHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Profesional.json";
    }
}