import javax.swing.JPanel;


public class Joueur extends JPanel {

	private int level;
	private int score;
	Jeu game;
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		if(==0){
			for (int i=0;i<60;i++){
				(game.univers.get(i)).dessin();	
			}
		}
		else{
			gameOver();	
			}
		
	}
}
