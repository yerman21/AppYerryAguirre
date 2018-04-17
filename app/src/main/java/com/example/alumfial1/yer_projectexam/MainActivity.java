package com.example.alumfial1.yer_projectexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.alumfial1.yer_projectexam.model.User;
import com.example.alumfial1.yer_projectexam.view.BuzonEntradaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ibtn_mensajes,ibtn_contactos,ibtn_estadistica,ibtn_cursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtn_mensajes=(ImageButton)findViewById(R.id.ibtn_mensajes);
        ibtn_contactos=(ImageButton)findViewById(R.id.ibtn_contactos);
        ibtn_estadistica=(ImageButton)findViewById(R.id.ibtn_estadistica);
        ibtn_cursos=(ImageButton)findViewById(R.id.ibtn_cursos);

        ibtn_mensajes.setOnClickListener(this);
        ibtn_contactos.setOnClickListener(this);
        ibtn_estadistica.setOnClickListener(this);
        ibtn_cursos.setOnClickListener(this);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText("Bienvenido "+ User.getUsername());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibtn_mensajes:
                navegar(BuzonEntradaActivity.class,"Mensajes");
                break;
            case R.id.ibtn_contactos:
                navegar(BuzonEntradaActivity.class,"Contactos");
                break;
            case R.id.ibtn_estadistica:
                navegar(GraficoEstadisticoActivity.class,"Encuesta");
                break;
            case R.id.ibtn_cursos:
                navegar(BuzonEntradaActivity.class,"Cursos");
                break;
        }
    }

    private void navegar(Class<?> clase,String accion){
        Intent intent = new Intent(this, clase);
        intent.putExtra("labelTitulo", accion);
        startActivity(intent);
    }
}
