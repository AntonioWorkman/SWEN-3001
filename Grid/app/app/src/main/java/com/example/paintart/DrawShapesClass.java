package com.example.paintart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.paintart.views.ShapesView;


public class DrawShapesClass extends AppCompatActivity{
    private ShapesView shapesView;


    private Button mButton;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes);

//      import custom view via id
        final ShapesView shapesView = findViewById(R.id.customView);

//      import button via id
        Button Arc = findViewById(R.id.Arc);
        Button Circle = findViewById(R.id.Circle);
        Button Line = findViewById(R.id.Line);
        Button Rectangle = findViewById(R.id.Rectangle);
        Button Trinagle = findViewById(R.id.Trinagle);
        Button Sqaure = findViewById(R.id.Sqaure);


        Arc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawArc();
            }
        });

        Circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawCircle();
            }
        });

        Line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawLine();
            }
        });

        Rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawRectangle();
            }
        });

        Sqaure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawSqaure();

            }
        });

        Trinagle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shapesView.DrawTriangle();

            }
        });



    }

}
