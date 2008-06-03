//  Created by Matthieu Gdon-Monaco on 01/06/08.
//  Copyright 2008 Bbnuts. All rights reserved.
//
// Fonctionne en autonome, pour l'intgration, penser
//  enlever le main. Pour l'instant c'est un menu qui
// pourra tre intgr  la fentre de jeu.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Menu extends JMenuBar {

	Accueil fenetre;
	JMenuItem game_newgame;
	JMenuItem game_pause;
	JMenuItem game_resume;
	JMenuItem game_quit;
	JMenuItem tools_options;
	JMenuItem tools_commandlist;
	JMenuItem help_credits;
	
	
	public Menu(Accueil fenetre) {
		super();
		this.fenetre=fenetre;
		initializeMenu();
	}

	private void initializeMenu() {
		JMenu game = new JMenu("Game");
		game_newgame = new JMenuItem("New Game");
		game_pause = new JMenuItem("Pause");
		game_resume = new JMenuItem("Resume");
		game_quit = new JMenuItem("Quit");
		
		game_newgame.addActionListener(fenetre);
		game_pause.addActionListener(fenetre);
		game_resume.addActionListener(fenetre);
		
		game_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		
		
		game.add(game_newgame);
		game.add(game_pause);
		game.add(game_resume);
		game.add(game_quit);
		
		add(game);
		
		
		
		JMenu tools = new JMenu("Tools");
		tools_commandlist = new JMenuItem("Command List");
		tools_options = new JMenuItem("Options");
		tools.add(tools_commandlist);
		tools.add(tools_options);
		add(tools);
		JMenu help = new JMenu("Help");
		help_credits = new JMenuItem("Credits");
		help.add(help_credits);
		add(help);
		
	}
}
