import java.awt.*;
import javax.swing.*;

class BriqueFrame extends JFrame 
{
	
	public BriqueFrame()
	{
		
		setTitle("Test de Brique");
		setSize(400,400);
		
		Brique panel=new Brique(20,20);
		add(panel);
		
	}

}
