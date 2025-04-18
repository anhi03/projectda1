/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Loaisanpham {
    private int id;
    private String malsp;
    private String tenlsp;
    private Boolean trangthai;

    public Loaisanpham() {
    }

    public Loaisanpham(int id, String malsp, String tenlsp, Boolean trangthai) {
        this.id = id;
        this.malsp = malsp;
        this.tenlsp = tenlsp;
        this.trangthai = trangthai;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMalsp() {
        return malsp;
    }

    public void setMalsp(String malsp) {
        this.malsp = malsp;
    }

    public String getTenlsp() {
        return tenlsp;
    }

    public void setTenlsp(String tenlsp) {
        this.tenlsp = tenlsp;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }


    public Object[] addtorow(){
        return new Object[]{
            this.getId(),this.getMalsp(), this.getTenlsp(),this.getTrangthai()
        };
    }
}
