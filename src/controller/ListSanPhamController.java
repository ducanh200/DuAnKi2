package controller;

import daopattern.SanphamDAO;
import entities.SanPham;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListSanPhamController implements Initializable {
    public TableColumn<SanPham,Integer> cid;
    public TableColumn<SanPham,String> cname;
    public TableColumn<SanPham,Double> cgia;
    public TableView<SanPham> tbView;

    public void BackHome(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void goToCreat(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sanpham/creat.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        cgia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        ObservableList<SanPham> list = FXCollections.observableArrayList();
        SanphamDAO cd = new SanphamDAO();
        ArrayList<SanPham> dslh = cd.getAll();
        tbView.getItems().addAll(dslh);
        tbView.refresh();
    }

    public void TaoHoaDon(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/hoadon/creat.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));

    }
}
