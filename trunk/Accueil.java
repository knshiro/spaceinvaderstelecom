//  Created by Matthieu Gedon-Monaco on 01/06/08.
//  Copyright 2008 Bbnuts. All rights reserved.
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

	Session partie;
	Menu myMenu;
	
	
	Accueil(){
		myMenu = new Menu(this);
		add(myMenu,BorderLayout.NORTH);
		AudioPlayer audioPlayer = new AudioPlayer("file:/Users/St_Sauveur/Documents/Music.wav");
		System.out.println("Menu ok");
		System.out.println("Listener ok");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		System.out.println("test");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myMenu.game_newgame){
			partie = new Session();
			System.out.println("Nouvelle session ok");
			/*add(partie.player, BorderLayout.NORTH);*/
			add(partie, BorderLayout.CENTER);
			pack();
			System.out.println("Disposition des panels ok");
			partie.jouer();
		}
		else if (e.getSource()==myMenu.game_pause){
			if (partie != null)
				partie.game.stop();
		}
		else if (e.getSource()==myMenu.game_resume){
			if (partie != null)
				partie.game.jouer();
		}
		
	}
	
	public static void main(String [] argv){
		Accueil fenetre = new Accueil();

	}

	

}