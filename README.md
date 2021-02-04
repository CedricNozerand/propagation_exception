# propagation_exception

## Prerequis
Projet archictecture en couche
Driver mysql
Base de données

## fonctionnement
la propagation d'une exception se creer avec le mot clé 'throws NomDeLexception' dans la signature d'une méthode. Ainsi la gestion de l'erreur se fera dans la classe appellante. 
Il est possible de creer soit même une classe Exception afin de spécialiser et personnaliser le traitement de chacune d'entre elles.

## Cas concret
Ici le projet en couche est un projet simple. 
* Une couche presentation (Main)
* une couche service (UserService)
* une couche dao (UserDao)

La méthode createUser() de la couche dao capture les exceptions dans une classe appelée DatabaseException qui hérite de la classe Exception. Cela permet de spécialiser le traitement de ce type d'erreur dans une classe spécifique.
Dans chaque 'catch' nous déterminons le type précis d'erreur pour capturer cette erreur dans une classe encore plus précise qui va hériter de la classe DatabaseException.(avec le mot clé 'throw NomDeLaClasse'.<br/>
Ex:
SQLDriverNotFoundException qui est utilisé quand le fichier (driver) n'est pas trouvé ou n'existe pas.

La classe UserService fonctionne de la même manière. La méthode creerUtilisateur capture les exceptions dans la classe ServiceException qui hérite aussi de la classe Exception et qui va permettre de propager la gestion de l'exception dans la couche présentation (main).  
