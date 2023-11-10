package com.example.act_9_listview_brenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrianguloEscalenoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trianguloescaleno_activity);

        final EditText editTextLadoA = findViewById(R.id.editTextLadoA);
        final EditText editTextLadoB = findViewById(R.id.editTextLadoB);
        final EditText editTextLadoC = findViewById(R.id.editTextLadoC);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        final TextView textViewPerimetro = findViewById(R.id.textViewPerimetro);
        final TextView textViewArea = findViewById(R.id.textViewArea);
        Button buttonRegresar = findViewById(R.id.buttonRegresar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los lados
                double ladoA = Double.parseDouble(editTextLadoA.getText().toString());
                double ladoB = Double.parseDouble(editTextLadoB.getText().toString());
                double ladoC = Double.parseDouble(editTextLadoC.getText().toString());

                // Calcular perímetro y área (aquí debes implementar las fórmulas correspondientes)
                // Supongamos que las fórmulas para perímetro y área son las siguientes (puedes cambiarlas según tus necesidades):
                double perimetro = ladoA + ladoB + ladoC;
                double area = (ladoA * ladoB) / 2;

                // Mostrar resultados en los TextViews
                textViewPerimetro.setText("Perímetro: " + perimetro);
                textViewArea.setText("Área: " + area);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Regresar a la pantalla principal
                Intent intent = new Intent(TrianguloEscalenoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
