import java.util.*;
import java.awt.*;

public class Escadrille extends Chose{

	/** classe Escadrille: hérite de chose. gère un tableau 5*11 d'Invaders pour les faire bouger et tirer
	 * @author: Charlix
	 * @version:1.1
	 * @package:default_package
	 * penser à rajouter de quoi perdre quand l'escadrille arrive en bas*/
	private Invaders[][] matrice; /*tableau des invaders*/
	private int[] colonnespleines;/*colonnespleines(i) vaut le nombre d'invaders dans la colonne*/
	private int[] lignespleines;
	int sens;
	int acceleration;
	int pas, xmax,xinf,espace,nbColonnes,bas;
	private int vie;
	private int largeur;
	private int hauteur;
	private int id;
	int game_over;
	private int larginv, hautinv;
	private double diff=0.1;




	/*constructeur.Prend en paramètres pareil que Chose+le sens, l'acceleration lors de la descente,le pas de descente*/
	public Escadrille(Joueur Player, ArrayPerso univers, Point coord, Point vitesse, int vie, int largeur, int hauteur, int id, int sens, int acceleration, int pas, int hautinv, int larginv, int espace)
	{
		super(Player, univers, coord, vitesse, vie, largeur, hauteur, id);
		int i,j;
		Point place;
		//System.out.println("vitesse state 1= "+ vitesse.getX());
		/*la vie devra valoir 55 au départ*/

		matrice=new Invaders[5][11];/*mettre à jour selon  le constructeur des invaders*/
		colonnespleines=new int[11];
		lignespleines=new int[5];
		for (i=0;i<11;i++)
		{
			colonnespleines[i]=5;
		}
		for (i=0;i<5;i++)
		{
			lignespleines[i]=11;
		}
		for (i=1;i<4;i++)
		{
			for(j=0;j<11;j++)
			{
				Point plac = new Point(coord.getX()+j*(espace+larginv),coord.getY()+i*(espace+hautinv));
				//place.setPoint(coord.getX()+j*(espace+larginv),coord.getY()+i*(espace+hautinv));
				matrice[i][j]= new Invaders(Player, univers, plac, vitesse, 1, larginv, hautinv, 15, i, j, i);/*new Invaders(Player, univers, place, vitesse, 1,21, 16, 15, i, j, i);*//*voir selon le constructeur de Invaders*/
			}
		}

		for(j=0;j<11;j++)
		{
			Point plac = new Point(coord.getX()+j*(espace+larginv),coord.getY()+0*(espace+hautinv));
			//place.setPoint(coord.getX()+j*(espace+larginv),coord.getY()+0*(espace+hautinv));
			Invaders in=new Invaders(Player, univers, plac, vitesse, 1, larginv, hautinv, 15, 1, j, 0);
			matrice[0][j]=in;
		}

		for(j=0;j<11;j++)
		{
			Point plac = new Point(coord.getX()+j*(espace+larginv),coord.getY()+4*(espace+hautinv));
			//place.setPoint(coord.getX()+j*(espace+larginv),coord.getY()+0*(espace+hautinv));
			Invaders in=new Invaders(Player, univers, plac, vitesse, 1, larginv, hautinv, 15, 2, j, 4);
			matrice[4][j]=in;
		}
		//System.out.println("vitesse state 3= "+ matrice[4][4].vitesse.getX());
		//System.out.println("x invader 4x4 state 1 ="+matrice[4][4].coord.getX());
		//System.out.println("x invader 4x4 state 1 ="+matrice[2][10].coord.getX());
		//System.out.println("x invader 4x4 state 1 ="+matrice[3][7].coord.getX());

		this.sens=sens;
		this.acceleration=acceleration;
		this.pas=pas;
		this.nbColonnes=11;
		this.xinf=0;
		this.xmax=800-larginv;
		this.bas=600;
	}

	/*pour récupérer la matrice
	 * param:rien
	 * renvoi:matrice
	 */

	public Invaders[][] getMatrice ()
	{
		return matrice;
	}

	int getgame_over()
	{
		return game_over;
	}

	/*modifier la matrice
	 * param:ligne et colonne de ce que l'on veut modifier, invader à mettre
	 * renvoi:rien
	 */
	public void setMatrice (int i,int j, Invaders vaisseau)
	{
		matrice[i][j]=vaisseau;
	}

	/*modifier une case de colonnespleines
	 * param: n° de la colonne, un 0 ou un 1
	 * renvoi: rien
	 */
	public void setColonnesPleines (int j, int nb)
	{
		colonnespleines[j]=nb;
	}

	/*recuperer le tableau colonnespleines
	 * param: ren
	 * renvoi: colonnespleines
	 */
	public int[] getColonnesPleines ()
	{
		return colonnespleines;
	}

	/*pareil pour les lignes*/      
	public void setLignesPleines (int i, int bool)
	{
		lignespleines[i]=bool;
	}

	public int[] getLignesPleines ()
	{
		return lignespleines;
	}
	
	public double getDiff ()
	{
		return this.diff;
	}
	
	public void setDiff (double aug)
	{
		this.diff=aug;
	}

	public void tableauxAJour (int i, int j)
	{
		setLignesPleines(i,(getLignesPleines()[i])-1);
		setColonnesPleines(j,(getColonnesPleines()[j])-1);
		System.out.println("colonnes pleines "+j+" "+getColonnesPleines()[j]);
		if (getColonnesPleines()[j]==0)
			nbColonnes--;

	}
	/*checker si l'escadrille arrive au bord de la surface de jeu
	 * param: xmax et xinf
	 * renvoi:booleen
	 */

	 public void dessin (Graphics g)
	 {
		 int i,j;
		 for (i=0;i<5;i++)
		 {
			 for(j=0;j<11;j++)
			 {if (matrice[i][j]!=null)
				 matrice[i][j].dessin(g);
			 }
		 }
	 }

	 boolean controlebord (int xmax, int xinf)
	 {
		 int j;
		 int i=0;
		 if (sens==1)
		 {
			 j=10;
			 while ((colonnespleines[j]==0)&&(j>0))/*récupération de la dernière colonne*/
			 {
				 j--;
			 }
			 while ((matrice[i][j]==null)&&(i<5))
			 {
				 i++;
			 }
			 return(matrice[i][j].coord.getX()>xmax); 
		 }
		 else
		 {
			 j=0;
			 while ((colonnespleines[j]==0)&&(j<11))/*récupération de la dernière colonne*/
			 {
				 j++;
			 }
			 while ((matrice[i][j]==null)&&(i<5))
			 {
				 i++;
			 }
			 return(matrice[i][j].coord.getX()<xinf);
		 }

	 }

	 public boolean controlebas (int bas)
	 {
		 int i=4;
		 int j=0;
		 while ((i>=0)&&(lignespleines[i]==0))
			 i--;
		 while ((matrice[i][j]==null)&&(j<11))
			 j++;
		 return(matrice[i][j].coord.getY()>bas);
	 }

	 public void tir ()
	 {
		 double i;
		 int j,k,l;
		 k=0;
		 l=0;
		 i=Math.random();
		 i=i*nbColonnes;
		 j = (int)i;
		 //j=Math.round(Math.round(i));
		 while (k<j)
		 {
			 if (getColonnesPleines()[k]>=0)
			 {
				 k++;
				 l++;
			 }
			 else
				 l++;
		 }
		 
		 k=0;
		 j=0;
		 for(j=0;j<5;j++)
		 {
			 if (matrice[k][l]!=null)
				 k=j;
		 }
		 if ((matrice[k][l]!=null)&&(k<5)&&(k>=0))
			 matrice[k][l].tir();
				 
		 
		 
	 
	 }

	 public void prochainTour () /*rajouter une fonction qui teste le timer pour pouvoir tirer*/
	 {
		 
		 int i,j;
		 double t;
		 //System.out.println("nbColonnes"+this.nbColonnes);
		 if (getVie()<=0){
			 //System.out.println("gagne");
			 game_over=-1;
		 }
		 else
		 {
			 if (controlebas(bas)){
				 //System.out.println("perdu");
				 game_over=1;
			 }
			 else
			 {
				 t=Math.random();
				 if (t<diff){
					 tir();  
					 //System.out.println("tir ok");
				 }


				 if (this.controlebord(xmax, xinf)) 
				 {
					 //System.out.println("on est au bord");
					 sens=-sens;
					 this.vitesse.setPoint(sens*(Math.abs((this.vitesse.getX())+acceleration)),this.vitesse.getY());
					 this.diff+=0.1;
					 for (i=0;i<5;i++)
					 {
						 for (j=0;j<11;j++)
						 {
							 if (matrice[i][j]!=null)
							 {
								 matrice[i][j].vitesse.setPoint(sens*(Math.abs(matrice[i][j].vitesse.getX())+acceleration),matrice[i][j].vitesse.getY());
								 matrice[i][j].coord.setPoint(matrice[i][j].coord.getX(),matrice[i][j].coord.getY()+pas);
							 }
						 }
					 }
				 }
				 else            

				 {
					 for (i=0;i<5;i++)
					 {
						 for (j=0;j<11;j++)
						 {
							 if (matrice[i][j]!=null)
							 {
								 //System.out.println("deplacement de "+ vitesse.getX()+ " " + vitesse.getY());
								 matrice[i][j].prochainTour();
							 }
						 }
					 }
					 deplacement();
				 }

			 }
		 }       
	 }

}
