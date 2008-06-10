import java.util.ArrayList;

/** Chose : Objet le plus générique. Contient les attributs et les méthodes de base.
 * 
 * @author Knshiro
 * @version 1.0
 * @package default_package
 */

public abstract class Chose {

	ArrayPerso univers = new ArrayPerso();
	Joueur player;
	
	Point coord;
	Point vitesse;
	
	private int vie;
	private int largeur;
	private int hauteur;
	private int id;
	
	/** Constructeur de Chose
	* @param player : permet d'acceder aux paramètres actuels de l'objet joueur
	* @param univers : permet d'accéder aux autres éléments del'univers de la partie en cours
	* @param coord : definit la position dans l'écran en pixel
	* @param vitess : definit la vitesse de déplacement en pixel
	* @param vie : donne l'état de santé de l'objet
	* @param largeur : definit la largeur de l'objet sur l'ecran en pixel
	* @param hauteur : definit la hauteur de l'objet sur l'ecran en pixel
	* @param id : permet à l'objet de se reconnaitre dans l'univers
	*/
	
	Chose(Joueur player,ArrayPerso univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id){
		this.player = player;
		this.univers = univers;
		this.coord = coord;
		this.vitesse = vitesse;
		this.vie = vie;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.id = id;
	}
	
	public void setVie(int v){
		vie=v;
	}
	public int getVie(){
		return vie;
	}
	public void setLargeur(int v){
		largeur=v;
	}
	public int getLargeur(){
		return largeur;
	}
	public void setHauteur(int v){
		hauteur=v;
	}
	public int getHauteur(){
		return hauteur;
	}
	
	public int getID(){
		return id;
	}
	
	/** dessin
	* méthode à implémenter qui créera le dessin
	* @param rien.
	* @return rien.
	*/
	public void dessin(java.awt.Graphics g){};
	
	
	/** deplacement
	* méthode qui translate l'objet avec sa vitesse
	* @param rien.
	* @return rien.
	*/
	public void deplacement(){
		coord.translate(vitesse.getX(), vitesse.getY());
		
	}
	
	/** degat
	* méthode qui diminue la vie de la chose d'une valeur impact
	* @param impact, un int.
	* @return rien.
	*/
	public void degat(int impact){
		vie -= impact;
		if (vie<=0)
			destruction();
	}
	
	/** destruction
	* méthode qui élimine la chose de l'univers dans lequel elle se trouve
	* @param rien.
	* @return rien.
	*/
	public void destruction(){
		univers.add(id,null); 
	}
	
	/** prochainTour
	* méthode qui effectuera toutes les action amenant à l'état suivant de la chose
	* @param rien.
	* @return rien.
	*/
	public abstract void prochainTour();
	
	
}
