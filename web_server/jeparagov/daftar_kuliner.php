<?php
	$response = array();
	include_once("koneksi.php");
	
	$hasil = mysql_query("SELECT * FROM tb_kuliner ORDER BY nm_kuliner ASC");
	
	if(mysql_num_rows($hasil) > 0){
		$response["daftar_kuliner"] = array();
		
		while($baris = mysql_fetch_array($hasil)){
			$daftar_kuliner = array();
			$daftar_kuliner["id_kuliner"] = $baris["id_kuliner"];
			$daftar_kuliner["nm_kuliner"] = stripslashes($baris["nm_kuliner"]);
			$daftar_kuliner["alamat"] = stripslashes($baris["alamat"]);
			$daftar_kuliner["jam_operasi"] = stripslashes($baris["jam_operasi"]);
			$daftar_kuliner["deskripsi"] = stripslashes($baris["deskripsi"]);
			$daftar_kuliner["gambar"] = stripslashes($baris["gambar"]);
			
			array_push($response["daftar_kuliner"], $daftar_kuliner);
		}
		
		$response["sukses"] = 1;
		echo json_encode($response);
	} else {
		$response["sukses"] = 0;
		$response["pesan"] = "Tidak ada data";
		echo json_encode($response);
	}
?>