package com.example.alumfial1.yer_projectexam.presentador;

import com.example.alumfial1.yer_projectexam.view.BuzonEntradaActivity;
import com.example.alumfial1.yer_projectexam.interfaces.MensajeInterface;
import com.example.alumfial1.yer_projectexam.model.Mensajes;
import com.example.alumfial1.yer_projectexam.view.MensajesActivity;

import java.util.ArrayList;
import java.util.Map;

public class MensajePresentator implements MensajeInterface.Presenter{
    private MensajeInterface.View view;
    private BuzonEntradaActivity view2;

    private MensajeInterface.Model model;

    public MensajePresentator(MensajesActivity view){
        this.view=view;
        model=new Mensajes(this);
    }

    public MensajePresentator(BuzonEntradaActivity view){
        this.view2=view;
        model=new Mensajes(this);
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>0)
            view.notificar(codigo);
    }

    @Override
    public void addMensaje(String titulo,String mensaje) {
        if(!titulo.isEmpty() && !mensaje.isEmpty()){
            model.addMensaje(titulo,mensaje);
        }
    }

    @Override
    public ArrayList<Map<String, Object>> getLista() {
        return model.getLista();
    }
}
