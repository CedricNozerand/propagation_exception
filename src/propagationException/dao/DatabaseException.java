package propagationException.dao;

public class DatabaseException extends Exception {
	private static final long serialVersionUID = 1L;

	public DatabaseException() {
        this( "DatabaseException - Erreur g�n�rale: Erreur dans la couche dao" );
    }

    public DatabaseException( String message ) {
        super( message );
    }
    
    public DatabaseException( String message, Throwable cause ) {
        super( message, cause );
    }
}
