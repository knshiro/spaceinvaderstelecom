import javax.swing.JPanel;
import java.awt.*;

public class BriquePanel extends JPanel 
{
	BriquePanel()
	{
	
	setPreferredSize(new java.awt.Dimension(300, 300));
	setBackground(Color.WHITE);
	
	}
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		mysteryship.dessin(g);
	}
	
	private MysteryShip mysteryship=new MysteryShip(40,40,70,80);
}
