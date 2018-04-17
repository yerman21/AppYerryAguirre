package com.example.alumfial1.yer_projectexam.model;

import com.example.alumfial1.yer_projectexam.interfaces.ContactosInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contactos implements ContactosInterface.Model{
    private static ArrayList<Map<String,Object>> contactos=new ArrayList<Map<String,Object>>();
    private ContactosInterface.Presenter presenter;

    public  Contactos(ContactosInterface.Presenter presenter){
        this.presenter=presenter;
    }

    @Override
    public  ArrayList<Map<String,Object>> getLista(){
        return contactos;
    }

    @Override
    public void addContacto(String nombre, String telefono) {
        int antesCount=contactos.size();
        Map<String,Object> nuevo=new HashMap<>();
        nuevo.put("nombre",nombre);
        nuevo.put("telefono",telefono);
        contactos.add(nuevo);
        presenter.notificar(contactos.size()-antesCount);
    }
}
