package com.example.gobuy2;
import android.graphics.Point;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
//要設定publc class
public class pointActivity extends AppCompatActivity {
    ImageView x_iv;
    RecyclerView recyclerView;
    TextView sum_tv;
    ListAdapter listAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    static String[] store = {"吃飽屋", "草本屋", "夢想家"};
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    public int sum = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        makeData();
        //設置recycleview
        recyclerView = findViewById(R.id.Data_rcview_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        listAdapter = new ListAdapter(arrayList, this);
        recyclerView.setAdapter(listAdapter);
        //設定查看第幾筆到第幾筆的spinner
        Spinner spinner = (Spinner) findViewById(R.id.data_sp);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"1~10", "11~20", "21~30", "31~40"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //x 返回鍵
        x_iv = findViewById(R.id.data_x_iv);
        x_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //下拉更新的物件綁定跟清除資料最後結束轉圈圈
        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.blue));
        swipeRefreshLayout.setOnRefreshListener(() -> {
            arrayList.clear();
            makeData();
            listAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);

        });
    }
    //每次下拉更新做的事
    private void makeData() {
        //recycleview四個Textview 雜湊值
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (i < 3) {
                int point = new Random().nextInt(10000);
                sum += point;
                hashMap.put("day", String.valueOf(new Random().nextInt(200) + 1900) + "/" + String.valueOf(new Random().nextInt(11) + 1) + "/" + String.valueOf(new Random().nextInt(29) + 1));
                hashMap.put("store", String.valueOf(store[new Random().nextInt(3)]));
                hashMap.put("time", String.valueOf(new Random().nextInt(23)) + ":" + String.valueOf(new Random().nextInt(59)));
                hashMap.put("point", "+" + String.valueOf(point));
            } else {

            }
            arrayList.add(hashMap);
        }
        sum_tv = findViewById(R.id.point_sum);
        sum_tv.setText(String.valueOf(sum));
    }
}
