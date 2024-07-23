package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstNumber = findViewById<EditText>(R.id.etFirstNumber)
        val etSecondNumber = findViewById<EditText>(R.id.etSecondNumber)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val firstNumber = etFirstNumber.text.toString().toDouble()
            val secondNumber = etSecondNumber.text.toString().toDouble()
            val operation = findViewById<Spinner>(R.id.spinner).selectedItem.toString()
            val result = when (operation) {
                "Addition" -> firstNumber + secondNumber
                "Subtraction" -> firstNumber - secondNumber
                "Multiplication" -> firstNumber * secondNumber
                "Division" -> firstNumber / secondNumber
                else -> 0.0
            }
            tvResult.text = result.toString()
        }

        // Retrieve the message from the intent
        val message = intent.getStringExtra("message")
        message?.let {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}
