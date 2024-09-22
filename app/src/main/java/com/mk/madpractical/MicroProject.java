package com.mk.madpractical;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//import java.util.logging.Handler;

public class MicroProject extends AppCompatActivity {
    public static final String BROCAST_INTENT_FILTER = "com.mk.MainBrodcast";
    private Button scan, view, upload;
    private EditText urlEdit;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_micro_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        scan = findViewById(R.id.scan);
        view = findViewById(R.id.view);
        upload = findViewById(R.id.upload);
        urlEdit = findViewById(R.id.url);
        dbHelper = new DatabaseHelper(this);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scanIntent = new Intent(MicroProject.this, Scanner.class);
                startActivity(scanIntent);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(MicroProject.this, ViewData.class);
                startActivity(viewIntent);
            }
        });
    }


    private void uploadData() {
//        String urlString = urlEdit.getText().toString().trim();
        String urlString = "https://codewithmk.site/.netlify/functions/AdharData";

        if (!TextUtils.isEmpty(urlString)) {
            if (!urlString.startsWith("http://") && !urlString.startsWith("https://")) {
                urlString = "https://" + urlString;  // Prepend "http://" if missing
            }

            JSONArray jsonData = dbHelper.getDataAsJsonArray();

            for (int i = 0; i < jsonData.length(); i++) {
                try {
                    String json = jsonData.getJSONObject(i).toString();
                    OkHttpClient client = new OkHttpClient();

                    // Create the JSON request body
                    RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

                    // Build the request


                    Request request = new Request.Builder()
                            .url(urlString)
                            .post(body)  // Use POST method
                            .build();
                    int c = 89;

                    // Execute the request asynchronously
                    client.newCall(request).enqueue(new okhttp3.Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            int a = 10;
                            e.printStackTrace();

                            // Handle the error here
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try {
                                if (response.isSuccessful()) {
                                    // Handle the successful response here
                                    // Process the response if needed
                                    String responseBody = response.body().string();

                                    int a = 10;//                            Toast.makeText(MicroProject.this, responseBody, Toast.LENGTH_SHORT).show();
                                } else {
                                    int a = 20;
                                    // Handle the unsuccessful response here
                                    //                            Toast.makeText(MicroProject.this, "Unsucessful", Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception e) {
                                //                        Toast.makeText(MicroProject.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                int o = 90;
                            }
                        }
                    });
                } catch (Exception e) {
                    int j = 89;
                }
            }
        }
    }
}
