-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2014 at 06:16 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_jeparagov`
--
CREATE DATABASE `db_jeparagov` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_jeparagov`;

-- --------------------------------------------------------

--
-- Table structure for table `tb_kuliner`
--

CREATE TABLE IF NOT EXISTS `tb_kuliner` (
  `id_kuliner` int(11) NOT NULL AUTO_INCREMENT,
  `nm_kuliner` varchar(50) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jam_operasi` varchar(25) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `gambar` varchar(100) NOT NULL,
  PRIMARY KEY (`id_kuliner`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `tb_kuliner`
--

INSERT INTO `tb_kuliner` (`id_kuliner`, `nm_kuliner`, `alamat`, `jam_operasi`, `deskripsi`, `gambar`) VALUES
(1, 'Adon adon coro', 'Shopping Centre Jepara (SCJ)', 'Sore - Malam', 'Adon-adon coro merupakan minuman tradisional dengan bahan : jahe, gula merah, santan, potongan kelap', 'http://192.168.137.1/jeparagov/img/makanan/img_adon.jpg'),
(2, 'Es Gempol Pleret', 'Shopping Centre Jepara (SCJ)', 'Siang - Malam', 'Bahan-bahannya terdiri dari gempol/pleret, santan, dan gula cair. Gempol/pleret berasal dari tepung ', 'http://192.168.137.1/jeparagov/img/makanan/img_gempol.jpg'),
(3, 'Es Dawet Cendol', 'Shopping Centre Jepara (SCJ)', 'Siang - Malam', 'Bahan minuman ini adalah cendol dari tepung sagu/aren, gula merah, dan santan. Semua bahan dicampur ', 'http://192.168.137.1/jeparagov/img/makanan/img_es_cendol.jpg'),
(4, 'Horok horok', 'Pasar Apung Jepara', 'Pagi', 'Horok-horok adalah tepung sagu yang dikukus. Setelah masak dituang dalam tempayan dan diaduk dengan ', 'http://192.168.137.1/jeparagov/img/makanan/img_horok.jpg'),
(5, 'Bontosan', 'Pasar Apung Jepara', 'Pagi', 'Bontosan merupakan bahan baku kerupuk tengiri. Daging ikan tengiri yang dihaluskan dicampur dengan t', 'http://192.168.137.1/jeparagov/img/makanan/img_bongko.jpg'),
(6, 'Latoh', 'Pasar Apung', 'Pagi', 'Demaan, jepara', 'http://192.168.137.1/jeparagov/img/makanan/img_latoh.jpg'),
(7, 'Moka', 'Demaan Jepara', 'Pagi', 'Makanan khas jepara', 'http://192.168.137.1/jeparagov/img/makanan/img_moka.jpg'),
(8, 'Pindang Srani', 'Kr.Kebagusan', 'Kapan saja', 'Uenak ndes', 'http://192.168.137.1/jeparagov/img/makanan/img_pindang.jpg'),
(9, 'Sate Kikil', 'Pasar Apung', 'Pagi', 'Sate kikil', 'http://192.168.137.1/jeparagov/img/makanan/img_sate_kikil.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tb_wisata`
--

CREATE TABLE IF NOT EXISTS `tb_wisata` (
  `id_wisata` int(11) NOT NULL AUTO_INCREMENT,
  `nm_wisata` varchar(50) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jam_operasi` varchar(25) NOT NULL,
  `deskripsi` text NOT NULL,
  `gambar` varchar(100) NOT NULL,
  PRIMARY KEY (`id_wisata`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tb_wisata`
--

INSERT INTO `tb_wisata` (`id_wisata`, `nm_wisata`, `alamat`, `jam_operasi`, `deskripsi`, `gambar`) VALUES
(1, 'Pantai Bandengan', 'Bandengan', 'Senin - Minggu', 'Pantai Tirto Samudro.', 'http://192.168.137.1/jeparagov/img/img_bandengan.jpg'),
(2, 'Pantai Kartini', 'Bulu', 'Senin - Minggu', 'Obyek Wisata Pantai Kartini.', 'http://192.168.137.1/jeparagov/img/img_kartini.jpg'),
(3, 'Pantai Empu Rancak', 'Jepara', 'Senin - Minggu', 'Wilayah Jepara terkenal.', 'http://192.168.137.1/jeparagov/img/img_empu.jpg'),
(4, 'Pantai Teluk Awur', 'Desa Teluk Awur', 'Senin - Minggu', 'Salah satu pantai di kabupaten Jepara.', 'http://192.168.137.1/jeparagov/img/img_teluk.jpg'),
(5, 'Pulau Karimun Jawa', 'Karimun', 'Senin - Minggu', 'Wisata alam di Karimunjawa.', 'http://192.168.137.1/jeparagov/img/img_karimun.jpg'),
(6, 'Pulau Panjang', 'Bulu', 'Senin - Minggu', '1,5 km dari pantai kartini di kelurahan Bulu kecamatan Jepara', 'http://192.168.137.1/jeparagov/img/img_panjang.jpg'),
(7, 'Pulau Mandalika', 'Ds.Donorojo', 'Senin - Minggu', 'berjarak sekitar 2 km Ds.Donorojo, kec.Donorojo kab. Jepara.', 'http://192.168.137.1/jeparagov/img/img_mandalika.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
