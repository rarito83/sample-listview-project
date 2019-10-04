package com.rarito.tenuclfootballclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private TypedArray dataLogo;
    private String[] nameClub;
    private String[] description;
    private ClubAdapter adapter;
    private ArrayList<Club> footballClub;
    public static String EXTRA_CLUB = "extra_club";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_football_club);
        adapter = new ClubAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, footballClub.get(i).getNameClub(), Toast.LENGTH_SHORT).show();

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_CLUB, footballClub.get(i));
                startActivity(detailIntent);
            }
        });
    }

    private void prepare() {
        dataLogo = getResources().obtainTypedArray(R.array.data_logo);
        nameClub = getResources().getStringArray(R.array.data_nameClub);
        description = getResources().getStringArray(R.array.data_description);
    }

    private void addItem() {
        footballClub = new ArrayList<>();
        for (int i = 0; i < dataLogo.length(); i++) {
            Club clubs = new Club();
            clubs.setLogo(dataLogo.getResourceId(i, -1));
            clubs.setNameClub(nameClub[i]);
            clubs.setDescription(description[i]);
            footballClub.add(clubs);
        }
        adapter.setFootballClub(footballClub);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() != 0) {
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
