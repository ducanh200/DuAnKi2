package daopattern;

import entities.SanPham;

import java.util.ArrayList;

public interface DAOInterface <S>{
    ArrayList<S> getALL();
    boolean create(S sanpham);
    boolean update(S sanpham);
    boolean delete(S sanpham);
    SanPham find(Integer id);
}

