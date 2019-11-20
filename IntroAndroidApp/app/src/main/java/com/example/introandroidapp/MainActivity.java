package com.example.introandroidapp;

import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, OnClickListener{

    //Declare Variables
    private RadioButton btnFah;
    private RadioButton btnCel;
    private RadioButton btnKel;
    private EditText txtInputTemp;
    private TextView lblOutputDegF;
    private TextView lblOutputDegC;
    private TextView lblOutputDegK;
    private Button btnConvert;


    public void onClick(View v){

        //Get resources for radio buttons, text boxes, and labels
        btnFah = (RadioButton) findViewById(R.id.btnDegF);
        btnCel = (RadioButton) findViewById(R.id.btnDegC);
        btnKel = (RadioButton) findViewById(R.id.btnDegK);
        txtInputTemp = (EditText) findViewById(R.id.txtInputTemp);
        lblOutputDegC = (TextView) findViewById(R.id.lblOutputC);
        lblOutputDegF = (TextView) findViewById(R.id.lblOutputF);
        lblOutputDegK = (TextView) findViewById(R.id.lblOutputK);

        //Convert the input temperature to double
        double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));
        double answer=0;

        //If the user choose Fahrenheit, convert to Celsius and Kelvin and display in those text boxes
        if(btnFah.isChecked()) {
            lblOutputDegF.setText(temp+" degrees F");
            lblOutputDegC.setText((Math.round((temp-32)*5/9*100.0)/100.0)+" degrees C");
            lblOutputDegK.setText((Math.round((temp+459.67)*5/9*100.0)/100.0)+" degrees K");
        }

        //If the user choose Celsius, convert to Fahrenheit and Kelvin and display in those text boxes
        if(btnCel.isChecked()) {
            lblOutputDegF.setText((Math.round(((temp*9)/5+32)*100.0)/100.0)+" degrees F");
            lblOutputDegC.setText(temp+" degrees C");
            lblOutputDegK.setText((Math.round((temp+273.15)*100.0)/100.0)+" degrees K");
        }

        //If the user choose Kelvin, convert to Fahrenheit and Celsius and display in those text boxes
        if(btnKel.isChecked()) {
            lblOutputDegF.setText((Math.round((temp*9/5-459.67)*100.0)/100.0)+" degrees F");
            lblOutputDegC.setText((Math.round((temp-273.15)*100.0)/100.0)+" degrees C");
            lblOutputDegK.setText(temp+" degrees K");
        }


//        if((displayToast(double temperature)).isEmpty())
//            displayToast("Please enter a value!");

        if(btnFah.isChecked()) {
            lblOutputDegF.setText(temp+" degrees F");
            lblOutputDegC.setText((Math.round((temp-32)*5/9*100.0)/100.0)+" degrees C");
            lblOutputDegK.setText((Math.round((temp+459.67)*5/9*100.0)/100.0)+" degrees K");

            answer = (temp-32)*5/9;

        }

        //If the user choose Celsius, convert to Fahrenheit and Kelvin and display in those text boxes

        if(btnCel.isChecked()) {

            lblOutputDegF.setText((Math.round(((temp*9)/5+32)*100.0)/100.0)+" degrees F");
            lblOutputDegC.setText(temp+" degrees C");
            lblOutputDegK.setText((Math.round((temp+273.15)*100.0)/100.0)+" degrees K");

            answer = temp;

        }


        //If the user choose Kelvin, convert to Fahrenheit and Celsius and display in those text boxes

        if(btnKel.isChecked()) {

            lblOutputDegF.setText((Math.round((temp*9/5-459.67)*100.0)/100.0)+" degrees F");
            lblOutputDegC.setText((Math.round((temp-273.15)*100.0)/100.0)+" degrees C");
            lblOutputDegK.setText(temp+" degrees K");

            answer = temp-273.15;

        }


        displayToast(answer);


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
        switch (checkedId){
            case R.id.btnDegF:
                lblOutput.setText("You chose Fahrenheit!");
                break;
            case R.id.btnDegC:
                lblOutput.setText("You chose Celsius!");
                break;
            case R.id.btnDegK:
                lblOutput.setText("You chose Kelvin!");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set listener
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }


private void displayToast(double temperature){
        if(temperature > 50)
            Toast.makeText(this, "Wow, its hot outside!", Toast.LENGTH_LONG).show();
        else if(temperature > 20)
            Toast.makeText(this, "Nice weather we are having.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Brrrrrr - It's cold outside.", Toast.LENGTH_LONG).show();
}
}
