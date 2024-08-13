package com.example.gobuy2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button yes_button,clear_button;
    EditText phone_et,email_et,pw_et,birthday_et;
    CheckBox checkBox;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //國籍的下拉選單
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"台灣", "中國", "日本", "韓國"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //綁定xml相對應的物件
        clear_button=findViewById(R.id.main_clear_button);
        phone_et = findViewById(R.id.main_phone_et);
        email_et = findViewById(R.id.main_email_et);
        pw_et = findViewById(R.id.main_pw_et);
        birthday_et = findViewById(R.id.main_birthday_et);
        yes_button = findViewById(R.id.main_yes_button);
        checkBox=findViewById(R.id.checkBox);
        //三個點擊事件
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked()){
                    yes_button.setEnabled(true);
                }
                else yes_button.setEnabled(false);
            }
        });
        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nonnull((phone_et.getText().toString()))) {
                    if (nonnull(email_et.getText().toString())) {
                        if (nonnull(pw_et.getText().toString())) {
                            if (nonnull(birthday_et.getText().toString())) {
                                Intent intent = new Intent(MainActivity.this, shoppingActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(context,"請輸入出生日期",Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(context,"請輸入密碼",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(context,"請輸入電子信箱",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(context,"請輸入手機1",Toast.LENGTH_SHORT).show();
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_et.setText("");;
                email_et.setText("");
                pw_et.setText("");
                birthday_et.setText("");
            }
        });




    }
    public static boolean nonnull(String s) {
        if (s != null && !"".equals(s.trim())  )
        {
            return true;
        }
        return false;
    }
}