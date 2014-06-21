package id.aditya.jeparagov;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class VisiActivity extends ActionBarActivity {
	
	String content;
	String namafile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_visi_misi);
		content = "file:///android_asset/visi_misi.html";
		WebView wv;

		wv = (WebView) findViewById(R.id.webViewVisi);
		WebSettings webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDomStorageEnabled(true);

		// wv.addJavascriptInterface(new WebAppInterface(this), "Android");

		wv.loadUrl(content);
	}

}
