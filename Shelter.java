import java.util.ArrayList;
import java.awt.*;



class Shelter extends Chose
{
	
	Shelter(Joueur player, ArrayList<Chose> univers,Point coord, Point vitesse, int vie, int largeur,int hauteur, int id)
	{
		super(player,univers,coord, vitesse, vie,largeur, hauteur,id);
		vitesse.setPoint(0, 0);
		
		
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+3*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+5*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
		bouclier.add(new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,id_bouclier()));
	}
	
	public void dessin(Graphics g)
	{
		int i;
		for(i=0;i<=9;i++)
		{
			bouclier.get(i).dessin(g);
		}
	}
	private int id_bouclier()
	{
		int i=3;
		
		while(univers.get(i)!=null)
		{
			i++;
		}
		return i;
		
	}
	
	public void prochainTour()
	{	
	}
	
	
	
	private int vie, largeur,hauteur,id;
	ArrayList<Brique> bouclier= new ArrayList<Brique>();
}
