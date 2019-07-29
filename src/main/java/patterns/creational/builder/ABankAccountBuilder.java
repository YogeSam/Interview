package patterns.creational.builder;

public class ABankAccountBuilder {

	private long accountId;
	private String bankName;
	private String accountName;
	private String bankLocation;
	private int deposit;

	public static ABankAccountBuilder buildAccount(long l) {
		ABankAccountBuilder builder = new ABankAccountBuilder();
		builder.accountId = l;
		return builder;
	}

	public ABankAccountBuilder atBank(String bankName) {
		
		this.bankName = bankName;
		return this;
	}

	public ABankAccountBuilder withAccountName(String accountname) {
		this.accountName= accountname;
		return this;
		
	}

	public ABankAccountBuilder atLocation(String bankLocation) {
		this.bankLocation = bankLocation;
		return this;
	}

	public ABankAccountBuilder withDepositOf(int deposit) {
		this.deposit = deposit;
		return this;
	}

	public BankAccount build() {
		// TODO Auto-generated method stub
		return new BankAccount(accountId, accountName, deposit, bankName,bankLocation);
	}

}
