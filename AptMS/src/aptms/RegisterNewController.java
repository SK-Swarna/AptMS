/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.DBConnect;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class RegisterNewController implements Initializable {

    @FXML
    private Button register_btn;
    String query;
    @FXML
    private TextField name_tf;
    @FXML
    private TextField phone_tf;
    @FXML
    private TextField email_tf;
    @FXML
    private DatePicker dob_datepicker;
    @FXML
    private TextField nid_tf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        query = "insert into RegPeople (Name, Phone, Email, DOB, NID) ";
        query += "values ('";
    }    

    @FXML
    private void onClickRegister_btn(ActionEvent event) {
        System.out.println("hi, btn pressed");
        DBConnect dbcon = new DBConnect();
        try {
            dbcon.connectToDB();
            System.out.println("con success!");
            
            String name = name_tf.getText(),
                    email = email_tf.getText(),
                    phone = phone_tf.getText();
                    
            LocalDate dob = dob_datepicker.getValue();
            
            query += name + "', '" + phone + "', '" + email + "', '" + dob + "', '" + nid_tf.getText();
            
            query += "')";
            System.out.println(query);
            try{
                dbcon.insertDataToDB(query);
            }
            catch (Exception e) {
                System.out.println("uh-oh : " + e);
            }
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterNewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
