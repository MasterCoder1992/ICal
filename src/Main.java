import javax.swing.SwingUtilities;

public class Main {

	
	
	public static void main(String[] args) {
	
		final GUI g1 = new GUI();
		
	
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				 
				g1.initGUI();
			
			}
			
		});

	}

}
