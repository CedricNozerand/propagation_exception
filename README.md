# Propagation_exception

## Prerequis
* Projet archictecture en couche
* Driver mysql
* Base de données

## Fonctionnement
La gestion de la propagation des exceptions se fait avec le mot clé 'throws NomDeLexception' dans la signature d'une méthode et permet de dire que cette méthode peut générer une exception mais que sont traitement ne se fera pas dans cette classe. Ainsi la gestion de l'erreur se fera dans la classe appellante. 
Il est possible de creer soit même une classe Exception afin de spécialiser et personnaliser le traitement de chaque exception.

## Cas concret
Ici le projet en couche est un projet simple. 
* Une couche presentation (Main)
* une couche service (UserService)
* une couche dao (UserDao)

La méthode createUser() de la couche dao capture les exceptions dans une classe appelée DatabaseException qui hérite de la classe Exception. Cela permet de spécialiser le traitement de ce type d'erreur dans une classe spécifique.
Dans chaque 'catch' nous déterminons le type précis d'erreur pour capturer cette erreur dans une classe encore plus précise qui va hériter de la classe DatabaseException.(avec le mot clé 'throw new NomDeLaClasse'.<br/>
Exemple:
* **SQLDriverNotFoundException** qui est utilisé quand le fichier (driver) n'est pas trouvé ou n'existe pas.
* **ConnexionDatabaseException** qui est utilisé lors d'une erreur pendant la connexion à la base de données.

La classe UserService fonctionne de la même manière. La méthode creerUtilisateur capture les exceptions dans la classe ServiceException qui hérite aussi de la classe Exception et qui va permettre de propager la gestion de l'exception dans la couche présentation (main).  

**Scénario**
1. Création d'une instance de la classe UserService.
2. Création d'un utilisateur
3. appelle de la méthode creerUtilisateur de la classe UserService avec l'utilisateur en paramètre
4. Depuis la classe UserSrvice: appelle de la méthode createUser dela classe UserDao avec l'utilisateur en paramètre
5. Définition de la propagationd'exception grace à la signature de la méthode: public boolean createUser(User user) **throws DatabaseException** ce qui permet de dire que les exceptions de cette méthode sont de type **DatabaseException** et seront gérées dans la classe appellante: **UserService**
6. Dans les 'catch' de la méthode, capture des différents exception grace à la ligne suivante: **throw new ConnexionDatabaseException();** et **throw new SQLDriverNotFoundException();** ce qui permet de spécialiser encore plus le traitement de chaque exception dans sa propre classe.
7. L'exception est renvoyée à la classe **UserService**
8. etc

Cela permet d'envoyer un message proprement de la couche dao à la couche service sans à avoir à spécifier quoi que ce soit dans la couche service.
