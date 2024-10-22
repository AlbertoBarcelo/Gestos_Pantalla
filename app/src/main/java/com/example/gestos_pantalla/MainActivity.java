package com.example.gestos_pantalla;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;
    private static final String TAG = "GESTOS"; // Etiqueta para los logs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos el GestureDetector
        gestureDetector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pasamos los eventos de toque al GestureDetector
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // Evento de tocar la pantalla
        Log.d(TAG, "onDown: Tocaste la pantalla");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // Evento de presionar y mantener
        Log.d(TAG, "onShowPress: Mantienes presionada la pantalla");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // Evento de un solo toque
        Log.d(TAG, "onSingleTapUp: Tocaste la pantalla una vez");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // Evento de desplazar el dedo por la pantalla

        // Analizar si el desplazamiento es más significativo en el eje X o Y
        if (Math.abs(distanceX) > Math.abs(distanceY)) {
            // Movimiento horizontal
            if (distanceX > 0) {
                Log.d(TAG, "onScroll: Desplazaste hacia la izquierda");
            } else {
                Log.d(TAG, "onScroll: Desplazaste hacia la derecha");
            }
        } else {
            // Movimiento vertical
            if (distanceY > 0) {
                Log.d(TAG, "onScroll: Desplazaste hacia arriba");
            } else {
                Log.d(TAG, "onScroll: Desplazaste hacia abajo");
            }
        }

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // Evento de una pulsación larga
        Log.d(TAG, "onLongPress: Mantienes una pulsación larga en la pantalla");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // Evento de un "fling" (deslizamiento rápido)
        Log.d(TAG, "onFling: Deslizó rápidamente con una velocidad de X: " + velocityX + " Y: " + velocityY);
        return true;
    }
}
