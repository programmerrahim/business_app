package com.home.myhomebussinessdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText loginPhoneButton, loginPasswordButton;
    private Button loginButton;
    private ProgressDialog loadingBar;
    private TextView adminLink,notAdminLink;


    private CheckBox checkBoxRemmemberMe;


    //Main Method Starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Admin Login");

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_admin_login);
        loginPhoneButton = findViewById(R.id.loginPhoneButtonId);
        loginPasswordButton = findViewById(R.id.loginPasswordButtonId);
        loginButton = findViewById(R.id.userLoginButtonId);
        adminLink = findViewById(R.id.admin_panel_linkId);
        notAdminLink = findViewById(R.id.not_admin_panel_linkId);
        checkBoxRemmemberMe = findViewById(R.id.rememberButtonId);



        loadingBar = new ProgressDialog(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        adminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adminintent = new Intent(AdminLoginActivity.this,LoginActivity.class);
                startActivity(adminintent);
            }
        });




    }

    //Login User Method Starts
    private void loginUser() {
        final String email = loginPhoneButton.getText().toString().trim();
        final String password = loginPasswordButton.getText().toString().trim();

        //cecking the validity of the email and password starts
        if (email.isEmpty()){
            loginPhoneButton.setError("Enter an email address");
            loginPhoneButton.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginPhoneButton.setError("Enter a valid email address");
            loginPhoneButton.requestFocus();
            return;
        }

        if (password.isEmpty()){
            loginPasswordButton.setError("Enter a password ");
            loginPasswordButton.requestFocus();
            return;
        }
        if (password.length()<6){
            loginPasswordButton.setError("Minimum length of password should be 6");
            loginPasswordButton.requestFocus();
            return;
        }
        //cecking the validity of the email and password ends
        loadingBar.setTitle("Login Account");
        loadingBar.setMessage("Please wait while we are checking the informations.");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login is successfull",Toast.LENGTH_LONG).show();
                    Intent loginintent = new Intent(getApplicationContext(),AdminCategoryActivity.class);
                    loginintent.addFlags(loginintent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginintent);
                    finish();
                    loadingBar.dismiss();
                }
                else {
                    loadingBar.dismiss();
                    Toast.makeText(getApplicationContext(),"Email/Password is incorrect",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    //Login Method Ends



    //Main Method Ends
}
