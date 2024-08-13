package com.example.gobuy2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settingActivity extends AppCompatActivity {
    private ImageView x_iv;

    private Context Context;
    private SeekBar seekBar;
    private TextView textView;
    private Spinner course;
    String[] Subject = new String[] {"英文","國文","數學"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);
        //返回健
        x_iv=findViewById(R.id.fun_x_iv);
        x_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Context = settingActivity.this;
        bindViews();

        course = findViewById(R.id.fun_lan_sp);
        String[] Subject = new String[] {"中國","台灣","日本","美國"};
        ArrayAdapter<String> adapterSubject = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Subject);
        adapterSubject.setDropDownViewResource(android.R.layout.simple_spinner_item);
        course.setAdapter(adapterSubject);
    }

    private void bindViews() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("目前數值:" + progress + "  / 100 ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Context, "按住SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Context, "放開SeekBar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}