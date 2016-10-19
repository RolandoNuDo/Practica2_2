package com.rolando.practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText capital;
    EditText periodo;
    TextView resultado;
    Button calcular;
    EditText tasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcular = (Button) findViewById(R.id.btnCalcular);
        capital = (EditText) findViewById(R.id.capital);
        periodo = (EditText) findViewById(R.id.periodos);
        resultado = (TextView) findViewById(R.id.mostrarRes);
        tasa = (EditText) findViewById(R.id.tasa);
        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.btnCalcular:
            String strgCapital = capital.getText().toString().trim();
            String strgPeriodo = periodo.getText().toString().trim();
            String strgTasa = tasa.getText().toString().trim();
            if(!strgCapital.isEmpty() && !strgPeriodo.isEmpty() && !strgTasa.isEmpty()){
            double numCapital = Double.parseDouble(strgCapital);
            double numPeriodo = Double.parseDouble(strgPeriodo);
            double numTasa = Double.parseDouble(strgTasa);
            double monto, total;
            monto = numCapital * Math.pow((1d + numTasa/100d),numPeriodo);
            resultado.setText("Total $"+  String.format("%8.2f",monto)+"\nAgregado al capital $"+String.format("%8.2f",(monto-numCapital)));
            resultado.setVisibility(View.VISIBLE);

            }else {
                resultado.setText("Rellena Los Campos Faltantes");
                resultado.setVisibility(View.VISIBLE);
            }
    }
    }
}
