import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Jeu {
	ArrayList<Chose> univers;
	private int score;
	private int level;
	private String pseudo;
	private int son;
	javax.swing.Timer tEscadrille;
	javax.swing.Timer tBaseLaser;
	javax.swing.Timer tMissile;
	
	public void setScore(int v){
		score=v;
	}
	public void addScore(int v){
		score+=v;
	}
	public int getScore(){
		return score;
	}
	
	public void setLevel(int v){
		level=v;
	}
	public int getLevel(){
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

	Jeu(int level,int score, String name){
		this.level=level;
		this.score=score;
		setPseudo(name);
		univers = new ArrayList<Chose>();
		
		ActionListener aEscadrille = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (univers.get(1)).prochainTour();
            }
		};
		
		ActionListener aBaseLaser = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                (univers.get(0)).prochainTour();
            }
		};
		
		ActionListener aBrique = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i=3;i<43;i++){
            		(univers.get(i)).prochainTour();
        			}
            }
		};
		
		ActionListener aMissile = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i=43;i<60;i++){
            		(univers.get(i)).prochainTour();
        			}
            }
		};
		
		switch (level) {
		
		case 1 :
			univers.add(new BaseLaser(univers, new Point(100,50), new Point(0,0), 4, 5, 2, 0));
			univers.add(new Escadrille(univers, new Point(0,0), 5*11, 11, 5, 1, 1, 1, 1, int hautinv, int larginv));
			univers.add(new MysteryShip());
			for (int i=3;i<43;i++){
			univers.add(new Brique());
			}
			tEscadrille.s
			break;

		case 2 :
			break;

		case 3 :
			break;

		default : 
			break;
		}
		
	}
}
