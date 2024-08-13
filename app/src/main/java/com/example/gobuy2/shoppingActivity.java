package com.example.gobuy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class shoppingActivity extends AppCompatActivity {
    ImageView iv8;
    ImageView iv7;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping);
        iv8=findViewById(R.id.shop_8_iv);
        iv7=findViewById(R.id.shop_7_iv);
        iv1=findViewById(R.id.shop_1_iv);
        //到設定畫面
        iv8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(shoppingActivity.this,settingActivity.class);
                startActivity(intent1);
            }
        });
        //返回go buy
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(shoppingActivity.this,MainActivity.class);
                startActivity(intent2);
            }
        });
        //到紅利點數查詢畫面
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(shoppingActivity.this, pointActivity.class);
                startActivity(intent3);
            }
        });
    }
}