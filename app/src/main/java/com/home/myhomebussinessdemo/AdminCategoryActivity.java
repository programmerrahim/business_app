package com.home.myhomebussinessdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {
    private ImageView imageView_1,imageView_2,imageView_3,imageView_4;
    private ImageView imageView_5,imageView_6,imageView_7,imageView_8;
    private ImageView imageView_9,imageView_10,imageView_11,imageView_12;


    private Button logoutBtn,checkOrdersBtn;


    //Main Method Starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);


        logoutBtn = findViewById(R.id.admin_logout_btn);
        checkOrdersBtn = findViewById(R.id.check_orders_btn);


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        checkOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });

        this.setTitle("Admin Category");

        imageView_1 = findViewById(R.id.lp_gas_1);
        imageView_2 = findViewById(R.id.lp_gas_2);
        imageView_3 = findViewById(R.id.lp_gas_3);
        imageView_4 = findViewById(R.id.lp_gas_4);
        imageView_5 = findViewById(R.id.lp_gas_5);
        imageView_6 = findViewById(R.id.lp_gas_6);
        imageView_7 = findViewById(R.id.lp_gas_7);
        imageView_8 = findViewById(R.id.lp_gas_8);
        imageView_9 = findViewById(R.id.lp_gas_9);
        imageView_10 = findViewById(R.id.lp_gas_10);
        imageView_11 = findViewById(R.id.lp_gas_11);
        imageView_12 = findViewById(R.id.lp_gas_12);


        imageView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_1");
                startActivity(intent);
            }
        });

        imageView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_2");
                startActivity(intent);
            }
        });

        imageView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_3");
                startActivity(intent);
            }
        });

        imageView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_4");
                startActivity(intent);
            }
        });

        imageView_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_5");
                startActivity(intent);
            }
        });

        imageView_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_6");
                startActivity(intent);
            }
        });

        imageView_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_7");
                startActivity(intent);
            }
        });

        imageView_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_8");
                startActivity(intent);
            }
        });

        imageView_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_9");
                startActivity(intent);
            }
        });

        imageView_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_10");
                startActivity(intent);
            }
        });

        imageView_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_11");
                startActivity(intent);
            }
        });

        imageView_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this,AdminAddNewProductActivity.class);
                intent.putExtra("category","imageView_12");
                startActivity(intent);
            }
        });

    }

    //Main Method Ends
}
