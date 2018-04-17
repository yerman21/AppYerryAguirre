package com.example.alumfial1.yer_projectexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumfial1.yer_projectexam.interfaces.ContactosInterface;
import com.example.alumfial1.yer_projectexam.interfaces.CursoInterface;
import com.example.alumfial1.yer_projectexam.presentador.ContactoPresentator;
import com.example.alumfial1.yer_projectexam.presentador.CursoPresentator;

public class CursosActivity extends AppCompatActivity implements View.OnClickListener,CursoInterface.View {
    private Button btn_add;
    private EditText et_curso,et_profesor;
    private CursoInterface.Presentator presentator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        et_curso=(EditText) findViewById(R.id.et_curso);
        et_profesor=(EditText)findViewById(R.id.et_profesor);
        btn_add=(Button)findViewById(R.id.btn_add);

        btn_add.setOnClickListener(this);
        presentator=new CursoPresentator(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_addMensaje:
                presentator.addCurso(et_curso.getText().toString(),et_profesor.getText().toString());
                break;
        }
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>0) {
            Toast.makeText(this, "Se ha registrado el curso", Toast.LENGTH_LONG).show();
            redirigir(MainActivity.class);
        }
    }

    public void redirigir(Class<?> claseActivity){
        Intent intent=new Intent(this,claseActivity);
        startActivity(intent);
    }
}
