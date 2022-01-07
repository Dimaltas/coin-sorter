import java.util.Scanner;

public class testCoinSorter {

	public static void main(String[] args)
	{

		CoinSorter cs = new CoinSorter();														//This command calls everything made in the CoinSorter class.
		Scanner sc=new Scanner (System.in);														//The scanner command lets the user to type something when the scanners name (sc here) is called.														
			
		System.out.println();
		System.out.println("***************Coin Sorter********************");					//Title of the program. This is the first line that will be shown.
		System.out.println();																	//Empty line.
		
		int userInput;
		do																						//do_while command was selected in order to show the main menu all the time, after the user has selected and finished from one of the options	
		{
			System.out.println("Please chose one of the options (1, 2, 3, 4, 5, 6)");			//This is the main menu. With instructions for the user. 
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			System.out.println();
			
			userInput = sc.nextInt();															//Scanner command is called and it is waiting for the user to type an integer(Int). If the user types a number other than 1,2,3,4,5 and 6 the progam will skip everything and will go to the default command (line 71)
			switch( userInput)																	//switch command was selected for the program to skip the cases until it found the one that the user selected
			{																					//e.g. if the user selected the 4th option, then the program will skip all the cases until the case 4.
			case 1:																				//Option 1.
				System.out.println("Please insert coins");
				System.out.println();
				cs.coinCalculator(userInput, userInput);										//calls the coinCalculator method from the CoinSorter class.
				break;																			//the break command forces the program to stop here if this case is selected, until the user tells it otherwise.
			case 2:																				//Option 2.
				System.out.println("Please isert multiple transactions");						//Not working.
				break;
			case 3:																				//Option 3.
				cs.printCoinList();																//calls the printCoinList method from the CoinSorter class.
				break;
			case 4:																				//Option 4
				do{																				//Sub menu in option 4.
				System.out.println("***Set Details Sub-Menu***");								//Here the user can change the initial values of the currency, the minimum coin input and the maximum coin input.
				System.out.println("1 - Set currency");
				System.out.println("2 - Set minimum coin input value");
				System.out.println("3 - Set maximum coin input value");
				System.out.println("4 - Return to main menu");
				System.out.println();
				userInput = sc.nextInt();														//Scanner command is called and it is waiting for the user to type an integer(Int).
				switch (userInput)
				{
				case 1:
					String str = sc.nextLine();													//Scanner command is called and waits for the user to type a String(str).
					cs.setCurrency(str);														//calls the setCurrency method from the CoinSorter class.
					break;
				case 2:
					cs.setMinCoinIn(userInput);													//calls the setMinCoinIn method from the CoinSorter class.
					break;
				case 3:			
					cs.setMaxCoinIn(userInput);													//calls the setMacCoinIn method from the CoinSorter class.
					break;
				default:
					if (userInput !=4) System.out.println("Wrong Input!");						//If the user types something other than 1,2,3 and 4, this line will be shown.
					break;
				}
				}while (userInput !=4);															//Option 4 ends here.
			case 5:																				//Option 5.
				cs.displayProgramConfigs();														//calls the displayProgramConfigs method from the CoinSorter class.
				break;	
			default:																			//The default command was placed in case the user selected a different number than the program can process.
				if (userInput !=6) System.out.println("Wrong input.");							//If the user selects 7 for example the program will show this line. Else it will skip it.
			}		
		}while (userInput != 6);																//If the user presses 6, the program will terminate.
	}
}
