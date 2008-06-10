import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

 
public class Joueur extends JPanel{

	private int level;
	private int score;
	private String pseudo;
	private int gameOver;
	Session partie;
	

	public void setGameOver(int v){
		gameOver=v;
	}
	public int getGameOver(){
		return gameOver;
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
	public void nextLevel(){
		if(level<4)
			level++;
	}
	
	Joueur(int level, int score){
		this.level=level;
		this.score=score;
		setPreferredSize(new java.awt.Dimension(800, 100));
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		g.drawString(Integer.toString(score), 400, 50);
		if(partie.game != null){
			for (int i=0; i< partie.game.univers.get(0).getVie(); i++){
			dessinBase(g, 200 + i*30, 50, 25, 20);
			}
		}
		
	}
	
	public void dessinBase(Graphics g,int abscisse,int ordonnee,int hauteur,int largeur)
	{
			
		g.setColor(Color.white);
		g.fillRect(abscisse+ 3*largeur/7, ordonnee, largeur/7, hauteur/8);//1
		g.fillRect(abscisse+ 3*largeur/7, ordonnee +hauteur/8, largeur/7, hauteur/8);//2
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +2*hauteur/8, 3*largeur/7, hauteur/8);//3
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +3*hauteur/8, 3*largeur/7, hauteur/8);//4
		g.fillRect(abscisse+ 2*largeur/7, ordonnee +4*hauteur/8, 3*largeur/7, hauteur/8);//5
		g.fillRect(abscisse+ largeur/7, ordonnee +5*hauteur/8, 5*largeur/7, hauteur/8);//6
		g.fillRect(abscisse, ordonnee +6*hauteur/8, 7*largeur/7, hauteur/8);//7
		g.fillRect(abscisse, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
		g.fillRect(abscisse+ 3*largeur/7, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
		g.fillRect(abscisse+ 6*largeur/7, ordonnee +7*hauteur/8, largeur/7, hauteur/8);//8
	
	}
}
