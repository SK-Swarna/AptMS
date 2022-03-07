/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.Bundle;
import aptms.utils.TableLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class FlatDetailsController implements Initializable {


    @FXML
    private Label flatID_label;

    @FXML
    private Label vacancyStatus_label;
    @FXML
    private Label rent_label;
    @FXML
    private TextField editProperties_tf;
    @FXML
    private Button update_btn;
    @FXML
    private Label gas_label;
    @FXML
    private Label electricity_label;
    @FXML
    private Label lift_label;
    @FXML
    private Label generator_tf;
    @FXML
    private Label sft_label;
    @FXML
    private Label bed_label;
    @FXML
    private Label bath_label;
    @FXML
    private Label level_label;
    @FXML
    private Label address_label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        flatID_label.setText(Bundle.UID);
        System.out.println(Bundle.UID);
        
    }    

    @FXML
    private void onClickUpdate_btn(ActionEvent event) {
        
    }
    
}
