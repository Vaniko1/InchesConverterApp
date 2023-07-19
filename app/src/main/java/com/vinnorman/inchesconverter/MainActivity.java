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

    Button metersButton;

    Button centimetersButton;

    Button millimetersButton;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateToMeters();
        calculateToCentimeters();
        calculateToMillimeters();
    }

    private void calculateToMillimeters() {
        millimetersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = inchesEditText.getText().toString();
                if (inchesText.isEmpty()) {
                    resultTextView.setText("");
                    Toast.makeText(MainActivity.this, "Please enter a value!", Toast.LENGTH_SHORT).show();
                } else {
                    int inches = Integer.parseInt(inchesText);
                    double meters = convertToMillimeters(inches);
                    DecimalFormat myFormatter = new DecimalFormat("0.00");
                    String metersText = myFormatter.format(meters);
                    resultTextView.setText(inchesText + " Inch = " + metersText + " millimeters");
                    Toast.makeText(MainActivity.this, "Converted Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculateToCentimeters() {
        centimetersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = inchesEditText.getText().toString();
                if (inchesText.isEmpty()) {
                    resultTextView.setText("");
                    Toast.makeText(MainActivity.this, "Please enter a value!", Toast.LENGTH_SHORT).show();
                } else {
                    int inches = Integer.parseInt(inchesText);
                    double meters = convertToCentimeters(inches);
                    DecimalFormat myFormatter = new DecimalFormat("0.00");
                    String metersText = myFormatter.format(meters);
                    resultTextView.setText(inchesText + " Inch = " + metersText + " centimeters");
                    Toast.makeText(MainActivity.this, "Converted Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void calculateToMeters() {
        metersButton.setOnClickListener(new View.OnClickListener() {
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
        metersButton = findViewById(R.id.metersButton);
        centimetersButton = findViewById(R.id.centimetersButton);
        millimetersButton = findViewById(R.id.millimetersButton);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private double convertToMeters(int inches) {
        return inches * 0.0254;
    }

    private double convertToCentimeters(int inches) {
        return inches * 2.54;
    }

    private double convertToMillimeters(int inches) {
        return inches * 25.4;
    }



}