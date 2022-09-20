package persistence;

import java.util.List;

import model.CandidatoPartito;

//restituisce la lista delle candidati e dei partiti presenti sul DB
public interface CandidatoPartitoDao {
	public List<CandidatoPartito> getAllCandidatiPartiti(int idVotazione);
	public List<CandidatoPartito> getAllCandidati(CandidatoPartito cand);
	public List<CandidatoPartito> getAllPartiti(int idVotazione);
	public int createCandidatoPartito(CandidatoPartito partito);
	public void deletePartito(CandidatoPartito partito);
	public void deleteCandidatoPartito(CandidatoPartito candidato);
//	public boolean esisteCandidato(CandidatoPartito cand);
}
