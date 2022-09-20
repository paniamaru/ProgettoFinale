package model;

/**
 * 	<p>
 * 		La classe Elettore raccoglie tutti i dati dell'utente in grado di efetuare votazioni.
 * 		questa classe estende Utente, aggiungendo altri campi utili a rappresentare questo tipo di utenza.
 * 	</p>
 * 	<p>
 * 		<ul>
 * 			<li>dataDiNascita: data di nascita dell'elettore nella forma (gg/mm/aaaa).</li>
 * 		</ul>
 * 	</p>
 * 	<p>
 * 		tutti i campi sono privati, quindi accessibili dai metodi get e set.
 * 	</p>
 * 
 */
public class Elettore extends Utente {

	private String dataDiNascita;
	
	/**
	 * restituisce un nuovo oggetto Elettore, contnente i dati passati come parametri.
	 * @param username username dell'account dell'elettore.
	 * @param password password dell'account dell'elettore.
	 * @param nome nome dell'elettore.
	 * @param cognome nome dell'elettore.
	 * @param dataDiNascita data di nascita dell'elettore (gg/mm/aaaa).
	 */
	public Elettore (String username, String password, String nome, String cognome, String dataDiNascita) {
		super(username, password);
		super.setCognome(cognome);
		super.setNome(nome);
		this.dataDiNascita = dataDiNascita;
	}
	
	/**
	 * restituisce un nuovo oggetto Elettore, contenente i dati passati come parametri.
	 * @param username username dell'account dell'elettore.
	 * @param password password dell'account dell'elettore.
	 * @param nome nome dell'elettore.
	 * @param cognome nome dell'elettore.
	 */
	public Elettore (String username, String password, String nome, String cognome) {
		super(username, password);
		super.setCognome(cognome);
		super.setNome(nome);
	}

	/**
	 * imposta la data di nascita dell'elettore sul quale `e stato invocato,
	 * sottoforma di stringa, nel formato (gg/mm/aaaa).
	 */
	public void setDataDiNascita(String data){
		this.dataDiNascita=data;
	}

	/**
	 * restituise la data di nascita dell'elettore sul quale `e stato invocato,
	 * sottoforma di stringa, nel formato (gg/mm/aaaa).
	 * @return data di nascita dell'elettore dell'elettore.
	 */
	public String getDataDiNascita(){
		return this.dataDiNascita;
	}
	
	/**
	 * Restituisce una stringa di caratteri che descrive l'Elettore
	 * rappresentato dall'oggetto che esegue il metodo.
	 * @return la stringa che rappresenta l'Elettore.
	 */
	public String toString(){
		return "{Elettore:[Cognome:"+super.getCognome()+"], [Nome:"+super.getNome()+"], [CF:"+super.getID()+"]}";
	}
}