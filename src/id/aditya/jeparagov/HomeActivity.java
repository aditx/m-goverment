package id.aditya.jeparagov;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class HomeActivity extends ActionBarActivity implements OnClickListener {
	
	private ImageView img1, img2, img3, img4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		img1 = (ImageView) findViewById(R.id.imageView1);
		img1.setOnClickListener(this);
		
		img2 = (ImageView) findViewById(R.id.imageView2);
		img2.setOnClickListener(this);
		
		img3 = (ImageView) findViewById(R.id.imageView3);
		img3.setOnClickListener(this);
		
		img4 = (ImageView) findViewById(R.id.imageView4);
		img4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.imageView1:
				Intent n = new Intent(this, ProfileActivity.class);
				startActivity(n);
			break;
			case R.id.imageView2:
				Intent o = new Intent(this, WisataActivity.class);
				startActivity(o);
			break;
			case R.id.imageView3:
				Intent p = new Intent(this, KulinerActivity.class);
				startActivity(p);
			break;
			case R.id.imageView4:
				Intent q = new Intent(this, AboutActivity.class);
				startActivity(q);
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
	    // do nothing.
		dialogBox();
	}
	
	private void dialogBox(){
		AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
		aBuilder.setMessage("Apakah ingin keluar dari aplikasi ?")
				.setCancelable(false)
				.setTitle("Keluar Aplikasi")
				.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						HomeActivity.this.finish();
						//moveTaskToBack(true);
					}
				})
				
				.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				}).show();
	}

}
