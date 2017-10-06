package com.ffl.vibe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.ffl.vibe.R;

public class SignupActivity extends AppCompatActivity {
TextView tvlink_login;
    EditText edtlastname;
    EditText edtfirstname;
    EditText edtemail;
    EditText edtphone;
    EditText edtpassword;
    EditText edtconfirmpass;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtlastname=(EditText)findViewById(R.id.etlastname);
        edtfirstname=(EditText)findViewById(R.id.etfirstname);
        edtemail=(EditText)findViewById(R.id.etemail);
        edtphone=(EditText)findViewById(R.id.etphone);
        edtpassword=(EditText)findViewById(R.id.etpassword);
        edtconfirmpass=(EditText)findViewById(R.id.etconfirmPassword);
        btnsignup=(Button) findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lastname= edtlastname.getText().toString();
                String Firstname= edtfirstname.getText().toString();
                String Email=edtemail.getText().toString();
                String phone=edtphone.getText().toString();
                String Password =edtpassword.getText().toString();
                String ConfirmPass=edtconfirmpass.getText().toString();
                BackendlessUser User=new BackendlessUser();
                User.setProperty("lastname",Lastname);
                User.setProperty("firstname",Firstname);
                User.setProperty("email",Email);
                User.setProperty("phone",phone);
                User.setPassword(Password);
                if (Password.equals(ConfirmPass)) {
                    Backendless.UserService.register(User, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {
                            Toast.makeText(SignupActivity.this, "Promotor Created", Toast.LENGTH_LONG).show();
                            clearEdittext();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(SignupActivity.this, "Register Failed" + fault.getCode(), Toast.LENGTH_LONG).show();
                            Log.d("LOGIN", fault.getMessage());
                            Log.d("LOGIN", fault.getDetail());
                        }
                    });
            }
                else {
                    Toast.makeText(SignupActivity.this, "Password should be same", Toast.LENGTH_LONG).show();}
            }
        });

        tvlink_login=(TextView)findViewById(R.id.tvlink_login);
        tvlink_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void clearEdittext()
    {
        edtlastname.setText("");
        edtfirstname.setText("");
        edtconfirmpass.setText("");
        edtemail.setText("");
        edtpassword.setText("");
        edtphone.setText("");
    }
}
