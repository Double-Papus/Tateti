package com.fergus.tatetipersonal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import java.lang.String;



public class Juego extends AppCompatActivity implements View.OnClickListener
{

    private Button botones[][] = new Button[3][3];
    private int casillero[][] = new int[3][3];
    private int turno_jugador = 1;
    private int jugadas = 0;
    private int ganador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                String identificador = "casillero_" + i + j;
                int resID = getResources().getIdentifier(identificador, "id", getPackageName());
                botones[i][j] = findViewById(resID);
                botones[i][j].setOnClickListener(this);


                // Esto último que hice no me despliega la función para que la escriba, pero
                // lo que puedo hacer es poner "implements View.onClickListener" al declarar la clase
                // y hacer el overriding necesario fuera de la función OnCreate()
            }

        }

    }


    // Acá está el overriding del que hablé antes (concepto de "interfaz")
    @Override
    public void onClick(View v)
    {
        //deberia poner "si tu id es tal, entonces chequea este valor

        int id_boton = ((Button) v).getId();
        int i = 0, j = 0;

        switch (id_boton)
        {
            case R.id.casillero_00:
                i = 0;
                j = 0;
                break;
            case R.id.casillero_10:
                i = 1;
                j = 0;
                break;
            case R.id.casillero_20:
                i = 2;
                j = 0;
                break;
            case R.id.casillero_01:
                i = 0;
                j = 1;
                break;
            case R.id.casillero_11:
                i = 1;
                j = 1;
                break;
            case R.id.casillero_21:
                i = 2;
                j = 1;
                break;
            case R.id.casillero_02:
                i = 0;
                j = 2;
                break;
            case R.id.casillero_12:
                i = 1;
                j = 2;
                break;
            case R.id.casillero_22:
                i = 2;
                j = 2;
                break;
            default:
                break;
        }


        if(casillero[i][j] == 0)
        {
            casillero[i][j] = turno_jugador;
            if (turno_jugador == 1)
            {
                ganador = chequear_ganador(1);
                turno_jugador = 2;
                ((Button) v).setBackgroundResource(R.drawable.o);
            }
            else if (turno_jugador == 2)
            {
                ganador = chequear_ganador(2);
                turno_jugador = 1;
                ((Button) v).setBackgroundResource(R.drawable.x);
            }
            jugadas++;

            if (ganador != 0)
            {
                Intent intent = new Intent(this, Finalizacion_Partida.class);
                startActivity(intent);

            }
        }



        if (jugadas == 9 && ganador == 0)
        {
            // hubo empate
        }






    }

    public int chequear_ganador(int jugador)
    {
        if (((casillero[0][0] == jugador) && (casillero[0][1] == jugador) && (casillero[0][2] == jugador)) ||
            ((casillero[1][0] == jugador) && (casillero[1][1] == jugador) && (casillero[1][2] == jugador)) ||
            ((casillero[2][0] == jugador) && (casillero[2][1] == jugador) && (casillero[2][2] == jugador)) ||

            ((casillero[0][0] == jugador) && (casillero[1][0] == jugador) && (casillero[2][0] == jugador)) ||
            ((casillero[0][1] == jugador) && (casillero[1][1] == jugador) && (casillero[2][1] == jugador)) ||
            ((casillero[0][2] == jugador) && (casillero[1][2] == jugador) && (casillero[2][2] == jugador)) ||

            ((casillero[0][0] == jugador) && (casillero[1][1] == jugador) && (casillero[2][2] == jugador)) ||
            ((casillero[0][2] == jugador) && (casillero[1][1] == jugador) && (casillero[2][0] == jugador)))


                {
            return jugador;
        }
        else
        {
            return 0;
        }
    }

}












