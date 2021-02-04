package propagationException.dao;

public class ConnexionDatabaseException extends DatabaseException{
	private static final long serialVersionUID = 1L;

	public ConnexionDatabaseException() {
		this("ConnexionDatabaseException - Erreur spécialisé: erreur lors de la connexion à la base de données.");
	}

	public ConnexionDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnexionDatabaseException(String message) {
		super(message);
	}
}
