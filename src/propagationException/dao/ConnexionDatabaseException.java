package propagationException.dao;

public class ConnexionDatabaseException extends DatabaseException{
	private static final long serialVersionUID = 1L;

	public ConnexionDatabaseException() {
		this("ConnexionDatabaseException - Erreur sp�cialis�: erreur lors de la connexion � la base de donn�es.");
	}

	public ConnexionDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnexionDatabaseException(String message) {
		super(message);
	}
}
