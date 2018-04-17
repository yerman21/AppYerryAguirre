package com.example.alumfial1.yer_projectexam;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alumfial1.yer_projectexam.interfaces.EstadisticaInterface;
import com.example.alumfial1.yer_projectexam.model.Encuesta;
import com.example.alumfial1.yer_projectexam.presentador.EstadisticaPresentator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class GraficoEstadisticoActivity extends AppCompatActivity implements View.OnClickListener {
    private BarChart mChart;
    private Button btn_atras,btn_nuevo;
    private TextView tv_titulo;

    private EstadisticaInterface.Presentator presentator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_estadistico);

        Intent intent=getIntent();
        String titulo=intent.getStringExtra("labelTitulo");

        tv_titulo=(TextView)findViewById(R.id.tv_titulo);
        mChart=(BarChart) findViewById(R.id.my_barchart);
        btn_atras=(Button)findViewById(R.id.btn_atras);
        btn_nuevo=(Button)findViewById(R.id.btn_nuevo);

        btn_atras.setOnClickListener(this);
        btn_nuevo.setOnClickListener(this);
        presentator=new EstadisticaPresentator(this);

        tv_titulo.setText(titulo);
        mChart.getDescription().setEnabled(true);
        mChart.setPinchZoom(false);
        mChart.setDrawValueAboveBar(true);


        setData(10);
        mChart.setFitBars(true);
    }

    private void setData(int count){


        ArrayList<BarEntry> barEntryEclipse = new ArrayList<>(),
                            barEntryNetbeans = new ArrayList<>(),
                            barEntryMyEclipse= new ArrayList<>();


        barEntryEclipse.add(new BarEntry(0,presentator.devolverData("eclipce")));
        barEntryNetbeans.add(new BarEntry(1,presentator.devolverData("netbeans")));
        barEntryMyEclipse.add(new BarEntry(2,presentator.devolverData("myeclipce")));

        BarDataSet barDataSetEclipse=new BarDataSet(barEntryEclipse,"Eclipse"),
                 barDataSetNetbeans=new BarDataSet(barEntryNetbeans,"NetBeans"),
                 barDataSetMyEclipse=new BarDataSet(barEntryMyEclipse,"MyEclipse");

        //Dar muchos colores ->   ColorTemplate.MATERIAL_COLORS

        barDataSetEclipse.setColors(Color.RED);
        barDataSetNetbeans.setColors(Color.GREEN);
        barDataSetMyEclipse.setColors(Color.BLUE);

        BarData data= new BarData(barDataSetEclipse,barDataSetNetbeans,barDataSetMyEclipse);
        mChart.setData(data);
        mChart.invalidate();
        mChart.animateY(500);
    }
    //evento onClick
    @Override
    public void onClick(View view) {
        Intent intent2=new Intent();
        switch (view.getId()){
            case R.id.btn_atras:
                intent2=new Intent(this,MainActivity.class);
                break;
            case R.id.btn_nuevo:
                intent2=new Intent(this,EstadisticaActivity.class);
                break;
        }
        startActivity(intent2);
    }
}
