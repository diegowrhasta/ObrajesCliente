package com.example.mateo.obrajescliente;

import java.util.List;

public class Auto {

    public String marca,modelo,color,placa,cprv,idUsuario;



    public Auto(MisAutos agragarAutos, List<Auto> autoList){

    }



    public Auto(String marca, String modelo, String color, String placa, String cprv, String idUsuario) {
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;
        this.placa=placa;
        this.cprv=cprv;
        this.idUsuario = idUsuario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCprv() {
        return cprv;
    }

    public String getIdUsuario() {
        return idUsuario;
    }
}
