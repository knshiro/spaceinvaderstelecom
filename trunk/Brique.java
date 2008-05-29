import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

 class Brique extends JPanel 
{
	
	 public Brique(int abscisse, int ordonnee)
	{
		 
		 vie=4;
		 largeur=30;
		 hauteur=30;
		 this.abscisse=abscisse;
		 this.ordonnee=ordonnee;
		
	}
	 
	 
	 public void paintComponent(Graphics g)
	 {

		 super.paintComponent(g);
		 Graphics2D g2=(Graphics2D) g;
		 Rectangle2D rect=new Rectangle2D.Double(abscisse-largeur/2,ordonnee-hauteur/2,largeur,hauteur);
		 g2.setPaint(Color.GREEN);
		 g2.fill(rect);
		  
	 }
	 
	 
	 private static int largeur,hauteur,abscisse, ordonnee;
	 private int vie;

}
