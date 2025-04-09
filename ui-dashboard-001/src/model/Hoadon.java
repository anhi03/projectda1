/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Hoadon {
    private int id;
    private String maHD;
    private int idkh;
    private int idnv;
    private int idvoucher;
    
    private String tenkh;
    private String tennv;
    private String mavoucher;
    
    private Long tongtienbandau;
    private Long tongkhuyenmai;
    private Long tongtiensauKM;
    private Date ngayThanhToan;
    private Boolean trangthai;

    public Hoadon() {
    }

    public Hoadon(int id, String maHD, int idkh, int idnv, int idvoucher, String tenkh, String tennv, String mavoucher, Long tongtienbandau, Long tongkhuyenmai, Long tongtiensauKM, Date ngayThanhToan, Boolean trangthai) {
        this.id = id;
        this.maHD = maHD;
        this.idkh = idkh;
        this.idnv = idnv;
        this.idvoucher = idvoucher;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.mavoucher = mavoucher;
        this.tongtienbandau = tongtienbandau;
        this.tongkhuyenmai = tongkhuyenmai;
        this.tongtiensauKM = tongtiensauKM;
        this.ngayThanhToan = ngayThanhToan;
        this.trangthai = trangthai;
    }

    public Hoadon(String maHD, int idkh, int idnv, int idvoucher, String tenkh, String tennv, String mavoucher, Long tongtienbandau, Long tongkhuyenmai, Long tongtiensauKM, Date ngayThanhToan, Boolean trangthai) {
        this.maHD = maHD;
        this.idkh = idkh;
        this.idnv = idnv;
        this.idvoucher = idvoucher;
        this.tenkh = tenkh;
        this.tennv = tennv;
        this.mavoucher = mavoucher;
        this.tongtienbandau = tongtienbandau;
        this.tongkhuyenmai = tongkhuyenmai;
        this.tongtiensauKM = tongtiensauKM;
        this.ngayThanhToan = ngayThanhToan;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public int getIdnv() {
        return idnv;
    }

    public void setIdnv(int idnv) {
        this.idnv = idnv;
    }

    public int getIdvoucher() {
        return idvoucher;
    }

    public void setIdvoucher(int idvoucher) {
        this.idvoucher = idvoucher;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMavoucher() {
        return mavoucher;
    }

    public void setMavoucher(String mavoucher) {
        this.mavoucher = mavoucher;
    }

    public Long getTongtienbandau() {
        return tongtienbandau;
    }

    public void setTongtienbandau(Long tongtienbandau) {
        this.tongtienbandau = tongtienbandau;
    }

    public Long getTongkhuyenmai() {
        return tongkhuyenmai;
    }

    public void setTongkhuyenmai(Long tongkhuyenmai) {
        this.tongkhuyenmai = tongkhuyenmai;
    }

    public Long getTongtiensauKM() {
        return tongtiensauKM;
    }

    public void setTongtiensauKM(Long tongtiensauKM) {
        this.tongtiensauKM = tongtiensauKM;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }
    
    public Object[]addtorow(){
        return new Object[]{
            this.getId()
        };
    }
}
