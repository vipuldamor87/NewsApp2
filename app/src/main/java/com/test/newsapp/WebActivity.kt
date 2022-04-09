package com.test.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        var webview = findViewById<WebView>(R.id.webView)

        webview.loadUrl(intent.extras!!.get("url").toString())
    }
}