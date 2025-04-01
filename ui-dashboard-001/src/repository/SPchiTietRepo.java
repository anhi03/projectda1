/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utils.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        sql = "select "
                + "id, maSPChiTiet, id_sanPham, id_mauSac, id_kichThuoc, soLuongTon, giaBan, trangthai "
                + "from SPChiTiet "
                + "where trangthai=1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SPchitiet spct = new SPchitiet();
                spct.setId(rs.getInt(1));
                spct.setMaSPChiTiet(rs.getString(2));
                spct.setIdsanpham(rs.getInt(3));
                spct.setIdmausac(rs.getInt(4));
                spct.setIdkichthuoc(rs.getInt(5));
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
                + "VALUES(?,?,?,?,?,?)";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getMaSPChiTiet());
            ps.setObject(2, spct.getIdsanpham());
            ps.setObject(3, spct.getIdmausac());
            ps.setObject(4, spct.getIdkichthuoc());
            ps.setObject(5, spct.getSoluongton());
            ps.setObject(6, spct.getGiaban());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(SPchitiet spct, String ma) {
        sql = "update SPChiTiet "
                + "set id_sanPham=?, id_mauSac=?, id_kichThuoc=?, "
                + "soLuongTon=?, giaBan=? "
                + "where maSPChiTiet = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getIdsanpham());
            ps.setObject(2, spct.getIdmausac());
            ps.setObject(3, spct.getIdkichthuoc());
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

    public ArrayList<SPchitiet> search(String keyword) {
        ArrayList<SPchitiet> list = new ArrayList<>();
        String sql = "SELECT id, maSPChiTiet, id_sanPham, id_mauSac, id_kichThuoc, soLuongTon, giaBan, trangthai FROM SPChiTiet "
                + "WHERE maSPChiTiet LIKE ? OR soLuongTon LIKE ?";

        try (Connection con = Dbconnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SPchitiet spct = new SPchitiet();
                spct.setId(rs.getInt(1));
                spct.setMaSPChiTiet(rs.getString(2));
                spct.setIdsanpham(rs.getInt(3));
                spct.setIdmausac(rs.getInt(4));
                spct.setIdkichthuoc(rs.getInt(5));
                spct.setSoluongton(rs.getInt(6));
                spct.setGiaban(rs.getLong(7));
                spct.setTrangthai(rs.getBoolean(8));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
