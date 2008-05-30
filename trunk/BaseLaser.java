import java.util.ArrayList;


public class BaseLaser extends Chose{
	private int nombremissile;
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
	
	BaseLaser(ArrayList univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id){
		super(univers,coord,vitesse,vie,largeur,hauteur,id);
		this.nombremissile=0;
		this.ordredeplacement=0;
		this.autorisation=1;
		}

	public void tir(){
		if( (autorisation==1) && (this.nombremissile<=3 )) {  // autorisation =1 si on demande à tirer un missile
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
	
	public void dessin(){
	}
	
	public void prochainTour(){
		this.tir();
		if(this.ordredeplacement==1)    // deplacement à droite si ordredeplacement vaut 1
			this.deplacement();
		if(this.ordredeplacement==-1){  // deplacement à gauche si ordredeplacement vaut -1;
			Point sauvervitesse = new Point(this.vitesse.getX(),this.vitesse.getY());
			this.vitesse.setPoint(-sauvervitesse.getX(),sauvervitesse.getY());
			this.deplacement();
			this.vitesse.setPoint(sauvervitesse.getX(),sauvervitesse.getY());
		}
	}
	
}
