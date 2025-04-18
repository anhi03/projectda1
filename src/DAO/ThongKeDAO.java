/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.DBConnect;
import static Utils.DBConnect.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DoanhThu;

/**
 *
 * @author anh quoc
 */
public class ThongKeDAO {

    public static List<DoanhThu> getDoanhThuTheoNgay(Date ngayBatDau, Date ngayKetThuc) {
        List<DoanhThu> doanhThuList = new ArrayList<>();

        String sql = "SELECT "
                + "HD.ngayThanhToan, "
                + "NV.maNhanVien, "
                + "NV.ten AS tenNhanVien, "
                + "SP.tenSP, "
                + "SUM(CT.soLuong) AS soLuongBan, "
                + "SUM(CT.soLuong * SPChiTiet.giaBan) AS tongTienTruocKM, "
                + "SUM(HD.tongKhuyenMai) AS tongTienKhuyenMai, "
                + "SUM(CT.soLuong * SPChiTiet.giaBan) - SUM(HD.tongKhuyenMai) AS tongTienSauKM "
                + "FROM HoaDon HD "
                + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
                + "JOIN SanPham SP ON CT.id_spChiTiet = SP.id "
                + "JOIN NhanVien NV ON HD.id_nhanVien = NV.id "
                + "JOIN SPChiTiet ON CT.id_spChiTiet = SPChiTiet.id "
                + "LEFT JOIN Voucher V ON HD.id_voucher = V.id "
                + "WHERE HD.ngayThanhToan BETWEEN ? AND ? "
                + "GROUP BY HD.ngayThanhToan, NV.maNhanVien, NV.ten, SP.tenSP "
                + "ORDER BY HD.ngayThanhToan, NV.maNhanVien, SP.tenSP";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(ngayBatDau.getTime()));
            stmt.setDate(2, new java.sql.Date(ngayKetThuc.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DoanhThu doanhThu = new DoanhThu(
                            rs.getDate("ngayThanhToan"),
                            rs.getString("maNhanVien"),
                            rs.getString("tenNhanVien"),
                            rs.getString("tenSP"),
                            rs.getInt("soLuongBan"),
                            rs.getDouble("tongTienTruocKM"),
                            rs.getDouble("tongTienKhuyenMai"),
                            rs.getDouble("tongTienSauKM")
                    );

                    doanhThuList.add(doanhThu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doanhThuList;
    }

    public static int getTongSoLuongBanTheoNgay(Date ngay) {
        int tongSoLuongBan = 0;

        String sql = "SELECT SUM(CT.soLuong) AS tongSoLuongBan "
                + "FROM HoaDon HD "
                + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
                + "WHERE CAST(HD.ngayThanhToan AS DATE) = ?";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, new java.sql.Date(ngay.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tongSoLuongBan = rs.getInt("tongSoLuongBan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongSoLuongBan;
    }

    public static int getTongSoLuongBanTheoThang(int nam, int thang) {
        int tongSoLuongBan = 0;

        String sql = "SELECT SUM(CT.soLuong) AS tongSoLuongBan "
                + "FROM HoaDon HD "
                + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
                + "WHERE YEAR(HD.ngayThanhToan) = ? AND MONTH(HD.ngayThanhToan) = ?";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam);
            stmt.setInt(2, thang);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tongSoLuongBan = rs.getInt("tongSoLuongBan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongSoLuongBan;
    }

    public static int getTongSoLuongBanTheoNam(int nam) {
        int tongSoLuongBan = 0;

        String sql = "SELECT SUM(CT.soLuong) AS tongSoLuongBan "
                + "FROM HoaDon HD "
                + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
                + "WHERE YEAR(HD.ngayThanhToan) = ?";

        try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nam);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tongSoLuongBan = rs.getInt("tongSoLuongBan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongSoLuongBan;
    }

    public static List<DoanhThu> getDoanhThuTheoThang(Date date) {
       List<DoanhThu> doanhThuList = new ArrayList<>();

    // Lấy tháng và năm từ đối tượng Date
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.setTime(date);
    int month = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng (1-12)
    int year = calendar.get(java.util.Calendar.YEAR); // Năm

    String sql = "SELECT "
            + "HD.ngayThanhToan, "
            + "NV.maNhanVien, "
            + "NV.ten AS tenNhanVien, "
            + "SP.tenSP, "
            + "SUM(CT.soLuong) AS soLuongBan, "
            + "SUM(CT.soLuong * SPChiTiet.giaBan) AS tongTienTruocKM, "
            + "SUM(HD.tongKhuyenMai) AS tongTienKhuyenMai, "
            + "SUM(CT.soLuong * SPChiTiet.giaBan) - SUM(HD.tongKhuyenMai) AS tongTienSauKM "
            + "FROM HoaDon HD "
            + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
            + "JOIN SanPham SP ON CT.id_spChiTiet = SP.id "
            + "JOIN NhanVien NV ON HD.id_nhanVien = NV.id "
            + "JOIN SPChiTiet ON CT.id_spChiTiet = SPChiTiet.id "
            + "LEFT JOIN Voucher V ON HD.id_voucher = V.id "
            + "WHERE YEAR(HD.ngayThanhToan) = ? AND MONTH(HD.ngayThanhToan) = ? "
            + "GROUP BY HD.ngayThanhToan, NV.maNhanVien, NV.ten, SP.tenSP "
            + "ORDER BY HD.ngayThanhToan, NV.maNhanVien, SP.tenSP";

    try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, year);  // Set năm
        stmt.setInt(2, month); // Set tháng

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DoanhThu doanhThu = new DoanhThu(
                        rs.getDate("ngayThanhToan"),
                        rs.getString("maNhanVien"),
                        rs.getString("tenNhanVien"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuongBan"),
                        rs.getDouble("tongTienTruocKM"),
                        rs.getDouble("tongTienKhuyenMai"),
                        rs.getDouble("tongTienSauKM")
                );

                doanhThuList.add(doanhThu);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return doanhThuList;
    }

    public static List<DoanhThu> getDoanhThuTheoNam(Date date) {
 List<DoanhThu> doanhThuList = new ArrayList<>();

    // Lấy năm từ đối tượng Date
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.setTime(date);
    int year = calendar.get(java.util.Calendar.YEAR); // Năm

    String sql = "SELECT "
            + "HD.ngayThanhToan, "
            + "NV.maNhanVien, "
            + "NV.ten AS tenNhanVien, "
            + "SP.tenSP, "
            + "SUM(CT.soLuong) AS soLuongBan, "
            + "SUM(CT.soLuong * SPChiTiet.giaBan) AS tongTienTruocKM, "
            + "SUM(HD.tongKhuyenMai) AS tongTienKhuyenMai, "
            + "SUM(CT.soLuong * SPChiTiet.giaBan) - SUM(HD.tongKhuyenMai) AS tongTienSauKM "
            + "FROM HoaDon HD "
            + "JOIN ChiTietHoaDon CT ON HD.id = CT.id_hoaDon "
            + "JOIN SanPham SP ON CT.id_spChiTiet = SP.id "
            + "JOIN NhanVien NV ON HD.id_nhanVien = NV.id "
            + "JOIN SPChiTiet ON CT.id_spChiTiet = SPChiTiet.id "
            + "LEFT JOIN Voucher V ON HD.id_voucher = V.id "
            + "WHERE YEAR(HD.ngayThanhToan) = ? "
            + "GROUP BY HD.ngayThanhToan, NV.maNhanVien, NV.ten, SP.tenSP "
            + "ORDER BY HD.ngayThanhToan, NV.maNhanVien, SP.tenSP";

    try (Connection conn = DBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, year);  // Set năm

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DoanhThu doanhThu = new DoanhThu(
                        rs.getDate("ngayThanhToan"),
                        rs.getString("maNhanVien"),
                        rs.getString("tenNhanVien"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuongBan"),
                        rs.getDouble("tongTienTruocKM"),
                        rs.getDouble("tongTienKhuyenMai"),
                        rs.getDouble("tongTienSauKM")
                );

                doanhThuList.add(doanhThu);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return doanhThuList;    }

   

}
