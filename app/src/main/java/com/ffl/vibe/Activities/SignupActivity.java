package com.ffl.vibe.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.ffl.vibe.R;

public class SignupActivity extends AppCompatActivity {
TextView tvlink_login;
    ImageView ivprofil;
    TextView tvaddprofil;
    EditText edtfullname;
    EditText edtemail;
    EditText edtphone;
    EditText edtpassword;
    EditText edtconfirmpass;
    Button btnsignup;
    Uri imageUri;
    private  static  final int PICK_IMAGE=100;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK && requestCode==PICK_IMAGE)
        {
            imageUri=data.getData();

            ivprofil.setImageURI(imageUri);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edtfullname=(EditText)findViewById(R.id.etfullname);
        edtemail=(EditText)findViewById(R.id.etemail);
        edtphone=(EditText)findViewById(R.id.etphone);
        edtpassword=(EditText)findViewById(R.id.etpassword);
        edtconfirmpass=(EditText)findViewById(R.id.etconfirmPassword);
        ivprofil=(ImageView) findViewById(R.id.ivprofil);
        tvaddprofil=(TextView) findViewById(R.id.tvaddprofil);
        tvaddprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery,PICK_IMAGE);
            }
        });
        btnsignup=(Button) findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fullname= edtfullname.getText().toString();
                String Email=edtemail.getText().toString();
                String phone=edtphone.getText().toString();
                String Password =edtpassword.getText().toString();
                String ConfirmPass=edtconfirmpass.getText().toString();
                BackendlessUser User=new BackendlessUser();
                User.setProperty("fullname",Fullname);
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
        edtfullname.setText("");
        edtconfirmpass.setText("");
        edtemail.setText("");
        edtpassword.setText("");
        edtphone.setText("");
        ivprofil.setImageResource(R.drawable.userpic);
    }

}
