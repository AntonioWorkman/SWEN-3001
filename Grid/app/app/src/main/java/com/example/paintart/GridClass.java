package com.example.paintart;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paintart.views.DialogView;
import com.example.paintart.views.GridView;

public class GridClass extends AppCompatActivity implements DialogView.DialogViewListener{


//    //      import forms and labels from layout_dialog.xml
//    TextView setNumColumnsLabel = findViewById(R.id.setNumColumnsLabel);
//    TextView setNumRowsLabel = findViewById(R.id.setNumRowsLabel);
////    TextView label = findViewById(R.id.label);
//    EditText setNumColumns = findViewById(R.id.setNumColumns);
//    EditText setNumRows = findViewById(R.id.setNumRows);

//    import custom view via id
      GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_class);

        gridView = (GridView) findViewById(R.id.gridView);
        Button setgrid = findViewById(R.id.setGrid);



        setgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
    });

    }
    public void openDialog(){
        DialogView dialogView = new DialogView();
        dialogView.show(getSupportFragmentManager(),"grid details");
    }

    @Override
    public void applyNumbers(String columns, String rows) {
                int column = Integer.parseInt(columns);
                int row = Integer.parseInt(rows);
                gridView.setNumColumns(column);
                gridView.setNumRows(row);

    }
}

