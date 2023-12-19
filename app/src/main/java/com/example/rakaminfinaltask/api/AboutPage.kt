package com.example.rakaminfinaltask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)
//        val buttonBack = findViewById<Button>(R.id.btn_back2)
//        buttonBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
//        if (v.id == R.id.btn_back2) {
//            val moveIntent = Intent(this@AboutPage, MainActivity::class.java)
//            startActivity(moveIntent)
//        }
    }
}