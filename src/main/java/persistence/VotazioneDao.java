package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Votazione;

/**
 * classe che permette il menagement delle votazioni presenti sul DB
 */
public interface VotazioneDao {

   /**
    * restituisce la lista delle votazioni presenti sul DB escluse quelle eliminate
    * @return lista delle votazioni presnti sul DB
    */
   public List<Votazione> getAllVotazioni();

   /**
    * restituice la votazione con id <code>id</code>
    * @param id <code>id</code> id dellavotazione che si vuole ottenere
    * @return votazione con chiave <code>id</code>
    */
   public Votazione getVotazione(int id);

   /**
    * aggiorna una votazione, supporta l'aggionrnamento di tutti i parametri eccetto l'ID
    * @param votazione votazione aggiornata
    */
   public void updateVotazione(Votazione votazione);
   
   /**
    * crea una votazione
    * @param votazione votazione da creare
    */
   public void createVotazione(Votazione votazione);
   /**
    * elimina logicamente la votazione con id <code>id</code>
    * @param votazione
    */
   public void deleteVotazione(int id);
}