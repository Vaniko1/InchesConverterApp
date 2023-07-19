package com.vinnorman.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;

    Button calculateButton;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = inchesEditText.getText().toString();
                if (inchesText.isEmpty()) {
                    resultTextView.setText("");
                    Toast.makeText(MainActivity.this, "Please enter a value!", Toast.LENGTH_SHORT).show();
                } else {
                    int inches = Integer.parseInt(inchesText);
                    double meters = convertToMeters(inches);
                    DecimalFormat myFormatter = new DecimalFormat("0.00");
                    String metersText = myFormatter.format(meters);
                    resultTextView.setText(inchesText + " Inch = " + metersText + " meters");
                    Toast.makeText(MainActivity.this, "Converted Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findViews() {
        inchesEditText = findViewById(R.id.inchesEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private double convertToMeters(int inches) {
        return inches * 0.0254;
    }


}