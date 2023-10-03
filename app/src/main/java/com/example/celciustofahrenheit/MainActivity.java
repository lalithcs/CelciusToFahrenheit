package com.example.celciustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public class CelsiusToFahrenheit {
        // Method to convert Celsius to Fahrenheit
        public double celsiusToFahrenheit(double celsius) {
            return (celsius * 9 / 5) + 32;
        }

        // Method to convert Fahrenheit to Celsius
        public double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }
    }
    // Declare UI elements
    EditText celsiusInput;
    Button convertButton;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize UI elements by finding their views
        celsiusInput = findViewById(R.id.editTextCelsius);
        convertButton = findViewById(R.id.buttonConvert);
        resultText = findViewById(R.id.textViewResult);
        // Set a click listener for the Convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the input Celsius temperature as a string
                String celsiusStr = celsiusInput.getText().toString();
                MainActivity.CelsiusToFahrenheit in=new MainActivity.CelsiusToFahrenheit();
                // Check if the input is empty
                if (!celsiusStr.isEmpty()) {
                    // Convert the Celsius string to a double
                    double celsius = Double.parseDouble(celsiusStr);
                    // Convert Celsius to Fahrenheit using the class method
                    double fahrenheit = in.celsiusToFahrenheit(celsius);
                    // Display the result in the TextView
                    resultText.setText(String.format("%.2f °F", fahrenheit));
                } else {
                    // Handle empty input
                    resultText.setText("Please enter a temperature in Celsius.");
                }
            }
        });
    }
}
