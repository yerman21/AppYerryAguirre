package com.example.alumfial1.yer_projectexam.interfaces;

public interface UserInterfaces {
    interface View{
        void mostrarScrem();
        void notificar(int codigo);
    }
    interface Presenter{
        void mostrarScrem();
        void notificar(int codigo);
        void loguearce(String user,String clave);
    }
    interface Model{
        void loguearce(String user,String clave);
    }
}
