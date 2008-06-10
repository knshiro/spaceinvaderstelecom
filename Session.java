import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import  java.awt.event.*;


public class Session extends JPanel implements KeyListener,MouseListener{

	Jeu game;
	Joueur player;
	Timer tRefresh;
	Image img;
	Thread proc;
	
	ActionListener aRefresh = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	repaint();
        	player.repaint();
        }
	};
	
	 public void keyPressed(KeyEvent evt){
		 if (evt.getKeyCode() == KeyEvent.VK_LEFT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(-1);
		 }
		 if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(1);
		 }
		 if (evt.getKeyCode() == KeyEvent.VK_SPACE){
			 ((BaseLaser) game.univers.get(0)).setauto(1);
		 }
	 }
	 public void keyReleased(KeyEvent evt){
		 if (evt.getKeyCode() == KeyEvent.VK_LEFT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(0);
		 }
		 if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(0);
		 }
		 if (evt.getKeyCode() == KeyEvent.VK_SPACE){
			 ((BaseLaser) game.univers.get(0)).setauto(0);
		 }
	 }  
	 public void keyTyped(KeyEvent evt){
		 
	 }

	
	Session(Joueur player){
		this.player=player;
		requestFocus();
		addMouseListener(this);
		addKeyListener (this);
		tRefresh = new Timer(40,aRefresh);
		setPreferredSize(new java.awt.Dimension(800, 600));
		setBackground(Color.BLACK);
		try {
		img = ImageIO.read(new File("FarAway.jpg"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		proc = new Thread(){
			public void run(){
				tRefresh.start();
				/*try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				game.jouer();
			}
		};
	}	
	 
	public void jouer(){
		game = new Jeu(player.getLevel(),player);
		proc.run();
		
	}
	
	
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		requestFocus();
		g.drawImage(img, 0, 0, null);
		switch(player.getGameOver()){
		case 0 :
			for (int i=0;i<200;i++){
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
		JLabel label = new JLabel("YOU WON !");
		label.setFont(new Font("Serif",Font.PLAIN,72));
		add(label,BorderLayout.CENTER);
		game.player.nextLevel();
		jouer();
	}
	
	public void gameOver(){
		game.stop();
		/*afficher un écran perdant*/
		JLabel label = new JLabel("GAME OVER");
		label.setFont(new Font("Serif",Font.PLAIN,72));
		add(label,BorderLayout.CENTER);
		/* afficher le score et demander le nom*/
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		requestFocus();
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
