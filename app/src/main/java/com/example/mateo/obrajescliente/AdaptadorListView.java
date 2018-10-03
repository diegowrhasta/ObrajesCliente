package com.example.mateo.obrajescliente;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorListView extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context contexto;
    String [][]datos;
    int []datosImg;

    public AdaptadorListView(Context contexto,String[][ ] datos, int[] imagenes){
        this.contexto=contexto;
        this.datos=datos;
        this.datosImg=imagenes;

        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView tv1 = (TextView)vista.findViewById(R.id.tv1);
        TextView tv2 = (TextView)vista.findViewById(R.id.tv2);
        ImageView imagen=(ImageView)vista.findViewById(R.id.iv1);

        tv1.setText(datos[i][0]);
        tv2.setText(datos[i][1]);
        imagen.setImageResource(datosImg[i]);
        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
