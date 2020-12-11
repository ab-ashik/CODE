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