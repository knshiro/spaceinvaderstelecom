import java.awt.*;
import javax.swing.*;

class BriqueFrame extends JFrame 
{
	
	public BriqueFrame()
	{
		
		setTitle("Test de Brique");
		setSize(400,400);
		
		BriquePanel panel=new BriquePanel();
		panel.setBackground(Color.black);
		add(panel);
		
	}

}
