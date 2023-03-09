package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController{
    public static Stage rootStage;

    public void goToSanPham(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sanpham/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void goToHoaDon(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/hoadon/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void ThemHoaDon(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/hoadon/creat.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void ThemSanPham(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sanpham/creat.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }
}
