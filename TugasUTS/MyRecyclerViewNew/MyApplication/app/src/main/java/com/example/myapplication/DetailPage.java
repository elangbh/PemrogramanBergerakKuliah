package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailPage extends AppCompatActivity {
    ImageView imgDetail;
    TextView tvIsi, tvJudul;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
//          imgDetail = findViewById(R.id.img_detail_page);
//          tvIsi = findViewById(R.id.tv_isi_detail_page);
//          tvJudul = findViewById(R.id.tv_judul_detail_page);

//          String judul = getIntent().getStringExtra("judul");
//          tvJudul.setText(judul);
//          String isi = getIntent().getStringExtra("isi");
//          tvIsi.setText(isi);
        getIncomingIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }




    private void getIncomingIntent(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("judul") && getIntent().hasExtra("isi")){
            String imageURL = getIntent().getStringExtra("image_url");
            String judul = getIntent().getStringExtra("judul");
            String isi = getIntent().getStringExtra("isi");

            setImage(imageURL, judul, isi);
            getSupportActionBar().setTitle(judul);
        }
    }
    private void setImage(String imageURL, String judul, String isi){
//        Toast.makeText(this, imageURL, Toast.LENGTH_SHORT).show();
        TextView name = findViewById(R.id.tv_judul_detail_page);
        name.setText(judul);

        TextView desc = findViewById(R.id.tv_isi_detail_page);
        desc.setText(isi);

        ImageView image = findViewById(R.id.img_detail_page);
        Glide.with(this)
                .load(imageURL)
                .into(image);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;}


}
