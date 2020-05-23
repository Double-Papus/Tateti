package com.fergus.tatetipersonal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;   // ojo, solo agarro el intent
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private Button boton1;

    //---------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button) findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                irAJuego();
            }
        });
    }

    //---------------------------------------------------------------------------------------------

    public void irAJuego()
    {   // Esto es para ir a Juego.class, como si fuese un salto.
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }
}
