package com.example.mateo.obrajescliente;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListaAuto extends ArrayAdapter<Auto> {

    private Activity context;
    private List<Auto> autoList;

    public ListaAuto(Activity context, List<Auto>autoList)
    {
        super(context, R.layout.elemento_lista, autoList);
        this.context= context;
        this.autoList=autoList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View Verlista=inflater.inflate(R.layout.elemento_lista,null,true);

        TextView textViewNombre=(TextView) Verlista.findViewById(R.id.tv1);
        TextView textViewGenero=(TextView) Verlista.findViewById(R.id.tv2);
        Auto autito=autoList.get(position);

        textViewNombre.setText(autito.getPlaca());
        textViewGenero.setText(autito.getIdUsuario());

        return Verlista;
    }
}

