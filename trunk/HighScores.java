import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class HighScores extends JFrame implements ActionListener{

	JButton but;
	JTextField  tf;
	int score;
	
	HighScores(int score){
		super("High Scores"); 
		this.score=score;
		setSize(new Dimension(300,100));              
		
		JPanel pan=new JPanel();              
		BoxLayout    bl=new BoxLayout(pan,BoxLayout.Y_AXIS);
		pan.setLayout(bl);                               

		JLabel  lab=new JLabel("Entrez votre pseudo (3 lettres seulement)");
		pan.add(lab);

		tf=new JTextField("Bob"); //un champ texte!
		pan.add(tf);       

		but=new JButton("Enregistrer");
		pan.add(but);       

		setContentPane(pan);        //defini le panel de la JFrame
		setVisible(true);           //affiche la JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opération par défaut a la fermeture

		but.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==but){
			BufferedWriter sortie;
			try {
				sortie = new BufferedWriter(new FileWriter("scores.txt",true));
				sortie.write(tf.getText()+" : "+ score +"\n");
				sortie.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		}

	}
}
