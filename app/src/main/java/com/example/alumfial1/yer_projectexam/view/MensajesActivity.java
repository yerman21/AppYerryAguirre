package com.example.alumfial1.yer_projectexam.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumfial1.yer_projectexam.MainActivity;
import com.example.alumfial1.yer_projectexam.R;
import com.example.alumfial1.yer_projectexam.interfaces.MensajeInterface;
import com.example.alumfial1.yer_projectexam.model.Mensajes;
import com.example.alumfial1.yer_projectexam.presentador.MensajePresentator;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MensajesActivity extends AppCompatActivity implements View.OnClickListener,MensajeInterface.View{
    private Button btn_addMensaje;
    private EditText et_titulo,et_mensaje;
    private MensajeInterface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);

        et_titulo=(EditText) findViewById(R.id.et_titulo);
        et_mensaje=(EditText)findViewById(R.id.et_mensaje);
        btn_addMensaje=(Button)findViewById(R.id.btn_addMensaje);
        btn_addMensaje.setOnClickListener(this);

        presenter=new MensajePresentator(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_addMensaje:
                presenter.addMensaje(et_titulo.getText().toString(),et_mensaje.getText().toString());
                break;
        }
    }

    @Override
    public void notificar(int codigo){
        if(codigo>0) {
            Toast.makeText(this, "Se ha enviado el mensaje", Toast.LENGTH_LONG).show();
            redirigir(MainActivity.class);
        }
    }


    public void redirigir(Class<?> claseActivity){
        Intent intent=new Intent(this,claseActivity);
        startActivity(intent);
    }
}
