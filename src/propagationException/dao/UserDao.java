package propagationException.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import propagationException.domaine.User;

public class UserDao {

	// Scénario de test:
	// Pour tester la propagation d'erreur, ecrire volontairement une erreur dans la variable 'url'.
	
	// variables bdd
	private String url = "jdbc:mysql://localhost/propagatio?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String login = "root";
	private String passwd = "";
	
	public boolean createUser(User user) throws DatabaseException {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT into user (nom, prenom, mail, adresse, telephone, dateNaissance) VALUES "
					+ "('"+user.getNom()+"'"
					+ ",'"+user.getPrenom()+"'"
					+ ",'"+user.getMail()+"'"
					+ ", '"+user.getAdresse()+"'"
					+ ", '"+user.getTelephone()+"'"
					+ ", '"+user.getDateNaissance()+"'"
					+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new ConnexionDatabaseException();
		} catch (ClassNotFoundException e ) {
			throw new SQLDriverNotFoundException();
		} // finally {
//			try {
//				cn.close();
//				st.close();
//			} catch (SQLException e) {
//				//e.printStackTrace();
//				throw new DatabaseException("Problème de connexion à la base de données");
//			}
//		}
		return true;
	}
}
