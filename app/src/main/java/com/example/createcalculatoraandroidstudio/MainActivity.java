package com.example.createcalculatoraandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Number1, Number2;
    Button btnAdd, btnSub;
    TextView textViewResult;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        Number1 = findViewById(R.id.etNum1);
        Number2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub); // Add this line
        textViewResult = findViewById(R.id.textView);

        // Set OnClickListener for the addition button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform addition when the button is clicked
                calculateAndDisplayResult("+");
            }
        });

        // Set OnClickListener for the subtraction button
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform subtraction when the button is clicked
                calculateAndDisplayResult("-");
            }
        });
    }

    // Method to perform addition or subtraction and display the result
    private void calculateAndDisplayResult(String operation) {
        // Get the numbers from the EditText fields
        String num1Str = Number1.getText().toString();
        String num2Str = Number2.getText().toString();

        // Check if the input is not empty
        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            // Parse the input strings to numbers
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            // Perform the operation based on the provided operator
            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            }

            // Display the result in the TextView
            textViewResult.setText("Result: " + result);
        } else {
            // Handle empty input fields
            textViewResult.setText("Result: Please enter numbers in both fields.");
        }
    }
}
