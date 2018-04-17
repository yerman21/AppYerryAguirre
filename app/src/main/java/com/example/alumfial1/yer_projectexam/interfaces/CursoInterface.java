package com.example.alumfial1.yer_projectexam.interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface CursoInterface {
    interface View{
        void notificar(int codigo);
    }
    interface Presentator{
        void notificar(int codigo);
        void addCurso(String titulo,String profesor);
        ArrayList<Map<String, Object>> getLista();
    }
    interface Model{
        void addCurso(String titulo,String profesor);
        ArrayList<Map<String, Object>> getLista();
    }
}
