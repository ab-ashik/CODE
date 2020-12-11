public class StartAccount
{
	public static void main(String args[])
	{
		AccountUpgrade aa1 = new AccountUpgrade("ABDULLAH","12-3456-7",10000);
		AccountUpgrade aa2 = new AccountUpgrade("ABDULLAH","12-3456-7",20000);
		aa1.showInfo();
		
		aa1.deposite(1000);
		aa1.withdraw(500);
		aa1.showInfo();
		
		aa1.addTransaction(aa1,aa2,2000);
		aa1.transfer(500,aa2);
		
		aa1.showAlltransaction();
		
	}
}



public class AccountUpgrade
{
	private String accId;
    private String accName;
    private int accBalance;
	public AccountUpgrade(){}
	public AccountUpgrade(String accName, String accId,int accBalance){
		this.accName=accName;
		this.accId=accId;
		this.accBalance=accBalance;
	}
	public void setAccName(String accName){this.accName=accName;}
	public void setAcId(String accId){this.accId=accId;}
	public void setBalance(int accBalance){this.accBalance = accBalance;}
	public String getAccName(){return accName;}
	public String getAccId(){return accId;}
	public int getBalance(){return accBalance;}
	public int deposite(int amount){
		accBalance +=amount;
		System.out.println("Your deposite amount : "+amount);
		System.out.println("Balance : "+accBalance);
		return accBalance;
	}
	public int withdraw(int amount){
		accBalance -=amount;
		System.out.println("Your withdraw amount : "+amount);
		System.out.println("Balance : "+accBalance);
		return accBalance;
	}
	public void showInfo()
	{
		System.out.println("Account Name :" + accName);
		System.out.println("Account id :" + accId);
		System.out.println("Balance :" + accBalance);
	}
	
	static Transaction transaction[] = new Transaction[100] ;
	static int totalNumberOfTransaction = 0;

	public void addTransaction(AccountUpgrade sender, AccountUpgrade receiver, int amount)
	{
		transaction[totalNumberOfTransaction] = new Transaction(sender , receiver,  amount);
		totalNumberOfTransaction++;
	}

	public void transfer(int amount, AccountUpgrade receiver){
		addTransaction(this, receiver, amount);
		int y = receiver.deposite(amount);
		System.out.println("Transfer Completed");
		System.out.println("Balance of "+this.accName+" is: "+this.accBalance);
		System.out.println("Balance of "+receiver.accName+" is: "+receiver.accBalance);
	}
	public void showAlltransaction()
	{
		for(int i = 0; i<totalNumberOfTransaction; i++)
		{
			transaction[i].showTransactionInfo();
		}	
	}
	
}
