import javax.swing.*;


public class Joueur extends JPanel {

	private int level;
	private int score;
	Timer tRefresh;
	Jeu game;
	
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
	
	
	Joueur(int level, int score, Jeu game){
		this.level=level;
		this.score=score;
		this.game=game;
	}
	
	
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		switch(game.getGameOver()){
		case 0 :
			for (int i=0;i<60;i++){
				(game.univers.get(i)).dessin();	
			}
			break;
		
		case 1 : 
			gameOver();
			break;
		case -1:
			win();
			break;
	}
	
	
	
}
