import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Graphic window
 * @author Clemens Heffner
 * @version 1.0
 *
 */
public class GUI {

	private JFrame mainFrame;
	
	private JButton ok, reset, chooseFile;
	
	private JFileChooser choose; 
	
	private JLabel header,desc;
	
	private JPanel panelNorth,panelSouth,panelWest, panelCenter, panelEast;
	/**
	 * Contains the window
	 */
	void initGUI(){
		
		mainFrame = new JFrame("Eventkalender V.1");
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(500, 500);
	
		
		north();
		south();
		center();
		west();
		east();
		
		
	
	
	
	
	
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	/**
	 * contains content
	 */
	private void north(){
	panelNorth = new JPanel();
	panelNorth.setBorder(BorderFactory.createEtchedBorder());
	mainFrame.add(panelNorth,BorderLayout.NORTH);
	header = new JLabel("Eventkalender");	
	header.setVisible(true);
	panelNorth.add(header);
		
	}
	
	private void CombinedLayoutManager(){
		
		Container pane = getContentPane();
		
	}
	
	/**
	 * content in the center area
	 */
	
	private void center(){
		panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createEtchedBorder());
		
		
		GridLayout grid = new GridLayout(0,2);
		mainFrame.add(new JLabel("StartDatum"));
		mainFrame.add(new JTextField(""));
		
		
		
	
		mainFrame.add(panelCenter,BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
	}
	/**
	 * content in the West area
	 */
	
	private void west(){
		panelWest = new JPanel();
		panelWest.setBorder(BorderFactory.createEtchedBorder());
		mainFrame.add(panelWest,BorderLayout.WEST);
		
	}
	
	/**
	 * Content in the south area 
	 */
	private void south(){
		panelSouth = new JPanel();
		panelSouth.setBorder(BorderFactory.createEtchedBorder());
		mainFrame.add(panelSouth,BorderLayout.SOUTH);
	}
	
	/**
	 * content in the east area
	 */
	private void east(){
		panelEast = new JPanel();
		panelEast.setBorder(BorderFactory.createEtchedBorder());
		mainFrame.add(panelEast,BorderLayout.EAST);
		
	}
	
	
}
