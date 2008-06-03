import java.util.ArrayList;
import java.awt.*;


/** Missile : arme du jeu.
 * Important : CHANGER dans deplacement les bords de l'cran qu'on a mis, moi et mes mains  800*600
 */
public class Missile extends Chose {

/**
 * Permet de dterminer le camp du tireur de missile
 * 1 : Base laser -- 0 : Ennemi
 */	
	private int camp;

/**
 * Constructeur : On ajoute juste le camp
 * @param univers
 * @param coord
 * @param vitesse
 * @param vie
 * @param largeur
 * @param hauteur
 * @param id
 * @param camp
 */
	public Missile(Joueur joueur,ArrayPerso univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id, int camp) {
		super(joueur,univers, coord, vitesse, vie, largeur, hauteur, id);
		this.camp = camp;
	}

/**
 * Permet de savoir si on touche qqn 
 * @param c
 * @return
 */
	
	public boolean touche(Chose c){
		if(c!=null){
			boolean contact = !( coord.getX() >= c.coord.getX()) && ( coord.getX() <= c.coord.getX()+c.getLargeur() ) && ( coord.getY() >= c.coord.getY() ) && ( coord.getY() <= c.coord.getY()+c.getHauteur()); 
			//System.out.println(( coord.getX() >= c.coord.getX()-c.getLargeur()/2 ) && ( coord.getX() <= c.coord.getX()+c.getLargeur()/2 ) && ( coord.getY() >= c.coord.getY()-c.getHauteur()/2 ) && ( coord.getY() <= c.coord.getY()+c.getHauteur()/2) );
			return (contact);
		}
		else return false;
	}
	
/**
 * Dtecte une ventuelle collision
 */
	public void collision(){
		int i,j;
		Escadrille mechant;
		if(camp==1){   // C'est le gentil terrien qui tire
			j=0;
			mechant = (Escadrille) univers.get(1);
			i=0;
			while(i<5 && !touche((mechant.getMatrice())[i][j])){
				j++;
				if (j==11) {
					i++;
					j=0;
				}
				
			}
			if(i!=5){
				System.out.println("TOUCHE PAR MISSILE");
				(mechant.getMatrice()[i][j]).degat(1);
				destruction(); 
				((BaseLaser) (univers.get(0))).nombremissile--;
			}
			else {
				if(touche(univers.get(2))) {
					(univers.get(2)).degat(1);
					destruction();
				}
				else {
					i=3;
					while(i < 100 && !touche(univers.get(i))){
						i++;
					}
					if(i<100) {
						(univers.get(i)).degat(1);
						destruction();
					}
				}
			}
		}
		if(camp==0){  // C'est l'ennemi qui tire
			i=3;
			while(i < 43 && !touche(univers.get(i))){
				i++;
			}
			if(i<43) {
				(univers.get(i)).degat(1);
				destruction();
			}
			else {
				if(touche(univers.get(0))) {
					(univers.get(0)).degat(1);
					destruction();
				}
			}	
		}	
	}	
	
/**
 * Fonction de dessin pour les missiles
 * @param g
 */
	public void dessin(Graphics g)
	{
		int abscisse,ordonnee,hauteur,largeur;
		abscisse=coord.getX();
		ordonnee=coord.getY();
		hauteur=super.getHauteur();
		largeur=super.getLargeur();
		g.setColor(Color.white);
		g.fillRect(abscisse,ordonnee, largeur, hauteur);
	}
	
/**
 * Redondance de la fonction de dplacement 
 * Rapide test si sortie de l'cran
 */
	public void deplacement(){
		if ((coord.getX()>800) || (coord.getY()>600) || (coord.getX()<0) || (coord.getY() <0)) {
				destruction();
				((BaseLaser) (univers.get(0))).nombremissile--;
		}
		else {
			super.deplacement();
		}
	}
	
/**
 * Permettra  la fonction de Jeu de contrler le prochain tour
 */
	public void prochainTour() {
		System.out.println("entree dans prochain tour de missile");
		deplacement();
		collision();
	}
}
