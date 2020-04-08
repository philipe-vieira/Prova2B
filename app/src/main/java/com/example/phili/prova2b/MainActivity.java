package com.example.phili.prova2b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup categoria;
    RadioButton veiculo;
    RadioButton casa;
    RadioButton geral;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoria = (RadioGroup) findViewById(R.id.categoria);
        veiculo = findViewById(R.id.veiculo);
        casa = findViewById(R.id.casa);
        geral = findViewById(R.id.geral);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itens, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void filtrar(View view) {
        if (veiculo.isChecked()){
            Intent FiltroVeiculo = new Intent(this, Veiculo.class);
            startActivityForResult(FiltroVeiculo, 100);
        } else if (casa.isChecked()){
            Intent FiltroCasa = new Intent(this, Casa.class);
            startActivityForResult(FiltroCasa, 100);
        }else if (geral.isChecked()){
            Intent FiltroGeral = new Intent(this, Geral.class);
            startActivityForResult(FiltroGeral, 100);
        }else {
            Toast.makeText(this, "Nenhuma Opção Selecionada. " , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100){
            if (resultCode == RESULT_OK){
                String pacote = data.getStringExtra("result");

                resultado = findViewById(R.id.resultado);
                resultado.setText(pacote);
            } else {
                Toast.makeText(this, "Filtro finalizado sem sucesso. Try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
