package com.jillandee.dialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Button alertButton;
    public static Button progressBar;
    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    public TimePickerDialog picker;
    public EditText eText;
    public Button btnGet;
    public TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize Exit
        onButtonClickListener();
        addItemsOnSpinner2();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        tvw = (TextView) findViewById(R.id.printDate);
        eText = (EditText) findViewById(R.id.Time);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                picker = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });
        btnGet = (Button) findViewById(R.id.Date);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Time: " + eText.getText());
            }
        });


    }

    // Loading screen on app startup.
        /*dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Initializing App");
        dialog.setMessage("Please wait...");
        dialog.show();*/


    public void onButtonClickListener() {
        alertButton = (Button) findViewById(R.id.Alert);
        alertButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                                               alertBuilder.setMessage("Are you sure you want to exit?")
                                                       .setCancelable(false)
                                                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                           @Override
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               Intent intent = new Intent(Intent.ACTION_MAIN);
                                                               intent.addCategory(Intent.CATEGORY_HOME);
                                                               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                               startActivity(intent);
                                                               finish();
                                                               System.exit(0);
                                                           }
                                                       })
                                                       .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                           @Override
                                                           public void onClick(DialogInterface dialog, int which) {
                                                               dialog.cancel();
                                                           }
                                                       });
                                               AlertDialog alert = alertBuilder.create();
                                               alert.setTitle("Exit Application");
                                               alert.show();
                                           }
                                       }
        );
        progressBar = (Button) findViewById(R.id.progressBar);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });

    }

    public void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("We're working on it.");
        progressDialog.setMessage("Please wait...");
        //progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void addItemsOnSpinner2() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "Result: " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });

    }
}
