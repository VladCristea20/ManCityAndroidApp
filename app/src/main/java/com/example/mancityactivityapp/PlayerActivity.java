package com.example.mancityactivityapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {
    private SparseArray<TextView> textViews;
    private Button detailButton;
    private ImageView playerImageView;
    private ImageView flagImageView;

    private Player playerData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        textViews=new SparseArray<>();

        textViews.append(R.id.textView,findViewById(R.id.textView));
        textViews.append(R.id.textViewDob,findViewById(R.id.textViewDob));
        textViews.append(R.id.textViewPob,findViewById(R.id.textViewPob));
        textViews.append(R.id.textViewNationality,findViewById(R.id.textViewNationality));
        textViews.append(R.id.textViewJoined,findViewById(R.id.textViewJoined));
        textViews.append(R.id.textViewPosition,findViewById(R.id.textViewPosition));



        flagImageView=findViewById(R.id.flagImageView);
        playerImageView = findViewById(R.id.imageView);
        detailButton = findViewById(R.id.button);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Player playerData = (Player)bundle.getSerializable("data");

        String nationality=null;
        switch(playerData.getNationality()){
            case "ALGERIA":
                nationality="algeria";
                break;
            case "ARGENTINA":
                nationality="argentina";
                break;
            case "BELGIUM":
                nationality="belgium";
                break;
            case "SWI":
                nationality="switzerland";
                break;
            case "GERMANY":
                nationality="germany";
                break;
            case "ENGLAND":
                nationality="england";
                break;
            case "NORWAY":
                nationality="norway";
                break;
            case "SPAIN":
                nationality="spain";
                break;
            case "PORTUGAL":
                nationality="portugal";
                break;
            case "BRAZIL":
                nationality="brazil";
                break;
            case "NL":
                nationality="netherlands";
                break;
            default:
                nationality="world";
                break;
        }

        int flagID = getResources().getIdentifier(nationality, "drawable",this.getPackageName());
        flagImageView.setImageResource(flagID);

        textViews.get(R.id.textView).setText(String.format("%s # %s", playerData.getName(),playerData.getShirtNumber()));
        textViews.get(R.id.textViewDob).setText(playerData.getDob());
        textViews.get(R.id.textViewPob).setText(playerData.getBirthPlace());
        textViews.get(R.id.textViewNationality).setText(playerData.getNationality());
        textViews.get(R.id.textViewJoined).setText(playerData.getJoined());
        textViews.get(R.id.textViewPosition).setText(playerData.getPosition());
        String name = playerData.getImage();

        name = name.substring(0, name.indexOf("."));
        int imageID = getResources().getIdentifier(name, "drawable",this.getPackageName());
        playerImageView.setImageResource(imageID);

        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make the intent and its bundle
                Intent intent = new Intent(PlayerActivity.this,DetailsActivity.class);
                Bundle bundle = new Bundle();

                // place data in bundle and then in intent
                bundle.putSerializable("data", playerData);
                intent.putExtras(bundle);

                // start activity
                startActivity(intent);


            }
        });
    }
}
