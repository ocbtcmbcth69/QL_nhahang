-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 26, 2021 lúc 11:40 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlnhahang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` int(11) NOT NULL,
  `MaKhuVuc` int(11) NOT NULL,
  `TenBan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `MaKhuVuc`, `TenBan`, `TrangThai`) VALUES
(1, 1, 'Bàn 1', 'Trống'),
(2, 7, 'Bàn 2', 'Trống'),
(3, 2, 'Bàn 3', 'Trống'),
(4, 2, 'Bàn 4', 'Trống'),
(5, 4, 'Bàn 5', 'Đã đặt trước'),
(6, 4, 'Bàn 6', 'Đang phục vụ'),
(7, 7, 'Bàn 7', 'Trống'),
(8, 3, 'Bàn Bàn 9', 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `calamviec`
--

CREATE TABLE `calamviec` (
  `MaCTCLV` int(11) NOT NULL,
  `MaNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GioBDThucTe` time NOT NULL,
  `GioKTThucTe` time NOT NULL,
  `NgayLam` date NOT NULL,
  `TienChotCa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `calamviec`
--

INSERT INTO `calamviec` (`MaCTCLV`, `MaNV`, `GioBDThucTe`, `GioKTThucTe`, `NgayLam`, `TienChotCa`) VALUES
(1, 'NV2', '20:53:38', '20:54:09', '2021-01-10', 140000),
(2, 'NV2', '22:07:24', '22:08:05', '2021-01-14', 50000),
(3, 'NV2', '22:16:22', '22:16:58', '2021-01-14', 50000),
(4, 'NV2', '07:41:51', '20:42:00', '2021-01-15', 0),
(5, 'NV2', '07:49:33', '07:50:00', '2021-01-15', 47500),
(6, 'NV2', '07:55:33', '07:59:52', '2021-01-15', 0),
(7, 'NV5', '19:01:40', '19:02:13', '2021-12-14', 1400000),
(8, 'NV5', '14:20:25', '14:21:51', '2021-12-21', 1500000),
(9, 'NV5', '16:07:52', '16:08:49', '2021-12-21', 120000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaChiTietHD` int(11) NOT NULL,
  `MaHoaDon` int(11) NOT NULL,
  `MaMon` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MaChiTietHD`, `MaHoaDon`, `MaMon`, `SoLuong`, `Gia`) VALUES
(6, 8, 1, 1, 25000),
(7, 8, 2, 2, 25000),
(9, 10, 1, 1, 25000),
(10, 10, 2, 1, 25000),
(11, 11, 1, 1, 25000),
(14, 14, 2, 1, 25000),
(16, 16, 1, 1, 25000),
(21, 20, 1, 1, 25000),
(22, 20, 2, 1, 25000),
(31, 26, 1, 3, 25000),
(33, 26, 2, 1, 25000),
(34, 27, 1, 1, 25000),
(35, 28, 2, 1, 25000),
(36, 29, 1, 3, 25000),
(37, 30, 1, 1, 25000),
(38, 30, 2, 1, 25000),
(39, 31, 1, 1, 25000),
(40, 31, 2, 1, 25000),
(41, 32, 1, 4, 25000),
(42, 32, 2, 2, 25000),
(46, 35, 1, 1, 25000),
(52, 39, 1, 1, 25000),
(53, 39, 2, 1, 25000),
(55, 41, 1, 1, 25000),
(56, 41, 2, 1, 25000),
(61, 46, 1, 1, 25000),
(62, 46, 2, 3, 25000),
(66, 50, 1, 3, 25000),
(67, 50, 2, 1, 25000),
(68, 51, 2, 1, 25000),
(70, 53, 1, 5, 25000),
(71, 54, 2, 2, 25000),
(72, 54, 1, 4, 25000),
(73, 55, 1, 1, 25000),
(74, 55, 2, 1, 25000),
(75, 56, 1, 1, 25000),
(76, 57, 1, 1, 25000),
(77, 58, 1, 2, 25000),
(78, 59, 1, 1, 25000),
(79, 60, 1, 4, 25000),
(80, 61, 1, 1, 25000),
(81, 62, 1, 1, 25000),
(82, 63, 1, 1, 25000),
(83, 64, 1, 1, 25000),
(84, 65, 2, 1, 25000),
(85, 65, 1, 1, 25000),
(86, 66, 1, 1, 25000),
(87, 67, 1, 1, 25000),
(88, 68, 2, 1, 25000),
(89, 69, 1, 1, 25000),
(90, 70, 1, 1, 25000),
(91, 71, 1, 1, 25000),
(92, 72, 2, 1, 25000),
(93, 73, 1, 1, 25000),
(94, 73, 2, 1, 25000),
(95, 74, 1, 1, 25000),
(96, 74, 2, 1, 25000),
(97, 75, 1, 1, 25000),
(98, 75, 2, 1, 25000),
(100, 77, 1, 1, 25000),
(101, 78, 1, 1, 25000),
(105, 82, 7, 1, 15000),
(106, 82, 9, 1, 20000),
(107, 82, 13, 1, 40000),
(108, 83, 38, 1, 20000),
(109, 83, 22, 1, 25000),
(110, 83, 46, 1, 30000),
(114, 84, 1, 1, 25000),
(117, 85, 38, 1, 20000),
(118, 85, 35, 1, 70000),
(123, 86, 1, 1, 118000),
(125, 87, 5, 1, 88000),
(126, 87, 6, 1, 108000),
(127, 87, 8, 1, 350000),
(128, 87, 59, 1, 1800000),
(129, 87, 60, 1, 100000),
(130, 87, 58, 1, 1500000),
(131, 87, 47, 1, 95000),
(132, 84, 24, 1, 148000),
(134, 84, 59, 2, 1800000),
(135, 84, 47, 1, 95000),
(136, 88, 59, 2, 1800000),
(137, 88, 49, 1, 98000),
(138, 88, 35, 1, 468000),
(139, 89, 3, 1, 128000),
(140, 89, 11, 1, 388000),
(143, 89, 59, 1, 1800000),
(144, 89, 12, 1, 138000),
(145, 89, 24, 1, 148000),
(146, 85, 59, 1, 1800000),
(147, 85, 51, 5, 20000),
(148, 90, 9, 1, 228000),
(149, 90, 30, 1, 108000),
(150, 90, 49, 1, 98000),
(151, 91, 1, 1, 118000),
(152, 91, 9, 1, 228000),
(153, 92, 18, 1, 348000),
(154, 92, 21, 1, 155000),
(155, 92, 39, 1, 268000),
(156, 93, 11, 1, 388000),
(157, 93, 49, 1, 98000),
(158, 93, 59, 1, 1800000),
(159, 94, 1, 1, 118000),
(160, 95, 1, 3, 118000),
(161, 95, 26, 1, 198000),
(162, 95, 61, 1, 50000),
(163, 96, 9, 1, 228000),
(164, 97, 5, 1, 88000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `MaNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'NV',
  `GiamGia` int(11) NOT NULL,
  `MaBan` int(11) NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaNV`, `GiamGia`, `MaBan`, `GioDen`, `TongTien`, `TrangThai`) VALUES
(8, 'NV1', 30, 2, '2021-12-14 17:51:32', 52500, 1),
(10, 'NV1', 0, 3, '2021-12-14 19:03:07', 50000, 1),
(11, 'NV1', 0, 1, '2021-12-14 19:04:29', 25000, 1),
(14, 'NV1', 0, 1, '2021-12-14 19:20:01', 25000, 1),
(16, 'NV1', 0, 2, '2021-12-14 19:22:42', 25000, 1),
(20, 'NV1', 0, 3, '2021-12-14 19:54:50', 50000, 1),
(26, 'NV1', 0, 1, '2021-12-14 22:13:04', 100000, 1),
(27, 'NV1', 20, 1, '2021-12-14 22:13:32', 20000, 1),
(28, 'NV1', 0, 6, '2020-12-14 22:13:36', 25000, 1),
(29, 'NV1', 50, 1, '2021-10-15 17:59:50', 37500, 1),
(30, 'NV1', 0, 1, '2021-10-17 19:53:27', 50000, 1),
(31, 'NV1', 0, 2, '2021-10-18 21:02:17', 50000, 1),
(32, 'NV1', 0, 1, '2021-10-18 22:09:08', 150000, 1),
(35, 'NV2', 0, 1, '2021-11-21 01:03:36', 25000, 1),
(39, 'NV1', 0, 1, '2021-11-22 22:53:53', 50000, 1),
(41, 'NV1', 0, 1, '2021-11-22 22:57:58', 50000, 1),
(46, 'NV1', 0, 1, '2021-09-22 23:43:51', 100000, 1),
(50, 'NV1', 0, 1, '2021-09-24 18:55:33', 100000, 1),
(51, 'NV1', 0, 2, '2021-09-27 18:01:13', 25000, 1),
(53, 'NV1', 0, 1, '2021-01-10 20:47:22', 125000, 1),
(54, 'NV2', 0, 1, '2021-01-10 20:53:47', 150000, 1),
(55, 'NV2', 5, 1, '2021-01-14 22:07:28', 47500, 1),
(56, 'NV1', 0, 1, '2021-01-14 22:11:27', 25000, 1),
(57, 'NV2', 0, 1, '2021-01-14 22:16:28', 25000, 1),
(58, 'NV1', 0, 1, '2021-01-14 22:30:53', 50000, 1),
(59, 'NV1', 0, 2, '2021-01-14 22:32:45', 25000, 1),
(60, 'NV1', 0, 1, '2021-01-14 22:33:40', 100000, 1),
(61, 'NV1', 0, 2, '2021-01-14 22:40:33', 25000, 1),
(62, 'NV1', 0, 1, '2021-01-14 22:46:05', 25000, 1),
(63, 'NV1', 0, 1, '2021-01-14 22:47:41', 25000, 1),
(64, 'NV1', 0, 1, '2021-01-14 22:49:37', 25000, 1),
(65, 'NV1', 0, 2, '2021-01-14 22:50:11', 50000, 1),
(66, 'NV1', 0, 3, '2021-01-14 22:52:48', 25000, 1),
(67, 'NV1', 0, 1, '2021-01-14 23:25:24', 25000, 1),
(68, 'NV1', 0, 1, '2021-01-14 23:26:39', 25000, 1),
(69, 'NV1', 0, 1, '2021-01-14 23:44:02', 25000, 1),
(70, 'NV1', 0, 1, '2021-01-14 23:44:48', 25000, 1),
(71, 'NV1', 0, 1, '2021-01-14 23:48:41', 25000, 1),
(72, 'NV1', 0, 3, '2021-01-14 23:55:02', 25000, 1),
(73, 'NV1', 5, 1, '2021-01-15 00:11:10', 47500, 1),
(74, 'NV2', 5, 7, '2021-01-15 07:49:39', 47500, 1),
(75, 'NV2', 0, 1, '2021-01-15 07:55:36', 50000, 1),
(77, 'NV4', 0, 5, '2021-12-14 18:36:49', 25000, 1),
(78, 'NV4', 0, 5, '2021-12-14 18:37:38', 25000, 1),
(82, 'NV4', 0, 5, '2021-12-14 19:12:44', 75000, 1),
(83, 'NV4', 0, 5, '2021-12-14 19:15:03', 75000, 1),
(84, 'NV4', 50, 5, '2021-10-14 19:17:16', 1934000, 1),
(85, 'NV4', 0, 1, '2021-11-14 21:14:26', 1990000, 1),
(86, 'NV4', 0, 7, '2021-12-17 17:59:29', 118000, 1),
(87, 'NV4', 0, 6, '2021-12-18 09:02:00', 4041000, 1),
(88, 'NV4', 0, 5, '2021-12-18 09:26:57', 4166000, 1),
(89, 'NV4', 0, 5, '2021-12-18 09:46:20', 2602000, 1),
(90, 'NV4', 0, 5, '2021-12-21 12:58:08', 434000, 1),
(91, 'NV4', 5, 7, '2021-12-21 13:07:16', 328700, 1),
(92, 'NV5', 0, 3, '2021-12-21 14:20:43', 771000, 1),
(93, 'NV5', 0, 1, '2021-12-21 14:20:58', 2286000, 1),
(94, 'NV4', 0, 6, '2021-12-21 14:41:59', NULL, 0),
(95, 'NV4', 10, 7, '2021-12-21 16:04:46', 541800, 1),
(96, 'NV4', 5, 1, '2021-12-26 17:33:48', 216600, 1),
(97, 'NV4', 0, 1, '2021-12-26 17:37:35', 88000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuvuc`
--

CREATE TABLE `khuvuc` (
  `MaKhuVuc` int(11) NOT NULL,
  `TenKhuVuc` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuvuc`
--

INSERT INTO `khuvuc` (`MaKhuVuc`, `TenKhuVuc`) VALUES
(1, 'Tầng 1'),
(2, 'Tầng 2'),
(3, 'Tầng 3'),
(4, 'Tầng 4'),
(7, 'Tầng 5'),
(8, 'Tầng 1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` tinyint(4) NOT NULL,
  `ChucVu` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NgayVaoLam` date NOT NULL,
  `DiaChi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` int(11) NOT NULL,
  `PhanQuyen` tinyint(4) NOT NULL,
  `MatKhau` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `GioiTinh`, `ChucVu`, `NgayVaoLam`, `DiaChi`, `SDT`, `PhanQuyen`, `MatKhau`) VALUES
('NV1', 'Thanh Tùng', 0, 'Quản lý', '2020-12-01', 'HCM\n', 386202101, 1, 'c4ca4238a0b923820dcc509a6f75849b'),
('NV2', 'Linh', 1, 'Nhân viên', '2020-12-01', 'HCM', 1231243214, 2, '1'),
('NV4', 'Trang', 1, 'Quản lý', '2021-12-14', 'Củ Chi', 8082016, 1, 'C4CA4238A0B923820DCC509A6F75849B'),
('NV5', 'Trâm Anh', 1, 'Nhân viên', '2021-12-14', 'Hóc Môn', 342759, 2, 'C4CA4238A0B923820DCC509A6F75849B');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhommon`
--

CREATE TABLE `nhommon` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhommon`
--

INSERT INTO `nhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Salad', '#33cc00'),
(2, 'Hấp/Xông Khói', '#EC2049'),
(3, 'Món Âu', '#333333'),
(4, 'Món Nhậu', '#F9D423'),
(5, 'Món Lẩu', '#FC913A'),
(6, 'Cơm/Canh', '#FF8C94'),
(7, 'Đồ Uống', '#45ADA8');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `MaMon` int(11) NOT NULL,
  `TenMon` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(1, 'SALAD CÁ HỒI ÁP CHẢO', 1, 118000, 'Đĩa'),
(2, 'SALAD CÁ NGỪ', 1, 98000, 'Đĩa'),
(3, 'GỎI BÒ MĂNG TRÚC', 1, 128000, 'Đĩa'),
(4, 'NỘM CỔ HỦ DỪA', 1, 98000, 'Đĩa'),
(5, 'SALAD BÒ MỸ CẢI MẦM', 1, 88000, 'Đĩa'),
(6, 'GỎI TÔM TẦM XUÂN', 1, 108000, 'Đĩa'),
(7, 'MỰC TRỨNG HẤP', 2, 228000, 'Đĩa'),
(8, 'TÔM CÀNG XANH HẤP', 2, 350000, 'Đĩa'),
(9, 'MỰC NANG HẤP', 2, 228000, 'Đĩa'),
(10, 'DÊ NÚI XÔNG KHÓI', 2, 268000, 'Đĩa'),
(11, 'BÒ FUJI XÔNG KHÓI', 2, 388000, 'Đĩa'),
(12, 'LỢN NƯỚNG KIỂU NGA', 3, 138000, 'Đĩa'),
(13, 'SƯỜN NƯỚNG KHỦNG', 3, 358000, 'Đĩa'),
(14, 'BẮP CỪU NƯỚNG ĐÁ', 3, 398000, 'Đĩa'),
(15, 'BÒ FUJI NƯỚNG ĐÁ', 3, 388000, 'Đĩa'),
(16, 'BÒ ÚC NƯỚNG ĐÁ', 3, 268000, 'Đĩa'),
(17, 'CÁ HỒI SỐT CHANH LEO', 3, 268000, 'Đĩa'),
(18, 'ĐÙI LỢN HẦM KIỂU ĐỨC', 3, 348000, 'Đĩa'),
(19, 'GAN NGỖNG ÁP CHẢO', 3, 388000, 'Đĩa'),
(20, 'MÌ Ý SỐT BÒ BẰM', 3, 135000, 'Đĩa'),
(21, 'MÌ Ý SỐT KEM NẤM', 3, 155000, 'Đĩa'),
(22, 'TRÂU GÁC BẾP', 4, 155000, 'Đĩa'),
(23, 'DÊ NƯỚNG TẢNG', 4, 248000, 'Đĩa'),
(24, 'MÓNG GIÒ CHÁY TỎI', 4, 148000, 'Đĩa'),
(25, 'ẾCH XÀO LĂN', 4, 128000, 'Đĩa'),
(26, 'MỰC 1 NẮNG NƯỚNG', 4, 198000, 'Đĩa'),
(27, 'CHẢ NGAO', 4, 118000, 'Đĩa'),
(28, 'CHÂN GÀ QUÁI THÚ', 4, 128000, 'Đĩa'),
(29, 'DẠ DÀY QUAY', 4, 148000, 'Đĩa'),
(30, 'PHÁ LẤU', 4, 108000, 'Đĩa'),
(31, 'XÁ XÍU QUAY', 4, 108000, 'Đĩa'),
(32, 'DỒI LỢN NƯỚNG', 4, 118000, 'Đĩa'),
(33, 'KIM CHI BÒ', 5, 348000, 'Nồi'),
(34, 'ĐẦU CÁ HỒI KIM CHI', 5, 295000, 'Nồi'),
(35, 'HẢI SẢN KIỂU THÁI', 5, 468000, 'Nồi'),
(36, 'GÀ LÁ É', 5, 295000, 'Nồi'),
(37, 'GÀ NẤM TƯƠI', 5, 368000, 'Nồi'),
(38, 'GÀ ỚT HIỂM', 5, 348000, 'Nồi'),
(39, 'VỊT OM SẤU', 5, 268000, 'Nồi'),
(40, 'VỊT OM MĂNG CAY', 5, 268000, 'Nồi'),
(41, 'CƠM CHIÊN DƯƠNG CHÂU', 6, 88000, 'Đĩa'),
(42, 'CƠM CHIÊN CÁ MẶN', 6, 88000, 'Đĩa'),
(43, 'CƠM CHIÊN HẢI SẢN', 6, 98000, 'Đĩa'),
(44, 'CƠM TRẮNG', 6, 45000, 'Thố'),
(45, 'CANH CHUA CÁ LÓC', 6, 58000, 'Thố'),
(46, 'CANH CUA MỒNG TƠI', 6, 58000, 'Thố'),
(47, 'SƯỜN NON NẤU SẤU', 6, 95000, 'Thố'),
(48, 'BA CHỈ CHÁY CẠNH', 6, 88000, 'Đĩa'),
(49, 'CÁ BÔNG LAU KHO TỘ', 6, 98000, 'Thố'),
(50, 'KHO QUẸT', 6, 58000, 'Thố'),
(51, 'BIA HEINEKEN', 7, 20000, 'Chai'),
(52, 'BIA SÀI GÒN', 7, 15000, 'Chai'),
(53, 'BIA HÀ NỘI', 7, 12000, 'Chai'),
(55, 'COCA/PEPSI', 7, 10000, 'Lon'),
(56, 'NƯỚC SUỐI AQUA', 7, 8000, 'Chai'),
(57, 'VANG CHILE 3L', 7, 500000, 'Bịch'),
(58, 'CHIVAS REGAL 18Y', 7, 1500000, 'Chai'),
(59, 'BALLANTIES 21Y 700ML', 7, 1800000, 'Chai'),
(60, 'VOLKA HN 750ML', 7, 100000, 'Chai'),
(61, 'TRÀ SỮA HOÀNG GIA', 7, 50000, 'Ly');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`),
  ADD KEY `MaKhuVuc` (`MaKhuVuc`);

--
-- Chỉ mục cho bảng `calamviec`
--
ALTER TABLE `calamviec`
  ADD PRIMARY KEY (`MaCTCLV`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `khuvuc`
--
ALTER TABLE `khuvuc`
  ADD PRIMARY KEY (`MaKhuVuc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMon`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `calamviec`
--
ALTER TABLE `calamviec`
  MODIFY `MaCTCLV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT cho bảng `khuvuc`
--
ALTER TABLE `khuvuc`
  MODIFY `MaKhuVuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ban`
--
ALTER TABLE `ban`
  ADD CONSTRAINT `ban_ibfk_1` FOREIGN KEY (`MaKhuVuc`) REFERENCES `khuvuc` (`MaKhuVuc`);

--
-- Các ràng buộc cho bảng `calamviec`
--
ALTER TABLE `calamviec`
  ADD CONSTRAINT `calamviec_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
