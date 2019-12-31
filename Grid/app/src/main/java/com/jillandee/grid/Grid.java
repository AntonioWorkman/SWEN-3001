package com.jillandee.grid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.jillandee.grid.GridViewClasses.GridView;
import com.jillandee.grid.GridViewClasses.DialogView;

public class Grid extends AppCompatActivity implements DialogView.DialogViewListener {

    //private SeekBar dynamicGrid;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        gridView = (GridView) findViewById(R.id.gridView);
        Button constraints = findViewById(R.id.constraints);
        //dynamicGrid = (SeekBar) findViewById(R.id.dynamicGrid);


        constraints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        /*dynamicGrid.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekBarValue = dynamicGrid.getProgress();
                gridView.setNumColumns(seekBarValue);
                gridView.setNumRows(seekBarValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });*/

    }

    public void openDialog() {
        DialogView dialogView = new DialogView();
        dialogView.show(getSupportFragmentManager(), "Grid Details");
    }

    @Override
    public void applyNumbers(String columns, String rows) {
        int column = Integer.parseInt(columns);
        int row = Integer.parseInt(rows);
        gridView.setNumColumns(column);
        gridView.setNumRows(row);

    }
}

