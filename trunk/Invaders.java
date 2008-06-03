import java.awt.*;
import java.util.ArrayList;
/**
 * Un objet invaders est un vaisseau ennemi. Son constructeur comporte plus d'arguments que le constructeur de Chose.
 * En effet il faut aussi préciser quel est le type du vaisseau (cela change le nombre de points attribués en cas de destruction), ainsi que sa position dans l'escadrille (ligne, colone).
 */
class Invaders extends Chose 
{
	private int abscisse,ordonnee,hauteur,largeur, type, colonne, ligne, vie, id ;
	

	
	/*hauteur=super.getHauteur();
	largeur=super.getLargeur();
	id=super.getId();
	vie=super.getVie();
	Vraisemblablement inutile*/

	public Invaders(Joueur player, ArrayList<Chose> univers, Point coord,Point vitesse, int vie, int largeur, int hauteur, int id, int type, int colonne, int ligne)
	{
		super(player,univers, coord,vitesse,vie, largeur, hauteur,id);
		this.type=type;
		this.colonne=colonne;
		this.ligne=ligne;
		abscisse=coord.getX();
		ordonnee=coord.getY();
		
	}
	
	/**Dessine l'invaders. Son apparence dépend de la valeur de <i>type</i>.
	 * 
	 * @param g de type Graphics
	 */
	public void dessin(Graphics g)
	{
			
		switch(type)
		{
		case 1:
			g.setColor(Color.WHITE);
			System.out.println(" " + abscisse+ " "+ ordonnee);
			System.out.println("invadlargeur = "+ getLargeur());
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
		
		case 4:
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
			g.fillRect(abscisse+largeur/7, ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+3*largeur/7, ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
			g.fillRect(abscisse+5*largeur/7 , ordonnee+7*hauteur/8,largeur/7, hauteur/8);//8 ligne
		break;
		
		case 5:
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
	 * Instancie un missile si l'invaders est appelé à tirer.
	 */
	void tir()
	{
		int vie_missile=1;
		int largeur_missile=4; //la largeur et la hauteur seront sans doute à modifier
		int hauteur_missile=10;
		Point vitesse_missile=new Point(0,20); //j'ai aucune idée de l'ordre de grandeur, à modifier ultérieurement
		int camp=0;//C'est un ennemi
		Point coord_missile=new Point(abscisse+(largeur-largeur_missile)/2,ordonnee+hauteur);//Pour que le missile parte du bon endroit
		//instancie un nouveau missile
		Missile missile=new Missile(player,univers,coord_missile,vitesse_missile,vie_missile,largeur_missile,hauteur_missile,id_missile(),camp);//à corriger
	}
	/**
	 * Cette foncion est utilisée dans la méthode tir pour déterminer l'id du missile à instancier. Cette fonction parcours la liste univers et renvoie l'index de la première case vide d'index supérieur ou égal à 43.
	 * @return L'id du missile. 
	 */
	private int id_missile()
	{
		int i=43;
		while(univers.get(i)!=null)
		{
			i++;
		}
		return i-1;
	}
	
	
	/**
	 * <b>Détermine le comportement à adopter lorsque l'invaders est touché:</b>
	 * <br> -On enlève une unité à la vie de l'escadrille
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
	 * Détermine le comportment à adopter au prochain décléchement du timer. Cette méthode permet le déplacement de l'invaders.
	 */
	public void prochainTour()
	{
		deplacement();
	}
	

	
	
}
