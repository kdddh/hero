package activity;

import com.hero.app.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import util.BaseActivity;

public class LicenseActivity extends BaseActivity{
	
	//WebView相当于浏览器的内核
	private WebView licenseWebView;
	
	private Button backButton;
	
	protected void onCreate(Bundle savedInstanceState) {
    	
		super.onCreate(savedInstanceState);
        setContentView(R.layout.license);
        
        backButton = (Button)findViewById(R.id.button_licenseback);
        backButton.setOnClickListener(new Listener());
        
        licenseWebView = (WebView)findViewById(R.id.webview_lisence);
        licenseWebView.getSettings().setJavaScriptEnabled(true);
        licenseWebView.setWebViewClient(new WebViewClient());
        
        //URL应设置为一段静态文本
        licenseWebView.loadUrl("https://www.baidu.com");
        
	}
	
	
	private class Listener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(LicenseActivity.this, MainActivity.class);
			startActivity(intent);
			
		}
	}

}
