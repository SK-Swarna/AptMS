/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.Bundle;
import aptms.utils.TableLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    @FXML
    private Button gotoDetails_btn;
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

    @FXML
    private void onClickGotoDetails_btn(ActionEvent event) throws IOException {
        //System.out.println(coursesTable.getSelectionModel().getSelectedItem().toString());

        Object s = flats_tv.getSelectionModel().getSelectedItems().get(0);

        System.out.println(s.toString().split(", ")[1].substring(1));

        String flatID = s.toString().split(", ")[0].substring(1); //got the 1st column of selected row -> first col = course id
        System.out.println("flat id : " + flatID);
        
        Bundle.UID = flatID;
        
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FlatDetails.fxml"));

        Parent rootPane = (Parent) loader.load();
        FlatDetailsController controller = loader.getController();
        Scene dialogScene = new Scene(rootPane);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    
}
