import java.awt.*;
import javax.swing.*;

class BriqueFrame extends JFrame 
{
	
	BriquePanel panel;
	
	
	public BriqueFrame()
	{
		
		setTitle("Test de Brique");
		setSize(400,400);
		
		panel=new BriquePanel();
		panel.setBackground(Color.black);
		add(panel);
		
	}
	
	public void ProchainTour(){
		panel.ProchainTour();
	}

}
