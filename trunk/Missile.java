import java.util.ArrayList;

/** Missile : arme du jeu.
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
		if(camp==1){
			int j=0;
			ArrayList<Chose> mechant = univers.get(1);
			int i=0;
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
					while(univers.get(i) != null && !touche(univers.get(i))){
						i++;
					}
					if(touche(univers.get(i))) {
						(univers.get(i)).degat(1);
						destruction();
					}
				}
			}
		}
	}
	
}
