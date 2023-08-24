package com.example.unitconvetr;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView kilometer, meter, centimeter, milimeter, micrometer, nanometer, mile, yard, foot, inch;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        kilometer = findViewById(R.id.kilometer);
        meter = findViewById(R.id.meter);
        centimeter = findViewById(R.id.centimeter);
        milimeter = findViewById(R.id.milimeter);
        micrometer = findViewById(R.id.micrometer);
        nanometer = findViewById(R.id.nanometer);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        String[] arr = {"kilometer", "meter", "centimeter", "milimeter", "micrometer", "nanometer", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }

    private void update() {
        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "kilometer":
                    setKm(in);
                    break;
                case "meter":
                    setKm(in / 1000);
                    break;
                case "centimeter":
                    setKm(in / 100000);
                    break;
                case "milimeter":
                    setKm(in / 1000000);
                    break;
                case "micrometer":
                    setKm(in / 1000000000);
                    break;
                case "nanometer":
                    double d = 1000000 * 1000000;
                    setKm(in / d);
                    break;
                case "mile":
                    setKm(in * 1.609);
                    break;
                case "yard":
                    setKm(in / 1094);
                    break;
                case "foot":
                    setKm(in / 3281);
                    break;
                case "inch":
                    setKm(in / 39370);
                    break;
            }
        }

    }

    private void setKm(double kilometer_in) {
        kilometer.setText(String.valueOf(kilometer_in));
        meter.setText(String.valueOf(kilometer_in * 1000));
        centimeter.setText(String.valueOf(kilometer_in * 100000));
        milimeter.setText(String.valueOf(kilometer_in * 1000000));
        micrometer.setText(String.valueOf(kilometer_in * 1000000000));
        nanometer.setText(String.valueOf(kilometer_in * 1000000 * 1000000));
        mile.setText(String.valueOf(kilometer_in / 1.609));
        yard.setText(String.valueOf(kilometer_in * 1094));
        foot.setText(String.valueOf(kilometer_in * 3281));
        inch.setText(String.valueOf(kilometer_in * 39370));

    }
}