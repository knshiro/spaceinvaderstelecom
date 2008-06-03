import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Session extends JPanel {

	Jeu game;
	Joueur player;
	Timer tRefresh;
	
	ActionListener aRefresh = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	repaint();
        }
	};
	
	Session(){
		player = new Joueur(1,0,"bob");
		tRefresh = new Timer(80,aRefresh);
		setPreferredSize(new java.awt.Dimension(800, 600));
		setBackground(Color.BLACK);
	}	
	
	public void jouer(){
		game = new Jeu(player.getLevel());
		tRefresh.start();
		game.jouer();
		
	}
	
	
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		switch(game.getGameOver()){
		case 0 :
			for (int i=0;i<60;i++){
				if(game.univers.get(i)!=null)
					(game.univers.get(i)).dessin(g);
				
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
	
	public void win(){
		game.stop();
		/*afficher un écran gagnant*/
		
		jouer();
	}
	
	public void gameOver(){
		game.stop();
		/*afficher un écran perdant*/
		
		/* afficher le score et demander le nom*/
	}

}
