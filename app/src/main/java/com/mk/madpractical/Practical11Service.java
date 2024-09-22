package com.mk.madpractical;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.IBinder;
import android.widget.Toast;

public class Practical11Service extends Service {

    private Thread thread;
    private boolean isServiceRunning;

    public Practical11Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder() {
            Practical11Service get_service() {
                return Practical11Service.this;
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isServiceRunning = true;

        // Create and start a new thread
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isServiceRunning) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Practical11Service.this, "Service is running", Toast.LENGTH_SHORT).show();
                        }
                    });

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!thread.isAlive()) {
            thread.start();  // Start the thread
        }
        return START_STICKY;  // Keep the service running
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceRunning = false;  // Stop the loop
        if (thread != null && thread.isAlive()) {
            thread.interrupt();  // Safely stop the thread
        }
    }
}