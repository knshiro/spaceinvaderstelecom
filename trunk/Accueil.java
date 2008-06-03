//  Created by Matthieu Gdon-Monaco on 01/06/08.
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
	JMenuItem game_newgame = new JMenuItem("New Game");
	JMenuItem game_pause = new JMenuItem("Pause");
	JMenuItem game_resume = new JMenuItem("Resume");
	
	Accueil(){
		myMenu = new Menu(this);
		add(myMenu);
		game_newgame.addActionListener(this);
		game_pause.addActionListener(this);
		game_resume.addActionListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==game_newgame){
			partie = new Session();
			add(partie.player, BorderLayout.NORTH);
			add(partie, BorderLayout.CENTER);
			pack();
			partie.jouer();
		}
		else if (e.getSource()==game_pause){
			if (partie != null)
				partie.game.stop();
		}
		else if (e.getSource()==game_resume){
			if (partie != null)
				partie.game.jouer();
		}
		
	}
	
	public static void main(String [] argv){
		Accueil fenetre = new Accueil();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
		fenetre.setVisible(true);
	}
	

}