package com.example.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter: TextView = findViewById(R.id.counter)
        val incrementButton: Button = findViewById(R.id.incrementButton)
        val decrementButton: Button = findViewById(R.id.decrementButton)
        val resetButton: TextView = findViewById(R.id.resetButton)

        incrementButton.setOnClickListener {
            var value = Integer.parseInt(counter.text.toString())
            value++
            counter.text = value.toString()
        }
        decrementButton.setOnClickListener {
            var value = Integer.parseInt(counter.text.toString())
            value--
            counter.text = value.toString()
        }
        resetButton.setOnClickListener {
            counter.text = "0"
        }
    }
}