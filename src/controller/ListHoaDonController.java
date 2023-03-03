package controller;

import daopattern.HoadonDAO;
import daopattern.SanphamDAO;
import entities.HoaDon;
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

public class ListHoaDonController implements Initializable {
    public TableColumn cid;
    public TableColumn cnamekh;
    public TableColumn csdt;
    public TableColumn cnamesp;
    public TableColumn cgia;
    public TableColumn csp_id;
    public TableView tbView;

    public void BackHome(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    public void goToCreat(ActionEvent actionEvent) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/hoadon/creat.fxml"));
        HomeController.rootStage.setScene(new Scene(root,1000,700));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        cnamekh.setCellValueFactory(new PropertyValueFactory<>("namekh"));
        csdt.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        cnamesp.setCellValueFactory(new PropertyValueFactory<>("namesp"));
        cgia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        csp_id.setCellValueFactory(new PropertyValueFactory<>("sp_id"));
        ObservableList<HoaDon> list = FXCollections.observableArrayList();
        HoadonDAO cd = new HoadonDAO();
        ArrayList<HoaDon> dslh = cd.getAll();
        tbView.getItems().addAll(dslh);
        tbView.refresh();
    }
}
