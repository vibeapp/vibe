package com.ffl.vibe.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.ffl.vibe.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class CreateeventActivity extends AppCompatActivity {
    ImageView imgposternewevent;
    EditText edtneweventname;
    EditText edtneweventclub;
    EditText edtneweventdate;
    EditText edtneweventprice;
    EditText edtneweventguest;
    EditText edtneweventsponsor;
    private  String[]spinnerList = {"House party", "Dance Party", "Christmas Party","Back to School Party",
    "BBQ Party"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createevent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarnewevent);
        setSupportActionBar(toolbar);
        MaterialBetterSpinner spinner = (MaterialBetterSpinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateeventActivity.this,
                android.R.layout.simple_dropdown_item_1line,spinnerList);
        spinner.setAdapter(adapter);

    }
}
