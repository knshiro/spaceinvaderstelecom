import java.util.ArrayList;

public class Jeu {
	ArrayList<Chose> univers;
	private int score;
	private int level;
	private String pseudo;
	private int son;
	Timer tRefresh;
	Timer tEscadrille;
	Timer tBaseLaser;
	Timer tMissile;
	
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
			pseudo=v;
		}
		else {
			pseudo=ASS;
		}
	}
	public int getPseudo(){
		return pseudo;
	}
	
}
