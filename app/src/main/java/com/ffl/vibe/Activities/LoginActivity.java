package com.ffl.vibe.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ffl.vibe.R;

public class LoginActivity extends AppCompatActivity {
    CheckBox checkboxShowPassword;
    EditText username;
    EditText password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //get the username EditText
        username=(EditText)findViewById(R.id.etusername);
        //get the password EditText
        password=(EditText)findViewById(R.id.etpassword);
        //get the checkbox show/hide password
        checkboxShowPassword = (CheckBox)findViewById(R.id.chkshowpassword);

        btnlogin=(Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "User Signed in", Toast.LENGTH_LONG).show();
            }
        });
        //add onCheckedListener on Checkbox
        //When user clicks on this checkbox this is the handler
        checkboxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Checkbox status is changed from unchecked to checked
                if(!isChecked){
                    //show password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                {
                    //hide password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }


            }
        });

    }


}
