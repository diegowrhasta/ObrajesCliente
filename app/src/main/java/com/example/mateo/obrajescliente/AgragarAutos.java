package com.example.mateo.obrajescliente;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgragarAutos extends Fragment implements View.OnClickListener {

    private EditText et1,et2,et3,et4,et5;
    private DatabaseReference databaseCliente;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    //Definimos las listas para mostrar datos

    private Button buttonReg,buttonVol;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_agregar_autos, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseAuth.getInstance().getCurrentUser();
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);
        et3 = (EditText) view.findViewById(R.id.et3);
        et4= (EditText) view.findViewById(R.id.et4);
        et5 = (EditText) view.findViewById(R.id.et5);
        databaseCliente = FirebaseDatabase.getInstance().getReference("Cliente").child(firebaseAuth.getUid()).child("auto");
        progressDialog = new ProgressDialog(getContext());





        buttonReg = (Button) view.findViewById(R.id.btnReg);
        buttonReg.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {

                final String marca = et1.getText().toString().trim();
                final String modelo = et2.getText().toString().trim();
                final String color = et3.getText().toString().trim();
                final String placa  = et4.getText().toString().trim();
                final String cprv  = et5.getText().toString().trim();
                final String idUsuario=firebaseAuth.getUid();

                Auto auto= new Auto(marca,modelo,color,placa,cprv,idUsuario);
                databaseCliente.push().setValue(auto);

                progressDialog.setMessage("Registrando...");
                progressDialog.show();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new MisAutos());
                transaction.addToBackStack(null);
                transaction.commit();
                progressDialog.dismiss();

            }

        });


        buttonVol = (Button) view.findViewById(R.id.btnVol);
        buttonVol.setOnClickListener(new View.OnClickListener()        {
            @Override
            public void onClick(View v)
            {


                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,new MisAutos());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        });
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
