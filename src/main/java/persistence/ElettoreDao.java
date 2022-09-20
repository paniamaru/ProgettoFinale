package persistence;

import model.Elettore;

/**
 * la classe è stata presa e adattata dagli esempi visti a lezione.
 * la nostra scelta è stata quella di mantenere solo le seguenti funzioni, almeno in questa implementazione.
 * poiche attualemnte le uniche interazioni con il DB si limitano al confronto
 * dei dati di un singolo utente e oper comodità l'inserimento.
 */

public interface ElettoreDao {
   public Elettore getElettore(Elettore user);
   public void addElettore(String User, String Password);
}