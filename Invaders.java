import java.awt.*;
import java.util.ArrayList;

class Invaders extends Chose 
{
	
	public Invaders(ArrayList univers, Point coord, int vie, int largeur, int hauteur, int id, int type, int colone, int ligne)
	{
		super(univers, coord, vie, largeur, hauteur,id);
		this.type=type;
		this.colone=colone;
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
	
	public void destruction()
	{
		
		univers.get(1).setVie(univers.get(1).getVie()-1);
		super.destruction();	
	}
	
	abscisse=coord.getX();
	ordonnee=coord.getY();
	hauteur=super.getHauteur();
	largeur=super.getLargeur();
	id=super.getId();
	vie=super.getVie();
	
	private int abscisse,ordonnee,hauteur,largeur, type, colone, ligne, vie, id;
}
