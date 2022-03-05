/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class RegisteredPeopleController implements Initializable {

    @FXML
    private TableView<?> registeredPeople_tv;
    @FXML
    private MenuButton searchBy_menu;
    @FXML
    private MenuItem searchByName_mi;
    @FXML
    private MenuItem searchByPhone_mi;
    @FXML
    private MenuItem searchByResID_mi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
