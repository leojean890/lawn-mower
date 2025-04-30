Ce projet permet d'exécuter les instructions des tondeuses dans l'ordre fourni en input.

J'ai créé une méthode Main.main qui prend en entrée un chemin vers un fichier d'instructions et affiche le résultat sur la sortie standard.

Ce projet contient également 5 tests automatisés :
- test nominal
- test dont le but est de vérifier que les commandes qui font sortir la tondeuse de la map sont ignorées
- test paramétré contenant 3 cas d'erreur liés au format du fichier d'entrée
  
Axes d'amélioration éventuels : 

- utiliser des exceptions custom
- utiliser des EnumMap ou des HashMap au lieu des switch pour déterminer selon l'instruction reçue, l'action à réaliser. 
- utiliser un logger
- ajouter d'autres tests automatisés de cas d'erreur, par exemple le cas où le fichier fourni en entrée n'est pas trouvé
- petite réserve : on reçoit les instructions en même temps que l'objet, je les ai construit ensemble 
mais ça aurait été mieux de les décorréler histoire de pouvoir recevoir plusieurs chaines d'instructions à des moments variés pour une même tondeuse (sujet différent)

Pour compiler le projet et exécuter les tests automatisés, utiliser la commande suivante :

mvn clean install

traces d'exécution :

[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.solent.service.InstructionsHandlerTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.452 s - in com.solent.service.InstructionsHandlerTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.3.0:jar (default-jar) @ lawn-mower ---
[INFO] Building jar: C:\Users\leo.jean\IdeaProjects\lawn-mower\target\lawn-mower-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- install:3.1.0:install (default-install) @ lawn-mower ---
[INFO] Installing C:\Users\leo.jean\IdeaProjects\lawn-mower\pom.xml to C:\Users\leo.jean\.m2\repository\com\solent\lawn-mower\1.0-SNAPSHOT\lawn-mower-1.0-SNAPSHOT.pom
[INFO] Installing C:\Users\leo.jean\IdeaProjects\lawn-mower\target\lawn-mower-1.0-SNAPSHOT.jar to C:\Users\leo.jean\.m2\repository\com\solent\lawn-mower\1.0-SNAPSHOT\lawn-mower-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.201 s
[INFO] Finished at: 2025-04-29T20:45:45+02:00
[INFO] ------------------------------------------------------------------------
