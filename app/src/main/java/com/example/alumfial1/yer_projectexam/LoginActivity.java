package com.example.alumfial1.yer_projectexam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumfial1.yer_projectexam.interfaces.UserInterfaces;
import com.example.alumfial1.yer_projectexam.model.User;
import com.example.alumfial1.yer_projectexam.presentador.UserPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,UserInterfaces.View {
    private EditText et_usu,et_pass;
    private Button btn_login;
    private int contador=0;
    private UserInterfaces.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usu=(EditText)findViewById(R.id.et_usu);
        et_pass=(EditText)findViewById(R.id.et_pass);
        btn_login=(Button)findViewById(R.id.btn_login);

        presenter=new UserPresenter(this);
        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                presenter.loguearce(et_usu.getText().toString(),et_pass.getText().toString());
                break;
        }
    }

    private void limpiarCasillas(){
        et_usu.setText("");
        et_pass.setText("");
    }

    private void cerrarApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                finish();
            }
        }, 5000);
    }

    @Override
    public void mostrarScrem() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>=3){
            limpiarCasillas();
            Toast.makeText(this,"Se ha equivocada 3 veces. La App se cerrara",Toast.LENGTH_SHORT).show();
            cerrarApp();
        }else {
            limpiarCasillas();
            Toast.makeText(this,"Usuario y/o password incorrectos",Toast.LENGTH_SHORT).show();
        }

    }
}
