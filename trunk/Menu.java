//  Created by Matthieu Gdon-Monaco on 01/06/08.
//  Copyright 2008 Bbnuts. All rights reserved.
//
// Fonctionne en autonome, pour l'intgration, penser
//  enlever le main. Pour l'instant c'est un menu qui
// pourra tre intgr  la fentre de jeu.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

class Menu extends JMenuBar {

	Accueil fenetre;
	JMenuItem game_newgame;
	JMenuItem game_pause;
	JMenuItem game_resume;
	JMenuItem game_quit;
	JMenuItem tools_options;
	JMenuItem tools_commandlist;
	JMenuItem help_credits;
	JMenuItem music_musicon;
	JMenuItem music_musicoff;
	
	
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
		game_newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		game_pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		game_resume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		game_quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));	
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
		
		
		JMenu music = new JMenu("Music");
		music_musicon = new JMenuItem("Music On");
		music_musicoff = new JMenuItem("Music Off");
		music_musicon.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		music_musicoff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		music_musicon.addActionListener(fenetre);
		music_musicoff.addActionListener(fenetre);
		music.add(music_musicon);
		music.add(music_musicoff);
		add(music);
		JMenu tools = new JMenu("Tools");
		tools_commandlist = new JMenuItem("Command List");
		tools_options = new JMenuItem("Options");
		tools_commandlist.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		tools_options.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		tools_commandlist.addActionListener(fenetre);
		tools_options.addActionListener(fenetre);
		tools.add(tools_commandlist);
		tools.add(tools_options);
		add(tools);
		JMenu help = new JMenu("Help");
		help_credits = new JMenuItem("Credits");
		help_credits.addActionListener(fenetre);
		help.add(help_credits);
		add(help);
		
	}
}
