package com.hu.bmi6;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_info);
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("身高體重指數（又稱身體質量指數，英文為Body Mass Index，簡稱BMI）是一個計算值，主要用於統計用途。")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    public void bmi (View view){
        Log.d("MainActivity" , "testing bmi method");
        EditText weight = (EditText) findViewById(R.id.ed_weight);
        EditText height = (EditText) findViewById(R.id.ed_height);
        float w = Float.parseFloat(weight.getText().toString());
        float h  =Float.parseFloat(height.getText().toString());
        float bmi = w / (h * h);
        if (bmi < 20){
            new AlertDialog.Builder(this)
                    .setMessage("your bmi is " + bmi + "請多吃點")
                    .setTitle(R.string.bmi)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("your bmi is " + bmi)
                    .setTitle(R.string.bmi)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }

    }


}
