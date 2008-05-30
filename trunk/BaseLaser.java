import java.util.ArrayList;


public class BaseLaser extends Chose{
	private int nombremissile;
	private int autorisation;
	
	int Getauto(){
		return autorisation;
	}
	
	void Setauto(int i){
		this.autorisation=i;
	}
	
	BaseLaser(ArrayList univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id){
		super(univers,coord,vitesse,vie,largeur,hauteur,id);
		this.nombremissile=0;
		}

	void tir(){
		if( (autorisation==1) && (this.nombremissile<=3 )) {
			int i=43;
			while(this.univers.get(i) != null) i++;
			
			int X = this.coord.getX();
			int Y = this.coord.getY()+ 2;
			Point coords = new Point(X,Y);
			
			int vitesseX = this.vitesse.getX();
			int vitesseY = this.vitesse.getY() + 10;
			Point vitesses = new Point(vitesseX,vitesseY);
			this.nombremissile++;
			Missile missile = new Missile(this.univers,coords,vitesses,1,1,2,i,1);
		}
		
			
	}
	
	void dessin(){
	}
	
	void prochainTour(){
		this.tir();
		this.deplacement();
	}
	
}
