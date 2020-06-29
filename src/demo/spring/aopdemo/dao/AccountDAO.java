package demo.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	// add a new method
	public String findAccounts() {
		System.out.println("\n\nList of Accounts : findAccounts() method in AccountDAO\n");
		return "Account 1, Account 2, Account 3";
	}
	
	public void addAccount() {
		System.out.println(getClass()+" : DOING MY DB WORK : ADDING AN ACCOUNT");
	}
}
