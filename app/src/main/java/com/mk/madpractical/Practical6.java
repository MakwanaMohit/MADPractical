package com.mk.madpractical;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical6 extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        layout = findViewById(R.id.Pr6_ScrollView_Linearlayout);
        for (int i = 1; i < 31; i++) {
            MyCustomView view = new MyCustomView(this);
            view.setCustomImage(view.createBitmapWithLetter("P"+i,view.getRandomColor()));
            view.setCustomText("this is custom view no."+i);
            LinearLayout lay = (LinearLayout) view.findViewById(R.id.My_Custom_View_Layout);
            lay.setGravity(Gravity.CENTER);
            ImageView imageView = view.findViewById(R.id.customImage);
            int newWidthInDp = 100;  // For example 100dp
            int newHeightInDp = 100;

            float scale = getResources().getDisplayMetrics().density;
            int newWidthInPx = (int) (newWidthInDp * scale + 0.5f);
            int newHeightInPx = (int) (newHeightInDp * scale + 0.5f);

            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            params.width = newWidthInPx;
            params.height = newHeightInPx;
            imageView.setLayoutParams(params);
            layout.addView(view);

        }
    }
}