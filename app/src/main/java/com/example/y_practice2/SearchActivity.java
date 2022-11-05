package com.example.y_practice2;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView = findViewById(R.id.search);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new BridgeInterface(), "Android");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Android -> JavaScript 함수 호출!
                webView.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

        // 최초 webView load
        webView.loadUrl("https://searchaddress-3e7c6.web.app/");
    }

    private class BridgeInterface {
        @JavascriptInterface
        public void processDATA(String data){
            // 카카오 주소 검색 api의 결과 값이 브릿지 통로를 통해 전달 받는다. (from JavaScript)
            Intent intent = new Intent();
            intent.putExtra("data", data);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}