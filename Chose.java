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
