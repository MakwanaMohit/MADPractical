package com.mk.madpractical;

import com.google.zxing.Result;


import android.widget.Toast;

import com.google.zxing.Result;

public class ProcessData implements Runnable{
    Result result;
    Scanner context;
    public ProcessData(Result result,Scanner context){
        this.result = result;
        this.context = context;
    }
    @Override
    public void run() {
        context.xmlParser.parseAndInsertData(result.toString());
        Toast.makeText(context, "Data added to the database", Toast.LENGTH_SHORT).show();

    }
}
