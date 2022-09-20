package com.example.currencyconverter;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText enterAmount;
    Button btnConvert;
    TextView convertedAmount;

    CountryItem countryItem;
    String clickedCountryName;

    CountryItem countryItemTo;
    String clickedCountryNameTo;

    private ArrayList<CountryItem> countryList;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        inListCountry();

        btnConvert = (Button) findViewById(R.id.converter_btn);
        enterAmount = (EditText) findViewById(R.id.amount_edit_text);
        convertedAmount = (TextView) findViewById(R.id.converted_amt);

        Spinner spinnerCountries = findViewById(R.id.spinner_countries);
        Spinner spinnerCountriesTo = findViewById(R.id.spinener_countries_to);

        mAdapter= new CountryAdapter(this,countryList);
        spinnerCountries.setAdapter(mAdapter);
        spinnerCountriesTo.setAdapter(mAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryItem = (CountryItem) parent.getItemAtPosition(position);
                clickedCountryName= countryItem.getCountryName();
                Toast.makeText(MainActivity2.this,clickedCountryName + " selected",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCountriesTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryItemTo = (CountryItem) parent.getItemAtPosition(position);
                clickedCountryNameTo= countryItemTo.getCountryName();
                Toast.makeText(MainActivity2.this,clickedCountryNameTo + " selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double totalCovertedAmount;
                Double amount=Double.parseDouble(enterAmount.getText().toString());

                if(clickedCountryName.equals("USA") && clickedCountryNameTo.equals("Pakistan"))
                {
                    totalCovertedAmount = amount * 226.49;
                    String tot = String.format("%.2f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }
                if(clickedCountryName.equals("USA") && clickedCountryNameTo.equals("India"))
                {
                    totalCovertedAmount = amount * 79.66;
                    String tot = String.format("%.2f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }
                if(clickedCountryName.equals("India") && clickedCountryNameTo.equals("Pakistan"))
                {
                    totalCovertedAmount = amount * 2.84;
                    String tot = String.format("%.2f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }
                if(clickedCountryName.equals("India") && clickedCountryNameTo.equals("USA"))
                {
                    totalCovertedAmount = amount * 0.013;
                    String tot = String.format("%.2f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }
                if(clickedCountryName.equals("Pakistan") && clickedCountryNameTo.equals("India"))
                {
                    totalCovertedAmount = amount * 0.35;
                    String tot = String.format("%.2f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }
                if(clickedCountryName.equals("Pakistan") && clickedCountryNameTo.equals("USA"))
                {
                    totalCovertedAmount = amount * 0.0044;
                    String tot = String.format("%.3f",totalCovertedAmount);
                    convertedAmount.setText(""+tot);
                }

            }
        });
    }

    private void inListCountry() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Pakistan",R.drawable.pakistan));
        countryList.add(new CountryItem("India",R.drawable.india));
        countryList.add(new CountryItem("USA",R.drawable.unitedstate));
    }
}