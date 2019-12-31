package com.example.paintart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);

        Button canvasView = findViewById(R.id.Canvas);
        Button gridView = findViewById(R.id.grid);
        Button drawShaes = findViewById(R.id.DrawShapes);

        canvasView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Canvas View",Toast.LENGTH_SHORT).show();
                goToCanvas();
            }
        });

        gridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Grid View",Toast.LENGTH_SHORT).show();
                goToGrid();
            }
        });

        drawShaes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Draw Shape",Toast.LENGTH_SHORT).show();
                goToDrawShape();
            }
        });
    }

    public void  goToCanvas(){
        Intent intent = new Intent(this,CanvasClass.class);
        startActivity(intent);
    }

    public void  goToGrid(){
        Intent intent = new Intent(this,GridClass.class);
        startActivity(intent);
    }

    public void  goToDrawShape(){
        Intent intent = new Intent(this, DrawShapesClass.class);
        startActivity(intent);
    }
}
