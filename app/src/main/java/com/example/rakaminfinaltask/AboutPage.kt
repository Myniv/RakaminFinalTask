package com.example.rakaminfinaltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class AboutPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val btnHome : ImageButton = findViewById(R.id.btn_home_inabout)
        btnHome.setOnClickListener(this)

//        val btnProfile : ImageButton = findViewById(R.id.btn_profile_inabout)
//        btnProfile.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home_inabout -> {
                val moveIntent = Intent(this@AboutPage, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}