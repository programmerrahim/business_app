package com.home.myhomebussinessdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.home.myhomebussinessdemo.Prevalent.Prevalent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivity extends AppCompatActivity
 {
     private EditText nameEditText,phoneEditText,addressEditText,cityEditText;
     private Button confirmOrderBtn;

     private String totolAmount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);


        totolAmount = getIntent().getStringExtra("Total Price");
        Toast.makeText(ConfirmFinalOrderActivity.this,"Total amount = Tk."+totolAmount,Toast.LENGTH_LONG).show();

        confirmOrderBtn = findViewById(R.id.confirm_final_order_btn);
        nameEditText = findViewById(R.id.shipment_name);
        phoneEditText = findViewById(R.id.shipment_phone_number);
        addressEditText = findViewById(R.id.shipment_address);
        cityEditText = findViewById(R.id.shipment_city);

        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check();
            }
        });
    }




     private void check()
     {
         if (TextUtils.isEmpty(nameEditText.getText().toString()))
         {
             Toast.makeText(ConfirmFinalOrderActivity.this,"Please provide  your full name",Toast.LENGTH_LONG).show();
         }

         else if (TextUtils.isEmpty(phoneEditText.getText().toString()))
         {
             Toast.makeText(ConfirmFinalOrderActivity.this,"Please provide  your phone name",Toast.LENGTH_LONG).show();
         }
         else if (TextUtils.isEmpty(addressEditText.getText().toString()))
         {
             Toast.makeText(ConfirmFinalOrderActivity.this,"Please provide  your address",Toast.LENGTH_LONG).show();
         }
         else if (TextUtils.isEmpty(cityEditText.getText().toString()))
         {
             Toast.makeText(ConfirmFinalOrderActivity.this,"Please provide  your city name",Toast.LENGTH_LONG).show();
         }
         else
             {
                 confirmOrder();
             }
     }


     private void confirmOrder()
     {
        final String saveCurrentTime,saveCurrentDate;

         Calendar callForDate = Calendar.getInstance();
         SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd,yyy");
         saveCurrentDate = currentDate.format(callForDate.getTime());

         SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
         saveCurrentTime = currentDate.format(callForDate.getTime());

         final DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference()
                 .child("Orders")
                 .child(Prevalent.currentOnlineUser.getPhone());

         HashMap<String,Object>ordersMap = new HashMap<>();

         ordersMap.put("totalAmount",totolAmount);
         ordersMap.put("name",nameEditText.getText().toString());
         ordersMap.put("phone",phoneEditText.getText().toString());
         ordersMap.put("address",addressEditText.getText().toString());
         ordersMap.put("citty",cityEditText.getText().toString());
         ordersMap.put("date",saveCurrentDate);
         ordersMap.put("time",saveCurrentTime);
         ordersMap.put("state","not shipped");

         ordersRef.updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete(@NonNull Task<Void> task)
             {
                 if (task.isSuccessful())
                 {
                     FirebaseDatabase.getInstance().getReference()
                             .child("Cart List")
                             .child("User View")
                             .child(Prevalent.currentOnlineUser.getPhone())
                             .removeValue()
                             .addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task)
                                 {
                                     if (task.isSuccessful())
                                     {
                                         Toast.makeText(ConfirmFinalOrderActivity.this,"Your final order has been placed successfully.",Toast.LENGTH_LONG).show();
                                         Intent intent = new Intent(ConfirmFinalOrderActivity.this,HomeActivity.class);
                                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                         startActivity(intent);
                                         finish();
                                     }
                                 }
                             });
                 }
             }
         });

     }
 }
