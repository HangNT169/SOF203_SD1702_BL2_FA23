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
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            //B3: Nhận dữ liệu từ database 
            // table trong SQL ten la ResultSet 
            ResultSet rs = ps.executeQuery();// Voi cau sql tra ra 1 bang => excuteQuery 
            // B4: Check lan luot tung dong 
            while (rs.next()) {
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

    // Cach chen dieu kien trong cau query 
    public List<GiangVien> searchTheoLoai(String type) {
        List<GiangVien> listGiangVien = new ArrayList<>();
        // Code 
        // B1: Tao SQL 
        String sql = """
                   SELECT ma, ten, tuoi,loai,gioi_tinh,bac
                                 FROM QLGV.dbo.giang_vien
                                 WHERE loai = ? 
                           
                   """;
        // B2: Mo cong ket noi => Xu ly ngoai le 
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            // Day du lieu cua dau ? sang sql 
            ps.setObject(1, type); // VIET TREN RESULT SET 
//            ps.setObject(2, tuoi);
            //B3: Nhận dữ liệu từ database 
            // table trong SQL ten la ResultSet 
            ResultSet rs = ps.executeQuery();// Voi cau sql tra ra 1 bang => excuteQuery 
            // B4: Check lan luot tung dong 
            while (rs.next()) {
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

    // C1: truyen lan luot tham so 
    // C2: Truyen 1 doi tuong Object
    public boolean add(GiangVien gv) {
        int check = 0;
        // B1: Viet SQL 
        String sql = """
                    INSERT INTO giang_vien
                    (ma, ten, loai, tuoi, bac, gioi_tinh)
                    VALUES(?,?,?,?,?,?)
                    """;
        // B2: Mo cong ket noi => Xu ly ngoai le 
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gv.getMaGiangVien());
            ps.setObject(2, gv.getTenGiangVien());
            ps.setObject(3, gv.getLoai());
            ps.setObject(4, gv.getTuoi());
            ps.setObject(5, gv.getBac());
            ps.setObject(6, gv.isGioiTinh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Khi chuong trinh loi => Nhay vao day
        }
        return check > 0; // check >0 => dung => add thanh cong
    }

    // Delete 
    public boolean delete(String ma) {
        int check = 0;
        // B1: Viet SQL 
        String sql = """
                    DELETE FROM QLGV.dbo.giang_vien
                    WHERE ma = ?
                    """;
        // B2: Mo cong ket noi => Xu ly ngoai le 
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Khi chuong trinh loi => Nhay vao day
        }
        return check > 0; // check >0 => dung => add thanh cong
    }

    // Update
    public boolean update(GiangVien gv, String oldMaGV) {
        int check = 0;
        // B1: Viet SQL 
        String sql = """
                    UPDATE QLGV.dbo.giang_vien
                    SET ten = ?, loai= ?, tuoi=?, bac=?, gioi_tinh=?
                    WHERE ma = ? ;
                    """;
        // B2: Mo cong ket noi => Xu ly ngoai le 
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, gv.getTenGiangVien());
            ps.setObject(2, gv.getLoai());
            ps.setObject(3, gv.getTuoi());
            ps.setObject(4, gv.getBac());
            ps.setObject(5, gv.isGioiTinh());
            ps.setObject(6, oldMaGV); // Ma CU DE K ANH HUONG DEN MA MOI
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Khi chuong trinh loi => Nhay vao day
        }
        return check > 0; // check >0 => dung => add thanh cong
    }

    // Test 
    public static void main(String[] args) {
        List<GiangVien> lists = new GiangVienRepository().searchTheoLoai("gdjhgf");
        for (GiangVien gv : lists) {
            System.out.println(gv.toString());
        }
    }
}
