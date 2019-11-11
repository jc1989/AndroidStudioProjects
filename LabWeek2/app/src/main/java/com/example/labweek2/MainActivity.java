package com.example.labweek2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    @Override
    public void onClick(View v) {
        //get Text from edit Text
        //Display text in text view
        EditText txtInput = (EditText) findViewById(R.id.txtInput);
        Editable display = txtInput.getText();
        TextView lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        lblDisplay.setText(display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick=(Button) findViewById(R.id.btnClick);
        btnClick.setOnClickListener(this);
    }
}
