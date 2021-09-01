package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.trimmedLength

class MainActivity : AppCompatActivity() {
    lateinit var entered_text:EditText
    lateinit var result_text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Initializing the edit text
        entered_text=findViewById(R.id.entered_value)
        //Initializing the text view which will show result
        result_text=findViewById(R.id.result)
        //Initializing the button
        val convert: Button =findViewById(R.id.button)
        //set on click listener for this button
        convert.setOnClickListener {
            do_conversion()
        }
    }

    private fun do_conversion() {
        //Taking input as a string
        val kg=entered_text.text.toString()
        //if the user don't put any input then show the below toast
        if(TextUtils.isEmpty(kg)){
            Toast.makeText( this,"Please Enter Some Value...", Toast.LENGTH_SHORT).show()
        }
        //if user's input is greater than 10 then show the below toast.We can also handle it by using long.
        else if(kg.length>=10){
            Toast.makeText(this, "Enter less Than 10 Digit No.", Toast.LENGTH_SHORT).show()
        }
        /*if the any of the above condition is not true then first convert the string value to int and then convert
        it in gm by multiplying it with 1000 */
        else{
            val gm=kg.toInt();
            result_text.setText("Gram Value is : "+(gm*1000))
        }

    }
}