import java.awt.*;
import java.util.ArrayList;

/** Un objet brique reprsente l'lment de base des boucliers.
 * Le constructeur est le mme que celui de la classe Chose.*/
 class Brique extends Chose 
{
	
	 public Brique(Joueur player, ArrayPerso univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id)
	{
		 super(player, univers,coord,vitesse,vie,largeur,hauteur,id);
		 col=Color.white;
		 abscisse=this.coord.getX();
		 ordonnee=this.coord.getY();	 
		 vie=getVie();
	}
	 
	 /**C'est la fonction qui dessine la brique, elle prend en compte les diffrents aspects possibles de la brique en fontion de la vie
	  * @param Graphics g
	  * */
	 public void dessin(Graphics g)
	 {
		 largeur = getLargeur();
		 hauteur = getHauteur();
		 vie=getVie();
		 
		 switch(vie)
		 {
		 case 4:
		 		g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(/*nbr_aleatoire()+*/10),hauteur/10);
		 			}
		 		}
		 break;
		 	
		 case 3:
			 
			 g.setColor(Color.GRAY);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+13),hauteur/(nbr_aleatoire()+13));
		 			}
		 		}
		 break;
		 	
		 case 2:
			 
			 g.setColor(Color.ORANGE);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+13),hauteur/(nbr_aleatoire()+13));
		 			}
		 		}
		 break;
		 
		 case 1:
			 
			 g.setColor(Color.RED);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/(nbr_aleatoire()+13),hauteur/(nbr_aleatoire()+13));
		 			}
		 		}
		 break;
		 
		 }
		 
	 }

	 /**
	  * Cette mthode est utilise dans la fonction dessin pour dessiner les briques de faon irrgulire
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
		
		else
		{
		if ((1<=alea)&&(alea<2))
		{
			return 2;
		}
		else 
		{
			return 3;
		}
		}
	 }
	 
	 public void prochainTour()
	 {
		 
	 }
	 
	 private int vie;
	 private int abscisse, ordonnee, i,j, hauteur, largeur;
	 private Color col;
	 

}