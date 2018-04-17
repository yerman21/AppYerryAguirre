package com.example.alumfial1.yer_projectexam.model;

import com.example.alumfial1.yer_projectexam.interfaces.CursoInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Cursos implements CursoInterface.Model{
    private static ArrayList<Map<String,Object>> cursos=new ArrayList<Map<String,Object>>();
    private CursoInterface.Presentator presentator;

    public Cursos(CursoInterface.Presentator presentator){
        this.presentator=presentator;
    }

    @Override
    public void addCurso(String titulo, String profesor) {
        int antesCount=cursos.size();

        Map<String,Object> nuevo=new HashMap<>();
        nuevo.put("curso",titulo);
        nuevo.put("profesor",profesor);
        cursos.add(nuevo);

        presentator.notificar(cursos.size()-antesCount);
    }
    @Override
    public  ArrayList<Map<String, Object>> getLista() {
        return cursos;
    }
}
