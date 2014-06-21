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

public class ListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList<HashMap<String, String>> data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;
	public TextView id_wisata;
	
	public ListAdapter(Activity a, ArrayList<HashMap<String, String>> data, TextView id) {
		super();
		this.activity = a;
		this.data = data;
		this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
		this.id_wisata = id;
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
		vi = inflater.inflate(R.layout.item_list_wisata, null);
		
		id_wisata = (TextView) vi.findViewById(R.id.id_wisata); 
		TextView nm_wisata = (TextView) vi.findViewById(R.id.nm_wisata);
		TextView alamat = (TextView) vi.findViewById(R.id.alamat);
		TextView jam_operasi = (TextView) vi.findViewById(R.id.jam_operasi); 
		TextView deskripsi = (TextView) vi.findViewById(R.id.deskripsi);
		ImageView thumb_image = (ImageView) vi.findViewById(R.id.image_wisata);
		
		HashMap<String, String> daftar_wisata = new HashMap<String, String>();
		daftar_wisata = data.get(position);
		id_wisata.setText(daftar_wisata.get(WisataActivity.TAG_ID_WST));
		nm_wisata.setText(daftar_wisata.get(WisataActivity.TAG_NAMA_WST));
		alamat.setText(daftar_wisata.get(WisataActivity.TAG_ALAMAT_WST));
		jam_operasi.setText(daftar_wisata.get(WisataActivity.TAG_JM_OPERASI));
		deskripsi.setText(daftar_wisata.get(WisataActivity.TAG_DESKRIPSI));
		imageLoader.DisplayImage(daftar_wisata.get(WisataActivity.TAG_GAMBAR_WST), thumb_image);
		return vi;
	}

}
