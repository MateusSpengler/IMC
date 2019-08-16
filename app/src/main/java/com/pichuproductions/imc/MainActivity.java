package com.pichuproductions.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Índice de massa corporal (IMC)");

        Button botao = (Button) findViewById(R.id.btn_calcular);

        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText peso = findViewById(R.id.text_peso);
                EditText altura = findViewById(R.id.text_altura);

                String txt_peso = peso.getText().toString();
                String txt_altura = altura.getText().toString();

                Double p1 = Double.parseDouble(txt_peso);
                Double a1 = Double.parseDouble(txt_altura);

                Double calculo = p1/(a1*a1);

                if (calculo < 18.5){

                    String resultadoFinal = String.valueOf(calculo);

                    TextView resultado = (TextView) findViewById(R.id.resultado);

                    resultado.setText(resultadoFinal+" \n\n |Abaixo do peso|");

                }

                if (calculo >= 18.6 && calculo <=24.9){

                    String resultadoFinal = String.valueOf(calculo);

                    TextView resultado = (TextView) findViewById(R.id.resultado);

                    resultado.setText(resultadoFinal+" \n\n |Peso ideal|");

                }

                if (calculo > 25){

                    String resultadoFinal = String.valueOf(calculo);

                    TextView resultado = (TextView) findViewById(R.id.resultado);

                    resultado.setText(resultadoFinal+" \n\n |Acima do peso|");

                }

            }
        });

    }

    public void openActivity(View view) {

        Intent intent = new Intent(this,CreditosActivity.class);
        startActivity(intent);

    }

}
