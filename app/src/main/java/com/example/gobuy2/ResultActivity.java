package com.example.gobuy2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jetbrains.annotations.Nullable;

public class ResultActivity extends AppCompatActivity {
    private ImageView re_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();


        String store=intent.getStringExtra("store");
        TextView re_store= (TextView) findViewById(R.id.result_store);
        re_store.setText(String.valueOf(store));

        String day=intent.getStringExtra("day");
        TextView re_day= (TextView) findViewById(R.id.result_day);
        re_day.setText(String.valueOf(day));

        String time=intent.getStringExtra("time");
        TextView re_time= (TextView) findViewById(R.id.result_time);
        re_time.setText(String.valueOf(time));

        String point=intent.getStringExtra("point");
        TextView re_point= (TextView) findViewById(R.id.result_point);
        re_point.setText(String.valueOf(point));

        re_x=findViewById(R.id.res_x);
        re_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}