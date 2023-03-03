package controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Statement;

public class CreatHoaDonController {
    public TextField txtnamekh;
    public TextField txtsp_id;
    public TextField txtsdt;
    public TextField txtgia;
    public TextField txtnamesp;

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
            String namesp = txtnamesp.getText();
            String gia = txtgia.getText();
            String sp_id = txtsp_id.getText();
            if (namekh.isEmpty() ||sdt.isEmpty()||namesp.isEmpty()||gia.isEmpty()||sp_id.isEmpty()){
                throw new Exception("Vui lòng nhập đủ thông tin vào đây");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into kiemtra(namekh,sdt,namesp,gia,sp_id) values('"+namekh+"','"+sdt+"','"+namesp+"','"+gia+"','"+sp_id+"')";
            stt.executeUpdate(sql);
            BackList(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
