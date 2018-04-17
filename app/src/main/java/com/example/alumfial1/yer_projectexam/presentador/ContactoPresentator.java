package com.example.alumfial1.yer_projectexam.presentador;

import com.example.alumfial1.yer_projectexam.view.BuzonEntradaActivity;
import com.example.alumfial1.yer_projectexam.view.ContactosActivity;
import com.example.alumfial1.yer_projectexam.interfaces.ContactosInterface;
import com.example.alumfial1.yer_projectexam.model.Contactos;

import java.util.ArrayList;
import java.util.Map;

public class ContactoPresentator implements ContactosInterface.Presenter{
    private ContactosInterface.View view;
    private BuzonEntradaActivity view2;
    private ContactosInterface.Model model;

    public ContactoPresentator(ContactosActivity view){
        this.view=view;
        model=new Contactos(this);
    }

    public ContactoPresentator(BuzonEntradaActivity view){
        this.view2=view;
        model=new Contactos(this);
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>-1)
            view.notificar(codigo);
    }

    @Override
    public void addContacto(String nombre, String telefono) {
        if(!nombre.isEmpty() && !telefono.isEmpty())
            model.addContacto(nombre, telefono);
    }

    @Override
    public ArrayList<Map<String, Object>> getLista() {
        return model.getLista();
    }
}
