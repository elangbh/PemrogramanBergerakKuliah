package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlayers;
    private ArrayList<Player> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlayers = findViewById(R.id.rv_player);
        rvPlayers.setHasFixedSize(true);

        list.addAll(PlayersData.getListData());
        showRecyclerList();



    }


    private void showRecyclerList(){
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
        ListPlayerAdapter listPlayerAdapter = new ListPlayerAdapter(list);
        rvPlayers.setAdapter(listPlayerAdapter);
    }
    private void showRecyclerGrid(){
        rvPlayers.setLayoutManager(new GridLayoutManager(this, 2));
        GridPlayerAdapter gridHeroAdapter = new GridPlayerAdapter(list);
        rvPlayers.setAdapter(gridHeroAdapter);
    }
    private void showRecyclerCardView(){
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
        CardViewPlayerAdapter cardViewPlayerAdapter = new CardViewPlayerAdapter(list);
        rvPlayers.setAdapter(cardViewPlayerAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {

            case R.id.action_cardview:
                showRecyclerCardView();
                break;

            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_profil:
                Intent intent = new Intent(this, ProfilActivity.class);
                startActivity(intent);
                break;

        }
    }


}




