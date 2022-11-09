package com.example.tempratureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText e1, e2;
    TextView t1, t2, t3, t4;
    Spinner s1;
    Button b1;
    String[] array = new String[]{"celsius", "Fahrenheit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) (findViewById(R.id.editTextNumber));
        e2 = (EditText) (findViewById(R.id.editTextTextPersonName));
        t1 = (TextView) (findViewById(R.id.textView));
        t2 = (TextView) (findViewById(R.id.textView2));
        t3 = (TextView) (findViewById(R.id.textView3));
        t4 = (TextView) (findViewById(R.id.textView4));
        s1 = (Spinner) (findViewById(R.id.spinner));
        b1 = (Button) (findViewById(R.id.button));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,array);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter);
        s1.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Celsius");
        categories.add("Fahrenheit");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter the temperature",Toast.LENGTH_SHORT).show();
                }

                else if (s1.getSelectedItem().toString().equalsIgnoreCase("Celsius"))
                {
                    double a= Double.parseDouble((e1.getText().toString()));
                    double b=a-32;
                    double c=b*5/9;
                    String r=String.valueOf(c);
                    e2.setText(r);
                    //Toast.makeText(getApplicationContext(),r,Toast.LENGTH_LONG).show();
                    //°F = (°C × 9/5) + 32
                }
                else //(s1.getSelectedItem().toString().equalsIgnoreCase("Fahrenheit"))
                {
                    double a= Double.parseDouble(String.valueOf(e1.getText()));
                    double b=a*9/5+32;
                    String r=String.valueOf(b);
                    e2.setText(r);
                   //Toast.makeText(getApplicationContext(),r,Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}