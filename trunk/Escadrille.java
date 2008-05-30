
public class Escadrille extends Chose{
	
	/* classe Escadrille: hérite de chose. gère un tableau 5*11 d'Invaders pour les faire bouger et tirer
	 * author: Charlix
	 * version:1.1
	 * package:default_package
	 * penser à rajouter de quoi perdre quand l'escadrille arrive en bas*/
	Invaders[][] matrice; /*tableau des invaders*/
	int[] colonnespleines;/*colonnespleines(i) vaut 0 si la colonne est vide,1 si elle est pleine*/
	int[] lignespleines;
	int sens;
	int acceleration;
	int pas, xmax,xinf;
	
	/*constructeur.Prend en paramètres pareil que Chose+le sens, l'acceleration lors de la descente,le pas de descente*/
	Escadrille(ArrayList univers, Point coord, int vie, int largeur, int hauteur, int id, int sens, int acceleration, int pas, int hautinv, int larginv)
	{
		super(univers, coord, vie, largeur, hauteur, id);
		int i,j;
		Point place;
		place=new Point(0,0);
		/*la vie devra valoir 55 au départ*/
		
		matrice=new Invaders[5][11]; /*mettre à jour selon  le constructeur des invaders*/
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
		for (i=0;i<5;i++)
		{
			for(j=0;j<11;j++)
			{
				place.setPoint(coord.getX()+j*larginv,coord.getY()+i*hautinv);
				matrice[i][j]=new Invaders(univers, place, 1, larginv, hautinv, 15, i, j, i);/*voir selon le constructeur de Invaders*/
			}
		}
		this.sens=sens;
		this.acceleration=acceleration;
		this.pas=pas;
	}
	
	/*pour récupérer la matrice
	 * param:rien
	 * renvoi:matrice
	 */
	public Invaders[][] getMatrice ()
	{
		return matrice;
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
	
	public void tableauxAJour (int i, int j)
	{
		lignespleines[i]=lignespleines[i]-1;
		colonnespleines[j]=colonnespleines[j]-1;
	}
	/*checker si l'escadrille arrive au bord de la surface de jeu
	 * param: xmax et xinf
	 * renvoi:booleen
	 */
	boolean controlebord (int xmax, int xinf)
	{
		int j;
		int i=0;
		if (sens==1)
		{
			j=10;
		while ((colonnespleines[j]==0)&&(j>=0))/*récupération de la dernière colonne*/
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
		return(matrice[i][j].coord.getY()<bas);
	}
	
	public void prochainTour ()
	{
		int i,j;
		if (this.controlebord(xmax, xinf)) /*voir comment récupérer ces parametres*/
		{
			sens=-sens;
			this.vitesse.setPoint(this.vitesse.getX()+sens*acceleration,this.vitesse.getY());
			for (i=0;i<5;i++)
			{
				for (j=0;j<11;j++)
				{
					if (matrice[i][j]!=null)
					{
						matrice[i][j].vitesse.setPoint(matrice[i][j].vitesse.getX()+sens*acceleration,matrice[i][j].vitesse.getY());
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
						matrice[i][j].deplacement();
					}
				}
			}
			deplacement();
		}
		
	}
	
}
