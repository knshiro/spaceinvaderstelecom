import javax.swing.JPanel;


public class Session extends JPanel {

	Jeu game;
	Joueur player;
	
	Session(String pseudo){
		player = new Joueur(1,0,pseudo);
	}	
	
	public void Jouer(){
		game = new Jeu(player.getLevel());
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
	
	public 

}
