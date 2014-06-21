package id.aditya.jeparagov;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListKuliner extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;
	public TextView id_kuliner;
	
	public ListKuliner(Activity a, ArrayList<HashMap<String, String>> data, TextView id) {
		super();
		this.activity = a;
		this.data = data;
		this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
		this.id_kuliner = id;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		if (convertView == null)
		vi = inflater.inflate(R.layout.item_list_kuliner, null);
		
		id_kuliner = (TextView) vi.findViewById(R.id.id_kuliner); 
		TextView nm_kuliner = (TextView) vi.findViewById(R.id.nama_kuliner);
		TextView alamat_kuliner = (TextView) vi.findViewById(R.id.alamat_kuliner);
		TextView jam_operasi_kuliner = (TextView) vi.findViewById(R.id.jam_operasi_kuliner); 
		TextView deskripsi_kuliner = (TextView) vi.findViewById(R.id.deskripsi_kuliner);
		ImageView thumb_image = (ImageView) vi.findViewById(R.id.image_kuliner);
		
		HashMap<String, String> daftar_kuliner = new HashMap<String, String>();
		daftar_kuliner = data.get(position);
		id_kuliner.setText(daftar_kuliner.get(KulinerActivity.TAG_ID_WST));
		nm_kuliner.setText(daftar_kuliner.get(KulinerActivity.TAG_NAMA_KULINER));
		alamat_kuliner.setText(daftar_kuliner.get(KulinerActivity.TAG_ALAMAT_WST));
		jam_operasi_kuliner.setText(daftar_kuliner.get(KulinerActivity.TAG_JM_OPERASI));
		deskripsi_kuliner.setText(daftar_kuliner.get(KulinerActivity.TAG_DESKRIPSI));
		imageLoader.DisplayImage(daftar_kuliner.get(KulinerActivity.TAG_GAMBAR_WST), thumb_image);
		return vi;
	}
}
