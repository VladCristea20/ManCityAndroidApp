package com.example.mancityactivityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView list = null;
    private DataAdapter adapter = null;
    private Squad squad=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        squad=new Squad(this);
        squad.PopulateSquad();

        list = findViewById(R.id.recycler_view);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setItemAnimator(new DefaultItemAnimator());

        // adapter
        adapter = new DataAdapter(this, R.layout.row_layout, squad,this);
        list.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int position) {
        // make an intent and a bundle
        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
        Bundle bundle = new Bundle();

        // get the data
        Player player=squad.getPlayerAt(position);
        bundle.putSerializable("data", player);
        intent.putExtras(bundle);

        // start activity
        startActivity(intent);
    }

}