package com.company.JSON;

import com.company.Class.Enfermedad;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EnfermedadJSON implements InterfazJSON <Enfermedad>{

    @Override
    public void cargarJSON(ArrayList<Enfermedad> objList) throws IOException, ParseException {
        File file = new File(this.getUbicacion());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, objList);
    }

    @Override
    public HashMap<String, Enfermedad> leerJSON() throws IOException, org.json.simple.parser.ParseException {

        HashMap<String,Enfermedad> enfermedadHashMap = new HashMap<String,Enfermedad>();

        Object objectJSON = new JSONParser().parse(new FileReader(this.getUbicacion()));
        JSONArray arrayJSON = (JSONArray) objectJSON;
        Iterator<?> i = arrayJSON.iterator();

        while (i.hasNext()) {

            ArrayList<String> tareaDeControlLista = null;
            JSONObject enfermedadJSON = (JSONObject) i.next();

            String nombre = (String)enfermedadJSON.get("nombre");
            String descripcion = (String)enfermedadJSON.get("descripcion");
            long duracionDias = (long) enfermedadJSON.get("duracionDias");

            JSONArray enfermedadArrayJSON = (JSONArray) enfermedadJSON.get("pacienteLista");
            if(enfermedadArrayJSON != null){
                Iterator<?> p = enfermedadArrayJSON.iterator();
                boolean flag = false;
                while (p.hasNext()) {
                    if(!flag){
                        tareaDeControlLista = new ArrayList<String>();
                        flag = true;
                    }
                    tareaDeControlLista.add(p.next().toString());
                }
            }
            Enfermedad enfermedad = new Enfermedad(nombre,tareaDeControlLista,descripcion,(int)duracionDias);
            enfermedadHashMap.put(nombre,enfermedad);
        }
        return enfermedadHashMap;
    }

    @Override
    public String getUbicacion() {
        return "Enfermedad.json";
    }
}