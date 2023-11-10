package com.example.act_9_listview_brenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] Figuras = {"Triángulo Escaleno", "Triángulo Rectángulo", "Pentágono", "Triángulo Isósceles"};
    int[] Imagenes = {R.drawable.triangulo_escaleno, R.drawable.triangulo_rectangulo, R.drawable.pentagono, R.drawable.triangulo_isosceles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listviewPersonalizado);
        FiguraAdapter adapter = new FiguraAdapter(getApplicationContext(), Figuras, Imagenes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String figura = Figuras[position];
                Intent intent = obtenerIntent(figura);

                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No hay actividad " + figura, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Intent obtenerIntent(String figura) {
        Intent intent = null;
        switch (figura) {
            case "Triángulo Escaleno":
                intent = new Intent(MainActivity.this, TrianguloEscalenoActivity.class);
                break;
            case "Triángulo Rectángulo":
                intent = new Intent(MainActivity.this, TrianguloRectanguloActivity.class);
                break;
            case "Pentágono":
                intent = new Intent(MainActivity.this, PentagonoActivity.class);
                break;
            case "Triángulo Isósceles":
                intent = new Intent(MainActivity.this, TrianguloIsoscelesActivity.class);
                break;
            default:
                break;
        }
        if (intent != null) {
            intent.putExtra("figura", figura);
        }
        return intent;
    }
}
