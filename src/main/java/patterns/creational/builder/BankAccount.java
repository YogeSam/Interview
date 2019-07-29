package patterns.creational.builder;

public class BankAccount {

	private long accountId;
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankLocation() {
		return bankLocation;
	}

	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}

	private String accountName;
	private int deposit;
	private String bankName;
	private String bankLocation;

	public BankAccount(long accountId, String accountName, int deposit, String bankName, String bankLocation) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.deposit = deposit;
		this.bankName = bankName;
		this.bankLocation = bankLocation;
		
	}

}
