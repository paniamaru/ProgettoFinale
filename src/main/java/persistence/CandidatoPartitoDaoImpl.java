package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CandidatoPartito;

public class CandidatoPartitoDaoImpl implements CandidatoPartitoDao {

	public List<CandidatoPartito> getAllCandidatiPartiti(int idVotazione) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		List<CandidatoPartito> candidatipartiti = new ArrayList<CandidatoPartito>();
		try {
			stmt = connection.prepareStatement(
					"SELECT * FROM ass_5.candidati_partiti WHERE candidati_partiti.idVotaz=? ORDER BY candidati_partiti.NomePartito");
			stmt.setInt(1, idVotazione);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				candidatipartiti.add(new CandidatoPartito(rs.getInt(3), rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// connection.close();
		return candidatipartiti;
	}

	public List<CandidatoPartito> getAllPartiti(int idVotazione) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		List<CandidatoPartito> partiti = new ArrayList<CandidatoPartito>();
		try {
			stmt = connection.prepareStatement(
					"SELECT * FROM ass_5.candidati_partiti WHERE candidati_partiti.idVotaz=? AND NomePartito=Candidati_Partiti");
			stmt.setInt(1, idVotazione);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				partiti.add(new CandidatoPartito(rs.getInt(3), rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// connection.close();
		return partiti;
	}

	public List<CandidatoPartito> getAllCandidati(CandidatoPartito cand) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		List<CandidatoPartito> candidati = new ArrayList<CandidatoPartito>();
		try {
			stmt = connection.prepareStatement(
					"SELECT * FROM ass_5.candidati_partiti WHERE candidati_partiti.idVotaz=? AND candidati_partiti.NomePartito=? AND NomePartito!=Candidati_Partiti");
			stmt.setInt(1, cand.getIdVotazione());
			stmt.setString(2, cand.getNomePartito());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				candidati.add(new CandidatoPartito(rs.getInt(3), rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// connection.close();
		return candidati;
	};
	
	public int createCandidatoPartito(CandidatoPartito partito) {
        Connection connection = Util.DataBase.getInstance().getConnection();
        PreparedStatement stmt;
        int r=0;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO ass_5.candidati_partiti (Candidati_Partiti, idVotaz, NomePartito) VALUES (?,?,?)");
            stmt.setString(1, partito.getNomeCandidato());
            stmt.setInt(2, partito.getIdVotazione());
            stmt.setString(3, partito.getNomePartito());
            r=stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r;
        // connection.close();
   }
	
	public void deletePartito(CandidatoPartito partito) {
        Connection connection = Util.DataBase.getInstance().getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(
                    "DELETE FROM ass_5.candidati_partiti WHERE (idVotaz=? AND NomePartito=?)");
            stmt.setInt(1, partito.getIdVotazione());
            stmt.setString(2, partito.getNomePartito());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // connection.close();
   }
	
	public void deleteCandidatoPartito(CandidatoPartito candidato) {
        Connection connection = Util.DataBase.getInstance().getConnection();
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement(
                    "DELETE FROM ass_5.candidati_partiti WHERE (Candidati_Partiti=? AND idVotaz=? AND NomePartito=?)");
            stmt.setString(1, candidato.getNomeCandidato());
            stmt.setInt(2, candidato.getIdVotazione());
            stmt.setString(3, candidato.getNomePartito());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // connection.close();
   }
/*
	public boolean esisteCandidato(CandidatoPartito cand) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
//		List<CandidatoPartito> partito = new ArrayList<CandidatoPartito>();
		try {
			stmt = connection.prepareStatement(
					"SELECT * FROM ass_5.candidati_partiti WHERE candidati_partiti.idVotaz=? AND NomePartito=? AND NomePartito=?");
			stmt.setInt(1, cand.getIdVotazione());
			stmt.setString(2, cand.getNomePartito());
			stmt.setString(3, cand.getNomeCandidato());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return false;
	}
*/
}