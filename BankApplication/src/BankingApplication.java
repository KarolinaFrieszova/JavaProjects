import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount("Sophia Green", "03019623");
		ba.showMenu();
	}
}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String accountNumber;
	
	BankAccount(String customerName, String accountNumber){
		this.customerName = customerName;
		this.accountNumber = accountNumber;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	void withdraw(int amount) {
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: "+ previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Account number " + accountNumber + "\n");
		
		System.out.println("Chose from following options to\n");
		System.out.println("1: Check your balance");
		System.out.println("2: Deposit");
		System.out.println("3: Withdraw");
		System.out.println("4: Previous transacion");
		System.out.println("5: Exit the system");
		
		do {
			System.out.println("\nEnter your option: ");
			option = scanner.next().charAt(0);
			 switch(option) {
			 case '1':
				 System.out.println("\nBalance: " + balance);
				 break;
			 case '2':
				 System.out.println("\nEnter an amount to deposit ");
				 int amount = scanner.nextInt();
				 deposit(amount);
				 break;
			 case '3':
				 System.out.println("\nEnter an amount to withdraw ");
				 int amount2 = scanner.nextInt();
				 withdraw(amount2);
				 break;
			 case '4':
				 System.out.println("\n");
				 getPreviousTransaction();
				 break;
			 case '5':
				 System.out.println("-----------------------------------------------------------");
				 break;
			 default:
				 System.out.println("\nInvalid option entered. Please enter correct option.");
				 break; 
			 }	 
		}
		while(option != '5'); {
			System.out.println("Thank you for using our services");
		}
	}
}
