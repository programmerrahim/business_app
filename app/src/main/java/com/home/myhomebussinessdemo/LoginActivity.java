package com.home.myhomebussinessdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.home.myhomebussinessdemo.Model.Users;
import com.home.myhomebussinessdemo.Prevalent.Prevalent;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    private EditText loginPhoneButton, loginPasswordButton;
    private Button loginButton;
    private ProgressDialog loadingBar;
    private TextView adminLink,notAdminLink;

    private String parentDbName = "Users";

    private CheckBox checkBoxRemmemberMe;


//Main Method Starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.setTitle("User Login");

        loginPhoneButton = findViewById(R.id.loginPhoneButtonId);
        loginPasswordButton = findViewById(R.id.loginPasswordButtonId);
        loginButton = findViewById(R.id.userLoginButtonId);
        adminLink = findViewById(R.id.admin_panel_linkId);
        notAdminLink = findViewById(R.id.not_admin_panel_linkId);
        checkBoxRemmemberMe = findViewById(R.id.rememberButtonId);

        Paper.init(this);

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
                Intent adminintent = new Intent(LoginActivity.this,AdminLoginActivity.class);
                startActivity(adminintent);
            }
        });




    }

    //Login User Method Starts
    private void loginUser() {
        String phone = loginPhoneButton.getText().toString().trim();
        String password = loginPasswordButton.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Please write your phone number.", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please write your password.", Toast.LENGTH_LONG).show();
        }
        else {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please wait while we are checking the informations.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(phone,password);
        }
    }

    //Login Method Ends

    // Allow Access Account Method Starts
    private void AllowAccessToAccount(final String phone, final String password) {

        if (checkBoxRemmemberMe.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey,phone);
            Paper.book().write(Prevalent.UserPasswordKey,password);
        }


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child(phone).exists()){
                    Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);

                    if (usersData.getPhone().equals(phone)){
                        if (usersData.getPassword().equals(password)){

                             if (parentDbName.equals("Users")){
                                Toast.makeText(LoginActivity.this,"Login is Successfull",Toast.LENGTH_LONG).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                Prevalent.currentOnlineUser = usersData;
                                startActivity(intent);
                            }

                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Password is Incorrect!!!",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"Account with this "+phone+" number do not exists",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LoginActivity.this,"Error :",Toast.LENGTH_LONG).show();

            }
        });
    }
    //Allow Access Account Method Starts

    //Main Method Ends
}
