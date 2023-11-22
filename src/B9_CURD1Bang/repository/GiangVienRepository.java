/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B9_CURD1Bang.repository;

import B9_CURD1Bang.entity.GiangVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection; // Phai tu dong import bang tay lop Connection 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;

/**
 *
 * @author hangnt
 */
public class GiangVienRepository {

    /**
     * JDBC -> CRUD(CREATE - READ - UPDATE - DELETE) -> SQL : INSERT INTO -
     * SELECT - UPDATE - DELETE
     */

    public List<GiangVien> getAll() {
        List<GiangVien> listGiangVien = new ArrayList<>();
        // Code 
        // B1: Tao SQL 
        String sql = """
                   SELECT ma, ten, tuoi,loai,gioi_tinh,bac
                   FROM QLGV.dbo.giang_vien;
                   """;
        // B2: Mo cong ket noi => Xu ly ngoai le 
        try(Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            //B3: Nhận dữ liệu từ database 
            // table trong SQL ten la ResultSet 
            ResultSet rs = ps.executeQuery();// Voi cau sql tra ra 1 bang => excuteQuery 
            // B4: Check lan luot tung dong 
            while(rs.next()){
                // B5: Tao doi tuong 
                GiangVien gv = new GiangVien();
                gv.setBac(rs.getInt(6));
                gv.setGioiTinh(rs.getBoolean(5));
                gv.setLoai(rs.getString(4));
                gv.setMaGiangVien(rs.getString(1));
                gv.setTenGiangVien(rs.getString(2));
                gv.setTuoi(rs.getInt(3));
                // B6: Add vao list
                listGiangVien.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Khi chuong trinh loi => Nhay vao day
        }
        return listGiangVien;
    }
    
    // Test 
    public static void main(String[] args) {
        List<GiangVien>lists = new GiangVienRepository().getAll();
        for (GiangVien gv : lists) {
            System.out.println(gv.toString());
        }
    }
}
