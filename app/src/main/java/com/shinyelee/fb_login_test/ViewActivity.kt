package com.shinyelee.fb_login_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("https://www.mangoplate.com/restaurants/yNGGQSGw7x")
    }
}