
public class Escadrille extends Chose{
	Invaders[][] matrice; /*tableau des invaders*/
	int[] colonnespleines;/*colonnespleines(i) vaut 0 si la colonne est vide,1 si elle est pleine*/
	int[] lignespleines;
	int sens;
	int acceleration;
	int pas;
	
	Escadrille(ArrayList univers, Point coord, int vie, int largeur, int hauteur, int id, int sens, int acceleration, int pas)
	{
		super(univers, coord, vie, largeur, hauteur, id);
		int i,j;
		/*la vie devra valoir 55 au départ*/
		
		matrice=new Invaders[5][11];
		colonnespleines=new int[11];
		lignespleines=new int[5];
		for (i=0;i<11;i++)
		{
			colonnespleines[i]=1;
		}
		for (i=0;i<5;i++)
		{
			lignespleines[i]=1;
		}
		for (i=0;i<5;i++)
		{
			for(j=0;j<11;j++)
			{
				matrice[i][j]=new Invaders();/*voir selon le constructeur de Invaders*/
			}
		}
		this.sens=sens;
		this.acceleration=acceleration;
		this.pas=pas;
	}
	
	public Invader[][] getMatrice ()
	{
		return matrice;
	}
	
	public void setMatrice (int i,int j, Invader vaisseau)
	{
		matrice[i][j]=vaisseau;
	}
	
	public void setColonnesPleines (int j, int bool)
	{
		colonnespleines[j]=bool;
	}
	
	public int[] getColonnesPleines ()
	{
		return colonnespleines;
	}
	
	public void setLignesPleines (int i, int bool)
	{
		lignespleines[i]=bool;
	}
	
	public int[] getLignesPleines ()
	{
		return lignespleines;
	}
	
	boolean controlebord (int xmax, int xinf)
	{
		int j;
		int i=0;
		if (sens==1)
		{
			j=10;
		while ((colonnespleines[j]=0)&&(j>=0))/*récupération de la dernière colonne*/
		{
			j--;
		}
		while ((matrice[i][j]==null)&&(i<5))
		{
			i++;
		}
		return(matrice[i][j].coord.getx()>xmax); 
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
			return(matrice[i][j].coord.getx()<xinf);
		}
		
	}
	
	void prochaintour ()
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
