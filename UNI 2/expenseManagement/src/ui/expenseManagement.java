import java.util.Scanner;
public class expenseManagement {
	
	//MAIN
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] usernameArray = new String[20];
		double[] expenseArray = new double[20];
		String username = "";
		double totalExpensesUniqueUser = 0;
		double averageAllUserExpenses = 0;
		int menuSelectOption;
		int validArrayCounter = 0;
		int z = 0;
		int i = 0;
		
		do {
			menuSelectOption = welcome();
			if (z==20) {z=0;}
			switch (menuSelectOption) {
				case 1:
					// REGISTER an expense
					z = registerAnExpense(usernameArray, expenseArray, z);
					break;
					
				case 2:
					// QUERY total expenses for an user
					queryTotalExpensesForUser(username, i, usernameArray, totalExpensesUniqueUser, expenseArray);	
					break;
					
				case 3:
					// QUERY average spending of all users
					queryAverageSpendingOfAllUsers(i, expenseArray, averageAllUserExpenses, validArrayCounter);
					break;
				
				case 4:
					// END
					System.out.println("Thank you for use the Expense-Management System, hope to see you soon again.");
					break;
				
				default:
					System.out.println("You are typing a not valid option, select an option from the main menu.");
					
		}} while (menuSelectOption != 4);
	}
	
	// -----BEGINNING OF METHODS-----
	
		// 1. Welcome | METHOD int
			/**
			*
			* This method will welcome the user and it will ask him for a menu selection.
			*
			* @return menuSelectOption This option will work as param to the switch to evaluate. 
			*
			*/
			public static int welcome() {
				Scanner lector = new Scanner(System.in);
				System.out.println("Welcome to the Expense Management System");
				System.out.println("Choose a option to continue");
				System.out.println("	[1] Register an expense");
				System.out.println("	[2] Query total expenses for a user");
				System.out.println("	[3] Query average spending of all users");
				System.out.println("	[4] Close the program");
				int menuSelectOption=lector.nextInt();
			return menuSelectOption;
			}
			
		// 2. Register-An-Expense | METHOD int
			/**
			*
			* This method will ask to the user the username and the expense value to attach the data in system, also this method will sum 1 to z as a counter for array index.
			*
			* @param z This variable will work to store data in the array depending of the index that is z
			* @param expenseArray This is a double array which will store expense values
			* @param usernameArray This is a String array which will store username values
			* @return z This return variable will be the sum in 1 of z to move the index forward 
			*
			*/
			public static int registerAnExpense(String[] usernameArray, double[] expenseArray, int z) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Type a USERNAME for attach it to the expense");
				usernameArray[z] = scanner.next();
				System.out.println("Type value of the EXPENSE");
				expenseArray[z] = scanner.nextDouble();
				z++;
			return z;
			}
		
		// 3. Query-Total-Expenses-For-A-User | METHOD void
			/**
			*
			* This method will go through an array comparing the username stored with the indicated by the user and will sum the values to a variable, which will be displayed in the end.
			*
			* @param username This variable will store the username indicated by the user to compare to the array username values
			* @param expenseArray This is a double array which will store expense values
			* @param usernameArray This is a String array which will store username values
			* @param i This variable will work as a counter for the cycle to go through the array
			* @param totalExpensesUniqueUser This variable will store temporarily the total expenses of an user
			*
			*/
			public static void queryTotalExpensesForUser(String username, int i, String[] usernameArray, double totalExpensesUniqueUser, double[] expenseArray) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Type a USERNAME to query his expense logs");
					username = scanner.next();
					for (i=0; i<usernameArray.length; i++) {
						if (username.equals(usernameArray[i])) {
							totalExpensesUniqueUser = totalExpensesUniqueUser + expenseArray[i];
						}
					}
					if (totalExpensesUniqueUser>0) {
						System.out.println("The total amount of expenses for " + username + " is of: $" + totalExpensesUniqueUser);
					} else {
						System.out.println("The user does not have any expense registered");
						}
					totalExpensesUniqueUser = 0;
			}
			
		// 4. Query-Average-Spending-Of-All-Users | METHOD void
			/**
			*
			* This method will query the average of all user expenses by going through an array and doing a sum to a variable, dividing it by the amount of times that a value was registered.
			*
			* @param averageAllUserExpenses This variable will store temporarily the average of all user expenses
			* @param expenseArray This is a double array which will store expense values
			* @param i This variable will work as a counter for the cycle to go through the array
			* @param validArrayCounter This variable will work as a counter for an array that have a value higher than 0
			*
			*/
			public static void queryAverageSpendingOfAllUsers(int i, double[] expenseArray, double averageAllUserExpenses, int validArrayCounter) {
				for (i=0; i<expenseArray.length; i++) {
					averageAllUserExpenses = averageAllUserExpenses + expenseArray[i];
						if (expenseArray[i]>0) {validArrayCounter++;}
						if (validArrayCounter==0) {validArrayCounter=1;}
					}
					averageAllUserExpenses = averageAllUserExpenses/validArrayCounter;
					System.out.println("The average of all user expenses is: $" + averageAllUserExpenses);
					validArrayCounter = 0;
					averageAllUserExpenses = 0;
			}
	
}