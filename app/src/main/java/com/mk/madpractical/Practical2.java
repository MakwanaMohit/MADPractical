package com.mk.madpractical;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("PRACTICAL2","On Create called");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("PRACTICAL2","On Start called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("PRACTICAL2","On Resume called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PRACTICAL2","On Pause called");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("PRACTICAL2","On Stop called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("PRACTICAL2","On Restart called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("PRACTICAL2","On destroy called");
    }
}