package id.aditya.jeparagov;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends ActionBarActivity {

	String content;
	String namafile;
	private SubMenu mItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#EEEEEE")));
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		content = "file:///android_asset/home.html";
		WebView wv;

		wv = (WebView) findViewById(R.id.webView1);
		WebSettings webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setDomStorageEnabled(true);

		// wv.addJavascriptInterface(new WebAppInterface(this), "Android");

		wv.loadUrl(content);
	}
	
	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mItem = menu.addSubMenu(0, 1, 0, null);
		mItem.setIcon(R.drawable.ic_forward);
		mItem.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case 1:
				Intent n = new Intent(this, HomeActivity.class);
				startActivity(n);
				MainActivity.this.finish();
				break;
		}
		return true;
	}
}
