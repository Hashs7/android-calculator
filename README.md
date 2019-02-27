# android-calculator
Projet Gobelins - Android applications - Calculator and newsfeed

## <a name="conception">1. Conception</a>

L'application permet d'effectuer les calculs basiques : addition, soustraction, multiplication et division.

Il y a une seule activité "MainActivity" qui contrôle la vue et écoute les évènements utilisateur.
Au clique d'un bouton, sa valeur est ajoutée à celle affichée par la vue. Au clique d'un bouton opérateur, sa valeur est stockée. 
Enfin lorsque le bouton égal est appuyé, la valeur affichée est coupé en deux parties par l'opérateur. Cela permet de récupérer la partie gauche et la partie droite du calcul pour effectuer l'opération. 

La classe modèle "Operation" a pour but de récupérer les valeurs saisies et retourner le résultat en fonction de l'opérateur choisi. Elle est séparé du MainActivity pour déporter la logique du calcul des opérations et évite de la surcharger. 
En cas de division par zéro ou d'opérateur invalide, l'utilisateur est prévenu par un "toast" afin de prévenir d'une erreur inattendu.



## <a name="organisation">2. Organisation</a>

Ce projet a été développé en collaboration avec [Guillaume Lagouy](https://github.com/GuillaumeLagouy/android-calculator).
Il a développé l'application des news et je me suis personnellement occupé de l'application calculatrice.


## <a name="installationn">3. Installation</a>

Pour installer le projet, ouvrez un terminal et exécutez ces commandes :

    cd AndroidStudioProjects
    
    git clone git@github.com:Hashs7/android-calculator.git
    

## <a name="demo">4. Vidéo demo</a>

<img src="https://s2.gifyu.com/images/calculator.gif" alt="demo" width="317"/>

