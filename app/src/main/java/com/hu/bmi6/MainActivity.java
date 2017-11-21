package com.hu.bmi6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    private EditText weight;
    private EditText height;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity" , "onCreate");
        bHelp = (Button) findViewById(R.id.b_info);
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
        findView();
    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity" , "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity" , "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity" , "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity" , "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity" , "onResume");
    }

    private void findView() {
        weight = (EditText) findViewById(R.id.ed_weight);
        height = (EditText) findViewById(R.id.ed_height);
    }

    public void bmi (View view){
        Log.d("MainActivity" , "testing bmi method");

        float w = Float.parseFloat(weight.getText().toString());
        float h  =Float.parseFloat(height.getText().toString());

        Intent intent = new Intent(this , ResultActivity.class);
        intent.putExtra("BMI_EXTRA" , R.string.bmi);
        startActivity(intent);

        if (h >= 3){
            new AlertDialog.Builder(this)
                    .setMessage(R.string.error)
                    .setTitle(R.string.bmi)
                    .setPositiveButton(R.string.ok , null)
                    .show();
        }else{
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
}