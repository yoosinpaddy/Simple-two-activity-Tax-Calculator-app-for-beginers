package com.trichain.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
SharedPreferences.Editor preferences;
EditText year,income;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        income=findViewById(R.id.incomeEd);
        year=findViewById(R.id.yearEd);
        SharedPreferences prefs = this.getSharedPreferences(
                "TaxPref", Context.MODE_PRIVATE);
        preferences= prefs.edit();
        
    }

    public void calculate(View view) {
        if (year.getText().toString().isEmpty()&&year.getText().toString().length()!=4){
            year.setError("Enter valid year");
            year.requestFocus();

        }else if (income.getText().toString().isEmpty()){
            income.setError("Enter valid year");
            income.requestFocus();

        }else {

            preferences.putString("year",year.getText().toString()).apply();
            preferences.putString("income",income.getText().toString()).apply();
            startActivity(new Intent(MainActivity.this,ResultsActivity.class));
        }

    }
}