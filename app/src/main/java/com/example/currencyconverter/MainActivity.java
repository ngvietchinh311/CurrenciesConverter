package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] clist = {"VND", "USD", "EUR", "JPY", "AUD", "GBP", "CAD", "CHF", "CNY", "HKD"};
    double[] rate = {1.0, 23000.0, 27000.0, 220.0, 16500.0, 30300.0, 17500.0, 25600.0, 3400.0, 2990.0};
    Spinner spinner1 = findViewById(R.id.spinner_1);
    Spinner spinner2 = findViewById(R.id.spinner_2);
    EditText amount = findViewById(R.id.amount);
    TextView tv_rs = findViewById(R.id.tv_rs);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, clist);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        //spinner1.getSelectedItemPosition();
        if(amount.getText().toString().equals("")){
            tv_rs.setHint("Nothing to convert");
        }
        else{
            double amt = Double.parseDouble("amount.getText().toString()");
            tv_rs.setText("" + amt * rate[spinner2.getSelectedItemPosition()]/rate[spinner1.getSelectedItemPosition()]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        spinner1.setSelection(0);
        spinner2.setSelection(0);
    }
}