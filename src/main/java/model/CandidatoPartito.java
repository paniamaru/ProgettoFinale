package model;

public class CandidatoPartito {
	private int idVotazione;
	private String nomePartito;
	private String nomeCandidato;
	
	public CandidatoPartito(int idVotazione, String nomePartito, String nomeCandidato) {
		this.idVotazione = idVotazione;
		this.nomePartito = nomePartito;
		this.nomeCandidato = nomeCandidato;
	}

	/**
	 * @return the idVotazione
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
	 * @return the nomePartito
	 */
	public String getNomePartito() {
		return nomePartito;
	}

	/**
	 * @param nomePartito the nomePartito to set
	 */
	public void setNomePartito(String nomePartito) {
		this.nomePartito = nomePartito;
	}

	/**
	 * @return the nomeCandidato
	 */
	public String getNomeCandidato() {
		return nomeCandidato;
	}

	/**
	 * @param nomeCandidato the nomeCandidato to set
	 */
	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	@Override
	public String toString() {
		return "CandidatoPartito [idVotazione=" + idVotazione + ", nomePartito=" + nomePartito + ", nomeCandidato="
				+ nomeCandidato + "]";
	}
}
