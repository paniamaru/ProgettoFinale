package model;

/**
 * 	<p>
 * 		La classe Utente raccoglie tutti i dati degli Utenti.
 * 	</p>
 * 	<p>
 * 		<ul>
 * 			<li>ID:username dell'utente, è il CF;</li>
			<li>Password: password dell'utente;</li>
 			<li>Cognome:cognome dell'utente;
			<li>Nome: nome dell'utente.</li>
 * 		</ul>
 * 	</p>
 * 	<p>
 * 		tutti i campi sono privati, quindi accessibili dall'esterno solo tramite i metodi get e set.
 * 	</p>
 * 
 */
public abstract class Utente {
	private String ID;
	private String Password;
	private String Nome;
	private String Cognome;
	private boolean admin;
	
	/**
	 * 	<p>
	 * 		questa classe implementa il sistema di utenti per l'applicativo.
	 * 		l'oggetto Utente � un oggetto generico in grado di contenere i dati
	 * 		minimali delgi utenti.
	 * 		il suo scopo principale � quello di fornire una base di partenza 
	 * 		comune per tutti i tipi differenti di utenti da implementare nell'applicativo.
	 * 		pertanto il set di campi e metodi � minimale.
	 * 	</p>
	 * 	<p>
	 * 		<ul>
	 * 			<li>Username: nome utente dell'utente</li>
	 * 			<li>Password: password dell'utente</li>
	 * 		</ul>
	 * 	</p>
	 */
	
	/**
	 * restituisce un nuovo oggetto Utente, contnente i dati passati come parametri.
	 * @param u username dell'utente.
	 * @param p password dell'utente.
	 */
	public Utente(String id, String password) {
		this.ID=id;
		this.Password=password;
	}
	
	/**
	 * restituise l'username dell'utente sul quale `e stato invocato.
	 * @return ID dell'utente.
	 */
	public String getID() {
		return ID;
	}	
	
	/**
	 * imposta l'ID dell'utente sul quale `e stato invocato.
	 */
	public void setID(String id) {
		ID=id;
	}

	/**
	 * restituisce il nome dell'utente sul quale `e stato invocato.
	 * @return Nome dell'utente.
	 */
	public String getNome() {
		return Nome;
	}
	
	/**
	 * imposta il nome dell'utente sul quale `e stato invocato.
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
	
	/**
	 * restituisce il cognome dell'utente sul quale `e stato invocato.
	 * @return Nome dell'utente.
	 */
	public String getCognome() {
		return Cognome;
	}
	
	/**
	 * imposta il cognome dell'utente sul quale `e stato invocato.
	 */
	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	/**
	 * restituisce la password dell'utente sul quale `e stato invocato.
	 * @return Password dell'utente.
	 */
	public String getPassword() {
		return Password;
	}
	
	/**
	 * imposta la password dell'utente sul quale `e stato invocato.
	 */
	public void setPassword(String password) {
		Password=password;
	}
	
	/**
	 * restituisce True se l'utente è admin, False altrimenti.
	 * 	 @return True se l'utente è admin, False altrimenti.
	 */
	public boolean isAdmin() {
		return admin;
	}
	
	/**
	 * imposta il valore della variabile admin.
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}