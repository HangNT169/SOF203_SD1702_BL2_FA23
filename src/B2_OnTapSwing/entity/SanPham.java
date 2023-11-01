/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2_OnTapSwing.entity;

/**
 *
 * @author hangnt
 */
public class SanPham {

    private String maSanPham;
    private String ten;
    private int khoiluong;
    private String loaiSP;

    public SanPham() {
    }

    public SanPham(String maSanPham, String ten, int khoiluong, String loaiSP) {
        this.maSanPham = maSanPham;
        this.ten = ten;
        this.khoiluong = khoiluong;
        this.loaiSP = loaiSP;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(int khoiluong) {
        this.khoiluong = khoiluong;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

}
