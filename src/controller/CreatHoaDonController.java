package controller;

import daopattern.SanphamDAO;
import database.Database;
import entities.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CreatHoaDonController implements Initializable {

    public TextField txtnamekh;
    public TextField txtsp_id;
    public TextField txtsdt;
    public TextField txtgia;
    public TextField txtsoluong;
    public ComboBox<String> cbName;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> sp= FXCollections.observableArrayList();
        sp.add("Bánh socola");
        sp.add("Bánh xốp");
        sp.add("Bánh kem");
        sp.add("Kẹo dẻo");
        sp.add("Kẹo Socola");
        sp.add("Kẹo Socola");
        sp.add("Kẹo dừa bến tre");
        sp.add("Kem ốc quế");
        sp.add("Bánh đậu xanh");
        sp.add("Mực khô ");
        sp.add("Cá khô");
        sp.add("Dưa hấu");
        sp.add("Kem que");
        sp.add("Thạch dừa");
        sp.add("Thạch rau câu");
        cbName.setItems(sp);
    }

    public void BackList(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/hoadon/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void Submit(ActionEvent actionEvent) throws Exception
    {
        try {
            String namekh = txtnamekh.getText();
            String sdt = txtsdt.getText();
            String namesp = cbName.getValue();
           String gia = txtgia.getText();

            String soluong = txtsoluong.getText();
            String tong = txtsoluong.getText();
            String sp_id = txtsp_id.getText();
            if (namekh.isEmpty() ||sdt.isEmpty()||namesp.isEmpty()||gia.isEmpty()||soluong.isEmpty()||tong.isEmpty()||sp_id.isEmpty()){
                throw new Exception("Vui lòng nhập đủ thông tin vào đây");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into kiemtra(namekh,sdt,namesp,gia,soluong,tong,sp_id) values('"+namekh+"','"+sdt+"','"+namesp+"','"+gia+"','"+soluong+"','"+tong+"','"+sp_id+"')";
            stt.executeUpdate(sql);
            BackList(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }


}
