/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B9_CURD1Bang.service;

import B9_CURD1Bang.entity.GiangVien;
import B9_CURD1Bang.repository.GiangVienRepository;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class GiangVienService {

    // repository
    private GiangVienRepository repo = new GiangVienRepository();

    public List<GiangVien> getAll() {
        return repo.getAll();
    }

    public boolean add(GiangVien gv) {
        return repo.add(gv);
    }
}
