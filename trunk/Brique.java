import java.awt.*;
import java.util.ArrayList;

/** Un objet brique représente l'élément de base des boucliers.
 * Le constructeur est le même que celui de la classe Chose.*/
 class Brique extends Chose
{
	
	 public Brique(ArrayList univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id)
	{
		 
		 super(univers,coord,vitesse,vie,largeur,hauteur,id);
		
	}
	 
	 /**C'est la fonction qui dessine la brique, elle prend en compte les différents aspects possibles de la brique en fontion de la vie
	  * @param Graphics g
	  * */
	 public void dessin(Graphics g)
	 {
		 switch(vie)
		 {
		 case 4:
		 		g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+10),hauteur/(nbr_aleatoire()+10));
		 			}
		 		}
		 break;
		 	
		 case 3:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+13),hauteur/(nbr_aleatoire()+13));
		 			}
		 		}
		 break;
		 	
		 case 2:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+17),hauteur/(nbr_aleatoire()+17));
		 			}
		 		}
		 break;
		 
		 case 1:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+20),hauteur/(nbr_aleatoire()+20));
		 			}
		 		}
		 break;
		 
		 }
		 
	 }

	 /**
	  * Cette méthode est utilisée dans la fonction dessin pour dessiner les briques de façon irrégulière
	  * @param aucun
	  * @return un int compris entre 1 et 3
	  */
	 private int nbr_aleatoire()
	 {
		double alea=Math.random()*3;
		if (alea<1)
		{
			return 1;
		}
		
		if ((1<=alea)&&(alea<2))
		{
			return 2;
		}
		if (alea>=2)
		{
			return 3;
		}
	 }
	 
	 public void prochainTour()
	 {
		 //A priori les briques ne bougent pas.
	 }
	 
	 private static int largeur;
	 private static int hauteur;
	 private int vie;
	 private int abscisse, ordonnee, i,j;
	 private Color col=Color.green;
	 
	 abscisse=coord.getX();
	 ordonnee=coord.getY();

}
