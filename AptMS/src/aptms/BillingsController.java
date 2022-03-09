/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package aptms;

import aptms.utils.DBConnect;
import aptms.utils.TableLoader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shabbir
 */
public class BillingsController implements Initializable {

    @FXML
    private TableView<?> flat_tv;
    @FXML
    private Button createBill_btn;
    @FXML
    private TableView<?> bills_tv;
    @FXML
    private Button markPaid_btn;
    TableLoader tableLoader;
    @FXML
    private TextField mnth_tf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();

    }

    private void init() {
        try {
            // TODO
            //load tables
            tableLoader.loadTable("select * from Flats", flat_tv);
            tableLoader.loadTable("select * from Bills", bills_tv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onClickCreateBill_btn(ActionEvent event) {
        //insert into bills : get selected flatID, 
        Object s = flat_tv.getSelectionModel().getSelectedItems().get(0);

        System.out.println(s.toString().split(", ")[1].substring(1));

        String flatID = s.toString().split(", ")[0].substring(1); //got the 1st column of selected row -> first col 

        String resID = "(select ResID from CurrentRentals where FlatID = " + flatID + ")",
                amount = "(select MonthlyRent from Flats where FlatID = " + flatID + ")",
                mnth = mnth_tf.getText();

        String newbill = "insert into Bills values(" + flatID + ", " + resID + ", " + amount + ", 'due', '" + mnth + "')";

        DBConnect dbcon = new DBConnect();
        System.out.println(newbill);
        try {
            dbcon.connectToDB();
            dbcon.insertDataToDB(newbill);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //finally
        init();
    }

    @FXML
    private void onClickMarkPaid_btn(ActionEvent event) {
        Object s = bills_tv.getSelectionModel().getSelectedItems().get(0);

        System.out.println(s.toString().split(", ")[1].substring(1));

        String billID = s.toString().split(", ")[0].substring(1); //got the 1st column of selected row -> first col 

        String updateSt = "update Bills Set Pay_st = 'paid' where BillID = " + billID;
        
        DBConnect dbcon = new DBConnect();
        System.out.println(updateSt);
        try {
            dbcon.connectToDB();
            dbcon.insertDataToDB(updateSt);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillingsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //finally
        init();
    }

}
