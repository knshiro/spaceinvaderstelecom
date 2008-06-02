import javax.swing.*;


public class Joueur{

	private int level;
	private int score;
	private String pseudo;
	
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
	
	Joueur(int level, int score, String pseudo){
		this.level=level;
		this.score=score;
		setPseudo(pseudo);
	}
	

}
