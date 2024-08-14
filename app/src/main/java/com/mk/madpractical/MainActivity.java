package com.mk.madpractical;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] tutorials = {
            "About: Author | Source code",
            "Practical-01: Setup Android Studio & Hello World",
            "Practical-02: Activity Lifecycle Demo App",
            "Practical-03: Basic Calculator App",
            "Practical-04: LinearLayout UI Arrangement",
            "Practical-05: RelativeLayout UI Arrangement",
            "Practical-06: ScrollView for Long Lists",
            "Practical-07: ListView with Custom Adapter",
            "Practical-08: Navigation Drawer Implementation",
            "Practical-09: Bottom Navigation Tabs",
            "Practical-10: Intent for Data Passing",
            "Practical-11: Background Tasks with Services",
            "Practical-12: Broadcast Receivers Usage",
            "Practical-13: Data Sharing with Content Providers",
            "Practical-14: Access System Data with Content Providers",
            "Practical-15: SQLite DB: Insert & Read Data",
            "Practical-16: SQLite DB: Update & Delete Data",
            "Practical-17: Firebase Integration & Data Storage",
            "Practical-18: Firebase Data Display in RecyclerView",
            "Practical-19: MySQL Connection & Data Insertion",
            "Practical-20: MySQL Data Insertion via PHP",
            "Practical-21: Read MySQL Data via PHP & JSON",
            "Practical-22: Google Maps API: Display Location",
            "Practical-23: Google Maps API: Distance Calculation",
            "Practical-24: Google Account Login Integration"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        l = findViewById(R.id.practicallist);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tutorials);
        l.setAdapter(arr);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent about = new Intent(MainActivity.this,about.class);
                        startActivity(about);
                        break;
                    case 1:
                        Intent pr1 = new Intent(MainActivity.this,Practical1.class);
                        startActivity(pr1);
                        break;
                    case 2:
                        Intent pr2 = new Intent(MainActivity.this,Practical2.class);
                        startActivity(pr2);
                        break;
                    case 3:
                        Intent pr3 = new Intent(MainActivity.this,Practical2.class);
                        startActivity(pr3);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Practical: "+i+" is comming soon", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
