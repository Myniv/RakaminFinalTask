package com.example.rakaminfinaltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rakaminfinaltask.databinding.ActivityNavBarBinding

class NavBar : AppCompatActivity() {
    private lateinit var binding: ActivityNavBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MainActivity())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(MainActivity())
                R.id.about -> replaceFragment(AboutPageMe())

                else ->{


                }
            }
                true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}