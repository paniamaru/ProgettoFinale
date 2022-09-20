import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;
import persistence.*;
import javafx.scene.control.Label;

/**
 * Applicando il design pattern MVC abbiamo gestito l'interazione utente con il tasto login all'interno del controller.
 * Il modello si trova nel file login.fxml.
 * La vera e propria interazione con il DB viene affidata alla classe Utente, in particolare dal design pattern DAO.
 */

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogin;
    @FXML
    private Button idDelete;
    @FXML
    private Label idError;

    @FXML
    private TextField idPassword;

    @FXML
    private TextField idUsername;

    @FXML
    private CheckBox admin;

    @FXML
    void handleLogin(ActionEvent event) throws Exception {

    	AdminDao AdminDao = new AdminDaoImpl();
        Admin user=new Admin(idUsername.getText(), idPassword.getText());
        
        Admin risultato = AdminDao.getAdmin(user);
    	//root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
    	
    	if(risultato!=null){
            //System.out.println(a.getUsername()+" - "+a.getPassword());
            //idError.setText("Ciao! " + risultato.getNome() + " " + risultato.getCognome());
    		
            AdminSingleton istanza=AdminSingleton.getInstance();//attenzione se non è già creato?
            istanza.setAdmin(risultato);
            Stage vistaVotazioni=new Stage();
    		Parent root;

        	root = FXMLLoader.load(getClass().getResource("adminpage.fxml"));
            vistaVotazioni.setTitle("iVote");
            vistaVotazioni.setScene(new Scene(root));
            vistaVotazioni.show();
            vistaVotazioni.setResizable(false);
            ((Stage) idError.getScene().getWindow()).close();
        }
    	else {
    		idError.setVisible(true);
    	}
    }

    @FXML
    void initialize() {
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'login.fxml'.";
        assert idError != null : "fx:id=\"idError\" was not injected: check your FXML file 'login.fxml'.";
        assert idPassword != null : "fx:id=\"idPassword\" was not injected: check your FXML file 'login.fxml'.";
        assert idUsername != null : "fx:id=\"idUsername\" was not injected: check your FXML file 'login.fxml'.";
        assert buttonLogin != null : "fx:id=\"buttonLogin\" was not injected: check your FXML file 'login.fxml'."; 
    }

}


