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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;

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
    
    TableLoader tableLoader = new TableLoader();
    @FXML
    private TableView<?> flats_tv;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            tableLoader.loadTable("select * from Flats", flats_tv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlatsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FlatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
