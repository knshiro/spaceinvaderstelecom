import java.awt.*;


 class Brique extends Chose
{
	
	 public Brique(int abscisse, int ordonnee)
	{
		 
		 this.abscisse=abscisse;
		 this.ordonnee=ordonnee;
		
	}
	 
	 
	 public void dessin(Graphics g)
	 {
		 switch(vie)
		 {
		 case 4:
		 		g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/10,hauteur/10);
		 			}
		 		}
		 break;
		 	
		 case 3:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/13,hauteur/13);
		 			}
		 		}
		 break;
		 	
		 case 2:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/17,hauteur/17);
		 			}
		 		}
		 break;
		 
		 case 1:
			 
			 g.setColor(col);
		 		for (j=0;j<=9;j++)
		 		{
		 			for (i=0;i<=9;i++)
		 			{
		 				g.fillRect(abscisse-largeur/2+i*largeur/10, ordonnee-hauteur/2+j*hauteur/10, largeur/20,hauteur/20);
		 			}
		 		}
		 break;
		 
		 }
		 
	 }
	 
	 
	 private static int largeur=30;
	 private static int hauteur=30;
	 private int vie=4;
	 private int abscisse, ordonnee, i,j;
	 private Color col=Color.green;

}
