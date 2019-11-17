package com.example.introandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{


    public void onClick(View v){
        EditText txtInput = (EditText) findViewById(R.id.txtInput);
        Editable display = txtInput.getText();
        if((display.toString()).isEmpty())
            displayToast("Please enter a value!");

        TextView lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        lblDisplay.setText(display);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
        switch (checkedId){
            case R.id.btnDegF:
                lblOutput.setText("You chose Fahrenheit");
                break;
            case R.id.btnDegC:
                lblOutput.setText("You chose Celsius");
                break;
            case R.id.btnDegK:
                lblOutput.setText("You chose Kelvin");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set Listener
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
            tempGroup.setOnCheckedChangeListener(this);
    }



private void displayToast(String message){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
}}
