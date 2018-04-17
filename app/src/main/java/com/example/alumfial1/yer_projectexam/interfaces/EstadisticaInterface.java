package com.example.alumfial1.yer_projectexam.interfaces;

import com.example.alumfial1.yer_projectexam.model.Encuesta;

import java.util.ArrayList;
import java.util.Map;

public interface EstadisticaInterface {
    interface View{
        void notificar(int codigo);
    }
    interface Presentator{
        void notificar(int codigo);
        void aumentarData(String ide);
        int devolverData(String ide);
    }
    interface Model{
        void aumentarData(String ide);
        int devolverData(String ide);
    }
}
