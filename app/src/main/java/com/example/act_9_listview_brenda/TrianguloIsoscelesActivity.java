package com.example.act_9_listview_brenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class TrianguloIsoscelesActivity extends AppCompatActivity {
    private EditText editTextBase;
    private EditText editTextAltura;
    private TextView textViewPerimetro;
    private TextView textViewArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trianguloisosceles_activity);

        editTextBase = findViewById(R.id.editTextBase);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewPerimetro = findViewById(R.id.textViewPerimetro);
        textViewArea = findViewById(R.id.textViewArea);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button buttonRegresar = findViewById(R.id.buttonRegresar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de la base y la altura desde los EditText
                double base = Double.parseDouble(editTextBase.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());
                // Calcular el perímetro del triángulo isósceles (suma de todos los lados)
                double perimetro = 2 * base + altura;
                // Calcular el área del triángulo isósceles
                double area = (base * altura) / 2;
                // Mostrar el resultado en los TextViews
                textViewPerimetro.setText("PERÍMETRO: " + perimetro);
                textViewArea.setText("ÁREA: " + area);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrianguloIsoscelesActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra la actividad actual y vuelve a la anterior en la pila de actividades
            }
        });
    }
}
