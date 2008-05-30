import java.util.ArrayList;

/** Missile : arme du jeu.
 * Important : CHANGER dans deplacement les bords de l'écran qu'on a mis à 640*800
 */
public class Missile extends Chose {

	private int camp; // 1 : ami et 0 : ennemi
	
	public int getCamp(){
		return camp;
	}
	
	Missile(ArrayList univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id, int camp) {
		super(univers, coord, vitesse, vie, largeur, hauteur, id);
		this.camp = camp;
	}
	
	public boolean touche(Chose c){
		return (coord.getX() >= (c.coord.getX()-c.getLargeur()/2) && c.coord.getX() <= (c.coord.getX()+c.getLargeur()/2)) && (c.coord.getY() >= (c.coord.getY()-c.getHauteur()/2) && c.coord.getY() <= (c.coord.getY()+c.getHauteur()/2)); 
	}
	
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
	
	public void deplacement(){
		if (coord.getX()==640 && coord.getY()==800) {
				destruction();
		}
		else {
			super.deplacement();
		}
	}
	
	public void prochainTour() {
		deplacement();
		collision();
	}
}
