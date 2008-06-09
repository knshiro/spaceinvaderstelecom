//  Created by Matthieu Gedon-Monaco on 01/06/08.
//  Copyright 2008 Bbnuts. All rights reserved.
//
//
// Fonctionne en autonome, pour l'intgration, penser
//  enlever le main. Pour l'instant c'est un menu qui
// pourra tre intgr  la fentre de jeu.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Accueil extends JFrame implements ActionListener{

	static Session partie;
	Menu myMenu;
	AudioPlayer audioPlayer;

	
	
	Accueil(){
		myMenu = new Menu(this);
		add(myMenu,BorderLayout.NORTH);
		System.out.println("Menu ok");
		System.out.println("Listener ok");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		System.out.println("test"); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myMenu.game_newgame){
			if(partie == null){
			partie = new Session();
			System.out.println("Nouvelle session ok");
			/*add(partie.player, BorderLayout.NORTH);*/
			add(partie, BorderLayout.CENTER);
			pack();
			System.out.println("Disposition des panels ok");
			partie.jouer();
			}
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