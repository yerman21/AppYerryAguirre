package com.example.alumfial1.yer_projectexam.presentador;

import com.example.alumfial1.yer_projectexam.CursosActivity;
import com.example.alumfial1.yer_projectexam.interfaces.CursoInterface;
import com.example.alumfial1.yer_projectexam.model.Cursos;
import com.example.alumfial1.yer_projectexam.view.BuzonEntradaActivity;

import java.util.ArrayList;
import java.util.Map;

public class CursoPresentator implements CursoInterface.Presentator {
    private CursoInterface.View view;
    private BuzonEntradaActivity view2;

    private CursoInterface.Model model;

    public CursoPresentator(CursosActivity view){
        this.view=view;
        model=new Cursos(this);
    }

    public CursoPresentator(BuzonEntradaActivity view){
        this.view2=view;
        model=new Cursos(this);
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>-1)
        view.notificar(codigo);
    }

    @Override
    public void addCurso(String titulo, String profesor) {
        if(!titulo.isEmpty() && !profesor.isEmpty())
        model.addCurso(titulo, profesor);
    }

    @Override
    public ArrayList<Map<String, Object>> getLista() {
        return model.getLista();
    }
}
