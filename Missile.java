import java.util.ArrayList;

/** Missile : arme du jeu.
 * Important : CHANGER dans deplacement les bords de l'écran qu'on a mis à 640*800
 */
public class Missile extends Chose {

/**
 * Permet de déterminer le camp du tireur de missile
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
	Missile(ArrayList univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id, int camp) {
		super(univers, coord, vitesse, vie, largeur, hauteur, id);
		this.camp = camp;
	}

/**
 * Permet de savoir si on touche qqn 
 * @param c
 * @return
 */
	
	public boolean touche(Chose c){
		return (coord.getX() >= (c.coord.getX()-c.getLargeur()/2) && c.coord.getX() <= (c.coord.getX()+c.getLargeur()/2)) && (c.coord.getY() >= (c.coord.getY()-c.getHauteur()/2) && c.coord.getY() <= (c.coord.getY()+c.getHauteur()/2)); 
	}
	
/**
 * Détecte une éventuelle collision
 */
	public void collision(){
		int i,j;
		if(camp==1){   // C'est le gentil terrien qui tire
			j=0;
			ArrayList<Chose> mechant = univers.get(1);
			i=0;
			while(i<5){
				while(i<5 && !touche((mechant.getMatrice)[i][j])){
					j++;
					if (j==11) {
							i++;
					}
				}
			}
			if(touche(mechant.getMatrice[i][j])){
				(mechant.getMatrice[i][j]).degat(1);
				destruction(); 
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
 * Redondance de la fonction de déplacement 
 * Rapide test si sortie de l'écran
 */
	public void deplacement(){
		if (coord.getX()==640 && coord.getY()==800) {
				destruction();
		}
		else {
			super.deplacement();
		}
	}
	
/**
 * Permettra à la fonction de Jeu de contrôler le prochain tour
 */
	public void prochainTour() {
		deplacement();
		collision();
	}
}
