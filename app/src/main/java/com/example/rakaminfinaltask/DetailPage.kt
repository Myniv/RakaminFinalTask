package com.example.rakaminfinaltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailPage : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val DETAIL_TITLE = "detail_title"
        const val DETAIL_IMG = "detail_img"
        const val DETAIL_DESC = "detail_desc"
        const val DETAIL_CONTENT = "detail_content"
        const val DETAIL_AUTHOR = "detail_author"
        const val DETAIL_DATE = "detail_date"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        val btnProfile : ImageButton = findViewById(R.id.btn_profile_indetail)
        btnProfile.setOnClickListener(this)
        val btnHome : ImageButton = findViewById(R.id.btn_home_indetail)
        btnHome.setOnClickListener(this)

        val txtTitleDetailShowed: TextView = findViewById(R.id.text_title_detail)
        val imgImgDetailShowed: ImageView = findViewById(R.id.img_detail)
        val txtDescDetailShowed: TextView = findViewById(R.id.text_description_detail)
        val txtContentDetailShowed: TextView = findViewById(R.id.text_content_detail)
        val txtAuthorDetailShowed: TextView = findViewById(R.id.text_author_detail)
        val txtDateDetailShowed: TextView = findViewById(R.id.text_date_detail)

        txtTitleDetailShowed.text = intent.getStringExtra(DETAIL_TITLE)
        txtDescDetailShowed.text = intent.getStringExtra(DETAIL_DESC)
        txtContentDetailShowed.text = intent.getStringExtra(DETAIL_CONTENT)
        txtAuthorDetailShowed.text = intent.getStringExtra(DETAIL_AUTHOR)
        txtDateDetailShowed.text = intent.getStringExtra(DETAIL_DATE)

        Glide.with(this).load(intent.getStringExtra(DETAIL_IMG)).centerCrop().into(imgImgDetailShowed)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home_indetail -> {
                val moveIntent = Intent(this@DetailPage, MainActivity::class.java)
                startActivity(moveIntent)

            }
            R.id.btn_profile_indetail -> {
                val moveIntent = Intent(this@DetailPage, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
    }
}