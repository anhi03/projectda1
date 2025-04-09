/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utils.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.SPchitiet;

/**
 *
 * @author Admin
 */
public class SPchiTietRepo {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<SPchitiet> getall() {
        ArrayList<SPchitiet> list = new ArrayList<>();
        sql = "SELECT \n"
                + "    ct.id,\n"
                + "    ct.maSPChiTiet,\n"
                + "    sp.tenSP,\n"
                + "    ms.tenMau,\n"
                + "    kt.tenKichThuoc,\n"
                + "    ct.soLuongTon,\n"
                + "    ct.giaBan,\n"
                + "    ct.trangThai\n"
                + "FROM SPChiTiet ct \n"
                + "JOIN SanPham sp ON ct.id_sanPham = sp.id\n"
                + "JOIN MauSac ms ON ct.id_mauSac = ms.id\n"
                + "JOIN KichThuoc kt ON ct.id_kichThuoc = kt.id "
                + "where ct.trangThai=1;";

        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SPchitiet spct = new SPchitiet();
                spct.setId(rs.getInt(1));
                spct.setMaSPChiTiet(rs.getString(2));
                spct.setTenSanPham(rs.getString(3));
                spct.setTenMauSac(rs.getString(4));
                spct.setTenKichThuoc(rs.getString(5));
                spct.setSoluongton(rs.getInt(6));
                spct.setGiaban(rs.getLong(7));
                spct.setTrangthai(rs.getBoolean(8));
                list.add(spct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int add(SPchitiet spct) {
        sql = "INSERT INTO SPChiTiet "
                + "(maSPChiTiet, id_sanPham, id_mauSac, id_kichThuoc, soLuongTon, giaBan) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = Dbconnection.getConnection();

            int idSanPham = getIdFromTen("SanPham", "tenSP", spct.getTenSanPham());
            int idMauSac = getIdFromTen("MauSac", "tenMau", spct.getTenMauSac());
            int idKichThuoc = getIdFromTen("KichThuoc", "tenKichThuoc", spct.getTenKichThuoc());

            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getMaSPChiTiet());
            ps.setObject(2, idSanPham);
            ps.setObject(3, idMauSac);
            ps.setObject(4, idKichThuoc);
            ps.setObject(5, spct.getSoluongton());
            ps.setObject(6, spct.getGiaban());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    
    private int getIdFromTen(String tableName, String columnName, String tenValue) throws SQLException {
    String query = "SELECT id FROM " + tableName + " WHERE " + columnName + " = ?";
    try (PreparedStatement psTemp = con.prepareStatement(query)) {
        psTemp.setString(1, tenValue);
        ResultSet rsTemp = psTemp.executeQuery();
        if (rsTemp.next()) {
            return rsTemp.getInt("id");
        } else {
            throw new SQLException("Không tìm thấy ID trong bảng " + tableName + " với giá trị: " + tenValue);
        }
    }
}

    
    //update
    public int update(SPchitiet spct, String ma) {
        sql = "update SPChiTiet "
                + "set id_sanPham=?, id_mauSac=?, id_kichThuoc=?, "
                + "soLuongTon=?, giaBan=? "
                + "where maSPChiTiet = ?";
        try {
            con = Dbconnection.getConnection();
            int idSanPham = getIdFromTen("SanPham", "tenSP", spct.getTenSanPham());
            int idMauSac = getIdFromTen("MauSac", "tenMau", spct.getTenMauSac());
            int idKichThuoc = getIdFromTen("KichThuoc", "tenKichThuoc", spct.getTenKichThuoc());
            ps = con.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            ps.setObject(2, idMauSac);
            ps.setObject(3, idKichThuoc);
            ps.setObject(4, spct.getSoluongton());
            ps.setObject(5, spct.getGiaban());
            ps.setObject(6, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int remove(String ma) {
        sql = "UPDATE SPChiTiet SET trangthai = 0 WHERE maSPChiTiet = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}
