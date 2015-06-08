package com.aliao.web;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private WebView mWebView;
    private Button mBtnCallJsFun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        String url = "file:///android_asset/test.html";
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);//支持js
        mWebView.addJavascriptInterface(this, "AppFunction");
        mWebView.loadUrl(url);

        mBtnCallJsFun = (Button) findViewById(R.id.btn_call_js_fun);
        mBtnCallJsFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl("javascript:funFromjs()");
            }
        });
    }

    @JavascriptInterface
    public void show(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
