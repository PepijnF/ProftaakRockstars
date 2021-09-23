package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        val startAppButton = findViewById<Button>(R.id.buttonLogin)
        startAppButton.setOnClickListener{
            saveData()
            val Intent = Intent(this, HomeScreen::class.java)
            startActivity(Intent)
        }



    }

    private fun saveData(){
        if(checkBoxRememberName.isChecked){
            val insertedText:String = editText.text.toString()
            textView.text = "Name: "+ insertedText

            val sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply{
                putString("Name", insertedText)
            }.apply()

            Toast.makeText(this,"Data saved", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("Name", null)

        textView.text = "Name: " + savedString

    }
}