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
        listSanPham.add(new SanPham("SP5", "Ten 5", 170, "Nhập khẩu"));
    }

    public List<SanPham> getAll() {
        return listSanPham;
    }

}
