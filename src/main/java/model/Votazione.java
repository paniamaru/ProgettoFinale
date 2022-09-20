package model;

/**
 * 	<p>
 * 		La classe Votazione raccoglie tutti i dati delle votazioni create dall'admin.
 * 	</p>
 * 	<p>
 * 		<ul>
 * 			<li>idVotazione: identificativo della singola votazione.</li>
 * 			<li>NomeVotazione: Nome proprio della singola votazione.</li>
 * 			<li>statoVotazione: stato in cui si trova la singola votazione.</li>
 * 		</ul>
 * 	</p>
 * 	<p>
 * 		tutti i campi sono privati, quindi accessibili dai metodi get e set.
 * 	</p>
 * 
 */

public class Votazione{

	private int idVotazione;
	private String nomeVotazione;
	private int tipoVotazione;	
	private int statoVotazione;
	private int tipoRisultato;

	/**
	 * restituisce un nuovo oggetto Votazione, contenente i dati passati come parametri.
	 * @param idVotazione identificativo della singola votazione.
	 * @param nomeVotazione Nome proprio della singola votazione.
	 * @param tipoVotazione stato in cui si trova la singola votazione.
	 * <p>
	 * 		<p>Stati possibili<p>
	 * 		<ul>
	 * 			<li>0: Creata</li>
	 * 			<li>1: Aperta</li>
	 * 			<li>2: Chiusa</li>
	 * 			<li>3: Scrutinata</li>
	 * 			<li>4: Eliminata</li>
	 * 		</ul>
	 * 	</p>
	 */
	public Votazione (int id, String nome, int tipo) {
		this.idVotazione = id;
		this.nomeVotazione=nome;
		this.statoVotazione=0;
		this.tipoVotazione=tipo;
	}
	
	public Votazione (String nome, int tipo) {
		this.nomeVotazione=nome;
		this.statoVotazione=0;
		this.tipoVotazione=tipo;
	}
	
	public Votazione () {
	}
	
	/**
	 * restituisce un nuovo oggetto Votazione, contenente i dati passati come parametri.
	 * @param idVotazione identificativo della singola votazione.
	 * @param nomeVotazione Nome proprio della singola votazione.
	 * @param statoVotazione stato in cui si trova la singola votazione.
	 * @param tipoVotazione tipo di Votazione.
	 */
	public Votazione (int id, String nome, int tipo, int stato) {
		this.idVotazione = id;
		this.nomeVotazione=nome;
		this.tipoVotazione=tipo;
		this.statoVotazione=stato;
	}

	/**
	 * @return idVotazione
	 */
	public int getIdVotazione() {
		return idVotazione;
	}

	/**
	 * @param idVotazione the idVotazione to set
	 */
	public void setIdVotazione(int idVotazione) {
		this.idVotazione = idVotazione;
	}

	/**
	 * @return the nomeVotazione
	 */
	public String getNomeVotazione() {
		return nomeVotazione;
	}

	/**
	 * @param nomeVotazione the nomeVotazione to set
	 */
	public void setNomeVotazione(String nomeVotazione) {
		this.nomeVotazione = nomeVotazione;
	}

	/**
	 * @return the statoVotazione
	 */
	public int getStatoVotazione() {
		return statoVotazione;
	}

	/**
	 * @param statoVotazione the statoVotazione to set
	 */
	public void setStatoVotazione(int statoVotazione) {
		this.statoVotazione = statoVotazione;
	}

	/**
	 * @return the tipoVotazione
	 */
	public int getTipoVotazione() {
		return tipoVotazione;
	}

	/**
	 * @param tipoVotazione the tipoVotazione to set
	 */
	public void setTipoVotazione(int tipoVotazione) {
		this.tipoVotazione = tipoVotazione;
	}

	@Override
	public String toString() {
		return "Votazione [idVotazione=" + idVotazione + ", nomeVotazione=" + nomeVotazione + ", statoVotazione="
				+ statoVotazione + "]";
	}

}