package propagationException.service;

import propagationException.dao.UserDao;
import propagationException.domaine.User;

public class UserService {

	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public void creerUtilisateur(User user) throws ServiceException {
		try {
			userDao.createUser(user);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
			//throw new ServiceException("Problème dans la couche service");
		}
	}
}
