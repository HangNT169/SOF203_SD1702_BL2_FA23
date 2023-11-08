/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2_OnTapSwing.service;

import B2_OnTapSwing.entity.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class SanPhamService {

    private List<SanPham> listSanPham = new ArrayList<>();

    public SanPhamService() {
        // fake data trong contructor 
        listSanPham.add(new SanPham("SP1", "Ten 1", 10, "Nhập khẩu"));
        listSanPham.add(new SanPham("SP2", "Ten 2", 120, "Nhập khẩu"));
        listSanPham.add(new SanPham("SP3", "Ten 3", 150, "Xuất khẩu"));
        listSanPham.add(new SanPham("SP4", "Ten 4", 160, "Xuất khẩu"));
        listSanPham.add(new SanPham("SP5", "An 5", 170, "Nhập khẩu"));
    }

    public List<SanPham> getAll() {
        return listSanPham;
    }

    public void removeSanPham(int index) {
        listSanPham.remove(index);
    }

    public String addSanPham(SanPham sp) {
        // Check cai doi tuong null
        if (sp == null) {
            return "Add that bai";
        }
        listSanPham.add(sp);
        return "Add thanh cong";
    }

    public void updateSanPham(int index, SanPham newSP) {
        listSanPham.set(index, newSP);
    }

    // Sort => su lamda expression (->)
    public void sapXep() {
        // Sap xep String (Chuoi )=> compareTo
//        listSanPham.sort((o1, o2) -> {
//            return o1.getTen().compareTo(o2.getTen()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
//        });
        // Sap xep so (int )=> dau - 
        listSanPham.sort((o1, o2) -> {
            return o1.getKhoiluong() - o2.getKhoiluong(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
        });
    }
    
    public List<SanPham>searchTheoTen(String ten){
        List<SanPham> listSearch = new ArrayList<>();
        // Code 
        for (SanPham sp : listSanPham) {
            // Check chua ten 
            if(sp.getTen().contains(ten)){
                // add vao list search
                listSearch.add(sp);
            }
        }
        return listSearch;
    }
}
