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
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_info);
        bHelp.setOnClickListener(listener);
    }

    public void bmi (View view){
        Log.d("MainActivity" , "testing bmi method");
        EditText weight = (EditText) findViewById(R.id.ed_weight);
        EditText height = (EditText) findViewById(R.id.ed_height);
        float w = Float.parseFloat(weight.getText().toString());
        float h  =Float.parseFloat(height.getText().toString());
        float bmi = w / (h*h);
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setTitle(R.string.bmi)
                .setPositiveButton(R.string.ok,null)
                .show();
    }


}
