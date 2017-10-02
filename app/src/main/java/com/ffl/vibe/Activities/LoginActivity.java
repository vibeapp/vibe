package com.ffl.vibe.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ffl.vibe.R;

public class LoginActivity extends AppCompatActivity {
    CheckBox checkboxShowPassword;
    EditText username;
    EditText password;
    Button btnlogin;
    TextView tvsignup;
    TextView tvforget;
    final Context context = this;
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
        tvforget=(TextView)findViewById(R.id.tvforget);
        tvforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Forget Password", Toast.LENGTH_LONG).show();
                DialogForgetPassword();
            }
        });
    }
    public void DialogForgetPassword()
    {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View resetView = li.inflate(R.layout.dialog_resetpass, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Reset password");
        final EditText etphonereset=(EditText)resetView.findViewById(R.id.etphonereset);
        final EditText etppasswordreset=(EditText)resetView.findViewById(R.id.etpasswordreset);
        final EditText etconfirmreset=(EditText)resetView.findViewById(R.id.etconfirmpassreset);
        builder.setView(resetView);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Logout();
                //finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(LoginActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
