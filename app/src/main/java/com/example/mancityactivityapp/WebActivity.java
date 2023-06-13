package com.example.mancityactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // wire
        webView     = findViewById(R.id.webView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("data");

        // populate view from url
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}