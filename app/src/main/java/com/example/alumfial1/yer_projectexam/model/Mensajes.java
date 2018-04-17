package com.example.alumfial1.yer_projectexam.model;

import com.example.alumfial1.yer_projectexam.interfaces.MensajeInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alum.fial1 on 4/04/2018.
 */

public class Mensajes implements MensajeInterface.Model {
    private static ArrayList<Map<String,Object>> mensajes=new ArrayList<Map<String,Object>>();
    private MensajeInterface.Presenter presenter;

    public Mensajes(MensajeInterface.Presenter presenter){
        this.presenter=presenter;
    }

    @Override
    public void addMensaje(String titulo,String mensaje) {
            int antesCount=mensajes.size();

            Map<String,Object> mensaje_nuevo=new HashMap<>();
            mensaje_nuevo.put("hora", Calendar.HOUR_OF_DAY+":"+Calendar.MINUTE+":"+Calendar.SECOND);
            mensaje_nuevo.put("titulo",titulo);
            mensaje_nuevo.put("mensaje",mensaje);
            mensajes.add(mensaje_nuevo);

            presenter.notificar(mensajes.size()-antesCount);
    }

    @Override
    public ArrayList<Map<String, Object>> getLista() {
        return mensajes;
    }
}
