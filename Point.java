/** La classe point dfinit un Point de coordonnes x et y. Le constructeur est du type Point(int x, int y). On accde  ses attributs au moyen des mthodes getX, getY et setPoint*/


class Point 
{
	
	Point (int abscisse, int ordonnee)
	{
		x=abscisse;
		y=ordonnee;
	}
	
	/** Récupère l'abscisse du point.
	 * @param aucun
	 * @return x, l'abscisse du point.*/
	public int getX()
	{
		return x;
	}
	
	/** Récupère l'ordonne du point.
	 * @param aucun
	 * @return y, l'ordonne du point.*/
	public int getY()
	{
		return y;
	}
	/** Change les coordonnes du point.
	 * @param abcisse et ordonne, des int.
	 * @return rien.*/
	public void setPoint(int abscisse, int ordonnee)
	{
		x=abscisse;
		y=ordonnee;
	}
	/** Effectue la translation d'un point par un vecteur.
	 * @param abcisse et ordonne, des int.
	 * @return rien.*/
	public void translate(int abscisse, int ordonnee)
	{
		x+=abscisse;
		y+=ordonnee;
	}
	
	private int x;
	private int y;

}
