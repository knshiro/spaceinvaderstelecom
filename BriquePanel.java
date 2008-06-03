import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;



public class BriquePanel extends JPanel 
{

	
	private Point coord = new Point(50,50);
	private Point vitesse = new Point(300,0);
	private ArrayList<Chose> univers = new ArrayList<Chose>();
	
	
	
	BriquePanel()
	{
	setPreferredSize(new java.awt.Dimension(300, 300));
	setBackground(Color.BLACK);
	univers.add(0,mysteryship);
	int i;
	for(i=0;i<=30;i++)
		univers.add(null);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		mysteryship.dessin(g);
	}
	
	public void ProchainTour(){
		mysteryship.prochainTour();
	}
	
}
