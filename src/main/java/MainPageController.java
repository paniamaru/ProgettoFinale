import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author tazth
 *
 */
public class MainPageController {

    @FXML
    private Label benvenuto;
    
    
    @FXML
    void initialize() {
        assert benvenuto != null : "fx:id=\"benvenuto\" was not injected: check your FXML file 'mainpage.fxml'.";
//        AdminSingleton istanza=UtenteSingleton.getInstance();
//        Utente corrente=istanza.getUtente();
//    	benvenuto.setText("Ciao! " + corrente.getNome() + " " + corrente.getCognome()+corrente.isAdmin());
        }
}