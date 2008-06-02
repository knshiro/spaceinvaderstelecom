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

	public Menu() {
		super();
		initializeMenu();
	}

	private void initializeMenu() {
		JMenu game = new JMenu("Game");
		JMenuItem game_newgame = new JMenuItem("New Game");
		JMenuItem game_pause = new JMenuItem("Pause");
		JMenuItem game_resume = new JMenuItem("Resume");
		JMenuItem game_quit = new JMenuItem("Quit");
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
		JMenuItem tools_commandlist = new JMenuItem("Command List");
		JMenuItem tools_options = new JMenuItem("Options");
		tools.add(tools_commandlist);
		tools.add(tools_options);
		add(tools);
		JMenu help = new JMenu("Help");
		JMenuItem help_credits = new JMenuItem("Credits");
		help.add(help_credits);
		add(help);
		
	}
}
