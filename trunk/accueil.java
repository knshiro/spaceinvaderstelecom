//  Created by Matthieu Gédon-Monaco on 01/06/08.
//  Copyright 2008 Bébénuts. All rights reserved.
//
// Fonctionne en autonome, pour l'intégration, penser
// à enlever le main. Pour l'instant c'est un menu qui
// pourra être intégré à la fenêtre de jeu.

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
		JMenu jeu = new JMenu("Space Invaders");
		JMenuItem newgame = new JMenuItem("New Game");
		JMenuItem highscores = new JMenuItem("High Scores");
		JMenuItem credits = new JMenuItem("Credits");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		jeu.add(newgame);
		jeu.add(highscores);
		jeu.add(credits);
		jeu.add(exit);
		add(jeu);
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setJMenuBar(new Menu());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
