/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class FlatsController implements Initializable {

    @FXML
    private CheckBox allFlats_chkbox;
    @FXML
    private CheckBox occFlats_chkbox;
    @FXML
    private CheckBox vacantFlats_chkbox;
    @FXML
    private CheckBox allPayTypes_chkbox;
    @FXML
    private CheckBox duePay_chkbox;
    @FXML
    private CheckBox allpaid_chkbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
