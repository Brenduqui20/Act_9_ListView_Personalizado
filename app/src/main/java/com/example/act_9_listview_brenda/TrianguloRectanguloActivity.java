package com.example.act_9_listview_brenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrianguloRectanguloActivity extends AppCompatActivity {

    private EditText editTextCatetoA;
    private EditText editTextCatetoB;
    private TextView textViewPerimetro;
    private TextView textViewArea;
    private Button buttonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangulorectangulo_activity);

        editTextCatetoA = findViewById(R.id.editTextCatetoA);
        editTextCatetoB = findViewById(R.id.editTextCatetoB);
        textViewPerimetro = findViewById(R.id.textViewPerimetro);
        textViewArea = findViewById(R.id.textViewArea);
        buttonRegresar = findViewById(R.id.buttonRegresar);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los catetos desde los EditText
                double catetoA = Double.parseDouble(editTextCatetoA.getText().toString());
                double catetoB = Double.parseDouble(editTextCatetoB.getText().toString());

                // Calcular el perímetro del triángulo rectángulo
                double perimetro = catetoA + catetoB + Math.sqrt(catetoA * catetoA + catetoB * catetoB);

                // Calcular el área del triángulo rectángulo
                double area = 0.5 * catetoA * catetoB;

                // Mostrar el resultado en los TextViews
                textViewPerimetro.setText("PERÍMETRO: " + perimetro);
                textViewArea.setText("ÁREA: " + area);
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a la pantalla principal
                finish(); // Cierra la actividad actual y vuelve a la anterior en la pila de actividades
            }
        });
    }
}
