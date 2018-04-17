package com.example.alumfial1.yer_projectexam.interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface MensajeInterface {
    interface View{
        void notificar(int codigo);
    }
    interface Presenter{
        void notificar(int codigo);
        void addMensaje(String titulo,String mensaje);
        ArrayList<Map<String, Object>> getLista();
    }
    interface Model{
        void addMensaje(String titulo,String mensaje);
        ArrayList<Map<String, Object>> getLista();
    }
}
