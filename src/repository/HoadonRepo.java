/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Hoadon;

/**
 *
 * @author Admin
 */
public class HoadonRepo {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
public ArrayList<Hoadon> getall() {
    ArrayList<Hoadon> list = new ArrayList<>();

    sql = "SELECT \n"
            + "    hd.id,\n"
            + "    hd.maHoaDon,\n"
            + "    kh.ten AS tenKhachHang,\n"
            + "    nv.ten AS tenNhanVien,\n"
            + "    hd.tongTienSauKM,\n"
            + "    hd.ngayThanhToan,\n"
            + "    hd.trangThai\n"
            + "FROM HoaDon hd\n"
            + "JOIN KhachHang kh ON hd.id_khachHang = kh.id\n"
            + "JOIN NhanVien nv ON hd.id_nhanVien = nv.id";

    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Hoadon hd = new Hoadon();
            hd.setId(rs.getInt("id"));
            hd.setMaHD(rs.getString("maHoaDon"));
            hd.setTenkh(rs.getString("tenKhachHang"));
            hd.setTennv(rs.getString("tenNhanVien"));
            hd.setTongtiensauKM(rs.getLong("tongTienSauKM"));
            hd.setNgayThanhToan(rs.getDate("ngayThanhToan"));
            hd.setTrangthai(rs.getBoolean("trangThai"));

            list.add(hd);

            // In ra để debug
            System.out.println("Hóa đơn: " + hd.getMaHD() + 
                               ", KH: " + hd.getTenkh() + 
                               ", NV: " + hd.getTennv() + 
                               ", Tổng tiền: " + hd.getTongtiensauKM());
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return list;
}

    

}
