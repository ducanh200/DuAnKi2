package controller;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Statement;

public class CreatSanPhamController {
    public TextField txtid;
    public TextField txtname;
    public TextField txtgia;

    public void BackList(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sanpham/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void Submit(ActionEvent actionEvent) throws Exception
    {
        try {
            String name = txtname.getText();
            String gia = txtgia.getText();
            if (name.isEmpty() ||gia.isEmpty()){
                throw new Exception("Vui lòng nhập đủ thông tin vào đây !");
            }
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "insert into sanpham(name,gia) values('"+name+"','"+gia+"')";
            stt.executeUpdate(sql);
            BackList(null);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
