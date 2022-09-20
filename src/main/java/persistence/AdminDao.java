package persistence;

import model.Admin;

/**
 * la classe è stata presa e adattata dagli esempi visti a lezione.
 * la nostra scelta è stata quella di mantenere solo le seguenti funzioni, almeno in questa implementazione.
 * poiche attualemnte le uniche interazioni con il DB si limitano al confronto
 * dei dati di un singolo utente e oper comodità l'inserimento.
 */

public interface AdminDao {
   public Admin getAdmin(Admin user);
   public void addAdmin(String User, String Password);
}