<?php
	$response = array();
	include_once("koneksi.php");
	if(isset($_POST["id_wisata"])) {
		$id = $_POST['id_wisata'];
	}
	
	$hasil = mysql_query("SELECT * FROM tb_wisata WHERE id_wisata = '".$_REQUEST['id_wisata']."'");
	
	if(mysql_num_rows($hasil) > 0){
		$response["daftar_wisata"] = array();
		
		while($baris = mysql_fetch_array($hasil)){
			$daftar_wisata = array();
			$daftar_wisata["id_wisata"] = $baris["id_wisata"];
			$daftar_wisata["nm_wisata"] = stripslashes($baris["nm_wisata"]);
			$daftar_wisata["alamat"] = stripslashes($baris["alamat"]);
			$daftar_wisata["jam_operasi"] = stripslashes($baris["jam_operasi"]);
			$daftar_wisata["deskripsi"] = stripslashes($baris["deskripsi"]);
			$daftar_wisata["gambar"] = stripslashes($baris["gambar"]);
			
			array_push($response["daftar_wisata"], $daftar_wisata);
		}
		
		$response["sukses"] = 1;
		echo json_encode($response);
	} else {
		$response["sukses"] = 0;
		$response["pesan"] = "Tidak ada data";
		echo json_encode($response);
	}
?>