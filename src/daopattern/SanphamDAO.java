package daopattern;

import database.Database;
import entities.SanPham;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SanphamDAO implements DAOInterface<SanPham> {
        private static SanphamDAO instance;
        public Statement statement;
        public ArrayList<SanPham> getAll(){
            ArrayList<SanPham> list = new ArrayList<>();
            try {
                Database db =  Database.getInstance();
                Statement stt = db.getStatement();
                String sql = "select * from sanpham";
                ResultSet rs = stt.executeQuery(sql);
                while (rs.next()){
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    Double gia = rs.getDouble("gia");
                    SanPham c = new SanPham(id,name,gia);
                    list.add(c);
                }
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();


            }
            return list;
        }

        @Override
        public ArrayList<SanPham> getALL() {
            return null;
        }

        public boolean create(SanPham sanPham){
            try {

                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = "insert into sanpham(name,gia) values('"+sanPham.getName()+"','"+sanPham.getGia()+"')";
                if (stt.executeUpdate(sql)>0){
                    return true;
                }
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
            }
            return false;
        }
        public boolean update(SanPham sanPham){
            try {
                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = " update sanpham  set name = '"+sanPham.getName()+"', room = '"+sanPham.getGia()+"' where id = " +sanPham.getId();
                if (stt.executeUpdate(sql)>0){
                    return true;
                }
            }catch (Exception e){
            }
            return false;
        }
        public boolean delete(SanPham sanPham){
            try {
                Database db = Database.getInstance();
                Statement stt = db.getStatement();
                String sql = " delete sanpham   where id = "+sanPham.getId();
                if (stt.executeUpdate(sql)>0){
                    return true;
                }
            }catch (Exception e){
            }
            return false;
        }

        public SanPham find(Integer id){
            try {
                Database db =  Database.getInstance();
                Statement stt = db.getStatement();
                String sql = "select * from sanpham";
                ResultSet rs = stt.executeQuery(sql);
                while (rs.next()){
                    String name = rs.getString("name");
                    Double gia = rs.getDouble("gia");
                    SanPham c = new SanPham(id,name,gia);
                    return c;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }
        //generic method
        public <N> SanPham findOne(N id){//khi su dung gia tri truyen vao se  la kieu du lieu
            return null;
        }
        public static SanphamDAO getInstance() throws Exception{
            if (instance == null){
                instance = new SanphamDAO();
            }
            return instance;
        }
        public Statement getStatement() {

            return statement;
        }
    }

