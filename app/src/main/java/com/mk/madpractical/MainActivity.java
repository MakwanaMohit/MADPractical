package com.mk.madpractical;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    ListView l;
    String[] Practicals = {
            "About: Author | Source code",
            "Microproject: Adhar Data",
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
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Practicals);
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
                        Intent micro = new Intent(MainActivity.this, MicroProject.class);
                        startActivity(micro);
                        break;
                    case 2:
                        Intent pr1 = new Intent(MainActivity.this,Practical1.class);
                        startActivity(pr1);
                        break;
                    case 3:
                        Intent pr2 = new Intent(MainActivity.this,Practical2.class);
                        startActivity(pr2);
                        break;
                    case 4:
                        Intent pr3 = new Intent(MainActivity.this,Practical3.class);
                        startActivity(pr3);
                        break;
                    case 5:
                        Intent pr4 = new Intent(MainActivity.this,Practical4.class);
                        startActivity(pr4);
                        break;
                    case 6:
                        Intent pr5 = new Intent(MainActivity.this,Practical5.class);
                        startActivity(pr5);
                        break;
                    case 7:
                        Intent pr6 = new Intent(MainActivity.this,Practical6.class);
                        startActivity(pr6);
                        break;
                    case 8:
                        Intent pr7 = new Intent(MainActivity.this,Practical7.class);
                        startActivity(pr7);
                        break;
                    case 9:
                        Intent pr8 = new Intent(MainActivity.this,Practical8.class);
                        startActivity(pr8);
                        break;
                    case 10:
                        Intent pr9 = new Intent(MainActivity.this,Practical9.class);
                        startActivity(pr9);
                        break;
                    case 11:
                        showInputDialog();
                        break;
                    case 12:
                        Intent pr11 = new Intent(MainActivity.this,Practical11.class);
                        startActivity(pr11);
                        break;


                    default:
                        Toast.makeText(MainActivity.this, "Practical: "+(i-1)+" is comming soon", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    private void showInputDialog() {
        // Create EditText programmatically
        final EditText editTextInput = new EditText(this);
        editTextInput.setHint("Enter your text");
        editTextInput.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        new AlertDialog.Builder(this)
                .setTitle("Enter your text")
                .setView(editTextInput)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputText = editTextInput.getText().toString();
                        Intent pr10 = new Intent(MainActivity.this,Practical10.class);
                        pr10.putExtra("MSG",inputText);
                        startActivity(pr10);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
