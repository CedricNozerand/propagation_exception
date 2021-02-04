package propagationException.presentation;

import propagationException.domaine.User;
import propagationException.service.ServiceException;
import propagationException.service.UserService;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		User user = new User("Nozerand", "Cédric", "cedric.nozerand@gmail", "11 rue de Paris", "0102030405", "20/10/1993");
		
		try {
			userService.creerUtilisateur(user);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}
}
