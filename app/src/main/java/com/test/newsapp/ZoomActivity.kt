package com.test.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.jsibbold.zoomage.ZoomageView

class ZoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom)

        val ZoomView = findViewById<ZoomageView>(R.id.zoomView)

        Glide.with(this).load(intent.extras!!.get("imageUrl")).into(ZoomView)
    }
}