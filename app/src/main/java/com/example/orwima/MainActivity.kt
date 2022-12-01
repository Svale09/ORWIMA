package com.example.orwima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView_name = findViewById<TextView>(R.id.textView_name)
        val textView_description = findViewById<TextView>(R.id.textView_description)
        val editText_name = findViewById<EditText>(R.id.editText_name)
        val editText_description = findViewById<EditText>(R.id.editText_description)
        val button_save = findViewById<Button>(R.id.button_save)
        val editText_height = findViewById<EditText>(R.id.editText_height)
        val editText_weight = findViewById<EditText>(R.id.editText_weight)
        val button_calculate = findViewById<Button>(R.id.button_calculate)

        button_save.setOnClickListener {
            textView_name.setText(editText_name.text)
            textView_description.setText(editText_description.text)
        }

        button_calculate.setOnClickListener {
            Toast.makeText(
                this,
                CalculateBMI(
                    editText_weight.text.toString().toInt(),
                    editText_height.text.toString().toInt()
                ).toString(),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

fun CalculateBMI(
    weight: Int,
    height: Int
): Float {
    var BMI: Float
    BMI = weight.toFloat() / (height * height).toFloat()
    return BMI*10000
}
