package com.example.mancityactivityapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public TextView descriptionTextView;

    public TextView playerNameTextView;
    public Button webButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        descriptionTextView = findViewById(R.id.descriptionTextView);
        playerNameTextView=findViewById(R.id.playerNameTextView);
        webButton = findViewById(R.id.buttonWeb);

        // get intent and extract data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Player player = (Player) bundle.getSerializable("data");

        // populate fields with data
        playerNameTextView.setText(player.getName());
        String description=player.getSummary().replace(".",".\n\n");
        descriptionTextView.setText(description);

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create intent and bundle
                Intent intent1 = new Intent(DetailsActivity.this, WebActivity.class);
                Bundle bundle1 = new Bundle();

                // bundle data
                bundle1.putString("data", player.getUrl());
                intent1.putExtras(bundle1);

                startActivity(intent1);

            }
        });

    }
}