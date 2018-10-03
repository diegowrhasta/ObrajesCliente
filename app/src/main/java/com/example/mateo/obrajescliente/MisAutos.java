package com.example.mateo.obrajescliente;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class MisAutos extends Fragment {
    private ImageButton button;

    private ListView lv1;
    private String [][] datos = {
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Nissan, Plateado","Parqueado"},
            {"Susuki, Rojo","Parqueado"}
    };
    int[] datosImg={R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto,R.mipmap.auto};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mis_autos, container, false);

        button = (ImageButton) view.findViewById(R.id.btnAddAuto);
        button.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new AgragarAutos());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        lv1 = (ListView)view.findViewById(R.id.lv1);
        lv1.setAdapter(new AdaptadorListView(getContext(), datos, datosImg));

    }
}
