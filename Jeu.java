import java.util.*;

public class Jeu {
	ArrayList<Chose> univers;
	private int score;
	private int level;
	private String pseudo;
	private int son;
	Timer tEscadrille;
	TimerTask taskEscadrille = new
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
		tEscadrille = new Timer(true);
		task
		tBaseLaser = new Timer(true);
		tMissile = new Timer(true);
		univers = new ArrayList<Chose>();
		
		switch (level) {
		
		case 1 :
			univers.add(new BaseLaser(univers, new Point(100,50), new Point(0,0), 4, 5, 2, 0));
			univers.add(new Escadrille(univers, new Point(0,0), 5*11, 11, 5, 1, 1, 1, 1, int hautinv, int larginv));
			univers.add(new MysteryShip());
			for (int i=3;i++;i<43){
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
