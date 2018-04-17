package com.example.alumfial1.yer_projectexam.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumfial1.yer_projectexam.CursosActivity;
import com.example.alumfial1.yer_projectexam.EstadisticaActivity;
import com.example.alumfial1.yer_projectexam.MainActivity;
import com.example.alumfial1.yer_projectexam.R;
import com.example.alumfial1.yer_projectexam.interfaces.ContactosInterface;
import com.example.alumfial1.yer_projectexam.interfaces.CursoInterface;
import com.example.alumfial1.yer_projectexam.interfaces.MensajeInterface;
import com.example.alumfial1.yer_projectexam.model.Cursos;
import com.example.alumfial1.yer_projectexam.model.Encuesta;
import com.example.alumfial1.yer_projectexam.presentador.ContactoPresentator;
import com.example.alumfial1.yer_projectexam.presentador.CursoPresentator;
import com.example.alumfial1.yer_projectexam.presentador.MensajePresentator;
import com.example.alumfial1.yer_projectexam.view.ContactosActivity;
import com.example.alumfial1.yer_projectexam.view.MensajesActivity;

import java.util.Map;

public class BuzonEntradaActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_buzon,tv_label;
    private Button btn_atras,btn_nuevo;
    private String accion="";

    private MensajeInterface.Presenter presenterMensaje;
    private ContactosInterface.Presenter presenterContacto;
    private CursoInterface.Presentator presentatorCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzon_entrada);

        tv_buzon=(TextView) findViewById(R.id.tv_buzon);
        tv_label=(TextView) findViewById(R.id.tv_label);
        btn_atras=(Button)findViewById(R.id.btn_atras);
        btn_nuevo=(Button)findViewById(R.id.btn_nuevo);

        presenterMensaje=new MensajePresentator(this);
        presenterContacto=new ContactoPresentator(this);
        presentatorCurso=new CursoPresentator(this);

        btn_atras.setOnClickListener(this);
        btn_nuevo.setOnClickListener(this);

        Intent intent=getIntent();
        accion=intent.getStringExtra("labelTitulo");
        tv_label.setText(accion);

        switch (accion){
            case "Mensajes":
                llenarBuzonMensajes();
                break;
            case "Contactos":
                llenarBuzonContactos();
                break;
            case "Cursos":
                llenarBuzonContactos();
                break;
        }
    }

    public void llenarBuzonMensajes(){
        String cadena="";
        for(Map<String,Object> mensaje_object : presenterMensaje.getLista()){
            cadena=cadena+"--------------"+mensaje_object.get("hora")+"--------------"+ Html.fromHtml("<br />")+
                    "Titulo: "+ mensaje_object.get("titulo")+ Html.fromHtml("<br />")+"Mensaje: "+ mensaje_object.get("mensaje")+Html.fromHtml("<br/>");
        }
        tv_buzon.setText(cadena);
    }

    public void llenarBuzonContactos(){
        String cadena="";
        for(Map<String,Object> object : presenterContacto.getLista()){
            cadena=cadena+"--------------X--------------"+ Html.fromHtml("<br />")+
                    "Nombre: "+ object.get("nombre")+ Html.fromHtml("<br />")+"Telefono: "+ object.get("telefono")+Html.fromHtml("<br/>");
        }
        tv_buzon.setText(cadena);
    }

    public void llenarBuzonCursos(){
        String cadena="";
        for(Map<String,Object> object : presentatorCurso.getLista()){
            cadena=cadena+"--------------X--------------"+ Html.fromHtml("<br />")+
                    "Curso: "+ object.get("curso")+ Html.fromHtml("<br />")+"Profesor: "+ object.get("profesor")+Html.fromHtml("<br/>");
        }
        tv_buzon.setText(cadena);
    }

    public void redirigir(Class<?> clase){
        Intent intent=new Intent();
        if(clase==null){
            switch (accion){
                case "Mensajes":
                    intent=new Intent(this,MensajesActivity.class);
                    break;
                case "Contactos":
                    intent=new Intent(this,ContactosActivity.class);
                    break;
                case "Cursos":
                    intent=new Intent(this,CursosActivity.class);
                    break;
            }
        }else{
            intent=new Intent(this,clase);
        }
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_atras:
                redirigir(MainActivity.class);
                break;
            case R.id.btn_nuevo:
                redirigir(null);
                break;
        }
    }

}
