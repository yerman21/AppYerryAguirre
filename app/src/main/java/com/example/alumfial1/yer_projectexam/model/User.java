package com.example.alumfial1.yer_projectexam.model;

import com.example.alumfial1.yer_projectexam.interfaces.UserInterfaces;

public class User implements UserInterfaces.Model{
    private static String username;
    private int contador=0;
    private UserInterfaces.Presenter presenter;

    public User(UserInterfaces.Presenter presenter){
        this.presenter=presenter;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
    public static String getUsername(){
       return User.username;
   }

   @Override
    public void loguearce(String user, String clave) {
       if(user.equals("yerman1") && clave.equals("123")){
           contador=0;

           setUsername(user);
           presenter.mostrarScrem();
       }else {
           contador = contador + 1;
           if(contador>=3){
               int codigo=contador;
               contador=0;
               presenter.notificar(codigo);
           }else {
               presenter.notificar(contador);
           }
       }
    }
}
