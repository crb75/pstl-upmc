# pstl-upmc
Code source PSTL

## Le code source est testé par le SonarLint plugin de Eclipse. 

Les résultats des tests sont les suivants : 

- **DisplayDg**
  - **This class has 7 parents which is greater than 5 authorized.** *(La classe PFrame est une classe de Piccolo2D. Pour éviter cette erreur il faut changer les héritages dans piccolo2D)*
  - **Make "gridLine" transient or serializable.** *(La classe Line2D est une classe de java.awt.geom. Pour faire serializable, il faut créer une classe qui est sérializable et qui hérite de la classe Line2D dans notre projet.)*
  - **Make "gridStroke" transient or serializable.** *(La classe Stroke est une classe de java.awt.geom. Pour faire serializable, il faut créer une classe qui est sérializable et qui hérite de la classe Stroke dans notre projet.)*
