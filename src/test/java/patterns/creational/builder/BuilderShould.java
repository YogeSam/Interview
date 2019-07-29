package patterns.creational.builder;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuilderShould {

	private static final String BANKLOCATION = "177 Millbury Street";
	private static final int DEPOSIT = 500;
	private static final String ACCOUNTNAME = "Yoge Sam";
	private static final String BANKNAME = "Soverign Bank";

	@Test
	public void build_A_BankAccount() {
		BankAccount account = ABankAccountBuilder.buildAccount(1L)
						.atBank(BuilderShould.BANKNAME)
						.withAccountName(BuilderShould.ACCOUNTNAME)
						.atLocation(BuilderShould.BANKLOCATION)
						.withDepositOf(BuilderShould.DEPOSIT)
						.build();
		
		assert(account.getBankName().equals(BANKNAME));
		assert(account.getAccountName().equals(ACCOUNTNAME));
		assert(account.getDeposit() == DEPOSIT);
		
	}

}
