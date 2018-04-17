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
import com.example.alumfial1.yer_projectexam.interfaces.ContactosInterface;
import com.example.alumfial1.yer_projectexam.model.Contactos;
import com.example.alumfial1.yer_projectexam.presentador.ContactoPresentator;

import java.util.HashMap;
import java.util.Map;

public class ContactosActivity extends AppCompatActivity implements View.OnClickListener,ContactosInterface.View {
    private Button btn_add;
    private EditText et_nombre,et_telefono;

    private ContactosInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        et_nombre=(EditText) findViewById(R.id.et_nombre);
        et_telefono=(EditText)findViewById(R.id.et_telefono);
        btn_add=(Button)findViewById(R.id.btn_add);

        presenter=new ContactoPresentator(this);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                presenter.addContacto(et_nombre.getText().toString(),et_telefono.getText().toString());
                break;
        }
    }

    public void redirigir(Class<?> claseActivity){
        Intent intent=new Intent(this,claseActivity);
        startActivity(intent);
    }

    @Override
    public void notificar(int codigo) {
        if (codigo>0)
            Toast.makeText(this,"Se ha guardado el Contacto",Toast.LENGTH_LONG).show();
            redirigir(MainActivity.class);
    }
}
