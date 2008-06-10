import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/** BaseLaser : objet représentant la base laser et gérant son comportement
 * 
 * @author Benoît Bottineau
 * @version 1.0
 * @package default_package
 */


public class BaseLaser extends Chose{
	int nombremissile;
	private int autorisation;
	private int ordredeplacement;
	
	
	int getdeplacement(){
		return ordredeplacement;
	}
	
	void setdeplacement(int ordredeplacement){
		this.ordredeplacement=ordredeplacement;
	}

	
	int getauto(){
		return autorisation;
	}
	
	void setauto(int i){
		this.autorisation=i;
	}
	
	BaseLaser(Joueur joueur,ArrayPerso univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id){
		super(joueur,univers,coord,vitesse,vie,largeur,hauteur,id);
		this.nombremissile=0;
		this.ordredeplacement=0;
		this.autorisation=0;
		}

	public void tir(){
		if( (this.autorisation==1) && (this.nombremissile<=3 )) {  // autorisation =1 si on demande  tirer un missile
			int i=60; 
			autorisation=0;
			int X = this.coord.getX()+this.getHauteur()/2;
			int Y = this.coord.getY() - 2;
			Point coords = new Point(X,Y);
			
			int vitesseX = this.vitesse.getX()*ordredeplacement;
			int vitesseY = this.vitesse.getY() - 10;
			Point vitesses = new Point(vitesseX,vitesseY);
			this.nombremissile++;
			while(this.univers.get(i) != null) i++;
			Missile missile = new Missile(player,this.univers,coords,vitesses,1,3,10,i,1);
			(missile.univers).add(i,missile);
			
			
		}
		
			
	}
	
	public void dessin(Graphics g)
	{
		int abscisse,ordonnee,hauteur,largeur;
		abscisse=coord.getX();
		ordonnee=coord.getY();
		hauteur=super.getHauteur();
		largeur=super.getLargeur();
		
		
		
		g.setColor(Color.white);
		g.fillRect(abscisse+ 3*largeur/7, ordonnee, largeur/7, hauteur/8);//1
		g.fillRect(abscisse+ 3*largeur/7, ordonnee +hauteur/8, largeur/7, hauteur/8);//2
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +2*hauteur/8, 3*largeur/7, hauteur/8);//3
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +3*hauteur/8, 3*largeur/7, hauteur/8);//4
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +4*hauteur/8, 3*largeur/7, hauteur/8);//5
		g.fillRect(abscisse+ largeur/7, ordonnee +5*hauteur/8, 5*largeur/7, hauteur/8);//6
		g.fillRect(abscisse, ordonnee +6*hauteur/8, 7*largeur/7, hauteur/8);//7
		g.fillRect(abscisse, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
		g.fillRect(abscisse+ 3*largeur/7, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
		g.fillRect(abscisse+ 6*largeur/7, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
	
	}
	
	public void deplacement(){
		int X = this.coord.getX();
		if(ordredeplacement==1){// deplacement droite si ordredeplacement vaut 1
			if (X<800){
			coord.translate(vitesse.getX(), vitesse.getY());
			}
		}	
		else if(ordredeplacement==-1){
			if (X>0){
				coord.translate(-(vitesse.getX()), vitesse.getY());
				}
		}
			
	}
	
	
	
	
	
	public void prochainTour(){
		this.tir();
		this.deplacement();
	}

	
	public void destruction(){
		player.setGameOver(1);
	}
	
}