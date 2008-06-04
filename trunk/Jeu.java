import java.util.*;
import java.awt.*;
import java.awt.event.*;

/** Jeu : Classe qui gère toute la partie IA. Elle génère l'univers et les timers qui
 * les controlent.
 * 
 * @author Knshiro
 * @version 1.0
 * @package default_package
 */

public class Jeu {
	ArrayPerso univers;
	private int level;
	private int son;
	javax.swing.Timer tEscadrille;
	javax.swing.Timer tBaseLaser;
	javax.swing.Timer tBrique;
	javax.swing.Timer tMissile;
	private int larginv, hautinv; //modifier pour entrer la hauteur et la largeur des invaders
	private int gameOver;
	Joueur player;
	
	
	/** aEscadrille
	 * action qui lance la méthode prochainTour de l'escadrille
	 */
	ActionListener aEscadrille = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(univers.get(1)!=null)
        		//System.out.println("prochain tour escadrille");
        		(univers.get(1)).prochainTour();
        }
	};
	
	/** aBaseLaser
	 * action qui lance la méthode prochainTour de la BaseLaser
	 */
	ActionListener aBaseLaser = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(univers.get(0)!=null)
        		(univers.get(0)).prochainTour();
        }
	};
	
	/** aBrique
	 * action qui lance la mthode prochainTour des briques de shelter
	 */
	ActionListener aBrique = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	for (int i=3;i<43;i++){
        		if(univers.get(i)!=null)
        			(univers.get(i)).prochainTour();
    			}
        }
	};
	
	/** aBrique
	 * action qui lance la méthode prochainTour des missiles
	 */
	ActionListener aMissile = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	for (int i=43;i<100;i++){
        		if(univers.get(i)!=null)
        			(univers.get(i)).prochainTour();
    			}
        }
	};
	
	
	public void setGameOver(int v){
		gameOver=v;
	}
	public int getGameOver(){
		return gameOver;
	}
	
	
	public void setSon(int v){
		son=v;
	}
	public int getSon(){
		return son;
	}

	/** Jeu
	 * constructeur qui instancie tous les objets et crée les timers utilisés par les timers
	 * 
	 * @param level
	 */
	Jeu(int level){
		this.level=1;//level;
		univers = new ArrayPerso();
		Point coord= new Point(100,500);
		Point vitesse=new Point(0,0);
		int largeur=15;
	 	int hauteur=15;
		switch (level) {
		
		case 1 :
			
			univers.add(0,new BaseLaser(player,univers, new Point(400,550), new Point(3,0), 4, 21, 16, 0));
			univers.add(1,new Escadrille(player,univers, new Point(110,0), new Point (3,0), 55, 11, 5, 1, 1, 0, 10, 25, 20, 10));
			univers.add(2,new MysteryShip(player,univers,new Point(10,50), new Point(2,0), 1, 21, 16, 2,0));
			for (int i=0;i<=3;i++)
			{
				coord.setPoint(100+i*150,500);
				univers.add(3+11*i,new Brique(player,univers,new Point(coord.getX()+3*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,3+11*i));
				univers.add(4+11*i,new Brique(player,univers,new Point(coord.getX()+3*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,4+11*i));
				univers.add(5+11*i,new Brique(player,univers,new Point(coord.getX()+5*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,5+11*i));
				univers.add(6+11*i,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,6+11*i));
				univers.add(7+11*i,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,7+11*i));
				univers.add(8+11*i,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,8+11*i));
				univers.add(9+11*i,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,9+11*i));
				univers.add(10+11*i,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,10+11*i));
				univers.add(11+11*i,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,11+11*i));
				univers.add(12+11*i,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,12+11*i));
				univers.add(13+11*i,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,13+11*i));
			}
			
			
			tEscadrille = new javax.swing.Timer(100,aEscadrille);
			tBaseLaser = new javax.swing.Timer(40,aBaseLaser);
			tBrique = new javax.swing.Timer(500,aBrique);
			tMissile = new javax.swing.Timer(30,aMissile);
			break;

		case 2 :
			break;

		case 3 :
			break;

		default : 
			break;
		}	
	}
	
	public void jouer(){
		tEscadrille.start();
		tBaseLaser.start();
		tBrique.start();
		tMissile.start();
	}
	public void stop(){
		tEscadrille.stop();
		tBaseLaser.stop();
		tBrique.stop();
		tMissile.stop();
	}
}
