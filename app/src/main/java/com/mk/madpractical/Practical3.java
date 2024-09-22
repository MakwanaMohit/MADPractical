package com.mk.madpractical;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical3 extends AppCompatActivity {
    EditText n1, n2, Result;
    Button plus, minus, multi, division, modulus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical3);

        n1 = (EditText) findViewById(R.id.edt_1);
        n2 = (EditText) findViewById(R.id.edt_2);
        plus = (Button) findViewById(R.id.btn_plus);
        minus = (Button) findViewById(R.id.btn_minus);
        multi = (Button) findViewById(R.id.btn_multi);
        division = (Button) findViewById(R.id.btn_divi);
        modulus = (Button) findViewById(R.id.btn_modu);
        Result = (EditText) findViewById(R.id.result);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = 0, num2 = 0, ans = 0;
                try {
                    num1 = Integer.parseInt(n1.getText().toString());
                    num2 = Integer.parseInt(n2.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(Practical3.this, "Please enter a valid number for both", Toast.LENGTH_SHORT).show();
                }
                if (v.equals(plus)) {
                    ans = num1 + num2;
                    Result.setText("Result: " + ans);
                } else if (v.equals(minus)) {
                    ans = num1 - num2;
                    Result.setText("Result: " + ans);
                } else if (v.equals(multi)) {
                    ans = num1 * num2;
                    Result.setText("Result: " + ans);
                } else if (v.equals(division)) {
                    ans = num1 / num2;
                    Result.setText("Result: " + ans);
                } else if (v.equals(modulus)) {
                    ans = num1 % num2;
                    Result.setText("Result: " + ans);
                }
            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multi.setOnClickListener(listener);
        division.setOnClickListener(listener);
        modulus.setOnClickListener(listener);


    }


}