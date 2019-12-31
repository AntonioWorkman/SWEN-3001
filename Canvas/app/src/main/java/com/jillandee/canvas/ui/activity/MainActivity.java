package com.jillandee.canvas.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.jillandee.canvas.R;
import com.jillandee.canvas.manager.FileManager;
import com.jillandee.canvas.manager.PermissionManager;
import com.jillandee.canvas.ui.component.DrawingView;
import com.jillandee.canvas.ui.dialog.StrokeSelectorDialog;

import org.xdty.preference.colorpicker.ColorPickerDialog;
import org.xdty.preference.colorpicker.ColorPickerSwatch;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_drawing_view)
    DrawingView mDrawingView;
    @Bind(R.id.main_fill)
    ImageButton mFillBackgroundImageButton;
    @Bind(R.id.main_colour)
    ImageButton mColorImageView;
    @Bind(R.id.main_stroke)
    ImageButton mStrokeImageView;
    @Bind(R.id.select_shape)
    ImageButton mShapeImageButton;
    @Bind(R.id.main_undo)
    ImageButton mUndoImageView;
    @Bind(R.id.main_redo)
    ImageButton mRedoImageButton;

    private int mCurrentBackgroundColor;
    private int mCurrentColor;
    private int mCurrentStroke;
    private static final int MAX_STROKE_WIDTH = 50;

    ImageButton shapes;
    Button mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//Shapes Button
        shapes = (ImageButton) findViewById(R.id.select_shape);
        shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, shapes);
                popupMenu.getMenuInflater().inflate(R.menu.shapes_popup, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    public boolean onOptionsItemSelected(MenuItem item) {
                        // Handle item selection
                        switch (item.getItemId()) {
                            case R.id.circle:
                                mDrawingView.drawCircle();
                                return true;
                            /*case R.id.help:
                                showHelp();
                                return true;*/
                            default:
                               return onOptionsItemSelected(item);
                        }
                    }
                });
                popupMenu.show();
            }
        });



        ButterKnife.bind(this);
        initDrawingView();

    }


    private void initDrawingView() {
        mCurrentBackgroundColor = ContextCompat.getColor(this, android.R.color.white);
        mCurrentColor = ContextCompat.getColor(this, android.R.color.black);
        mCurrentStroke = 10;

        mDrawingView.setBackgroundColor(mCurrentBackgroundColor);
        mDrawingView.setPaintColor(mCurrentColor);
        mDrawingView.setPaintStrokeWidth(mCurrentStroke);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //case R.id.save_and_share:
            //requestPermissionsAndSaveBitmap();
            //break;
            case R.id.delete:
                mDrawingView.clearCanvas();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startFillBackgroundDialog() {
        int[] colors = getResources().getIntArray(R.array.palette);

        ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
                colors,
                mCurrentBackgroundColor,
                5,
                ColorPickerDialog.SIZE_SMALL);

        dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                mCurrentBackgroundColor = color;
                mDrawingView.setBackgroundColor(mCurrentBackgroundColor);
            }

        });

        dialog.show(getFragmentManager(), "ColorPickerDialog");
    }

    private void startColorPickerDialog() {
        int[] colors = getResources().getIntArray(R.array.palette);

        ColorPickerDialog dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
                colors,
                mCurrentColor,
                5,
                ColorPickerDialog.SIZE_SMALL);

        dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                mCurrentColor = color;
                mDrawingView.setPaintColor(mCurrentColor);
            }

        });

        dialog.show(getFragmentManager(), "ColorPickerDialog");
    }

    private void startStrokeSelectorDialog() {
        StrokeSelectorDialog dialog = StrokeSelectorDialog.newInstance(mCurrentStroke, MAX_STROKE_WIDTH);

        dialog.setOnStrokeSelectedListener(new StrokeSelectorDialog.OnStrokeSelectedListener() {
            @Override
            public void onStrokeSelected(int stroke) {
                mCurrentStroke = stroke;
                mDrawingView.setPaintStrokeWidth(mCurrentStroke);
            }
        });

        dialog.show(getSupportFragmentManager(), "StrokeSelectorDialog");
    }

    private void startShareDialog(Uri uri) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "Share Image"));
    }

    private void requestPermissionsAndSaveBitmap() {
        if (PermissionManager.checkWriteStoragePermissions(this)) {
            Uri uri = FileManager.saveBitmap(mDrawingView.getBitmap());
            startShareDialog(uri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionManager.REQUEST_WRITE_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Uri uri = FileManager.saveBitmap(mDrawingView.getBitmap());
                    startShareDialog(uri);
                } else {
                    Toast.makeText(this, "The app was not allowed to write to your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @OnClick(R.id.main_fill)
    public void onBackgroundFillOptionClick() {
        startFillBackgroundDialog();
    }

    @OnClick(R.id.main_colour)
    public void onColorOptionClick() {
        startColorPickerDialog();
    }

    @OnClick(R.id.main_stroke)
    public void onStrokeOptionClick() { startStrokeSelectorDialog();
    }

    /*@OnClick(R.id.main_stroke)
    public void onDrawCircleOptionClick() {
        mDrawingView.drawCircle();
    }*/

    @OnClick(R.id.main_undo)
    public void onUndoOptionClick() {
        mDrawingView.undo();
    }

    @OnClick(R.id.main_redo)
    public void onRedoOptionClick() {
        mDrawingView.redo();
    }


}



