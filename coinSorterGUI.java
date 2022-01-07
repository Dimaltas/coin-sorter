import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class coinSorterGUI extends Frame implements WindowListener,ActionListener {

	private String currency = "British Pounds (BPS)";
	private int minCoinIn = 0;
	private int maxCoinIn = 10000;
	private int totalCoins, twoPounds, onePound, fiftyP, twentyP, tenP;
	Button b1, b2, b3, b4 ,b5 ,b6;
		
	int userInput;
	public coinSorterGUI(String title) {
			
		super(title);	        												//The title of the main window. The name is called in the testCoinSorterGUI
	    setLayout(new FlowLayout());											//Lines 25 to 38, create the window and new buttons with colors.		
	    addWindowListener(this);
	    b1 = new Button("1 - Coin calculator");									//Gives a name for the 1st button
	    b1.setBackground(Color.yellow);											//sets the color of the 1st button
	    b2 = new Button("2 - Multiple coin calculator");						
	    b2.setBackground(Color.green);											//Similarly for b2,b3,b4,b5 and b6
	    b3 = new Button("3 - Print coin list");
	    b3.setBackground(Color.cyan);
	    b4 = new Button("4 - Set Details");
	    b4.setBackground(Color.magenta);
	    b5 = new Button("5 - Display program configurations");
	    b5.setBackground(Color.gray);
	    b6 = new Button("6 - Quit the program");
	    b6.setBackground(Color.red);
	    
        add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);    				//adds the new buttons.
	    
	    b1.addActionListener(new ActionListener()								//This is the 1st option of the main menu (coin calculator).
	    {																		// The method to calculate the total coins the user will get, works similarly as in the CoinSorter Class.
	      public void actionPerformed(ActionEvent e)
	      {
	        String totValue; 			
	        totValue = JOptionPane.showInputDialog(null,"\nPlease select between "+minCoinIn+" and "+maxCoinIn+"\nSelect amount you want to exchange in penies: ");
	        int totValueInt = Integer.parseInt(totValue);						//JOptionPane.showInputDiaolg command, creates a new window with the title and instructions inside the (), and waits for user input.
	        
	        if (totValueInt > minCoinIn && totValueInt <= maxCoinIn)
			{		
	        twoPounds = totValueInt/200;
	        totValueInt = totValueInt % 200;	
	        			
	        onePound = totValueInt/100;
	        totValueInt = totValueInt % 100;	

	        fiftyP = totValueInt/50;
	        totValueInt = totValueInt % 50;	

	        twentyP = totValueInt/20;
	        totValueInt = totValueInt % 20;
	        				
	        tenP = totValueInt/10;
	        totValueInt = totValueInt % 10;
	        totalCoins = twoPounds + onePound + fiftyP + twentyP + tenP;
	        																	//Shows the amount the user selected, the total coins that they will get and the amount of each coin
	        JOptionPane.showMessageDialog(null,"You have selected: "+totValue+"\n\nYou will take: "+"\n" + twoPounds+": 200p\n"+onePound+": 100p\n"+fiftyP+" :50p\n"
	        +twentyP+" :20p\n"+tenP+" :10p\n\nRemainder is: "+totValueInt+"p\n\nThe total coins that you will get are: "+totalCoins+" coins +"+totValueInt+"p");		        			
	        
	        totalCoins = 0;    
			}
	        else																//Creates a new window to indicate to the user that they selected a number outside of the range the machine can give.
	        	JOptionPane.showMessageDialog(null,"Invalid Input. Please select between "+minCoinIn+" and "+maxCoinIn); 	
	        }}
	        );
	    
	        b2.addActionListener(new ActionListener()							//2nd option of the main menu (Multiple coin calculator).
	    	{																	//Not working.
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			final JPanel panel = new JPanel();
	    			JOptionPane.showInputDialog("Please insert multiple transactions");
	    			JOptionPane.showMessageDialog(panel, "Under construction", "Warning",
	    			        JOptionPane.WARNING_MESSAGE);
	    		}}
	    	);
	        
	        b3.addActionListener(new ActionListener()							//3rd option of the main menu (Print coin list).
	    	{
	    		public void actionPerformed(ActionEvent e)						//creates a new window, prints the coin list and gives it a title. showMessageDialog was selected because 
	    		{																//it is unnecessary for the user to type something.
	    			JFrame coinList = new JFrame();
	    			JOptionPane.showMessageDialog(coinList, "\nThe machine gives the following coins\n\n£2 = 200p\n£1 = 100p\n0.5p = 50p"
	    																+ "\n0.2p = 20p\n0.1p = 10p\n","Coin List", JOptionPane.INFORMATION_MESSAGE);
	    		}}
	    	);
	              
	        b4.addActionListener(new ActionListener()							//4th option of the main menu (Set details).
	    	{																	
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			b1 = new Button("1 - Set currency");						//Lines 101 to 111 create a new window (sub-menu) with three new options. 
	    			b2 = new Button("2 - Set minimum coin input value");		//A panel is created and is given a size in order to have a color in the background.
	    			b3 = new Button("3 - Set maximum coin input value");
	    																		
	    			JFrame f= new JFrame("Set Details");
	    			JPanel panel=new JPanel(); 
	    			f.add(panel);
	    			f.setSize(300,300);
	    	        panel.add(b1); panel.add(b2); panel.add(b3);	
	    	        panel.setBackground(Color.gray);
	    			f.setVisible(true);
	    			
	    			b1.addActionListener(new ActionListener()					//1st option of the sub-menu.				
	    	    	{
	    	    		public void actionPerformed(ActionEvent e)				//creates an input dialog window for the user to change the currency accepted from the coin sorter.
	    	    		{  	    			
	    	    			currency = JOptionPane.showInputDialog("Please select the currency that you want to exchange");  	    			
	    	    			JOptionPane.showMessageDialog(null ,"The currecy selected is: " +currency);		//Shows the new currency that the user selected.
	    	    		}}
	    	    	);
	    			b2.addActionListener(new ActionListener()					//2nd option of the sub-menu					
	    	    	{
	    	    		public void actionPerformed(ActionEvent e)				//Works similarly as above.
	    	    		{
	    	    			String minCoin;
	    	    			minCoin = JOptionPane.showInputDialog(null, "Please select the minimum coin input value.");
	    	    			minCoinIn = Integer.parseInt(minCoin);
	    	    			JOptionPane.showMessageDialog(null, "The min coin that you can put is: " +minCoinIn);
	    	    		}}
	    	    	);
	    			b3.addActionListener(new ActionListener()					//3rd option of the sub-menu
	    	    	{
	    	    		public void actionPerformed(ActionEvent e)				//Works similarly as before
	    	    		{
	    	    			String maxCoin;
	    	    			maxCoin = JOptionPane.showInputDialog("Please select the maximum coin input value.");
	    	    			maxCoinIn = Integer.parseInt(maxCoin);
	    	    			JOptionPane.showMessageDialog(null, "The max coins that you can put is: "+ maxCoinIn);
	    	    		}}
	    	    	);
	    		}}
	    	);

	        b5.addActionListener(new ActionListener()							//5th option of the main menu Display program configurations.
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			JFrame progConfigs = new JFrame();							//Shows the currency, the maximum value and the minimum value accepted from the machine in a new window.
	    			JOptionPane.showMessageDialog(progConfigs, "The Currency accepted is: " +currency+ "\nThe minimum value accepted is: "+minCoinIn+ "\nThe maximum value accepted is: "+maxCoinIn, "Display program configurations",JOptionPane.INFORMATION_MESSAGE);
	    		}}																//If the user changed these values from option 4 of the main menu, the new values will be shown here.
	    	);
	        b6.addActionListener(new ActionListener()							//6th option (Quit)
	    	{
	    		public void actionPerformed(ActionEvent e)						//Asks the user if they want to quit in a newly created window. Options Yes,No and Cancel are available.
	    		{																//If the user selects No or Cancel the program will not terminate. If they select Yes it will terminate and close the window.
	    			int exit = JOptionPane.showConfirmDialog(null,"Are you sure you want to Quit?", "Quit?", JOptionPane.YES_NO_OPTION);

	    			if (exit == JOptionPane.YES_OPTION)
	    			{
	    			    System.exit(0);
	    			}
	    			else {
	    			}
	    		}}
	    	);   
	}

	public void windowClosing(WindowEvent e) {									//Commands for the window to be open, close
	        dispose();
	        System.exit(0);
	}
	public void windowOpened(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void actionPerformed(ActionEvent e) {}								//Command to activate the buttons (options).
}    	 	