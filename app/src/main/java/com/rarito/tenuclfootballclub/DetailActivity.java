package com.rarito.tenuclfootballclub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_CLUB = "extra_club";
    TextView txtClubName;
    TextView txtClubDesc;
    ImageView imgClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail Club");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Club football = getIntent().getParcelableExtra(EXTRA_CLUB);

        imgClub = findViewById(R.id.club_logo);
        imgClub.setImageResource(football.getLogo());

        txtClubName = findViewById(R.id.club_name);
        txtClubName.setText(football.getNameClub());

        txtClubDesc = findViewById(R.id.club_description);
        txtClubDesc.setText(football.getDescription());
    }
}
