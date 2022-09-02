package com.example.calcapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    lateinit var zero: TextView
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView

    lateinit var plus: TextView
    lateinit var minus: TextView
    lateinit var divide: TextView
    lateinit var multiply: TextView
    lateinit var modulo: TextView
    lateinit var equals: TextView

    lateinit var changeSign: TextView
    lateinit var decimal: TextView

    lateinit var expression: TextView
    lateinit var result: TextView

    lateinit var ac: TextView
    lateinit var back: ImageView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.subtract)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        modulo = findViewById(R.id.modulo)
        equals = findViewById(R.id.equals)

        changeSign = findViewById(R.id.change_sign)
        decimal = findViewById(R.id.decimal)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)

        ac = findViewById(R.id.ac)
        back = findViewById(R.id.back)

        zero.setOnClickListener {
            appendText("0",true)
        }
        one.setOnClickListener {
            appendText("1",true)
        }
        two.setOnClickListener {
            appendText("2",true)
        }
        three.setOnClickListener {
            appendText("3",true)
        }
        four.setOnClickListener {
            appendText("4",true)
        }
        five.setOnClickListener {
            appendText("5",true)
        }
        six.setOnClickListener {
            appendText("6",true)
        }
        seven.setOnClickListener {
            appendText("7",true)
        }
        eight.setOnClickListener {
            appendText("8",true)
        }
        nine.setOnClickListener {
            appendText("9",true)
        }
        plus.setOnClickListener {
            appendText("+",false)
        }
        minus.setOnClickListener {
            appendText("-",false)
        }
        divide.setOnClickListener {
            appendText("/",false)
        }
        multiply.setOnClickListener {
            appendText("*",false)
        }

        equals.setOnClickListener {
            try {
                val expr = ExpressionBuilder(expression.text.toString()).build()
                val answer = expr.evaluate()
                result.text = answer.toString()
            } catch (e: Exception){
                result.text = e.message
            }
        }

        back.setOnClickListener{
            result.hint = ""
            result.text = ""
            val value = expression.text
            if (value.isNotEmpty()){
                expression.text = value.toString().substring(0,value.length-1)
            }
        }

        ac.setOnClickListener {
            expression.text = ""
            result.text = ""
            result.hint = ""
        }

        changeSign.setOnClickListener {
            result.text = ""
            result.hint = ""
            if (expression.text.isNotEmpty() && expression.text[0] == '-'){
                expression.text = expression.text.substring(1)
            }else{
                expression.text = "-" + expression.text
            }
        }

        decimal.setOnClickListener {
            appendText(".",true)
        }

        modulo.setOnClickListener {
            appendText("%",false)
        }
    }

     private fun appendText(value:String, toBeCleared: Boolean){
        if(result.text != ""){
            expression.text = ""
        }
        if (toBeCleared) { // when value is a number
            result.text = ""
            expression.append(value)
        }else{ // when value is a operator
            expression.append(result.text)
            expression.append(value)
            result.text = ""
        }
         result.hint = expression.text
    }
}