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
	ArrayList<Chose> univers;
	private int level;
	private String pseudo;
	private int son;
	javax.swing.Timer tEscadrille;
	javax.swing.Timer tBaseLaser;
	javax.swing.Timer tBrique;
	javax.swing.Timer tMissile;
	private int larginv, hautinv; //modifier pour entrer la hauteur et la largeur des invaders
	private int gameOver;
	Joueur player;
	
	
	public void setGameOver(int v){
		level=v;
	}
	public int getGameOver(){
		return level;
	}
	
	public void setPseudo(String v){
		if(v.length()<4){
			pseudo=v.toUpperCase();
		}
		else {
			pseudo="ASS";
		}
	}
	public String getPseudo(){
		return pseudo;
	}
	
	public void setSon(int v){
		son=v;
	}
	public int getSon(){
		return son;
	}

	/** Jeu
	 * constructeur qui instancie tous les objets et crée les listeners utilisés par les timers
	 * 
	 * @param level
	 * @param score
	 * @param name
	 */
	Jeu(int level){
		this.level=level;
		univers = new ArrayList<Chose>();
		
		/** aEscadrille
		 * action qui lance la méthode prochainTour de l'escadrille
		 */
		ActionListener aEscadrille = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (univers.get(1)).prochainTour();
            }
		};
		
		/** aBaseLaser
		 * action qui lance la méthode prochainTour de la BaseLaser
		 */
		ActionListener aBaseLaser = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (univers.get(0)).prochainTour();
            }
		};
		
		/** aBrique
		 * action qui lance la méthode prochainTour des briques de shelter
		 */
		ActionListener aBrique = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i=3;i<43;i++){
            		(univers.get(i)).prochainTour();
        			}
            }
		};
		
		/** aBrique
		 * action qui lance la méthode prochainTour des missiles
		 */
		ActionListener aMissile = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i=43;i<60;i++){
            		(univers.get(i)).prochainTour();
        			}
            }
		};
		
		switch (level) {
		
		case 1 :
			univers.add(new BaseLaser(player,univers, new Point(100,50), new Point(0,0), 4, 5, 2, 0));
			univers.add(new Escadrille(player,univers, new Point(0,0), new Point (3,0), 5*11, 11, 5, 1, 1, 1, 1,hautinv, larginv, 2));
			univers.add(new MysteryShip());
			for (int i=3;i<43;i++){
			univers.add(new Brique());
			}
			for(int i=3;i<=60;i++){
				univers.add(null);
			}
			tEscadrille = new javax.swing.Timer(500,aEscadrille);
			tBaseLaser = new javax.swing.Timer(500,aBaseLaser);
			tBrique = new javax.swing.Timer(500,aBrique);
			tMissile = new javax.swing.Timer(500,aMissile);
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
}