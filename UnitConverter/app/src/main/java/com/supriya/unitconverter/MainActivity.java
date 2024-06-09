package com.supriya.unitconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.supriya.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding  binding;
    private String convertUnit;
    private Double convertValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.dark_green));

        String[] arr = {"km", "m", "cm","mm","nm","mile","foot","inch"};
        binding.dropdownUnit.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arr));
        binding.dropdownUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        binding.dropdownValue.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arr));
        binding.dropdownValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        binding.etValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                setValue();
                if (s.toString().isEmpty()) {
                    binding.tvConvertValue.setText("");
                }
            }
        });
    }

    private void setValue() {
        if(!binding.dropdownValue.getSelectedItem().toString().isEmpty()) {
            convertUnit =  binding.dropdownValue.getSelectedItem().toString();
        } else {
            convertUnit = "km";
        }
        if (!(binding.etValue.getText().toString().isEmpty()) && !binding.dropdownUnit.getSelectedItem().toString().isEmpty()) {
            Double value =  Double.valueOf(binding.etValue.getText().toString()).doubleValue();
            switch (convertUnit) {
                case "km": {
                    convertValue = value;
                    break;
                }
                case "m": {
                    convertValue = (value/1000)*1000;
                    break;
                }
                case "cm": {
                    convertValue = (value/100000)*100000;
                    break;
                }
                case "mm": {
                    convertValue = (value*1000000)*1000000;
                    break;
                }
                case "mile" : {
                    convertValue = (value/1.609)*1.609;
                    break;
                }
                case "foot" : {
                    convertValue =(value/3281)*3281;
                    break;
                }
                case "inch" : {
                    convertValue = (value/39370)*39370;
                    break;
                }
            }
            binding.tvConvertValue.setText(String.valueOf(convertValue));
        }
    }
}