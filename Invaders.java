import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics;
/**
 * Un objet invaders est un vaisseau ennemi. Son constructeur comporte plus d'arguments que le constructeur de Chose.
 * En effet il faut aussi prciser quel est le type du vaisseau (cela change le nombre de points attribus en cas de destruction), ainsi que sa position dans l'escadrille (ligne, colone).
 */
class Invaders extends Chose 
{
	private int abscisse,ordonnee,hauteur,largeur, type, colonne, ligne, vie, id ;
	

	
	
	


	public Invaders(Joueur player, ArrayPerso univers, Point coord,Point vitesse, int vie, int largeur, int hauteur, int id, int type, int colonne, int ligne)
	{
		super(player,univers, coord,vitesse,vie, largeur, hauteur,id);
		this.type=type;
		this.colonne=colonne;
		this.ligne=ligne;
		vie=super.getVie();
		abscisse=coord.getX();
		ordonnee=coord.getY();
		
	}
	
	/**Dessine l'invaders. Son apparence dpend de la valeur de <i>type</i>.
	 * 
	 * @param g de type Graphics
	 */
	public void dessin(Graphics g)
	{
			largeur = getLargeur();
			hauteur = getHauteur();
			abscisse = coord.getX();
			ordonnee = coord.getY();
		switch(type)
		{
		case 1:
			g.setColor(Color.WHITE);
			g.fillRect((2*abscisse+largeur)/2-3*largeur/14, ordonnee, 3*largeur/7, hauteur/8);//premire ligne
			g.fillRect(abscisse+largeur/14 , ordonnee+hauteur/8, 6*largeur/7, hauteur/8);//2nd ligne
			g.fillRect(abscisse, ordonnee+2*hauteur/8, largeur, hauteur/8);//troisime ligne
			g.fillRect(abscisse, ordonnee+3*hauteur/8, 2*largeur/7, hauteur/8);//quatrime
			g.fillRect(abscisse+3*largeur/7, ordonnee+3*hauteur/8, largeur/7, hauteur/8);
			g.fillRect(abscisse+5*largeur/7, ordonnee+3*hauteur/8,2*largeur/7, hauteur/8);
			g.fillRect(abscisse, ordonnee+4*hauteur/8,largeur, hauteur/8);//cinquime ligne
			g.fillRect(abscisse+2*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);//sixime ligne
			g.fillRect(abscisse+4*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);//7 ligne
			g.fillRect(abscisse+5*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+3*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+6*largeur/7 , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
		break;
		
		case 2:
			g.setColor(Color.white);
			g.fillRect(abscisse + 2*largeur/7, ordonnee, 3*largeur/7, hauteur/8);//premire ligne
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
		
		case 4:
			g.setColor(Color.white);
			g.fillRect((2*abscisse+largeur)/2-3*largeur/14, ordonnee, 3*largeur/7, hauteur/8);//premire ligne
			g.fillRect(abscisse+largeur/14 , ordonnee+hauteur/8, 6*largeur/7, hauteur/8);//2nd ligne
			g.fillRect(abscisse , ordonnee+2*hauteur/8, largeur, hauteur/8);//troisime ligne
			g.fillRect(abscisse , ordonnee+3*hauteur/8, 2*largeur/7, hauteur/8);//quatrime
			g.fillRect(abscisse+3*largeur/7 , ordonnee+3*hauteur/8, largeur/7, hauteur/8);
			g.fillRect(abscisse+5*largeur/7 , ordonnee+3*hauteur/8,2*largeur/7, hauteur/8);
			g.fillRect(abscisse , ordonnee+4*hauteur/8,largeur, hauteur/8);//cinquime ligne
			g.fillRect(abscisse+2*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);//sixime ligne
			g.fillRect(abscisse+4*largeur/7 , ordonnee+5*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);//7 ligne
			g.fillRect(abscisse+5*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+3*largeur/7 , ordonnee+6*hauteur/8,largeur/7, hauteur/8);
			g.fillRect(abscisse+largeur/7, ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+3*largeur/7, ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+5*largeur/7 , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
		break;
		
		case 5:
			g.setColor(Color.white);
			g.fillRect(abscisse + 2*largeur/7, ordonnee, 3*largeur/7, hauteur/8);//premire ligne
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
			g.fillRect(abscisse + largeur/7, ordonnee+7*hauteur/8, largeur/7, hauteur/8);//8
			g.fillRect(abscisse + 5*largeur/7, ordonnee+7*hauteur/8, largeur/7, hauteur/8);//8
		break;
		
		case 6:
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
			g.fillRect(abscisse + largeur/7, ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse + 3*largeur/7, ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse + 5*largeur/7, ordonnee+ 7*hauteur/8, largeur/7, hauteur/8);//2 ligne
		break;
			
		}
	}
	
	/**
	 * Instancie un missile si l'invaders est appel  tirer.
	 */
	void tir()
	{
		int vie_missile=1;
		int largeur_missile=4; //la largeur et la hauteur seront sans doute  modifier
		int hauteur_missile=10;
		Point vitesse_missile=new Point(0,10); //j'ai aucune ide de l'ordre de grandeur,  modifier ultrieurement
		int camp=0;//C'est un ennemi
		Point coord_missile=new Point(abscisse+(largeur-largeur_missile)/2,ordonnee+hauteur);//Pour que le missile parte du bon endroit
		//instancie un nouveau missile
		Missile missile=new Missile(player,univers,coord_missile,vitesse_missile,vie_missile,largeur_missile,hauteur_missile,id_missile(),camp);
		int i=43;
		while(this.univers.get(i) != null) i++;
		(missile.univers).add(i,missile);
		// corriger
	}
	/**
	 * Cette foncion est utilise dans la mthode tir pour dterminer l'id du missile  instancier. Cette fonction parcours la liste univers et renvoie l'index de la premire case vide d'index suprieur ou gal  43.
	 * @return L'id du missile. 
	 */
	private int id_missile()
	{
		int i=43;
		while(univers.get(i)!=null)
		{
			i++;
		}
		return i;
	}
	

	/**
	 * <b>Dtermine le comportement  adopter lorsque l'invaders est touch:</b>
	 * <br> -On enlve une unit  la vie de l'escadrille
	 * <br> -On vide la case correspondante dans la matrice de l'Escadrille
	 * <br> -On supprime l'invaders de la liste <i>univers</i> 
	 */
	public void destruction() 
	{
		
		univers.get(1).setVie(univers.get(1).getVie()-1);
		Escadrille esc=(Escadrille) univers.get(1);
		esc.setMatrice(ligne, colonne, null);
		esc.tableauxAJour(ligne, colonne);
		super.destruction();
	}
	/**
	 * Dtermine le comportment  adopter au prochain dclchement du timer. Cette mthode permet le dplacement de l'invaders.
	 */
	public void prochainTour()
	{
		deplacement();
		switch(type)
		{
		case 1:
			type=4;
		break;
		case 2: 
			type=5;
		break;
		case 3:
			type=6;
		break;
		case 4:
			type=1;
		break;
		case 5:
			type=2;
		break;
		case 6:
			type=1;
		break;
		}
	
	}
	

	
	
}
