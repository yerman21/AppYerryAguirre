package com.example.alumfial1.yer_projectexam.model;

import com.example.alumfial1.yer_projectexam.interfaces.EstadisticaInterface;

public class Encuesta implements EstadisticaInterface.Model{
    private static int eclipse=0;
    private static int netbeans=0;
    private static int myeclipse=0;

    private EstadisticaInterface.Presentator presentator;

    public  Encuesta(EstadisticaInterface.Presentator presentator){
        this.presentator=presentator;
    }

    public int getEclipse() {
        return this.eclipse;
    }

    public void setEclipse() {
        this.eclipse = this.eclipse+1;
    }

    public int getNetbeans() {
        return netbeans;
    }

    public void setNetbeans() {
        this.netbeans = this.netbeans+1;
    }

    public int getMyeclipse() {
        return myeclipse;
    }

    public void setMyeclipse() {
        this.myeclipse = this.myeclipse+1;
    }

    @Override
    public void aumentarData(String ide) {
        switch (ide){
            case "eclipce":
                setEclipse();
                break;
            case "netbeans":
                setNetbeans();
                break;
            case "myeclipce":
                setMyeclipse();
                break;
        }
        presentator.notificar(1);
    }

    @Override
    public int devolverData(String ide) {
        int dato=0;
        switch (ide){
            case "eclipce":
                dato=getEclipse();
                break;
            case "netbeans":
                dato=getNetbeans();
                break;
            case "myeclipce":
                dato=getMyeclipse();
                break;
        }
        return dato;
    }
}
