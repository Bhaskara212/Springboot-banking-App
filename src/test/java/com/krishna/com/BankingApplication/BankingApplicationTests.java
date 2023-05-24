package com.krishna.com.BankingApplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankingApplicationTests {
    
	@Autowired
	private AccountController Actlr;
	
	@Autowired
	private AccountRepository ARepo;
	
	
	@Test
	void contextLoads() {
	
	}
		
		
	@Test
	public void testregistermethod() {
		Account Ac = ARepo.save(new Account(100220023,"Krishna",912217116,"HYD",20987.98));
		assertThat(Ac.getAccountId()).isGreaterThan(0);
	}
		
	@Test
	public void testgetdetailsmethod() {
		Account Ac = ARepo.save(new Account(100220023,"Krishna",912217116,"HYD",20987.98));
		Account AcListById = ARepo.findById(Ac.getAccountId()).get();
		assertThat(AcListById).isNotNull();
	}
	
	@Test
	public void testgetallistmethod() {
		Account Ac = new Account(100220023,"Krishna",912217116,"HYD",20987.98);
		Account Ac2 = new Account(100220024,"Bhaskar",991219161,"RJY",120577.00);
		Iterable<Account> Accalllist = ARepo.findAll();
		assertThat (Accalllist).isNotNull();
		assertThat(Accalllist.iterator()).isNotEqualTo(2);
		
	}
	
	@Test
	public void testupdatemethod(){
		Account Ac = new Account(100220023,"Krishna",912217116,"HYD",20987.98);
		Account savedAcc =ARepo.findById(Ac.getAccountId()).get();
		savedAcc.setMobileNumber(897645578);
		savedAcc.setBalanceAmount(128973.00);
		Account updatedetails = ARepo.save(savedAcc);
		assertThat(updatedetails.getMobileNumber()).isEqualTo(897645578);
		assertThat(updatedetails.getBalanceAmount()).isEqualTo(128973.00);
	}
	
	@Test
	public void testdeletemethod() {
		Account Ac = new Account(100220023,"Krishna",912217116,"HYD",20987.98);
		ARepo.deleteById(Ac.getAccountId());
		Optional<Account> optionalAcc = ARepo.findById(Ac.getAccountId());
		assertThat(optionalAcc).isEmpty();
	}
		
}
