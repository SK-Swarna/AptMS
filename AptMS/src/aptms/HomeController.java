/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class HomeController implements Initializable {

    private ImageView cat_imgview;
    @FXML
    private Button regNew_btn;
    @FXML
    private Button flats_btn;
    @FXML
    private AnchorPane loadPage_anchorpane;
    @FXML
    private Button registeredPpl_btn;
    @FXML
    private Button addNewFlat_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AnchorPane defaultPage;
        try {
            defaultPage = FXMLLoader.load(getClass().getResource("RegisterNew.fxml"));
            loadPage_anchorpane.getChildren().addAll(defaultPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickRegNew_btn(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("RegisterNew.fxml"));
//
//        Scene currentScr = new Scene(root);
//        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        currentStage.setScene(currentScr);
//        
//        currentStage.show();

        AnchorPane regNewPage = FXMLLoader.load(getClass().getResource("RegisterNew.fxml"));
        loadPage_anchorpane.getChildren().clear();
        loadPage_anchorpane.getChildren().addAll(regNewPage);

    }

    @FXML
    private void onClickFlats_btn(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Flats.fxml"));
//
//        Scene currentScr = new Scene(root);
//        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        currentStage.setScene(currentScr);
//
//        currentStage.show();

        AnchorPane flatsPage = FXMLLoader.load(getClass().getResource("Flats.fxml"));
        loadPage_anchorpane.getChildren().clear();
        loadPage_anchorpane.getChildren().addAll(flatsPage);
    }

    @FXML
    private void onClickRegisteredPpl_btn(ActionEvent event) throws IOException {
        AnchorPane regedPpl = FXMLLoader.load(getClass().getResource("RegisteredPeople.fxml"));
        loadPage_anchorpane.getChildren().clear();
        loadPage_anchorpane.getChildren().addAll(regedPpl);
    }

    @FXML
    private void onClickAddNewFlat_btn(ActionEvent event) throws IOException {

        try {
            AnchorPane newFlat = FXMLLoader.load(getClass().getResource("AddNewFlat.fxml"));
            loadPage_anchorpane.getChildren().clear();
            loadPage_anchorpane.getChildren().addAll(newFlat);
        } catch (Exception e) {
            System.out.println("-----------------problem " + e);
        }

    }

    @FXML
    private void onClickBillngs_btn(ActionEvent event) throws IOException {
        AnchorPane regedPpl = FXMLLoader.load(getClass().getResource("Billings.fxml"));
        loadPage_anchorpane.getChildren().clear();
        loadPage_anchorpane.getChildren().addAll(regedPpl);
    }

}
