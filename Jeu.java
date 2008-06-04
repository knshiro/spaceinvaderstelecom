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
		Point coord= new Point(50,50);
		Point vitesse=new Point(0,0);
		int largeur=20;
	 	int hauteur=20;
		switch (level) {
		
		case 1 :
			univers.add(0,new BaseLaser(player,univers, new Point(400,550), new Point(3,0), 4, 21, 16, 0));
			univers.add(1,new Escadrille(player,univers, new Point(110,0), new Point (3,0), 55, 11, 5, 1, 1, 0, 10, 25, 20, 10));
			univers.add(2,new MysteryShip(player,univers,new Point(10,50), new Point(2,0), 1, 21, 16, 2,0));
			univers.add(3,new Brique(player,univers,new Point(coord.getX()+3*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,3));
			univers.add(4,new Brique(player,univers,new Point(coord.getX()+3*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,4));
			univers.add(5,new Brique(player,univers,new Point(coord.getX()+5*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,5));
			univers.add(6,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,6));
			univers.add(7,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,7));
			univers.add(8,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+3*hauteur/2),vitesse,4,largeur,hauteur,8));
			univers.add(9,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,9));
			univers.add(10,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+5*hauteur/2),vitesse,4,largeur,hauteur,10));
			univers.add(11,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,11));
			univers.add(12,new Brique(player,univers,new Point(coord.getX()+7*largeur/2,coord.getY()+7*hauteur/2),vitesse,4,largeur,hauteur,12));
			univers.add(13,new Brique(player,univers,new Point(coord.getX()+largeur/2,coord.getY()+hauteur/2),vitesse,4,largeur,hauteur,13));
			
			
			
			tEscadrille = new javax.swing.Timer(40,aEscadrille);
			tBaseLaser = new javax.swing.Timer(100,aBaseLaser);
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
