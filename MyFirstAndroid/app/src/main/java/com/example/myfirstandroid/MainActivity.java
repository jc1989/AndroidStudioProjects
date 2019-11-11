package com.example.myfirstandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    public void onClick(View v) {

    }

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt=(TextView) findViewById(R.id.words);
        btn =(Button) findViewById(R.id.btnClick);

        btn.setOnClickListener(
                new Button.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        TextView mytext = (TextView) findViewById(R.id.words);
                        mytext.setText("You clicked me!");
                    }
                }
        );
    }
}

