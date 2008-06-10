import java.awt.*;
import java.util.*;

//Attention la classe n'est pas du tout oprationnelle pour l'instant, il faut modifier le constructeur.

class MysteryShip extends Chose 
{
	public MysteryShip(Joueur joueur,ArrayPerso univers,Point coord, Point vitesse, int vie, int largeur,int hauteur, int id, int etat)
	{
			
		super(joueur,univers,coord,vitesse,vie,largeur,hauteur,id);
		AudioPlayer son_mystery_ship = new AudioPlayer("file:mysterysound.wav");
		try {
			son_mystery_ship.start();
		} catch (Exception f) {
			System.out.println("Impossible de lire (cause : " + f + ")");
		}
		this.etat=etat;
		abscisse=coord.getX();
		ordonnee=coord.getY();
		System.out.println("Le mysteryShip est instancié");
		
	}
	
	public void dessin(Graphics g)
	{
		largeur = getLargeur();
		hauteur = getHauteur();
		abscisse = coord.getX();
		ordonnee = coord.getY();
		if(etat==1)
		{
			g.setColor(Color.red);
			g.fillRect(abscisse +5*largeur/13, ordonnee, largeur/13, hauteur/9);//1
			g.fillRect(abscisse +7*largeur/13, ordonnee, largeur/13, hauteur/9);//1
			g.fillRect(abscisse +6*largeur/13, ordonnee + hauteur/9, largeur/13, hauteur/9);//2
			g.fillRect(abscisse +2*largeur/13, ordonnee + 2*hauteur/9, 9*largeur/13, hauteur/9);//3
			g.fillRect(abscisse +largeur/13, ordonnee + 3*hauteur/9, 11*largeur/13, hauteur/9);//4
			g.fillRect(abscisse, ordonnee + 4*hauteur/9, 2*largeur/13, hauteur/9);//5
			g.fillRect(abscisse +4*largeur/13, ordonnee + 4*hauteur/9, largeur/13, hauteur/9);//5
			g.fillRect(abscisse +8*largeur/13, ordonnee + 4*hauteur/9, largeur/13, hauteur/9);//5
			g.fillRect(abscisse +11*largeur/13, ordonnee + 4*hauteur/9, 2*largeur/13, hauteur/9);//5
			g.fillRect(abscisse +largeur/13, ordonnee + 5*hauteur/9, 11*largeur/13, hauteur/9);//6
			g.fillRect(abscisse +2*largeur/13, ordonnee + 6*hauteur/9, 9*largeur/13, hauteur/9);//7
			for (i=1;i<=5;i++)
			{
				g.fillRect(abscisse +2*i*largeur/13, ordonnee + 7*hauteur/9, largeur/13, hauteur/9);//8
			}
			for (i=1;i<=6;i++)
			{		
				g.fillRect(abscisse +(2*i-1)*largeur/13, ordonnee + 8*hauteur/9, largeur/13, hauteur/9);//8
			}		
			
		}
			
		else if(etat==2)
		{
			g.setColor(Color.red);
			g.fillRect(abscisse +5*largeur/13, ordonnee, largeur/13, hauteur/9);//1
			g.fillRect(abscisse +7*largeur/13, ordonnee, largeur/13, hauteur/9);//1
			g.fillRect(abscisse +6*largeur/13, ordonnee + hauteur/9, largeur/13, hauteur/9);//2
			g.fillRect(abscisse +2*largeur/13, ordonnee + 2*hauteur/9, 9*largeur/13, hauteur/9);//3
			g.fillRect(abscisse +largeur/13, ordonnee + 3*hauteur/9, 11*largeur/13, hauteur/9);//4
			g.fillRect(abscisse, ordonnee + 4*hauteur/9, 2*largeur/13, hauteur/9);//5
			g.fillRect(abscisse +4*largeur/13, ordonnee + 4*hauteur/9, largeur/13, hauteur/9);//5
			g.fillRect(abscisse +8*largeur/13, ordonnee + 4*hauteur/9, largeur/13, hauteur/9);//5
			g.fillRect(abscisse +11*largeur/13, ordonnee + 4*hauteur/9, 2*largeur/13, hauteur/9);//5
			g.fillRect(abscisse +largeur/13, ordonnee + 5*hauteur/9, 11*largeur/13, hauteur/9);//6
			g.fillRect(abscisse +2*largeur/13, ordonnee + 6*hauteur/9, 9*largeur/13, hauteur/9);//7
			for (i=1;i<=6;i++)
			{		
				g.fillRect(abscisse +(2*i-1)*largeur/13, ordonnee + 8*hauteur/9, largeur/13, hauteur/9);//8
			}	
			for (i=1;i<=5;i++)
			{
				g.fillRect(abscisse +2*i*largeur/13, ordonnee + 7*hauteur/9, largeur/13, hauteur/9);//8
			}
			
		}	
		
	}
	
	
	public void prochainTour()
	{
		deplacement();
		if((coord.getX()>800)||(coord.getX()<0)||(coord.getY()<0)||(coord.getY()>600))
		{
			destruction();
		}
		switch (etat)
		{
		case 1:
			etat=2;
			break;
		case 2:
			etat=1;
			break;
		}
	}
	
	public void destruction()
	{
		super.destruction();
		player.addScore(250);
	}
	
	private int i, abscisse, ordonnee, largeur, hauteur, etat;

	
}
