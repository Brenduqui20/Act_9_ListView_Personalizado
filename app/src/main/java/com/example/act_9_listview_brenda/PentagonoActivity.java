package com.example.act_9_listview_brenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PentagonoActivity extends AppCompatActivity {

    private EditText editTextLado;
    private EditText editTextApotema;
    private TextView textViewPerimetro;
    private TextView textViewArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pentagono_activity);

        editTextLado = findViewById(R.id.editTextLado);
        editTextApotema = findViewById(R.id.editTextApotema);
        textViewPerimetro = findViewById(R.id.textViewPerimetro);
        textViewArea = findViewById(R.id.textViewArea);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button buttonRegresar = findViewById(R.id.buttonRegresar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores del lado y la apotema desde los EditText
                double lado = Double.parseDouble(editTextLado.getText().toString());
                double apotema = Double.parseDouble(editTextApotema.getText().toString());

                // Calcular el perímetro del pentágono
                double perimetro = 5 * lado;

                // Calcular el área del pentágono
                double area = (perimetro * apotema) / 2;

                // Mostrar el resultado en los TextViews
                textViewPerimetro.setText("PERÍMETRO: " + perimetro);
                textViewArea.setText("ÁREA: " + area);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a la pantalla principal
                Intent intent = new Intent(PentagonoActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual y vuelve a la anterior en la pila de actividades
            }
        });
    }
}
