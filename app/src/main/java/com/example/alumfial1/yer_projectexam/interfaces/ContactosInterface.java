package com.example.alumfial1.yer_projectexam.interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface ContactosInterface {
    interface View{
        void notificar(int codigo);
    }
    interface Presenter{
        void notificar(int codigo);
        void addContacto(String nombre,String telefono);
        ArrayList<Map<String, Object>> getLista();
    }
    interface Model{
        void addContacto(String nombre,String telefono);
        ArrayList<Map<String, Object>> getLista();
    }
}
