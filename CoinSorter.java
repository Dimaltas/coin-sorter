import java.util.Scanner;

public class CoinSorter {
	
	private String currency = "British Pounds (BPS)";								//Some of the variables are initialized here so they are available in all the CoinSorter class.
	private int minCoinIn = 0;
	private int maxCoinIn = 10000;
	int twoPounds, onePound, fiftyP, twentyP, tenP;

	Scanner sc = new Scanner(System.in);											//Scanner is called here in order to not repeatedly call it inside the constructors.
	
	public void setCurrency(String currencyIn) 										//This method creates the currency. By default the currency is assigned as 'British Pounds (BPS)'and here the user can change it.
	{
		System.out.println("Please select the currency that you want to exchange");	//System.out.println() command, shows on the console whatever is in the brackets("")
		currency = sc.nextLine();													//Waits for user input
		currencyIn = currency;														//Saves the user Input(currency) as a String. currencyIn is a String initialized in the setCurrency class.
		System.out.println("The currecy selected is: " +currency);					//Prints the user input.
		System.out.println();
	}			
	
	public void setMinCoinIn(int minCoin) 											//This method creates the minimum coin input. By default it is zero(0).The user can change the minimum coins that the machine accepts to whatever they want.
	{																				//This method functions similarly as the setCurrency method. The difference is that the user input is an integer
		System.out.println("Please select the minimum coin input value.");			
		minCoin = sc.nextInt();
		minCoinIn = minCoin;
		System.out.println("The min coin that you can put is: " +minCoin);
		System.out.println();														//empty line.
	}

	public void setMaxCoinIn(int maxCoin)											//Same as the minCoinIn. The difference is that the default maximum coin accepted is 20,000.
	{	
		System.out.println("Please select the maximum coin input value.");
		maxCoin = sc.nextInt();
		maxCoinIn = maxCoin;
		System.out.println("The max coins that you can put is: "+ maxCoinIn);
		System.out.println();
	}
	
	public String getCurrency()
	{
		return currency;
	}		
	
	public int getMinCoinIn()
	{
		return minCoinIn;
	}
	
	public int getMaxCoinIn()
	{
		return maxCoinIn;
	}
	
	public void printCoinList()														//It is the 3rd option of the menu. It shows the list of the coins that the machine can give.
	{
		System.out.println("***********Coin List******************");
		System.out.println();
		System.out.println("The machine gives the following coins");
		System.out.println();
		System.out.println("£2 = 200p");
		System.out.println("£1 = 100p");
		System.out.println("0.5p = 50p");
		System.out.println("0.2p = 20p");
		System.out.println("0.1p = 10p");
		System.out.println();
		System.out.println("Please put the coins below");
		System.out.println();
	}
	
	
	public String coinCalculator(int totValue , int totalCoins)						//This is the 1st option of the menu. It provides information to the user and prompts them to select the amount of money they want to exchange.

	{		
		System.out.println("Please select between "+getMinCoinIn()+" and "+getMaxCoinIn());
		System.out.println();
		System.out.print("Select amount you want to exchange in penies: ");
		totValue = sc.nextInt();
		System.out.println();	
		
		if (totValue > minCoinIn && totValue <= maxCoinIn)							//The totValue is the input of the user and the totalCoins will show the number of the coins that the user will take back.
		{
			System.out.println((twoPounds = totValue/200)+ ": 200p");				//The result of the division totValue/200 will be a whole number and it will printed in order to show how many two-pound coins the user will take. 
			totValue = totValue % 200;												//The result is saved in the twoPounds variable for later. totValue%200 is the remainder of this division, and saves it in the totValue to use it below  
																					//in order to calculate how many one-pound coins the user will take. This process is repeated until the 10p coins were calculated. 
			System.out.println((onePound = totValue/100)+ ": 100p");				//If there is no remainder before the 10p, the program skips to line 96.
			totValue = totValue % 100;												//e.g totValue is 300. The user will take 2 two-pound coins and a one-pound. The program will show then and then it will skip to line 96
																					//as there are no more calculations for it to do.
			System.out.println((fiftyP = totValue/50)+ ": 50p");
			totValue = totValue % 50;	

			System.out.println((twentyP = totValue/20)+ ": 20p");
			totValue = totValue % 20;
			
			System.out.println((tenP = totValue/10)+ ": 10p");
			totValue = totValue % 10;
			
			System.out.println("Remainder is: "+totValue+"p");						//If there is any remainder from line 94, it will be printed here, as the number will be smaller than 10p.
			System.out.println();
			totalCoins = twoPounds + onePound + fiftyP + twentyP + tenP;			//The total of the coins is calculated
			System.out.println("The total coins that you will get are: "+totalCoins);	//Prints the total coins for the user to see.
			totalCoins = 0;															//Initializes the total coins as zero in case the user wanted to do more transactions.
		
			System.out.println();													
			System.out.println("***************************************************");
			return currency;
		}
		else
			System.out.println("Invalid Input. Please select between "+getMinCoinIn()+" and "+getMaxCoinIn());	//Prompts the user to put the amount between the minimum and the maximum coin that the machine can give.
			System.out.println();
			return currency;
    }
	
	
	//public String multiCoinCalculator(int ,int)
	//{
		
	//}
	
	public String displayProgramConfigs()											//This is the 5th option of the menu. It shows the currency, the minimum value accepted and the maximum. If the user changes those
	{																				//from the 4th option(Set details), their values will change here as well.
		System.out.println("The currency accepted is: " +getCurrency());
		System.out.println("The minimum value accepted is: " + getMinCoinIn());
		System.out.println("The maximum value accepted is: " + getMaxCoinIn());
		System.out.println();
		System.out.println("***************************************************");
		System.out.println();
		return currency;
	}
}