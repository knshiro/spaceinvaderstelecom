import javax.swing.*;

public class TestBrique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		BriqueFrame frame=new BriqueFrame();
		int i =0;
		while(i<=0) {
			frame.ProchainTour();
			i++;
		}
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}

}