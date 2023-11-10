package com.example.act_9_listview_brenda;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FiguraAdapter extends BaseAdapter {

    private Context context;
    private String[] Figuras;
    private int[] Imagenes;

    public FiguraAdapter(Context context, String[] Figuras, int[] Imagenes) {
        this.context = context;
        this.Figuras = Figuras;
        this.Imagenes = Imagenes;
    }

    @Override
    public int getCount() {
        return Figuras.length;
    }

    @Override
    public Object getItem(int position) {
        return Figuras[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.personalizado, null);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textViewPerimetro = convertView.findViewById(R.id.textViewPerimetro);
            holder.textViewArea = convertView.findViewById(R.id.textViewArea);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(Imagenes[position]);
        // Aquí establece las fórmulas del perímetro y área según la figura correspondiente
        String Perimetro = obtenerPerimetro(Figuras[position]);
        String Area = obtenerArea(Figuras[position]);
        holder.textViewPerimetro.setText("PERIMETRO: " + Perimetro);
        holder.textViewArea.setText("ÁREA: " + Area);
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewPerimetro;
        TextView textViewArea;
    }
    // Método para obtener la fórmula del perímetro según la figura
    private String obtenerPerimetro(String figura) {
        switch (figura) {
            case "Triángulo Escaleno":
            case "Triángulo Rectángulo":
                return "A + B + C";
            case "Pentágono":
                return "L + L + L + L + L";
            case "Triángulo Isósceles":
                return "A + A + B";
            default:
                return "";
        }
    }
    // Método para obtener la fórmula del área según la figura
    private String obtenerArea(String figura) {
        switch (figura) {
            case "Triángulo Escaleno":
                return "B * H / 2";
            case "Triángulo Rectángulo":
                return "1 / 2 * A * B";
            case "Pentágono":
                return "(PERIMETRO * APOTEMA) / 2";
            case "Triángulo Isósceles":
                return "B * H / 2";
            default:
                return "";
        }
    }
}

