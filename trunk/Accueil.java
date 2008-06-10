//  Created by Matthieu Gedon-Monaco on 01/06/08.
//  Copyright 2008 Bbnuts. All rights reserved.
//
//
// Fonctionne en autonome, pour l'intgration, penser
//  enlever le main. Pour l'instant c'est un menu qui
// pourra tre intgr  la fentre de jeu.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

class Accueil extends JFrame implements ActionListener{

	Session partie;
	Menu myMenu;
	AudioPlayer audioPlayer;
	Joueur player;
	Timer tRefresh;
	Thread win;
	
	ActionListener aRefresh = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	switch(partie.player.getGameOver()){
        	case 0:
        	partie.repaint();
        	player.repaint();
        	break;
        	
        	case 1:
        		tRefresh.stop();
        		gameOver();
        		break;
        		
        	case -1:
        		tRefresh.stop();
        		win.run();
        		break;
        	}
        	
        }
	};

/*	public void win(){
		partie.game.stop();
		JLabel label = new JLabel("YOU WON !");
		label.setFont(new Font("Serif",Font.PLAIN,72));
		label.setForeground(Color.RED);
		partie.add(label,BorderLayout.SOUTH);
		pack();
		//partie.game.player.nextLevel();
		//partie.jouer();
	}
*/	
	public void gameOver(){
		partie.game.stop();
		/*afficher un écran perdant*/
		JLabel label = new JLabel("GAME OVER");
		label.setFont(new Font("Serif",Font.PLAIN,72));
		label.setForeground(Color.RED);
		partie.add(label,BorderLayout.SOUTH);
		pack();
		HighScores end = new HighScores(player.getScore());
		/* afficher le score et demander le nom*/
	}
	
	Accueil(){
		myMenu = new Menu(this);
		add(myMenu,BorderLayout.NORTH);
		System.out.println("Menu ok");
		System.out.println("Listener ok");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		tRefresh = new Timer(15,aRefresh);
		System.out.println("Accueil ok"); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myMenu.game_newgame){
			if(partie != null){
				remove(partie);
				remove(player);
				partie=null;
			}
			player = new Joueur(1,0);
			partie = new Session(player);
			player.partie=partie;
			win = new Thread(){
				public void run(){
					partie.game.stop();
					/*JLabel label = new JLabel("YOU WON !");
					label.setFont(new Font("Serif",Font.PLAIN,72));
					label.setForeground(Color.RED);
					partie.add(label,BorderLayout.SOUTH);
					pack();
					partie.repaint();
					*/
					try {
						sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//partie.remove(label);
					player.setGameOver(0);
					partie.jouer();
					tRefresh.start();
					
				}
			};
			System.out.println("Nouvelle session ok");
			add(partie, BorderLayout.CENTER);
			add(player, BorderLayout.SOUTH);
			pack();
			System.out.println("Disposition des panels ok");
			partie.jouer();
			tRefresh.start();
			audioPlayer = new AudioPlayer("file:spaceinvaders.wav");
			try {
				audioPlayer.start();
			} catch (Exception f) {
				System.out.println("Impossible de lire (cause : " + f + ")");
			}	

		}
		else if (e.getSource()==myMenu.game_pause){
			if (partie != null)
				partie.game.stop();
		}
		else if (e.getSource()==myMenu.game_resume){
			if (partie != null)
				partie.game.jouer();
		}
		else if (e.getSource()==myMenu.music_musicoff){
			audioPlayer.stop();
		}
		else if (e.getSource()==myMenu.music_musicon){
			try{
				audioPlayer.start();}
			catch (Exception f) {
				System.out.println("Impossible de lire (cause : " + f + ")");
			}	
		}
	}
	
	public static void main(String [] argv){
		Accueil fenetre = new Accueil();

	}

	

}