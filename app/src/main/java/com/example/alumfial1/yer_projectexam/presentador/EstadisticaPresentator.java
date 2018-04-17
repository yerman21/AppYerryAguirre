package com.example.alumfial1.yer_projectexam.presentador;

import com.example.alumfial1.yer_projectexam.EstadisticaActivity;
import com.example.alumfial1.yer_projectexam.GraficoEstadisticoActivity;
import com.example.alumfial1.yer_projectexam.interfaces.EstadisticaInterface;
import com.example.alumfial1.yer_projectexam.model.Encuesta;

public class EstadisticaPresentator implements EstadisticaInterface.Presentator {
    private EstadisticaInterface.View view;
    private GraficoEstadisticoActivity view2;

    private EstadisticaInterface.Model model;

    public EstadisticaPresentator(EstadisticaActivity view){
        this.view=view;
        model=new Encuesta(this);
    }

    public EstadisticaPresentator(GraficoEstadisticoActivity view){
        this.view2=view;
        model=new Encuesta(this);
    }

    @Override
    public void notificar(int codigo) {
        view.notificar(codigo);
    }

    @Override
    public void aumentarData(String ide) {
        if(!ide.isEmpty())
        model.aumentarData(ide);
    }

    @Override
    public int devolverData(String ide) {
        return model.devolverData(ide);
    }
}
