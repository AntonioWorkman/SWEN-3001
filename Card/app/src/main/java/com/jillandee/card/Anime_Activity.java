package com.jillandee.card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

public class Anime_Activity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtGenre;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_);

        txtTitle = (TextView) findViewById(R.id.txttitle);
        txtGenre = (TextView) findViewById(R.id.txtgenre);
        img = (ImageView) findViewById(R.id.animethumbnail);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Genre = intent.getExtras().getString("Genre");
        int image = intent.getExtras().getInt("Thumbnail");

        txtTitle.setText(Title);
        txtGenre.setText(Genre);
        img.setImageResource(image);
    }
}
