package id.aditya.jeparagov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class KulinerActivity extends ActionBarActivity {
	
	private ProgressDialog pDialog;
	JSONParser jParser = new JSONParser();
	ArrayList<HashMap<String, String>> DaftarWST;

	private static String url_daftar_wst = "http://192.168.137.1/jeparagov/daftar_kuliner.php";
	
	// JSON Node names
	public static final String TAG_SUCCESS = "sukses";
	public static final String TAG_DAFTAR_WST = "daftar_kuliner";
	public static final String TAG_ID_WST = "id_kuliner";
	public static final String TAG_NAMA_KULINER = "nm_kuliner";
	public static final String TAG_ALAMAT_WST = "alamat";
	public static final String TAG_JM_OPERASI = "jam_operasi";
	public static final String TAG_DESKRIPSI = "deskripsi";
	public static final String TAG_GAMBAR_WST = "gambar";
	
	JSONArray daftar_wisata = null;
	ListView list;
	ListKuliner adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kuliner);
		
		DaftarWST = new ArrayList<HashMap<String, String>>();
		list = (ListView) findViewById(R.id.list_kuliner);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TextView txtId = (TextView) view.findViewById(R.id.id_kuliner);
				Intent n = new Intent(KulinerActivity.this,KulinerDetailActivity.class);
				n.putExtra("id_kuliner", txtId.getText().toString());
				startActivity(n);
			}
		});
		
		new LoadData().execute();
		
	}
	
	public void SetListViewAdapter(ArrayList<HashMap<String, String>> daftar) {
		adapter = new ListKuliner(this, daftar, null);
		list.setAdapter(adapter);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	// if result code 100
		if (resultCode == 100) {
			Intent intent = getIntent();
			finish();
			startActivity(intent);
		}
	}
	
	class LoadData extends AsyncTask<String, String, String>{
		
		@Override
		protected void onPreExecute() {
		super.onPreExecute();
			pDialog = new ProgressDialog(KulinerActivity.this);
			pDialog.setMessage("Mohon tunggu...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			JSONObject json = jParser.makeHttpRequest(url_daftar_wst, "GET", params);
			Log.d("Daftar Kuliner : ", json.toString());
			try{
				int success = json.getInt(TAG_SUCCESS);
				if(success == 1){
					daftar_wisata = json.getJSONArray(TAG_DAFTAR_WST);
					for(int i=0; i<daftar_wisata.length(); i++){
						JSONObject c = daftar_wisata.getJSONObject(i);
						String id_wisata = c.getString(TAG_ID_WST);
						String nm_kuliner = c.getString(TAG_NAMA_KULINER);
						String alamat = c.getString(TAG_ALAMAT_WST);
						String jam_operasi = c.getString(TAG_JM_OPERASI);
						String deskripsi = c.getString(TAG_DESKRIPSI);
						String gambar = c.getString(TAG_GAMBAR_WST);
						
						HashMap<String, String> map = new HashMap<String, String>();
						
						map.put(TAG_ID_WST, id_wisata);
						map.put(TAG_NAMA_KULINER, nm_kuliner);
						map.put(TAG_ALAMAT_WST, alamat);
						map.put(TAG_JM_OPERASI, jam_operasi);
						map.put(TAG_DESKRIPSI, deskripsi);
						map.put(TAG_GAMBAR_WST, gambar);
						
						DaftarWST.add(map);
					}
				} else {
					finish();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
			runOnUiThread(new Runnable() {
				public void run() {
					SetListViewAdapter(DaftarWST);
				}
			});
		}
		
	}

}
