# PROJET_LU3IN033
Visualisateur de trame de Bouchaal Samia et Malenfer François pour L'UE LU3IN033

## Introduction

Notre programme permet de  visualiser les flux entre deux machines : il a été developpé dans le cadre du projet de réseau de L3 Informatique a Sorbonne Université (LU3IN033). 

## Fonctionnement

### Explication du programme

Le programme est fourni avec un makefile pour le compiler et lancer l'execution du programme qui attent le chemin vers le fichier trace pour le lire.  
Le programme affiche dans la console les flux entre la source et la destination. Cet affichage est aussi sauvegardé dans le fichier out.txt

### Explication du langage

On a choisit java pour implémenter ce programme car la programation orienté objet permet de diviser les informations entres les differentes couches de manière naturel et la bibliothèque d'éxecution de java offre des outils pour gérer les flux d'entrée et de sortie. 

### Explication du code

Le programme prend en entrée un fichier à partir duquel il construit un FileReader.
Ce file reader est transmit de classe en classe tout du long de l'éxecution pour 
permettre la construction des classes representant le contenu des trames.

On a 4 classes qui représente le contenu des trames :

Trame.java qui represente une trame dans on entierté, elle est composé des adreresses MAC sources et destinations ainsi que du champ type qui indique quel protocole est contenu dans la section data.

IpV4.java qui contient un champ par élément de l'entête ip (parfois moins, comme les champs contiennent minimum un byte on se retrouve parfois avec plusieurs éléments de l'entête dans un seul champ par exemple le Champ version_IHL contient a la fois les informations de la version du protocole ip et de la taille de l'entête ip)

TCP.java contient les informations de l'entête TCP 

HTTP.java contient les informations de l'entête HTTP ainsi que le contenu de la trame


En plus de ces 4 classes qui représente les trames, on a d'autres classes qui permettent d'exploiter les informations contenus dans les trames. On a la classe Trame_champ.java qui contient une ArrayList d'élément de type Trame_info.

Trame_info contient une référence sur les 4 constituant de la trame qu'il représente, trame, ip, tcp et http. Il contient aussi 2 fonction recoitData() et envoieData() qui renvoient respectivement deux chaînes de caractères differentes en fonction de si la trame  dont on veut recupérer l'affichage correspond à une trame envoyé par la source de la 1ère trame ou la destination de la 1ère trame.

Affichage.java est la classe qui permet de générer l'affichage. Elle contient 3 methodes, makeAffichage() qui génère l'affichage, printAffichage() qui écrit l'affichage dans la console et printAffichageIn(String fileName) qui écrit l'affichage au format .txt dans le fichier fileName.  
