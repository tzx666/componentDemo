package buct.tzx.webviewspecfic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        var intent = intent
        var url = intent.extras?.getString("url")
        webView = findViewById(R.id.webview)
        url?.apply {
            webView.loadUrl(url)
        }
    }
    fun loadUrl(url:String){
        webView.loadUrl(url)
    }
}