import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CandidatoPartito;
import model.Votazione;
import persistence.CandidatoPartitoDao;
import persistence.CandidatoPartitoDaoImpl;
import persistence.VotazioneDao;
import persistence.VotazioneDaoImpl;

/**
 * @author tazth
 *
 */
public class AdminPageController {

    private VotazioneDao votazioneDao=new VotazioneDaoImpl();
    private CandidatoPartitoDao candidatoPartitoDao=new CandidatoPartitoDaoImpl();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label benvenuto;
    @FXML
    private Button buttonCreate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonCreatePartito;
    @FXML
    private Button buttonDeletePartito;    
    @FXML
    private Button buttonCreateCandidato;
    @FXML
    private Button buttonDeleteCandidato;
    @FXML
    private TableView<Votazione> tabellaVotazioni;
    @FXML
    private TableView<CandidatoPartito> tabellaPartiti;
    @FXML
    private TableView<CandidatoPartito> tabellaCandidati;
    private ObservableList<Votazione> data;
    private ObservableList<CandidatoPartito> data2, data3;

    @FXML
    private TableColumn<Votazione, Integer> idID;
    @FXML
    private TableColumn<Votazione, String> idNome;
    @FXML
    private TableColumn<Votazione, Integer> idTipo;

    @FXML
    private TableColumn<CandidatoPartito, String> idPartito;
    @FXML
    private TableColumn<CandidatoPartito, String> idCandidato;

    
    //Variabili per creare una nuova Votazione
    @FXML private TextField idNuovoNome;
    @FXML private TextField idNuovoTipo;
    @FXML private TextField idNuovoNomePartito;
    @FXML private TextField idNuovoNomeCandidato;


    @FXML
    void bottoneCreazionePremuto(ActionEvent event) {
    	Votazione nuova=new Votazione(idNuovoNome.getText(), Integer.parseInt(idNuovoTipo.getText()));
    	votazioneDao.createVotazione(nuova);
    	updateTable();
    }
    
    @FXML
    void bottoneCancellazionePremuto(ActionEvent event) {
    	data=tabellaVotazioni.getSelectionModel().getSelectedItems();
//    	System.out.println(" "+data.get(0).getIdVotazione());
    	votazioneDao.deleteVotazione(data.get(0).getIdVotazione());
    	updateTable();
    }
    
    //metodo chiamato dal tasto crea partito
    @FXML
    void bottoneCreatePartitoPremuto(ActionEvent event) {
    	CandidatoPartito nuova=new CandidatoPartito(tabellaVotazioni.getSelectionModel().selectedItemProperty().get().getIdVotazione(),idNuovoNomePartito.getText(),idNuovoNomePartito.getText());
    	int err=candidatoPartitoDao.createCandidatoPartito(nuova);
    	if(err==0) {
    		Stage stage=(Stage)idNuovoNome.getScene().getWindow();
    		AlertType type=AlertType.WARNING;
    		Alert alert=new Alert(type,"");
    		
    		alert.initModality(Modality.APPLICATION_MODAL);
    		alert.initOwner(stage);
    		
    		alert.getDialogPane().setContentText("Il valore inserito è già presente per questa votazione");
    		
    		alert.showAndWait();
    	}
    	updateTable2(tabellaVotazioni.getSelectionModel().selectedItemProperty().get());
    	}
    
    @FXML   
    void bottoneCreateCandidatoPremuto(ActionEvent event) {
    	CandidatoPartito nuova=new CandidatoPartito(tabellaVotazioni.getSelectionModel().selectedItemProperty().get().getIdVotazione(),
    			tabellaPartiti.getSelectionModel().selectedItemProperty().get().getNomePartito(),
    			idNuovoNomeCandidato.getText());
    	int err=candidatoPartitoDao.createCandidatoPartito(nuova);
    	if(err==0) {
    		Stage stage=(Stage)idNuovoNome.getScene().getWindow();
    		AlertType type=AlertType.WARNING;
    		Alert alert=new Alert(type,"");
    		
    		alert.initModality(Modality.APPLICATION_MODAL);
    		alert.initOwner(stage);
    		
    		alert.getDialogPane().setContentText("Il come inserito è già presente per questo Partito in questa Votazione");
    		
    		alert.showAndWait();
    	}
    	updateTable3(tabellaPartiti.getSelectionModel().selectedItemProperty().get());
    	}
    @FXML
    void bottoneCancellazionePartitoPremuto(ActionEvent event) {
    	candidatoPartitoDao.deletePartito(tabellaPartiti.getSelectionModel().getSelectedItems().get(0));
    	updateTable2(tabellaVotazioni.getSelectionModel().selectedItemProperty().get());
    }
    
    @FXML
    void bottoneCancellazioneCandidatoPremuto(ActionEvent event) {
    	candidatoPartitoDao.deletePartito(tabellaCandidati.getSelectionModel().getSelectedItems().get(0));
    	updateTable3(tabellaPartiti.getSelectionModel().selectedItemProperty().get());
    	}
    
    @FXML
    void initialize() {
    	 assert benvenuto != null : "fx:id=\"benvenuto\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert buttonCreate != null : "fx:id=\"buttonCreate\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idCandidato != null : "fx:id=\"idCandidato\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idID != null : "fx:id=\"idID\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idNome != null : "fx:id=\"idNome\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idNuovoNome != null : "fx:id=\"idNuovoNome\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idNuovoTipo != null : "fx:id=\"idNuovoTipo\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idPartito != null : "fx:id=\"idPartito\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert idTipo != null : "fx:id=\"idTipo\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert tabellaCandidati != null : "fx:id=\"tabellaCandidati\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert tabellaPartiti != null : "fx:id=\"tabellaPartiti\" was not injected: check your FXML file 'adminpage.fxml'.";
         assert tabellaVotazioni != null : "fx:id=\"tabellaVotazioni\" was not injected: check your FXML file 'adminpage.fxml'.";


        updateTable();

        tabellaVotazioni.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            if (newSelection!= null) {
                updateTable2(tabellaVotazioni.getSelectionModel().selectedItemProperty().get());
            	}
        });

       tabellaPartiti.getSelectionModel().selectedItemProperty().addListener((obs2, oldSelection2, newSelection2) -> {
            if (newSelection2 != null) {
            	updateTable3(tabellaPartiti.getSelectionModel().selectedItemProperty().get());
                }
        });
    }
    
    private void updateTable() {
        data=FXCollections.observableArrayList(votazioneDao.getAllVotazioni());
        
        idID.setCellValueFactory(new PropertyValueFactory<Votazione, Integer>("idVotazione"));
        idNome.setCellValueFactory(new PropertyValueFactory<Votazione, String>("nomeVotazione"));
        idTipo.setCellValueFactory(new PropertyValueFactory<Votazione, Integer>("tipoVotazione"));
        
        tabellaVotazioni.setItems(data);
        tabellaPartiti.setVisible(false);
        tabellaCandidati.setVisible(false);
    }
    
    private void updateTable2(Votazione votSel){
    	data2=FXCollections.observableArrayList(candidatoPartitoDao.getAllPartiti(votSel.getIdVotazione()));
    	
    	idPartito.setCellValueFactory(new PropertyValueFactory<CandidatoPartito, String>("nomePartito"));
    	
    	tabellaPartiti.setItems(data2);
    	tabellaPartiti.setVisible(true);
    	tabellaCandidati.setVisible(false);
    }

    private void updateTable3(CandidatoPartito partSel){
    	data3=FXCollections.observableArrayList(candidatoPartitoDao.getAllCandidati(partSel));
    	
    	System.out.println(data3.size());
    	
    	idCandidato.setCellValueFactory(new PropertyValueFactory<CandidatoPartito, String>("nomeCandidato"));
    	
    	tabellaCandidati.setItems(data3);
    	tabellaCandidati.setVisible(true);
    }
}