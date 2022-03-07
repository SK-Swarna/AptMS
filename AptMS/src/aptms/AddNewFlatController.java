/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class AddNewFlatController implements Initializable {

    @FXML
    private TextField flatID_tf;
    @FXML
    private MenuButton vacancy_menubtn;
    @FXML
    private TextField rent_tf;
    @FXML
    private Button Save;
    @FXML
    private MenuButton gas_menubtn;
    @FXML
    private MenuItem gasYes_mi;
    @FXML
    private MenuItem gasNo_mi;
    @FXML
    private MenuButton electricity_menubtn;
    @FXML
    private MenuItem elecYes_mi;
    @FXML
    private MenuItem elecNo_mi;
    @FXML
    private MenuButton lift_menubtn;
    @FXML
    private MenuItem liftYes_mi;
    @FXML
    private MenuItem liftNo_mi;
    @FXML
    private MenuButton generator_menubtn;
    @FXML
    private MenuItem genYes_mi;
    @FXML
    private MenuItem genNo_mi;
    @FXML
    private TextField area_tf;
    @FXML
    private TextField bed_tf;
    @FXML
    private TextField bath_tf;
    @FXML
    private TextField level_tf;
    @FXML
    private TextField flatNo_tf;
    @FXML
    private TextField houseNo_tf;
    @FXML
    private TextField road_tf;
    @FXML
    private TextField block_tf;
    @FXML
    private TextField thana_tf;
    @FXML
    private TextField zilla_tf;
    @FXML
    private TextField division_tf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void onClickUpdate_btn(ActionEvent event) {
    }
    
}
