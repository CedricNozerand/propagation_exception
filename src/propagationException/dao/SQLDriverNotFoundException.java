package propagationException.dao;

public class SQLDriverNotFoundException extends DatabaseException{
	private static final long serialVersionUID = 1L;

	public SQLDriverNotFoundException() {
        this( "SQLDriverNotFoundException - Erreur spécialisé: erreur lors du chargement du driver" );
    }

    public SQLDriverNotFoundException( String message ) {
        super( message );
    }
    
    public SQLDriverNotFoundException( String message, Throwable cause ) {
        super( message, cause );
    }
}
