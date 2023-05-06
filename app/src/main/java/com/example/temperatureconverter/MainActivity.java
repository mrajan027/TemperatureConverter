package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtLabel, txtInputLabel, txtOutputLabel;
    private EditText txtInputValue, txtOutputValue;
    private Spinner spinnerInput, spinnerOutput;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLabel = findViewById(R.id.txtLabel);
        txtInputLabel = findViewById(R.id.txtInputLabel);
        txtOutputLabel = findViewById(R.id.txtOutputLabel);
        txtInputValue = findViewById(R.id.txtInputValue);
        txtOutputValue = findViewById(R.id.txtOutputValue);
        spinnerInput = findViewById(R.id.spinnerInput);
        spinnerOutput = findViewById(R.id.spinnerOutput);
        button1 = findViewById(R.id.button1);


        ArrayList<String> Unit = new ArrayList<>();
        Unit.add("Fahrenheit");
        Unit.add("Celsius");

        ArrayAdapter<String> TemperatureAdapter = new ArrayAdapter<>(

                this,
                android.R.layout.simple_spinner_dropdown_item,
                Unit
        );

        spinnerInput.setAdapter(TemperatureAdapter);
        spinnerOutput.setAdapter(TemperatureAdapter);


        spinnerInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String a = Unit.get(i);
                switch (a) {

                    case "Fahrenheit":
                        txtInputLabel.setText("Enter Temperature in Fahrenheit ");
                        break;

                    case "Celsius":
                        txtInputLabel.setText("Enter Temperature in Celsius ");
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinnerOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String b = Unit.get(i);
                switch (b) {

                    case "Fahrenheit":
                        txtOutputLabel.setText("Converted Temperature  ");
                        break;

                    case "Celsius":
                        txtOutputLabel.setText("Converted Temperature  ");
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double value = new Double(txtInputValue.getText().toString());
                int a = spinnerInput.getSelectedItemPosition();
                int b = spinnerOutput.getSelectedItemPosition();
                String inputTemp = Unit.get(a);
                String outputTemp = Unit.get(b);

                if (inputTemp == "Fahrenheit" && outputTemp == "Fahrenheit" || inputTemp == "Celsius" && outputTemp == "Celsius") {
                    txtOutputValue.setText(new Double(value).toString());

                }

                if (inputTemp == "Fahrenheit" && outputTemp == "Celsius") {
                    Double result = f2cconverter(value);
                    txtOutputValue.setText(new Double(result).toString());

                }
                if (inputTemp == "Celsius" && outputTemp == "Fahrenheit") {
                    Double result = c2fconverter(value);
                    txtOutputValue.setText(new Double(result).toString());
                }

            }
        });


    }

    public Double f2cconverter(double value) {
        return (value - 32) * 5 / 9;
    }

    public Double c2fconverter(Double value) {
        return (value * 9 / 5) + 32;
    }


}