package com.example.phili.prova2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class Casa extends AppCompatActivity {
    Spinner spTipo, spAreaDe, spAreaAte;
    EditText EdtMin, EdtMax;
    ToggleButton TbPart, TbProf;
    ToggleButton Q1,Q2,Q3,Q4,Q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        // SP TIPO DE VEICULO
        spTipo = findViewById(R.id.tipo);
        ArrayAdapter adaptTipoCasa = ArrayAdapter.createFromResource(this,
                R.array.TipoCasa, android.R.layout.simple_spinner_item);
        adaptTipoCasa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipo.setAdapter(adaptTipoCasa);
        // SP QUILOMETRAGENS
        spAreaDe = findViewById(R.id.de);
        ArrayAdapter adaptAreaDe = ArrayAdapter.createFromResource(this,
                R.array.AreaDe, android.R.layout.simple_spinner_item);
        adaptAreaDe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAreaDe.setAdapter(adaptAreaDe);

        spAreaAte = findViewById(R.id.ate);
        ArrayAdapter adaptAreaAte = ArrayAdapter.createFromResource(this,
                R.array.AreaAte, android.R.layout.simple_spinner_item);
        adaptAreaAte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAreaAte.setAdapter(adaptAreaAte);

        EdtMin = findViewById(R.id.pre_min);
        EdtMax = findViewById(R.id.pre_max);
        TbPart = findViewById(R.id.anuncia_partic);
        TbProf = findViewById(R.id.anuncia_profis);
        Q1 = findViewById(R.id.quarto_1);
        Q2 = findViewById(R.id.quarto_2);
        Q3 = findViewById(R.id.quarto_3);
        Q4 = findViewById(R.id.quarto_4);
        Q5 = findViewById(R.id.quarto_5);


    }

    public void filtrar(View view) {
        String txt = "Moradias com ";
        //RECUPERANDO OS FILTROS DE PREÇO
        Double P_min = null;
        if (EdtMin.getText().length() != 0){
            P_min = Double.valueOf(EdtMin.getText().toString());
        }
        Double P_max = null;
        if (EdtMax.getText().length() != 0){
            P_max = Double.valueOf(EdtMax.getText().toString());
        }

        //RECUPENRANDO O TIPO DE MORADIA
        String Tipo = spTipo.getSelectedItem().toString();
        int OpTipo = spTipo.getSelectedItemPosition();

        //RECUPERANDO A QNT DE QUARTOS
        String Quartos = "";
        if (Q1.isChecked() || Q2.isChecked() ||
                Q3.isChecked() || Q4.isChecked() ||
                Q5.isChecked() ){
            if (Q1.isChecked()){
                Quartos = Quartos + "1 ";
            }
            if (Q2.isChecked()){
                Quartos = Quartos + "2 ";
            }
            if (Q3.isChecked()){
                Quartos = Quartos + "3 ";
            }
            if (Q4.isChecked()){
                Quartos = Quartos + "4 ";
            }
            if (Q5.isChecked()){
                Quartos = Quartos + "5+ ";
            }
            Quartos = Quartos + "quartos";
        }
        else {
            Quartos = null;
        }

        //RECUPERANDO AS SELEÇÕES DE AREA
        String de = spAreaDe.getSelectedItem().toString();
        int Opde = spAreaDe.getSelectedItemPosition();

        String ate = spAreaAte.getSelectedItem().toString();
        int Opate = spAreaAte.getSelectedItemPosition();

        //RECUPERANDO O ANUNCIANTE
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


        //CRIANDO A VARIAVEL DE TEXTO
        if (P_min != null){
            txt = txt + "\nPreço mínimo R$ " + P_min;
        }
        if (P_max != null){
            txt = txt + "\nPreço máximo R$ " + P_max;
        }
        if (OpTipo != 0){
            txt = txt+ "\nSendo " + Tipo;
        }
        if (Quartos != null){
            txt = txt + "\n" + Quartos;
        }
        if (Opde != 0 && Opate != 0){
            txt = txt+ "\nÁrea de " + de + " até " + ate;
        }else if (Opde != 0){
            txt = txt+ "\nÁrea de " + de;
        }else if (Opate != 0){
            txt = txt+ "Área até " + ate;
        }
        if (Anunciante != null){
            txt = txt+ "\nAnuciante " + Anunciante;
        }

        Intent RetornaInicio = new Intent();
        if (txt == "Moradias com "){
            RetornaInicio.putExtra("result", "Todos as moradias.");
        }else{
            RetornaInicio.putExtra("result", txt);
        }
        setResult(RESULT_OK, RetornaInicio);
        finish();
    }
}
