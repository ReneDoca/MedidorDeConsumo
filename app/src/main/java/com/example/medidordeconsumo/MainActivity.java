package com.example.medidordeconsumo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private EditText txtVoltaje;
    private EditText txtCorriente;
    private TextView Rango;
    private TextView Consumo;
    private EditText txtCantidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();

        txtVoltaje = (EditText)findViewById(R.id.Voltaje);
        txtCorriente = (EditText) findViewById(R.id.Corriente);
        Rango = (TextView) findViewById(R.id.rangoConsumo);
        Consumo = (TextView) findViewById(R.id.consumoKilo);
       // txtCantidad = (EditText) findViewById(R.id.Cantidad);


    }

    public void myButtonListenerMethod (){

        Button button = findViewById(R.id.Agregar);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                final EditText VoltajeText = findViewById(R.id.Voltaje);
                String VoltajeStr = VoltajeText.getText().toString();
                double Voltaje = Double.parseDouble(VoltajeStr);

                final EditText CorrienteText = findViewById(R.id.Corriente);
                String CorrienteStr = CorrienteText.getText().toString();
                double Corriente = Double.parseDouble((CorrienteStr));



                double potencia = (Voltaje) *(Corriente);

               String CAT;

               if (potencia< 0.793 )
                   CAT = "basico";
               else if (potencia < 0.956)
                   CAT = "intermedio";
               else
                   CAT = "excedente";

               final TextView Categoria = findViewById(R.id.rangoConsumo);
               Categoria.setText(CAT);


                final TextView Consumo = findViewById(R.id.consumoKilo);
                Consumo.setText(Double.toString(potencia));
            }



        } );

    }

    public void btnCalcularIMC(){
        Button bntCalcularConsumo = findViewById(R.id.Agregar);
        bntCalcularConsumo.setOnClickListener(new BtnCalcularConsumoscuchador());

    }
// ni idea
    class BtnCalcularConsumoscuchador implements View.OnClickListener{
        @Override
        public void onClick (View view){


            String voltajeStr = txtVoltaje.getText().toString();
            String corrienteStr = txtCorriente.getText().toString();

            Double voltajeDbl = Double.parseDouble(voltajeStr);
            Double corrienteDbl = Double.parseDouble(corrienteStr);

            Double potencia = calcularPotencia (voltajeDbl, corrienteDbl);


            Consumo.setText (Double.toString(potencia));
            Rango.setText(getRango(potencia));



        }

    }

    private Double calcularPotencia (Double voltajeDl, Double corrienteDBL) {

        Double potencia = voltajeDl * corrienteDBL;
        return potencia;


    }

    private String getRango (Double rangos){

        RANGOS categoria;

        if (rangos < 0.793 ) {

            categoria = RANGOS.BASICO;
        }
        else if( rangos < 0.956 ){

            categoria = RANGOS.INTERMEDIO;
        } else{

            categoria = RANGOS.EXCEDENTE;
        }

        return com.example.medidordeconsumo.Rango.getValue(categoria);

    }

}
