package com.example.calculadorav2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVisor;
    String textoVisor;
    float numeroAtual = 0;
    float numeroAnterior = 0;
    String op = "";
    boolean digitando = false;
    boolean separador = false;
    String modificaVirgula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVisor = findViewById(R.id.txtVisor);

    }


    public void btnNumero(View view) {

        // recebe elemento do view
        Button btnNumero = (Button) view;

        // recebe texto do botão 'clicado'
        String numero = btnNumero.getText().toString();

        // recebe texto do visor
        textoVisor = txtVisor.getText().toString();


        if (!digitando || textoVisor.equals("0")) {
            txtVisor.setText(numero);

            if (!numero.equals("0")) {
                digitando = true;
            }

        } else {
            txtVisor.setText(textoVisor + numero);
        }


    }

    public void apagar(View view) {
        txtVisor.setText("0");
        numeroAtual = 0;
        numeroAnterior = 0;
        digitando = false;
        separador = false;
    }

    public void btnOperacao(View view) {

        Button btnOp = (Button) view;


        if (btnOp.getText().equals(",") && !separador) {
            separador = true;

            if (!digitando) {
                txtVisor.setText("0,");
            } else {
                txtVisor.setText(txtVisor.getText().toString() + ",");
            }

            digitando = true;

        } else if (!btnOp.getText().equals(",")) {

            modificaVirgula = txtVisor.getText().toString().replace(',', '.');

            numeroAtual = Float.parseFloat(modificaVirgula);

            switch (btnOp.getId()) {

                case R.id.btnAdi:

                    if (numeroAnterior == 0) {
                        numeroAnterior = numeroAtual;
                    } else {
                        numeroAnterior += numeroAtual;
                    }
                    textoVisor = String.valueOf(numeroAnterior);
                    if (textoVisor.endsWith(".0")) {
                        textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                    }
                    modificaVirgula = textoVisor.replace('.', ',');
                    txtVisor.setText(modificaVirgula);

                    op = "adi"; // adição selecionada (importante para a operação de "=")

                    digitando = false; // não estou mais digitando um valor
                    separador = false;

                    break;

                case R.id.btnSub:

                    if (numeroAnterior == 0) {
                        numeroAnterior = numeroAtual;
                    } else {
                        numeroAnterior -= numeroAtual;
                    }
                    textoVisor = String.valueOf(numeroAnterior);
                    if (textoVisor.endsWith(".0")) {
                        textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                    }
                    modificaVirgula = textoVisor.replace('.', ',');
                    txtVisor.setText(modificaVirgula);

                    op = "sub"; //

                    digitando = false;
                    separador = false;

                    break;

                case R.id.btnMult:

                    if (numeroAnterior == 0) {
                        numeroAnterior = numeroAtual;
                    } else {
                        numeroAnterior *= numeroAtual;
                    }
                    textoVisor = String.valueOf(numeroAnterior);
                    if (textoVisor.endsWith(".0")) {
                        textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                    }
                    modificaVirgula = textoVisor.replace('.', ',');
                    txtVisor.setText(modificaVirgula);

                    op = "mult"; //

                    digitando = false;
                    separador = false;

                    break;

                case R.id.btnDiv:

                    if (numeroAnterior == 0) {
                        numeroAnterior = numeroAtual;
                    } else {
                        numeroAnterior /= numeroAtual;
                    }
                    textoVisor = String.valueOf(numeroAnterior);
                    if (textoVisor.endsWith(".0")) {
                        textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                    }
                    modificaVirgula = textoVisor.replace('.', ',');
                    txtVisor.setText(modificaVirgula);

                    op = "div"; //

                    digitando = false;
                    separador = false;
                    break;

                case R.id.btnIgual:

                    float result;

                    if (op.equals("adi")) {

                        result = numeroAnterior + numeroAtual;
                        numeroAnterior = 0;
                        numeroAtual = 0;
                        textoVisor = String.valueOf(result);

                        if (textoVisor.endsWith(".0")) {
                            textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                        }
                        modificaVirgula = textoVisor.replace('.', ',');
                        txtVisor.setText(modificaVirgula);

                    }
                    if(op.equals("sub")) {

                        result = numeroAnterior - numeroAtual;
                        numeroAnterior = 0;
                        numeroAtual = 0;
                        textoVisor = String.valueOf(result);
                        if (textoVisor.endsWith(".0")) {
                            textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                        }
                        modificaVirgula = textoVisor.replace('.', ',');
                        txtVisor.setText(modificaVirgula);
                    }

                    if(op.equals("mult")) {

                        result = numeroAnterior * numeroAtual;
                        numeroAnterior = 0;
                        numeroAtual = 0;
                        textoVisor = String.valueOf(result);
                        if (textoVisor.endsWith(".0")) {
                            textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                        }
                        modificaVirgula = textoVisor.replace('.', ',');
                        txtVisor.setText(modificaVirgula);
                    }

                    if(op.equals("div")) {

                        result = numeroAnterior / numeroAtual;
                        numeroAnterior = 0;
                        numeroAtual = 0;
                        textoVisor = String.valueOf(result);
                        if (textoVisor.endsWith(".0")) {
                            textoVisor = textoVisor.substring(0, textoVisor.length() - 2);
                        }
                        modificaVirgula = textoVisor.replace('.', ',');
                        txtVisor.setText(modificaVirgula);
                    }


                    op = "";
                    digitando = false;
                    separador = false;

                    break;
            }


        }


    }



}