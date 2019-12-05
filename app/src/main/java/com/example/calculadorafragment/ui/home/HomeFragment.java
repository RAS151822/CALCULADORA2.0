package com.example.calculadorafragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.calculadorafragment.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private double resultado = 0;
    private double numero = 0;
    private String operacion;
    private TextView texto1, texto2;
    private Button prueba, boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, botonPunto, botonSuma, botonResta, botonMultiplicacion, botonDivision, botonIgual, botonC, botonMasMenos, botonAC, botonporcentaje;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_standard, container, false);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        //ASOCIAMOS CADA BOTON DE NUESTRA CALCULADORA  A SU VARIABLE CORRESPONDIENTE SEGUN TIPO

        //1º Enlazamos los Text View

        texto1 = root.findViewById(R.id.textViewResultado);
        texto2 = root.findViewById(R.id.textViewOperacion);


        //2º Enlazamos los bottones y programamos las funciones de cada uno

        //Insertar números naturales

        boton1 = root.findViewById(R.id.button1);

        boton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                texto1.setText(texto1.getText() + "1");

            }
        });


        boton2 =  root.findViewById(R.id.button2);

        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                texto1.setText(texto1.getText() + "2");

            }

        });

        boton3 =  root.findViewById(R.id.button3);

        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                texto1.setText(texto1.getText() + "3");
            }
        });

        boton4 =  root.findViewById(R.id.button4);

        boton4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "4");
            }
        });

        boton5 =  root.findViewById(R.id.button5);

        boton5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "5");
            }
        });

        boton6 =  root.findViewById(R.id.button6);

        boton6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "6");
            }
        });

        boton7 =  root.findViewById(R.id.button7);

        boton7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "7");
            }
        });

        boton8 =  root.findViewById(R.id.button8);

        boton8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "8");
            }
        });
        boton9 =  root.findViewById(R.id.button9);

        boton9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "9");
            }
        });

        boton0 =  root.findViewById(R.id.button0);

        boton0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                texto1.setText(texto1.getText() + "0");
            }
        });

        botonPunto =  root.findViewById(R.id.buttonpunto);

        botonPunto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String cadena = texto1.getText().toString();
                int resultado = cadena.indexOf(".");

                if(resultado != -1) {

                }else if (texto1.getText() == "") {

                }else{

                    String pant = texto1.getText().toString();
                    texto1.setText(pant + ".");
                }
            }
        });



        //INSERTAMOS LAS OPERACIONES

        //BORRADO TOTAL

        botonAC = root.findViewById(R.id.buttonAC);
        botonAC.setOnClickListener (new View.OnClickListener() {

            public void onClick(View v) {

                resultado = 0;
                texto1.setText("");
                texto2.setText("");
            }
        });

        //BORRADO uno

        botonC = root.findViewById(R.id.buttonC);
        botonC.setOnClickListener (new View.OnClickListener() {

            public void onClick(View v) {

                if (!texto1.getText().toString().equals("")){
                    texto1.setText(texto1.getText().subSequence(0, texto1.getText().length()-1));
                }
            }
        });

        //DIVISION
        botonDivision = root.findViewById(R.id.buttondivision);

        botonDivision.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(texto1.getText() == "") {

                }else{

                    numero = Double.parseDouble((texto1.getText().toString()));
                    operacion = "/";
                    texto2.setText(texto1.getText() + " " + "/");
                    texto1.setText("");
                }

            }
        });

        //SUMA
        botonSuma = root.findViewById(R.id.buttonsuma);

        botonSuma.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(texto1.getText() == "") {

                }else {
                    numero = Double.valueOf((String) texto1.getText()).doubleValue();
                    operacion = "+";
                    texto2.setText(texto1.getText() + " " + "+");
                    texto1.setText("");
                }

            }
        });

        //RESTA
        botonResta = root.findViewById(R.id.buttonresta);

        botonResta.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(texto1.getText() == "") {

                }else {
                    numero = Double.valueOf((String) texto1.getText()).doubleValue();
                    operacion = "-";
                    texto2.setText(texto1.getText() + " " + "-");
                    texto1.setText("");
                }

            }
        });

        //MULTIPLICACION
        botonMultiplicacion = root.findViewById(R.id.buttonmultiplicacion);

        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(texto1.getText() == "") {

                }else {
                    numero = Double.valueOf((String) texto1.getText()).doubleValue();
                    operacion = "X";
                    texto2.setText(texto1.getText() + " " + "X");
                    texto1.setText("");
                }

            }
        });

        //Boton PORCENTAJE
        botonporcentaje =  root.findViewById(R.id.buttonporcentaje);

        botonporcentaje.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(texto1.getText() == "") {

                }else {
                    numero = Double.valueOf((String) texto1.getText()).doubleValue();
                    operacion = "%";
                    texto2.setText(texto1.getText() + " " + "%");
                    texto1.setText("");
                }
            }
        });

        //BOTON RESULTADO =
        botonIgual = root.findViewById(R.id.buttonigual);

        botonIgual.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                double segundo_numero = Double.valueOf((String)  texto1.getText()).doubleValue();

                String aux = texto2.getText().toString() + " " +  texto1.getText().toString();


                texto2.setText(aux);

                if(operacion != "") {

                    if (operacion == "+") {
                        resultado = numero + segundo_numero;
                    } else if (operacion == "-") {
                        resultado = numero - segundo_numero;
                    } else if (operacion == "X") {
                        resultado = numero * segundo_numero;
                    } else if (operacion == "/") {
                        resultado = numero / segundo_numero;
                    }else if (operacion == "%") {
                        resultado = numero % segundo_numero;
                    }

                    String resultadoFinal = String.valueOf( resultado );
                    int longitud = resultadoFinal.length();

                    //Si acaba en .0 muestro como entero
                    if ((resultadoFinal.charAt(longitud - 2) == '.') && (resultadoFinal.charAt(longitud - 1) == '0'))
                        resultadoFinal = resultadoFinal.substring(0, resultadoFinal.length() - 2);
                    texto1.setText(resultadoFinal);
                    resultado = 0;


                }
            }
        });

        return root;
    }
}