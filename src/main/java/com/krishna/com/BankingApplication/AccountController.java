package com.krishna.com.BankingApplication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountRepository ARepo;
	
	   @RequestMapping(value="/create",method=RequestMethod.GET)
	   public Account create() {
	   Account Ac = new Account(100220023,"Krishna",912217116,"HYD",20987.98);
	   Account savedacc = ARepo.save(Ac);
	   return savedacc;
	   }
	   
	   @RequestMapping(value="/register",method=RequestMethod.POST)
	   public Account register(@RequestBody Account Ac) {
		   Account savedacc = ARepo.save(Ac);
		   return savedacc;
	   }
	   
	   @RequestMapping(value="/getdetails/{AccountId}",method=RequestMethod.GET)
	   public Account getdetails(@PathVariable(value="AccountId")int AccountId) {
		   return ARepo.findById(AccountId).get();
		   
	   }
	   
	   @RequestMapping(value={"/getalllist","/"},method=RequestMethod.GET)
	   public Iterable<Account> getalllist(){
		   return ARepo.findAll();
	   }
	   
	   @RequestMapping(value="/update/{AccountId}",method=RequestMethod.PUT)
	   public ResponseEntity<Object> update(@RequestBody Account Ac,@PathVariable int AccountId){
		   Optional<Account> Acopt = ARepo.findById(AccountId);
		   if(Acopt.isEmpty())
			   return ResponseEntity.notFound().build();
		   Ac.setAccountId(AccountId);
		   ARepo.save(Ac);
		   return ResponseEntity.noContent().build();
	   }
	
	   @RequestMapping(value="/delete/{AccountId}",method=RequestMethod.DELETE)
	   public void delete(@PathVariable int AccountId) {
		   ARepo.deleteById(AccountId);
		   
	   }
	

}
