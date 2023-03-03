package daopattern;

import database.Database;
import entities.HoaDon;
import entities.SanPham;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HoadonDAO implements DAOInterface<HoaDon>{
    private static HoadonDAO instance;
    public Statement statement;
    public ArrayList<HoaDon> getAll(){
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            Database db =  Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from kiemtra";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String namekh = rs.getString("namekh");
                String sdt = rs.getString("sdt");
                String namesp = rs.getString("namesp");
                Double gia = rs.getDouble("gia");
                String sp_id = rs.getString("sp_id");
                HoaDon c = new HoaDon(id,namekh,sdt,namesp,gia,sp_id);
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
    public ArrayList<HoaDon> getALL() {
        return null;
    }

    public boolean create(HoaDon hoaDon){
        try {

            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into kiemtra(name,room) values('"+hoaDon.getNamekh()+"','"+hoaDon.getSdt()+"','"+hoaDon.getNamesp()+"','"+hoaDon.getGia()+"','"+hoaDon.getSp_id()+"')";
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
    public boolean update(HoaDon hoaDon){
        try {
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = " update kiemtra  set name = '"+hoaDon.getNamekh()+"','"+hoaDon.getSdt()+"','"+hoaDon.getNamesp()+"','"+hoaDon.getGia()+"','"+hoaDon.getSp_id()+"' where id = " +hoaDon.getId();
            if (stt.executeUpdate(sql)>0){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
    public boolean delete(HoaDon hoaDon){
        try {
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = " delete kiemtra   where id = "+hoaDon.getId();
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
            String sql = "select * from kiemtra";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
                String namekh = rs.getString("namekh");
                String sdt = rs.getString("sdt");
                String namesp = rs.getString("namesp");
                Double gia = rs.getDouble("gia");
                String sp_id = rs.getString("sp_id");
                HoaDon c = new HoaDon(id,namekh,sdt,namesp,gia,sp_id);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    //generic method
    public <N> HoaDon findOne(N id){//khi su dung gia tri truyen vao se  la kieu du lieu
        return null;
    }
    public static HoadonDAO getInstance() throws Exception{
        if (instance == null){
            instance = new HoadonDAO();
        }
        return instance;
    }
    public Statement getStatement() {

        return statement;
    }
}
