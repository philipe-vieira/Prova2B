package com.example.phili.prova2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ToggleButton;

public class Geral extends AppCompatActivity {
    EditText EdtMin;
    EditText EdtMax;
    ToggleButton TbPart;
    ToggleButton TbProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral);

        EdtMin = findViewById(R.id.pre_min);
        EdtMax = findViewById(R.id.pre_max);
        TbPart = findViewById(R.id.anuncia_partic);
        TbProf = findViewById(R.id.anuncia_profis);
    }

    public void filtrar(View view) {
        String txt = "Produtos em Geral: ";
        Double P_min = null;
        if (EdtMin.getText().length() != 0){
            P_min = Double.valueOf(EdtMin.getText().toString());
        }
        Double P_max = null;
        if (EdtMax.getText().length() != 0){
            P_max = Double.valueOf(EdtMax.getText().toString());
        }

        String Anunciante;
        if (TbPart.isChecked() && TbProf.isChecked()){
            Anunciante = "Particular e Profissional";
        } else if (TbPart.isChecked() && TbProf.isChecked() == false){
            Anunciante = "Particular";
        } else if (TbPart.isChecked() == false && TbProf.isChecked()){
            Anunciante = "Profissional";
        } else {
            Anunciante = null;
        }

        if (P_min != null){
            txt = txt + "\nPreço mínimo R$ " + P_min;
        }
        if (P_max != null){
            txt = txt + "\nPreço máximo R$ " + P_max;
        }
        if (Anunciante != null){
            txt = txt+ "\nAnuciante " + Anunciante;
        }

        Intent RetornaInicio = new Intent();
        if (txt == "Produtos em Geral: "){
            RetornaInicio.putExtra("result", "Todos os produtos. \nFiltro não solicitado");
        }else{
            RetornaInicio.putExtra("result", txt);
        }
        setResult(RESULT_OK, RetornaInicio);
        finish();
    }
}
