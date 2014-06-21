<?php
	$dbhost = 'localhost'; //alamat database server
	$dbuser = 'root'; //user database server
	$dbpass = 'adm13'; //password database server kalau tidak ada dikosongkan
	$dbname = 'db_jeparagov'; //nama database

	//skrip koneksi ke database server
	$koneksi = mysql_connect($dbhost, $dbuser, $dbpass);

	//skrip koneksi ke nama database shoutbox
	mysql_select_db($dbname,$koneksi) or die();
?>
