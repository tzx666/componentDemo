package buct.tzx.webviewspecfic;

import android.content.Context;
import android.content.Intent;

import androidx.core.content.ContextCompat;

import buct.tzx.webviewprotool.WebViewService;

public class WebViewServiceImpl implements WebViewService {
    @Override
    public void loadUrl(Context context, String url) {
        Intent intent = new Intent(context,WebViewActivity.class);
        intent.putExtra("url",url);
        ContextCompat.startActivity(context,intent,null);
    }
}
