package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Votazione;

public class VotazioneDaoImpl implements VotazioneDao {

	public List<Votazione> getAllVotazioni() {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		List<Votazione> votazioni = new ArrayList<Votazione>();
		try {
			stmt = connection.prepareStatement("SELECT * FROM ass_5.votazione WHERE StatoVotazione <> 4");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				votazioni.add(new Votazione(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// connection.close();
		return votazioni;
	}

	public Votazione getVotazione(int id) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		Votazione risultato = new Votazione();
		try {
			stmt = connection.prepareStatement("SELECT * FROM ass_5.votazione WHERE votazione.idVotazione = ? AND StatoVotazione <> 4");

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			risultato = new Votazione(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risultato;
	}

	public void updateVotazione(Votazione votazione) {
		// UPDATE Tabella SET Attributo = 'Valore' WHERE (Condizione bool);
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(
					"UPDATE `ass_5`.`votazione` SET NomeVotazione = ?, StatoVotazione = ? WHERE votazione.idVotazione = ?");

			stmt.setString(1, votazione.getNomeVotazione());
			stmt.setInt(2, votazione.getStatoVotazione());
			stmt.setInt(3, votazione.getIdVotazione());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createVotazione(Votazione votazione) {
		// INSERT Tabella  ;
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(
					"INSERT INTO `ass_5`.`votazione`(NomeVotazione, StatoVotazione, TipoVotazione) VALUES (?,?,?)");

			stmt.setString(1, votazione.getNomeVotazione());
			stmt.setInt(2, votazione.getStatoVotazione());
			stmt.setInt(3, votazione.getTipoVotazione());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteVotazione(int id) {
		Connection connection = Util.DataBase.getInstance().getConnection();
		PreparedStatement stmt;
		try {
			stmt = connection
					.prepareStatement("UPDATE `ass_5`.`votazione` SET StatoVotazione = 4 WHERE votazione.idVotazione = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		
		 * Connection connection = Util.DataBase.getInstance().getConnection();
		 * PreparedStatement stmt = connection.
		 * prepareStatement("DELETE FROM `ass_5`.`scheda` WHERE scheda.idVotazione = ?"
		 * ); stmt.setInt(1, votazione.getIdVotazione()); stmt.executeQuery();
		 * 
		 * stmt = connection.
		 * prepareStatement("DELETE FROM `ass_5`.`voti` WHERE voti.idVotazione = ?");
		 * stmt.setInt(1, votazione.getIdVotazione()); stmt.executeQuery();
		 * 
		 * stmt = connection.
		 * prepareStatement("DELETE FROM `ass_5`.`candidati_partiti` WHERE candidati_partiti.idVotaz = ?"
		 * ); stmt.setInt(1, votazione.getIdVotazione()); stmt.executeQuery();
		 * 
		 * stmt = connection.
		 * prepareStatement("DELETE FROM `ass_5`.`votazione` WHERE votazione.idVotazione = ?"
		 * ); stmt.setInt(1, votazione.getIdVotazione()); stmt.executeQuery();
*/
	}
}
