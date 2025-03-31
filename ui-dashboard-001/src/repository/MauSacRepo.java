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
import model.Kichthuoc;
import model.Loaisanpham;
import model.Mausac;

/**
 *
 * @author Admin
 */
public class MauSacRepo {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

//    màu sắc
    public ArrayList<Mausac> getallms() {
        ArrayList<Mausac> list = new ArrayList<>();
        sql = "SELECT id, mamau, tenmau, trangthai FROM MauSac WHERE trangthai=1 ";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mausac ms = new Mausac();
                ms.setId(rs.getInt(1));
                ms.setMamausac(rs.getString(2));
                ms.setTenmausac(rs.getString(3));
                //ms.setTrangthai(Boolean.TRUE);
                ms.setTrangthai(rs.getBoolean(4));  // Lấy đúng trạng thái từ DB
                list.add(ms);  // Cần thêm vào list
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();;
            return null;
        }
    }

    public int addms(Mausac ms) {
        sql = "insert into MauSac( mamau, tenmau) values (?,?)";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ms.getMamausac());
            ps.setObject(2, ms.getTenmausac());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatems(Mausac mausac, String ma) {
        sql = "UPDATE MauSac SET tenmau = ?, trangthai = ? WHERE mamau = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, mausac.getTenmausac());
            ps.setObject(2, mausac.getTrangthai());
            ps.setObject(3, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deletems(String ma) {
        sql = "UPDATE MauSac SET trangthai = 0 WHERE mamau = ?";
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

    public ArrayList<Mausac> getAllIncludingDeleted() {
        ArrayList<Mausac> list = new ArrayList<>();
        sql = "SELECT id, mamau, tenmau, trangthai FROM MauSac";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mausac ms = new Mausac();
                ms.setId(rs.getInt(1));
                ms.setMamausac(rs.getString(2));
                ms.setTenmausac(rs.getString(3));
                ms.setTrangthai(rs.getBoolean(4));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
