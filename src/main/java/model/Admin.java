package model;

/**
 * 	<p>
 * 		La classe Admin raccoglie tutti i dati dell'utente con privilegi da amministratore.
 * 		questa classe estende Utente.
 * 		tutti i campi sono privati, quindi accessibili dai metodi get e set.
 * 	</p>
 * 
 */

public class Admin extends Utente {
	
	/**
	 * restituisce un nuovo oggetto Admin, contenente i dati passati come parametri.
	 * @param username username dell'account dell'admin.
	 * @param password password dell'account dell'admin.
	 * @param nome nome dell'admin.
	 * @param cognome nome dell'admin.
	 */
	public Admin(String username, String password, String nome, String cognome) {
		super(username, password);
		super.setCognome(cognome);
		super.setNome(nome);
	}

	public Admin(String username, String password) {
		super(username, password);
	}
	
	/**
	 * Restituisce una stringa di caratteri che descrive l'Admin
	 * rappresentato dall'oggetto che esegue il metodo.
	 * @return la stringa che rappresenta l'admin.
	 */
	public String toString(){
		return "{Admin:[Cognome:"+super.getCognome()+"], [Nome:"+super.getNome()+"], [CF:"+super.getID()+"]}";
	}
}
