package id.aditya.jeparagov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ProfileActivity extends ActionBarActivity implements OnClickListener {
	
	private ImageView img1, img2, img3, img4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil);
		
		img1 = (ImageView) findViewById(R.id.imageViewSejarah);
		img1.setOnClickListener(this);
		
		img2 = (ImageView) findViewById(R.id.imageViewVisi);
		img2.setOnClickListener(this);
		
		img3 = (ImageView) findViewById(R.id.imageViewGeografis);
		img3.setOnClickListener(this);
		
		img4 = (ImageView) findViewById(R.id.imageViewOrganisasi);
		img4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.imageViewSejarah:
				Intent i = new Intent(this, Sejarah.class);
				startActivity(i);
			break;
			case R.id.imageViewVisi:
				Intent n = new Intent(this, VisiActivity.class);
				startActivity(n);
			break;
			case R.id.imageViewGeografis:
				Intent o = new Intent(this, geografis.class);
				startActivity(o);
			break;
			case R.id.imageViewOrganisasi:
				Intent p = new Intent(this, STOActivity.class);
				startActivity(p);
			break;
		}
	}

}
