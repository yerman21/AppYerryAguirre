package com.example.alumfial1.yer_projectexam.presentador;

import com.example.alumfial1.yer_projectexam.LoginActivity;
import com.example.alumfial1.yer_projectexam.interfaces.UserInterfaces;
import com.example.alumfial1.yer_projectexam.model.User;

public class UserPresenter implements UserInterfaces.Presenter {
    private UserInterfaces.View view;
    private UserInterfaces.Model model;

    public UserPresenter(LoginActivity view){
        this.view=view;
        model=new User(this);
    }

    @Override
    public void mostrarScrem() {
        view.mostrarScrem();
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>-1){
            view.notificar(codigo);
        }
    }

    @Override
    public void loguearce(String user, String clave) {
        if(!user.isEmpty() && !clave.isEmpty()){
            model.loguearce(user,clave);
        }
    }
}
