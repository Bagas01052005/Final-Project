package com.example.temperatureconverterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etTemperature = findViewById(R.id.etTemperature);
        Button btnToFahrenheit = findViewById(R.id.btnToFahrenheit);
        Button btnToCelsius = findViewById(R.id.btnToCelsius);
        TextView tvResult = findViewById(R.id.tvResult);

        btnToFahrenheit.setOnClickListener(v -> {
            String input = etTemperature.getText().toString();
            if (!input.isEmpty()) {
                double tempCelsius = Double.parseDouble(input);
                double tempFahrenheit = (tempCelsius * 9/5) + 32;
                tvResult.setText(String.format("Hasil: %.2f °F", tempFahrenheit));
            } else {
                Toast.makeText(this, "Masukkan suhu terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });

        btnToCelsius.setOnClickListener(v -> {
            String input = etTemperature.getText().toString();
            if (!input.isEmpty()) {
                double tempFahrenheit = Double.parseDouble(input);
                double tempCelsius = (tempFahrenheit - 32) * 5/9;
                tvResult.setText(String.format("Hasil: %.2f °C", tempCelsius));
            } else {
                Toast.makeText(this, "Masukkan suhu terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
