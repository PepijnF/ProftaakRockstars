package com.example.myapplication

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        val startAppButton = findViewById<Button>(R.id.buttonLogin)
        startAppButton.setOnClickListener{
            saveDate()
            val Intent = Intent(this, HomeScreen::class.java)
            startActivity(Intent)
        }



    }

    private fun saveData(){

        val insertedText:String = editText.text.toString()
        textView.text = "Name: "+ insertedText

        val sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("Name", insertedText)
        }

    }
}