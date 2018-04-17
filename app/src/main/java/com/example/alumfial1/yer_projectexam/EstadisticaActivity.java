package com.example.alumfial1.yer_projectexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.alumfial1.yer_projectexam.interfaces.EstadisticaInterface;
import com.example.alumfial1.yer_projectexam.model.Encuesta;
import com.example.alumfial1.yer_projectexam.presentador.EstadisticaPresentator;

public class EstadisticaActivity extends AppCompatActivity implements View.OnClickListener,EstadisticaInterface.View {
    private Button btn_add;
    private RadioGroup rgroup_grupo1;

    private EstadisticaInterface.Presentator presentator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        btn_add=(Button)findViewById(R.id.btn_add);
        rgroup_grupo1=(RadioGroup)findViewById(R.id.rgroup_grupo1);

        btn_add.setOnClickListener(this);
        presentator=new EstadisticaPresentator(this);
    }

    @Override
    public void onClick(View view) {
        int selectedId = rgroup_grupo1.getCheckedRadioButtonId();
        guardarOpcion(selectedId);
    }

    public void guardarOpcion(int idd){
        //boolean checked=((RadioButton)view).isChecked();
        switch (idd){
            case R.id.rb_opcion1:
          //      if (checked)
                presentator.aumentarData("netbeans");
                break;
            case R.id.rb_opcion2:
            //    if (checked)
                presentator.aumentarData("myeclipce");
                break;
            case R.id.rb_opcion3:
             //   if (checked)
                presentator.aumentarData("eclipce");
                break;
        }
    }

    public void redirigir(Class<?> claseActivity){
        Intent intent=new Intent(this,claseActivity);
        startActivity(intent);
    }

    @Override
    public void notificar(int codigo) {
        if(codigo>0)
        Toast.makeText(this,"Opcion agregada",Toast.LENGTH_LONG).show();
        redirigir(MainActivity.class);
    }
}
