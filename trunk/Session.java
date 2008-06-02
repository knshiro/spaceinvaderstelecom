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
	}	
	
	public void jouer(){
		game = new Jeu(player.getLevel());
		tRefresh.start();
		wait(3000);
		game.jouer();
		
	}
	
	
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		switch(game.getGameOver()){
		case 0 :
			for (int i=0;i<60;i++){
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
		tRefresh.stop();
		/*afficher un écran gagnant*/
		try{
			wait(5000);
		}
		catch(InterruptedException e){ e.printStackTrace(); }
		player.nextLevel();
		jouer();
	}
	
	public void gameOver(){
		game.stop();
		/*afficher un écran perdant*/
		try{
			wait(5000);
		}
		catch(InterruptedException e){ e.printStackTrace(); }
		/* afficher le score et demander le nom*/
	}

}
