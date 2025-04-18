package repository;

import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HDChiTiet;

public class ChiTietHoaDonRepo {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<HDChiTiet> getByHoaDonId(int hoaDonId) {
        ArrayList<HDChiTiet> list = new ArrayList<>();
        sql = "SELECT \n" +
              "    ct.id,\n" +
              "    ct.maHDCT,\n" +
              "    hd.maHoaDon,\n" +
              "    sp.maSPChiTiet,\n" +
              "    ct.donGia,\n" +
              "    ct.soLuong,\n" +
              "    (ct.donGia * ct.soLuong) as thanhTien\n" +
              "FROM ChiTietHoaDon ct\n" +
              "JOIN HoaDon hd ON ct.id_hoaDon = hd.id\n" +
              "JOIN SPChiTiet sp ON ct.id_spChiTiet = sp.id\n" +
              "WHERE ct.id_hoaDon = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, hoaDonId);
            rs = ps.executeQuery();
            while (rs.next()) {
                HDChiTiet ct = new HDChiTiet();
                ct.setId(rs.getInt(1));
                ct.setMaHDCT(rs.getString(2));
                ct.setMahd(rs.getString(3));
                ct.setMaspct(rs.getString(4));
                ct.setDongia(rs.getLong(5));
                ct.setSoluong(rs.getInt(6));
//                ct.(rs.getDouble(7));
                list.add(ct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<HDChiTiet> getByIdHD(int idHD) {
    ArrayList<HDChiTiet> list = new ArrayList<>();
    String sql = "SELECT ct.id, ct.maHDCT, ct.id_hoaDon, ct.id_spChiTiet, spct.maSPChiTiet, ct.soLuong, ct.donGia " +
                 "FROM ChiTietHoaDon ct " +
                 "JOIN SPChiTiet spct ON ct.id_spChiTiet = spct.id " +
                 "WHERE ct.id_hoaDon = ?";
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idHD);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            HDChiTiet ct = new HDChiTiet();
            ct.setId(rs.getInt("id"));
            ct.setMaHDCT(rs.getString("maHDCT"));
            ct.setIdHD(rs.getInt("id_hoaDon"));
            ct.setIdSPCT(rs.getInt("id_spChiTiet"));
            ct.setMaspct(rs.getString("maSPChiTiet")); 
            ct.setSoluong(rs.getInt("soLuong"));
            ct.setDongia(rs.getLong("donGia"));
            list.add(ct);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

}