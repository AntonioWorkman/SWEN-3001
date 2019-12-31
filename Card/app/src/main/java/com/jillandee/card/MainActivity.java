package com.jillandee.card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Anime> lstAnime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstAnime = new ArrayList<>();
        lstAnime.add(new Anime("Sword Art Online", "Fantasy", "https://swordartonline.fandom.com/wiki/Sword_Art_Online_Wiki", R.drawable.asuna));
        lstAnime.add(new Anime("Hellsing", "Fantasy", "https://hellsing.fandom.com/wiki/Hellsing_Wiki", R.drawable.alucard));
        lstAnime.add(new Anime("Kaname and Yuki", "Romance", "https://vampireknight.fandom.com/wiki/Vampire_Knight_Wiki", R.drawable.kaname_and_yuki));
        lstAnime.add(new Anime("Fairy Tail Zero", "Fantasy", "https://fairytail.fandom.com/wiki/Fairy_Tail_Zer%C3%B8", R.drawable.mavis_and_zera));
        lstAnime.add(new Anime("Shokugeki no Soma", "Food", "https://shokugekinosoma.fandom.com/wiki/Shokugeki_no_Soma_Wiki", R.drawable.shokugeki));
        lstAnime.add(new Anime("Naruto Shippuden", "Shounen", "https://naruto.fandom.com/wiki/Naruto:_Shipp%C5%ABden", R.drawable.sasuke));
        lstAnime.add(new Anime("Yamada-kun and the 7 Witches", "Slice of Life", "https://nananinnomajo.fandom.com/wiki/The_Seven_Witches", R.drawable.yamada_and_shiraishi));


        lstAnime.add(new Anime("Sword Art Online", "Fantasy", "https://swordartonline.fandom.com/wiki/Sword_Art_Online_Wiki", R.drawable.asuna));
        lstAnime.add(new Anime("Hellsing", "Fantasy", "https://hellsing.fandom.com/wiki/Hellsing_Wiki", R.drawable.alucard));
        lstAnime.add(new Anime("Kaname and Yuki", "Romance", "https://vampireknight.fandom.com/wiki/Vampire_Knight_Wiki", R.drawable.kaname_and_yuki));
        lstAnime.add(new Anime("Fairy Tail Zero", "Fantasy", "https://fairytail.fandom.com/wiki/Fairy_Tail_Zer%C3%B8", R.drawable.mavis_and_zera));
        lstAnime.add(new Anime("Shokugeki no Soma", "Food", "https://shokugekinosoma.fandom.com/wiki/Shokugeki_no_Soma_Wiki", R.drawable.shokugeki));
        lstAnime.add(new Anime("Naruto Shippuden", "Shounen", "https://naruto.fandom.com/wiki/Naruto:_Shipp%C5%ABden", R.drawable.sasuke));
        lstAnime.add(new Anime("Yamada-kun and the 7 Witches", "Slice of Life", "https://nananinnomajo.fandom.com/wiki/The_Seven_Witches", R.drawable.yamada_and_shiraishi));


        lstAnime.add(new Anime("Sword Art Online", "Fantasy", "https://swordartonline.fandom.com/wiki/Sword_Art_Online_Wiki", R.drawable.asuna));
        lstAnime.add(new Anime("Hellsing", "Fantasy", "https://hellsing.fandom.com/wiki/Hellsing_Wiki", R.drawable.alucard));
        lstAnime.add(new Anime("Kaname and Yuki", "Romance", "https://vampireknight.fandom.com/wiki/Vampire_Knight_Wiki", R.drawable.kaname_and_yuki));
        lstAnime.add(new Anime("Fairy Tail Zero", "Fantasy", "https://fairytail.fandom.com/wiki/Fairy_Tail_Zer%C3%B8", R.drawable.mavis_and_zera));
        lstAnime.add(new Anime("Shokugeki no Soma", "Food", "https://shokugekinosoma.fandom.com/wiki/Shokugeki_no_Soma_Wiki", R.drawable.shokugeki));
        lstAnime.add(new Anime("Naruto Shippuden", "Shounen", "https://naruto.fandom.com/wiki/Naruto:_Shipp%C5%ABden", R.drawable.sasuke));
        lstAnime.add(new Anime("Yamada-kun and the 7 Witches", "Slice of Life", "https://nananinnomajo.fandom.com/wiki/The_Seven_Witches", R.drawable.yamada_and_shiraishi));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recylerview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstAnime);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);

    }
}
