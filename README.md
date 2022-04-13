# Les Graphes valués
Théorie des graphes valués !

<img src="https://forthebadge.com/images/badges/made-with-java.svg" height = "35" />
<img src="https://forthebadge.com/images/badges/contains-17-coffee-cups.svg" height="35" />
<img src="https://forthebadge.com/images/badges/powered-by-coffee.svg" height="35" />

# Fichier :
Les fichiers chargés doivent respecter un certain format :

Format d'un lien : "Type lien", "Valuation lien" (type -> double)
Format d'un noeud : "Type noeud", "Nom noeud"


Dans cet exemple les voisins sont du type noeud :
```
Noeud:lien1::voisin1; lien2::voisin2;lien3::voisin3;………;lienk::voisink;;
```

Exemple complet de fichier :

```
V,Villefontaine:A,17::V,Heyrieux;A,3::V,Diemoz;;
V,Heyrieux:A,17::V,Villefontaine;D,6::V,Saint-Pierre de Chandieu;A,22::V,Saint-Priest;A,23::L,Eurexpo;D,8::V,Frontonas;;
V,Diemoz:A,3::V,Villefontaine;N,35::V,Oullins;;
L,Théatre Gallo Romain:A,6::R,Le Bateau Bellona;A,8::R,Poupées Russes;A,7::V,Ecully;D,3::R,Pitaya;;
R,Pitaya:D,3::L,Théatre Gallo Romain;A,5::R,Le Bateau Bellona;D,3::L,Parc sergent Blandan;D,1::V,Lyon;;
V,Oullins:N,35::V,Diemoz;D,3::V,Pierre-Bénite;D,2::L,Aquarium de Lyon;A,11::V,Ecully;;
```


# Exemples d'utilisations: 


### Fenêtre sans graphe chargé : 
![Screenshot_2](https://user-images.githubusercontent.com/82316285/163236705-527a7d63-97c8-42b6-89f6-5ccf9b870728.png)  
  
  
### Fenêtre avec un graphe chargé :
![Screenshot_5](https://user-images.githubusercontent.com/82316285/163249057-dd8edea9-77fd-4e97-a03e-58687e5caafd.png)  
  
  
### Ici on a sélectionné deux noeuds, avec l'action "Plus Courte Distance (valeur)" de coché :
![Screenshot_1](https://user-images.githubusercontent.com/82316285/163236779-373a35f2-64cf-4484-97f7-c14cbf1dbec0.png)  
  
  
### Ici l'action "Plus court chemin"
![Screenshot_3](https://user-images.githubusercontent.com/82316285/163236787-ac82e803-ee77-4535-b1a7-a1183bd256f2.png)  
  
  
### Et enfin toute les villes directement relié à un certain point avec l'action "Ville 1 Distance"
![Screenshot_4](https://user-images.githubusercontent.com/82316285/163249047-c1a20ebc-5fd1-46f0-a66f-f924069b5394.png)

# Utiliser les fonctionnalités dans la console

Vous pouvez également utiliser les méthodes de la classe graphe uniquement dans la console.  
Pour cela modifier la classe GrapheApp à vos souhaits !

Exemple :
```
//open your file with ui 
//disable GrapheDraw if you want
//then in GrapheApp call methods you want
graphe.floydWarshallPredesseceurs().afficher();
System.out.println(graphe.floydWarshallChemin(21,7));
System.out.println(graphe.plusCourtChemin(0,5));
```

Si vous souhaitez travailler sur des Graphes non valués allez voir notre premier projet de [Graphe](https://github.com/icepick4/Graphe)!  
(comprend la plupart des méthodes de ce projet également)


