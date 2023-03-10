package com.example.ifurniture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.RangeSlider;

public class MainActivity extends AppCompatActivity {

    int m_check=0,f_check=0;
    float h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton male_btn = findViewById(R.id.male);
        ImageButton female_btn = findViewById(R.id.female);
        RangeSlider rangeSlider = findViewById(R.id.height_value);
        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                TextView   height_val=findViewById(R.id.height);
                 h=value;
                height_val.setText(Float.toString(value));
            }
        });





        male_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_check=1;
                click_Check();

            }
        });

        female_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f_check=1;
                click_Check();
            }
        });

        Button calculate = findViewById(R.id.cal);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"Working",Toast.LENGTH_SHORT).show();
                EditText weight=findViewById(R.id.weight_value);
                RangeSlider height=findViewById(R.id.height_value);

               int wt =Integer.parseInt(weight.getText().toString());

               float height_val=h*h;
               float bmi=wt/height_val;






               //Toast.makeText(MainActivity.this,"height"+ht,Toast.LENGTH_SHORT).show();
               if(bmi>40) {
                   Toast.makeText(MainActivity.this,"very Severely obese",Toast.LENGTH_SHORT).show();
               }
                else if(bmi>35){
                    Toast.makeText(MainActivity.this,"Severely obese",Toast.LENGTH_SHORT).show();
                }
                 else if(bmi>30){
                    Toast.makeText(MainActivity.this,"Moderately obese",Toast.LENGTH_SHORT).show();
                }
                 else if(bmi>25){
                    Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_SHORT).show();
                }
               //
                else if(bmi>18.5){
                    Toast.makeText(MainActivity.this," Normal(healthy weight)",Toast.LENGTH_SHORT).show();
                }
               else if(bmi>15){
                    Toast.makeText(MainActivity.this,"Severely Underweight:"+bmi,Toast.LENGTH_SHORT).show();
                }
               else if(bmi<15){
                    Toast.makeText(MainActivity.this,"Very Severely underweight:"+bmi,Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
    public void  click_Check(){
        if(m_check==f_check){
            Toast.makeText(MainActivity.this,"Please Select one option Male or Female",Toast.LENGTH_LONG).show();
            m_check=0;
            f_check=0;

        }


    }

}