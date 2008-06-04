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
	
	ActionListener aRefresh = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	repaint();
        }
	};
	
	 public void keyPressed(KeyEvent evt){
		 System.out.println("caca");
		 if (evt.getKeyCode() == KeyEvent.VK_LEFT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(-1);
			 System.out.println("gauche");
		 }
		 else if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
			 ((BaseLaser) game.univers.get(0)).setdeplacement(1);
			 System.out.println("droite");
		 }
	 }
	 public void keyReleased(KeyEvent evt){
	 }  
	 public void keyTyped(KeyEvent evt){
		 
	 }

	
	Session(){
		requestFocus();
		addMouseListener(this);
		addKeyListener (this);
		player = new Joueur(1,0,"bob");
		tRefresh = new Timer(80,aRefresh);
		setPreferredSize(new java.awt.Dimension(800, 600));
		setBackground(Color.BLACK);
		try {
		img = ImageIO.read(new File("FarAway.jpg"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}	
	
	public void jouer(){
		game = new Jeu(player.getLevel());
		tRefresh.start();/*
		try{
			wait(5000);
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}*/
		
		game.jouer();
		
	}
	
	
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		requestFocus();
		g.drawImage(img, 0, 0, null);
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
		JLabel label = new JLabel("YOU WON !");
		label.setFont(new Font("Serif",Font.PLAIN,72));
		add(label,BorderLayout.CENTER);
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
		System.out.println("salut");
		requestFocus();
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("yo");
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
