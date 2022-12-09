# projet_LU3IN033
analyseur de trame de Bouchaal Samia et Malenfer François pour L'UE LU3IN033

## introduction

notre programme permet de de visualiser les flux entre deux machines, il a etait developpé dans le cadre du projet de reseau de L3 informatique a Sorbonne Université. 

## fonctionnement

### explication du programme

le programme est fourni avec un makefile pour le compiler et lancer l'execution du programme qui attent le chemin vers le fichier trace pour le lire.  
le programme affiche dans la console les flux entre la source et la destination. cette affichage est aussi sauvegardé dans le fichier out.txt

### explication du langage

on a choisit java pour implementer ce programme car la programation orienté objet permet de diviser les informations entres les differentes couches de manière naturel et la bibliothèque d'execution de java offre des outils pour gérer les flux d'entré et de sortie. 

### explication du code

le programme prend en entré un fichier a partir duquel il construit un FileReader.
ce file reader est transmit de classe en classe tout du long de l'execution pour 
permettre la construction des classes representant le contenu des trames.

on a 4 classes qui represente le contenu des trames :

Trame.java qui represente une trame dans on entierté, elle est composé des adreresses MAC sources et destinations ainsi que du champ type qui indique quel protocole est contenu dans la section data.

IpV4.java qui contient un champ par element de l'entete ip (parfois moins, comme les champs contiennent minimum un byte on ce retrouve parfois avec plusieurs elements de l'entete dans un seul champ par exemple le Champ version_IHL contient a la fois les informations de la version du protocole ip et de la taille de l'entete ip)

TCP.java contient les informations de l'entete TCP 

HTTP.java contient les informations de l'entete HTTP ainsi que le contenu de la trame


en plus de ces 4 classes qui represente les trames on a d'autres classes qui permettent d'exploiter les informations contenus dans les trames. on a la classe Trame_champ.java qui contient une ArrayList d'element de type Trame_info.

Trame_info contient une references sur les 4 constituant de la trame qu'il represente, trame, ip, tcp et http . il contient aussi 2 fonction recoitData() et envoieData() qui respectivement deux chaine de caractère differente en fonction de si la trame de d'on on veut recupérer l'affichage correspond a une trame envoyé par la source de la 1er trame ou la dest de la 1er trame.

Affichage.java est la classe qui permet de generer l'affichage. elle contient 3 methodes, makeAffichage() qui génere l'affichage, printAffichage() qui ecrit l'affichage dans la console et printAffichageIn(String fileName) qui ecrit l'affichage au format txt dans le fichier fileName.  
