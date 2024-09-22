package com.mk.madpractical;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Practical7 extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.PR7_ListView);
        String[] arr = {"Mohit Makwana", "Neha Kavaiya", "Malav Solanki", "Harshil Kanzariya", "AdityaSingh Vaghela", "Rushbh Ughreja"};
        listView.setAdapter(new Pr7CustomAdapter(this, arr));


    }
}

class Pr7CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;

    public Pr7CustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Inflate custom layout for each list item
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current item
        String item = (String) getItem(position);
        // Set the text for the TextView
        holder.textView.setText(item);

        // Create an image based on the first 3 letters


        holder.imageView.setImageBitmap(createBitmapWithLetter(item, getRandomColor()));

        return convertView;
    }

 */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyCustomView view;
        if (convertView == null) {
            view = new MyCustomView(context);
        } else {
            view = (MyCustomView) convertView;
        }
        String item = (String) getItem(position);
        view.setCustomText(item);
        view.setCustomImage(view.createBitmapWithLetter(item, view.getRandomColor()));
        return (View) view;
    }
}
