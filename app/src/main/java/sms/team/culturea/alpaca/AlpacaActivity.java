package sms.team.culturea.alpaca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import sms.team.culturea.R;

public class AlpacaActivity extends AppCompatActivity {
    private WebView webView;
    String url="file:///android_asset/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpaca);
        webView=findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}