/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HDChiTiet {

    private int id;
    private String maHDCT;
    private int idHD;
    private int idSPCT;

    private String mahd;
    private String maspct;

    private int soluong;
    private Long dongia;

    public HDChiTiet() {
    }

    public HDChiTiet(int id, String maHDCT, int idHD, int idSPCT, String mahd, String maspct, int soluong, Long dongia) {
        this.id = id;
        this.maHDCT = maHDCT;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.mahd = mahd;
        this.maspct = maspct;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMaspct() {
        return maspct;
    }

    public void setMaspct(String maspct) {
        this.maspct = maspct;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Long getDongia() {
        return dongia;
    }

    public void setDongia(Long dongia) {
        this.dongia = dongia;
    }

    public Long getThanhTien() {
        return this.soluong * this.dongia;
    }

    public Object[] addtorow() {
        return new Object[]{
            this.getId(),
            this.getMaHDCT(), this.getIdHD(), this.getIdSPCT(), this.getSoluong(), this.getDongia(), this.getThanhTien()
        };
    }

    public Object getThanhtien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
