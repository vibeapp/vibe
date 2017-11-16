package com.ffl.vibe.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ffl.vibe.Models.EventEntity;
import com.ffl.vibe.R;
import com.squareup.picasso.Picasso;

public class DetailseventActivity extends AppCompatActivity {
  ImageView imgPoster;
    TextView tveventname;
    TextView tveventclub;
    TextView tveventprice;
    TextView tveventdate;
    TextView tveventguest;
    TextView tveventsponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsevent);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbardetailsevent);
          setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_returnback);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

      EventEntity event =(EventEntity) getIntent().getSerializableExtra("event");
       tveventname= (TextView)findViewById(R.id.tveventnamedetails);
        tveventname.setText(event.getEvent_name());

        tveventclub= (TextView)findViewById(R.id.tveventclubdetails);
        tveventclub.setText(event.getEvent_club());

        tveventprice= (TextView)findViewById(R.id.tveventpricedetails);
        tveventprice.setText(event.getEvent_price());

        tveventdate= (TextView)findViewById(R.id.tveventdatedetails);
        tveventdate.setText(event.getEvent_date());

        tveventguest= (TextView)findViewById(R.id.tveventguestdetails);
        tveventguest.setText(event.getEvent_guest());

        tveventsponsor= (TextView)findViewById(R.id.tveventsponsordetails);
        tveventsponsor.setText(event.getEvent_sponsor());

        imgPoster = (ImageView) findViewById(R.id.imgposterdetails);
        Picasso.with(this).load(event.getEvent_poster()).placeholder(R.drawable.vibe_logo).into(imgPoster);
       // Picasso.with(this).load(event.getEvent_poster()).into(imgPoster);
    }





}
