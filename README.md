# Final-Project

Tugas Membuat di android studio  "Aplikasi Konversi Suhu". Aplikasi ini memungkinkan pengguna untuk mengonversi suhu dari Celcius ke Fahrenheit dan sebaliknya.
Langkah 1: Buat Proyek Baru
•	Pilih template Empty Activity.
•	Beri nama proyek, misalnya TemperatureConverterApp.
Langkah 2: Desain Layout (UI)
Edit file res/layout/activity_main.xml untuk mendesain tampilan aplikasi:
xml
CopyEdit
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:gravity="center">

    <!-- Input Suhu -->
    <EditText
        android:id="@+id/etTemperature"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Masukkan Suhu"
        android:inputType="numberDecimal"
        android:padding="10dp"
        android:background="@drawable/edittext_border"
        android:layout_marginBottom="16dp"/>

    <!-- Tombol Konversi ke Fahrenheit -->
    <Button
        android:id="@+id/btnToFahrenheit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Konversi ke Fahrenheit"
        android:layout_marginBottom="8dp"/>

    <!-- Tombol Konversi ke Celcius -->
    <Button
        android:id="@+id/btnToCelsius"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Konversi ke Celcius"
        android:layout_marginBottom="16dp"/>

    <!-- Hasil Konversi -->
    <TextView
        android:id="@+id/tvResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Hasil akan muncul di sini"
        android:textSize="18sp"
        android:textColor="#000000"
        android:gravity="center"
        android:padding="16dp"
        android:background="@drawable/textview_border" />

</LinearLayout>
Tambahkan file edittext_border.xml di folder res/drawable (untuk desain EditText):
xml
CopyEdit
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#FFFFFF" />
    <stroke android:width="1dp" android:color="#CCCCCC" />
    <corners android:radius="5dp" />
</shape>
Tambahkan file textview_border.xml di folder res/drawable (untuk desain TextView):
xml
CopyEdit
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#F9F9F9" />
    <stroke android:width="1dp" android:color="#CCCCCC" />
    <corners android:radius="5dp" />
</shape>
________________________________________
Langkah 3: Tambahkan Logika di MainActivity
Edit file MainActivity.java atau MainActivity.kt:
Java:
java
CopyEdit
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
Langkah 4: Jalankan Aplikasi
Hasil Akhir:
1.	Input Suhu: Pengguna dapat memasukkan angka (misalnya 25 untuk 25 °C).
2.	Konversi ke Fahrenheit: Tombol "Konversi ke Fahrenheit" akan mengubah 25 °C menjadi 77 °F.
3.	Konversi ke Celcius: Tombol "Konversi ke Celcius" akan mengubah angka Fahrenheit (misalnya 77) menjadi 25 °C.
4.	Hasil Konversi: Hasil ditampilkan di bawah tombol dalam format: Hasil: 77.00 °F.
Tampilan pada Emulator/Perangkat:
