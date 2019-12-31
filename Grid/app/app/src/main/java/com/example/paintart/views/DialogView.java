package com.example.paintart.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.paintart.R;

public class DialogView extends AppCompatDialogFragment {
    private EditText setNumColumns;
    private EditText setNumRows;
    private DialogViewListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Enter Grid details")
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            String columns = setNumColumns.getText().toString();
                            String rows = setNumRows.getText().toString();
                            listener.applyNumbers(columns,rows);
                    }
                });

                setNumColumns = view.findViewById(R.id.setNumColumns);
                setNumRows = view.findViewById(R.id.setNumRows);

                return builder.create();
    }
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        try{
            listener = (DialogViewListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"Must implement DialogViewListener");
        }

    }

    public interface DialogViewListener{
        void applyNumbers(String columns, String rows);
    }
}
