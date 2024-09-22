package com.mk.madpractical;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MyCustomView extends LinearLayout {

    private TextView customText;
    private ImageView customImage;

    public MyCustomView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.custom_layout, this, true);

        customText = findViewById(R.id.customText);
        customImage = findViewById(R.id.customImage);
    }

    public void setCustomText(String text) {
        customText.setText(text);
    }

    public void setCustomImage(int resourceId) {
        customImage.setImageResource(resourceId);
    }
    public void setCustomImage (Bitmap bitmap){
        customImage.setImageBitmap(bitmap);
    }

    public Bitmap createBitmapWithLetter(String letter, int color) {
        if (letter.length() > 3){
            letter = letter.substring(0,3);
        }
        // Create a Bitmap
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // Set the background color
        canvas.drawColor(color);

        // Draw the text
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);

        Rect bounds = new Rect();
        paint.getTextBounds(letter, 0, letter.length(), bounds);

        int x = (bitmap.getWidth() / 2);
        int y = (int) ((bitmap.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));

        canvas.drawText(letter, x, y, paint);

        return bitmap;
    }

    public int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
