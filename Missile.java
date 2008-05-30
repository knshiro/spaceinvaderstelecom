import java.util.ArrayList;

/** Missile : arme du jeu.
 * 
 * @author Knshiro
 * @version 1.0
 * @package default_package
 */

public class Missile extends Chose {

	private int camp; // 1 : ami et 0 : ennemi
	
	public void setCamp(int v){
		camp = v;
	}
	public int getCamp(){
		return camp;
	}
	
	Missile(ArrayList univers, Point coord, int vie, int largeur, int hauteur, int id, int camp) {
		super(univers, coord, vie, largeur, hauteur, id);
		this.camp = camp;
	}
	
	public boolean touche(Chose c){
		return (coord.getX() > (c.coord.getX()-c.getLargeur()/2) && c.coord.getX()<(c.coord.getX()+c.getLargeur()/2)) && (c.coord.getY() > (c.coord.getY()-c.getHauteur()/2) && c.coord.getY()<(c.coord.getY()+c.getHauteur()/2)); 
	}
	
	public void collision(){
		if(camp==1){ //allié
			int i=1;
			while(i<4*10 && !touche(univers.get(i))){
				i++;
				}
			if(touche(univers.get(i))){
				(univers.get(i)).degat(1);
				destruction();
			}
			else{
				i++;
				ArrayList<Chose> mechant = (univers.get(i)).troupe;
				i=0;
				int j=0;
				while(i<5 && (mechant.get(i,j)).coord.get(Y))
			}
		}
	}
	
}
