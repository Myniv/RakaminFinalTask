package com.example.rakaminfinaltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class AboutPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        val btnHome : ImageButton = findViewById(R.id.btn_home_inabout)
        btnHome.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home_inabout -> {
                val moveIntent = Intent(this@AboutPage, MainActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_profile_inabout -> {
                val toast = Toast.makeText(this, "You Already in About Page", Toast.LENGTH_SHORT) // in Activity
                toast.show()
            }
        }
    }
}