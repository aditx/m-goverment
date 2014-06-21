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

public class KulinerDetailActivity extends ActionBarActivity {
	
	private static String url_detail_wst = "http://192.168.137.1/jeparagov/tampil_data_kuliner.php";
	private TextView txtNm, txtAlamat, txtJam, txtDesc;
	private ImageView imgFoto;
	public ImageLoader imageLoader;
	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();
	String id_kuliner;
	String result = "";
	JSONObject json, c;
	JSONArray wisata_detail = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kuliner_detail);
		txtNm = (TextView)findViewById(R.id.txt_nm_kuliner);
		txtAlamat = (TextView)findViewById(R.id.txt_alamat_kuliner);
		txtJam = (TextView)findViewById(R.id.txt_jm_kuliner);
		txtDesc = (TextView)findViewById(R.id.txt_deskripsi_kuliner);
		imgFoto = (ImageView)findViewById(R.id.image_kuliner_detail);
		Intent i = getIntent();
		id_kuliner = i.getStringExtra("id_kuliner");
		imageLoader = new ImageLoader(this.getApplicationContext());
		
		new LoadData().execute();
		
	}
	
	class LoadData extends AsyncTask<String, String, String>{
			
			@Override
			protected void onPreExecute() {
			super.onPreExecute();
				pDialog = new ProgressDialog(KulinerDetailActivity.this);
				pDialog.setMessage("Mohon tunggu...");
				pDialog.setIndeterminate(false);
				pDialog.setCancelable(false);
				pDialog.show();
			}
	
			@Override
			protected String doInBackground(String... args) {
				// TODO Auto-generated method stub
				List<NameValuePair> params = new ArrayList<NameValuePair>();
            	params.add(new BasicNameValuePair("id_kuliner", id_kuliner));
    			json = jParser.makeHttpRequest(url_detail_wst, "POST", params);
	            try {
	            	wisata_detail = json.getJSONArray("daftar_kuliner");
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
							txtNm.setText(c.getString("nm_kuliner"));
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
