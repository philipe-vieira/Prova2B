package com.example.phili.prova2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Veiculo extends AppCompatActivity {
    Spinner spMarca;
    Spinner spCombustivel;
    Spinner spTipoVeiculo;
    Spinner spQuilometragemDe;
    Spinner spQuilometragemAte;
    EditText EdtMin;
    EditText EdtMax;
    ToggleButton TbAuto, TbMan;
    ToggleButton TbPart;
    ToggleButton TbProf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        // SP MARCA
        spMarca = (Spinner) findViewById(R.id.marca);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Marca, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spMarca.setAdapter(adapter);

        // SP COMBUSTIVEL
        spCombustivel = findViewById(R.id.combustivel);
        ArrayAdapter adaptCombustivel = ArrayAdapter.createFromResource(this,
                R.array.Combustivel, android.R.layout.simple_spinner_item);
        adaptCombustivel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCombustivel.setAdapter(adaptCombustivel);

        // SP TIPO DE VEICULO
        spTipoVeiculo = findViewById(R.id.tipo_veiculo);
        ArrayAdapter adaptTipoVeiculo = ArrayAdapter.createFromResource(this,
                R.array.TipoVeiculo, android.R.layout.simple_spinner_item);
        adaptTipoVeiculo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoVeiculo.setAdapter(adaptTipoVeiculo);
        // SP QUILOMETRAGENS
        spQuilometragemDe = findViewById(R.id.de);
        ArrayAdapter adaptQuilometragemDe = ArrayAdapter.createFromResource(this,
                R.array.QuilometragemDe, android.R.layout.simple_spinner_item);
        adaptQuilometragemDe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuilometragemDe.setAdapter(adaptQuilometragemDe);

        spQuilometragemAte = findViewById(R.id.ate);
        ArrayAdapter adaptQuilometragemAte = ArrayAdapter.createFromResource(this,
                R.array.QuilometragemAte, android.R.layout.simple_spinner_item);
        adaptQuilometragemAte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuilometragemAte.setAdapter(adaptQuilometragemAte);


        EdtMin = findViewById(R.id.pre_min);
        EdtMax = findViewById(R.id.pre_max);
        TbAuto = findViewById(R.id.camb_auto);
        TbMan = findViewById(R.id.camb_man);
        TbPart = findViewById(R.id.anuncia_partic);
        TbProf = findViewById(R.id.anuncia_profis);

    }

    public void filtrar(View view) {
        String txt = "Veiculos com ";
        Double P_min = null;
        if (EdtMin.getText().length() != 0){
            P_min = Double.valueOf(EdtMin.getText().toString());
        }
        Double P_max = null;
        if (EdtMax.getText().length() != 0){
            P_max = Double.valueOf(EdtMax.getText().toString());
        }


        String Marca = spMarca.getSelectedItem().toString();
        int OpMarca = spMarca.getSelectedItemPosition();

        String Cambio;
        if (TbAuto.isChecked() && TbMan.isChecked()){
            Cambio = "Automático e Manual";
        } else if (TbAuto.isChecked() && TbMan.isChecked() == false){
            Cambio = "Automático";
        } else if (TbAuto.isChecked() == false && TbMan.isChecked()){
            Cambio = "Manual";
        } else {
            Cambio = null;
        }

        String Combustivel = spCombustivel.getSelectedItem().toString();
        int OpCombustivel = spCombustivel.getSelectedItemPosition();

        String Tipo = spTipoVeiculo.getSelectedItem().toString();
        int OpTipo = spTipoVeiculo.getSelectedItemPosition();

        String de = spQuilometragemDe.getSelectedItem().toString();
        int Opde = spQuilometragemDe.getSelectedItemPosition();

        String ate = spQuilometragemAte.getSelectedItem().toString();
        int Opate = spQuilometragemAte.getSelectedItemPosition();

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
        if (OpMarca != 0){
            txt = txt + "\nMarca " + Marca;
        }
        if (Cambio != null){
            txt = txt+ "\nCambio " + Cambio;
        }
        if (OpCombustivel != 0){
            txt = txt+ "\nCombustivel " + Combustivel;
        }
        if (OpTipo != 0){
            txt = txt+ "\nSendo " + Tipo;
        }
        if (Opde != 0 && Opate != 0){
            txt = txt+ "\n Quilometragem de " + de + " até " + ate;
        }else if (Opde != 0){
            txt = txt+ "\n Quilometragem de " + de;
        }else if (Opate != 0){
            txt = txt+ "Quilometragem até " + ate;
        }
        if (Anunciante != null){
            txt = txt+ "\nAnuciante " + Anunciante;
        }

        Intent RetornaInicio = new Intent();
        if (txt == "Veiculos com "){
            RetornaInicio.putExtra("result", "Todos os veiculos.");
        }else{
            RetornaInicio.putExtra("result", txt);
        }
        setResult(RESULT_OK, RetornaInicio);
        finish();

    }
}
