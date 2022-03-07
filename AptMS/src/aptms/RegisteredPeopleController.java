/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.TableLoader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    @FXML
    private TextField searchBy_tf;
    @FXML
    private Button search_btn;
    @FXML
    private CheckBox currRes_chkbox;
    @FXML
    private CheckBox formerRes_chkbox;
    @FXML
    private CheckBox allRes_chkbox;
    @FXML
    private Button filter_btn;

    TableLoader tableLoader = new TableLoader();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
//        allRes_chkbox.isSelected()
            tableLoader.loadTable("select * from RegPeople", registeredPeople_tv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisteredPeopleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisteredPeopleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
