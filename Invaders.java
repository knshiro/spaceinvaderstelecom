import java.awt.*;
import java.util.ArrayList;

class Invaders extends Chose 
{
	
	private int abscisse,ordonnee,hauteur,largeur, type, colonne, ligne, vie, id;
	
	abscisse=coord.getX();
	ordonnee=coord.getY();
	hauteur=super.getHauteur();
	largeur=super.getLargeur();
	id=super.getId();
	vie=super.getVie();
	
	public Invaders(ArrayList<Chose> univers, Point coord,Point vitesse, int vie, int largeur, int hauteur, int id, int type, int colonne, int ligne)
	{
		super(univers, coord,vitesse,vie, largeur, hauteur,id);
		this.type=type;
		this.colonne=colonne;
		this.ligne=ligne;	
	}
	
	
	public void dessin(Graphics g)
	{
			
		switch(type)
		{
		case 1:
			g.setColor(Color.white);
			g.fillRect((2*abscisse+largeur)/2-3*largeur/14, ordonnee, 3*largeur/7, hauteur/8);//première ligne
			g.fillRect(abscisse+largeur/14 , ordonnee+hauteur/8, 6*largeur/7, hauteur/8);//2nd ligne
			g.fillRect(abscisse , ordonnee+2*hauteur/8, largeur, hauteur/8);//troisième ligne
			g.fillRect(abscisse , ordonnee+3*hauteur/8, 2*largeur/7, hauteur/8);//quatrième
			g.fillRect(abscisse+3*largeur/7 , ordonnee+3*hauteur/8, largeur/7, hauteur/8);
			g.fillRect(abscisse+5*largeur/7 , ordonnee+3*hauteur/8,2*largeur/7, hauteur/8);
			g.fillRect(abscisse , ordonnee+4*hauteur/8,largeur, hauteur/8);//cinquième ligne
			g.fillRect(abscisse+2*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);//sixième ligne
			g.fillRect(abscisse+4*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);//7 ligne
			g.fillRect(abscisse+5*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+3*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+6*largeur/7 , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
		break;
		
		case 2:
			g.setColor(Color.white);
			g.fillRect(abscisse + 2*largeur/7, ordonnee, 3*largeur/7, hauteur/8);//première ligne
			g.fillRect(abscisse + largeur/7, ordonnee+ hauteur/8, 5*largeur/7, hauteur/8);//2 ligne
			g.fillRect(abscisse + largeur/7, ordonnee +2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee+2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse + 5*largeur/7, ordonnee+2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse , ordonnee+3*hauteur/8, 2*largeur/7, hauteur/8);//4
			g.fillRect(abscisse + 3*largeur/7, ordonnee+3*hauteur/8, largeur/7, hauteur/8);//4
			g.fillRect(abscisse + 5*largeur/7, ordonnee+3*hauteur/8, 2*largeur/7, hauteur/8);//4
			g.fillRect(abscisse , ordonnee+4*hauteur/8, largeur, hauteur/8);//5
			g.fillRect(abscisse , ordonnee+5*hauteur/8, largeur/7, hauteur/8);//6
			g.fillRect(abscisse + 2*largeur/7, ordonnee+5*hauteur/8, largeur/7, hauteur/8);//6
			g.fillRect(abscisse + 4*largeur/7, ordonnee+5*hauteur/8, largeur/7, hauteur/8);//6
			g.fillRect(abscisse + 6*largeur/7, ordonnee+5*hauteur/8, largeur/7, hauteur/8);//6
			g.fillRect(abscisse , ordonnee+6*hauteur/8, largeur/7, hauteur/8);//7
			g.fillRect(abscisse + 2*largeur/7, ordonnee+6*hauteur/8, largeur/7, hauteur/8);//
			g.fillRect(abscisse + 4*largeur/7, ordonnee+6*hauteur/8, largeur/7, hauteur/8);//
			g.fillRect(abscisse + 6*largeur/7, ordonnee+6*hauteur/8, largeur/7, hauteur/8);//
			g.fillRect(abscisse + 3*largeur/7, ordonnee+7*hauteur/8, largeur/7, hauteur/8);//8
		break;
		
		case 3:
			g.setColor(Color.white);
			g.fillRect(abscisse , ordonnee, 2*largeur/7, hauteur/8);//1 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee, largeur/7, hauteur/8);//1 ligne
			g.fillRect(abscisse + 5*largeur/7, ordonnee, 2*largeur/7, hauteur/8);//1 ligne
			g.fillRect(abscisse + largeur/7, ordonnee+ hauteur/8, 5*largeur/7, hauteur/8);//2 ligne
			g.fillRect(abscisse + largeur/7, ordonnee+ 2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee+ 2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse + 5*largeur/7, ordonnee+ 2*hauteur/8, largeur/7, hauteur/8);//3 ligne
			g.fillRect(abscisse, ordonnee+ 3*hauteur/8, largeur, hauteur/8);//4 ligne
			g.fillRect(abscisse + largeur/7, ordonnee+ 4*hauteur/8, 5*largeur/7, hauteur/8);//5 ligne
			g.fillRect(abscisse + 2*largeur/7, ordonnee+ 5*hauteur/8, 3*largeur/7, hauteur/8);//6 ligne
			g.fillRect(abscisse + largeur/7, ordonnee+ 6*hauteur/8, largeur/7, hauteur/8);//7 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee+ 6*hauteur/8, largeur/7, hauteur/8);//7 ligne
			g.fillRect(abscisse + 5*largeur/7, ordonnee+ 6*hauteur/8, largeur/7, hauteur/8);//2 ligne
			g.fillRect(abscisse , ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse + 6*largeur/7, ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//2 ligne
		break;
			
		}
	}
	
	void tir()
	{
		int vie_missile=1;
		int largeur_missile=4; //la largeur et la hauteur seront sans doute à modifier
		int hauteur_missile=10;
		Point vitesse_missile=new Point(0,20); //j'ai aucune idée de l'ordre de grandeur, à modifier ultérieurement
		int id_missile=id; //Qu'en sais-je?
		int camp=0;//C'est un ennemi
		Point coord_missile=new Point(abscisse+(largeur-largeur_missile)/2,ordonnee+hauteur);
		
		Missile missile=new Missile(univers,coord_missile,vitesse_missile,vie_missile,largeur_missile,hauteur_missile,id_missile,camp);//à corriger
	}
	
	public void destruction()
	{
		
		univers.get(1).setVie(univers.get(1).getVie()-1);
		Escadrille esc=(Escadrille) univers.get(1);
		esc.setMatrice(ligne, colonne, null);
		esc.tableauxAJour(ligne, colonne);
		super.destruction();
	}
	
	public void prochainTour()
	{
		deplacement();
	}
	

	
	
}
