package com.trichain.taxcalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ResultsActivity extends AppCompatActivity {
    TextView result;
    String tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        result = findViewById(R.id.results);
        SharedPreferences prefs = this.getSharedPreferences(
                "TaxPref", Context.MODE_PRIVATE);
        int income = Integer.parseInt(prefs.getString("income", ""));
        String year = prefs.getString("year", "");
        DecimalFormat df = new DecimalFormat("#.00");
        if (year.contentEquals("2019")) {
            tax = df.format(income * 32d / 100);
        } else if (year.contentEquals("2018")) {
            tax = df.format(income * 30d / 100);
        } else {
            tax = df.format(income * 25d / 100);
        }
        result.setText(tax);
    }
}