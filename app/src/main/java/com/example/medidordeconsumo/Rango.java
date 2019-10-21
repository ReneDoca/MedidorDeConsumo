package com.example.medidordeconsumo;

enum RANGOS {BASICO, INTERMEDIO, EXCEDENTE}

public class Rango {

private static RANGOS rangos;

public Rango (RANGOS rangos) {this.rangos = rangos;}

    public static String getValue (RANGOS rangos){
        String rangoStr = "Sin valor";

        switch (rangos) {

            case BASICO:
                rangoStr = "Su rango de consumo es basico";
                break;

            case INTERMEDIO:
                rangoStr = "Su rango de consumo es intermedio";
                break;

            case EXCEDENTE:
                rangoStr = "Su rango de consumo es Excedente";


        }

        return rangoStr;
    }


}






