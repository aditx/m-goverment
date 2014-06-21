package id.aditya.jeparagov;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WisataDetailActivity extends ActionBarActivity {
	
	private static String url_detail_wst = "http://192.168.137.1/jeparagov/tampil_data_wisata.php";
	private TextView txtNm, txtAlamat, txtJam, txtDesc;
	private ImageView imgFoto;
	public ImageLoader imageLoader;
	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();
	String id_wisata;
	String result = "";
	JSONObject json, c;
	JSONArray wisata_detail = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wisata_detail);
		txtNm = (TextView)findViewById(R.id.txt_nm_wisata);
		txtAlamat = (TextView)findViewById(R.id.txt_alamat_detail);
		txtJam = (TextView)findViewById(R.id.txt_jm_operasi);
		txtDesc = (TextView)findViewById(R.id.txt_deskripsi_detail);
		imgFoto = (ImageView)findViewById(R.id.image_wisata_detail);
		Intent i = getIntent();
		id_wisata = i.getStringExtra("id_wisata");
		imageLoader = new ImageLoader(this.getApplicationContext());
		
		new LoadData().execute();
		
	}
	
	class LoadData extends AsyncTask<String, String, String>{
			
			@Override
			protected void onPreExecute() {
			super.onPreExecute();
				pDialog = new ProgressDialog(WisataDetailActivity.this);
				pDialog.setMessage("Mohon tunggu...");
				pDialog.setIndeterminate(false);
				pDialog.setCancelable(false);
				pDialog.show();
			}
	
			@Override
			protected String doInBackground(String... args) {
				// TODO Auto-generated method stub
				List<NameValuePair> params = new ArrayList<NameValuePair>();
            	params.add(new BasicNameValuePair("id_wisata", id_wisata));
    			json = jParser.makeHttpRequest(url_detail_wst, "POST", params);
	            try {
	            	wisata_detail = json.getJSONArray("daftar_wisata");
	            	for(int i=0; i<wisata_detail.length(); i++){
	            		c = wisata_detail.getJSONObject(i);
		            	//Log.d("Detail Wisata : ", c.getString("nm_wisata"));
	            	}
				} catch (Exception e) {
					e.printStackTrace();
				}
	            return null;
			}
			
			protected void onPostExecute(String file_url) {
				pDialog.dismiss();
				runOnUiThread(new Runnable() {
					public void run() {
						try {
							txtNm.setText(c.getString("nm_wisata"));
							txtAlamat.setText(c.getString("alamat"));
							txtJam.setText(c.getString("jam_operasi"));
							txtDesc.setText(c.getString("deskripsi"));
							imageLoader.DisplayImage(c.getString("gambar"), imgFoto);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			}
			
	}
}
