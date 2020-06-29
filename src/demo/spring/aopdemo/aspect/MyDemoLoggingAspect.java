package demo.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advice for logging
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* demo.spring.aopdemo.dao.AccountDAO.findAccounts())",
			returning = "result")
	public void afterReturningFindAccounts(JoinPoint joinpoint, String result) {

		// print out we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @AfterReturning on method : "+method);
		
		// print out the results of method call
		System.out.println("\n====>>> Result is : "+result);
		
		// we can modify the data in here also
		result = result.toUpperCase();
		
		System.out.println("\n====>>> Modified Result is : "+result);
	}
	
	// @Before annotation, execute this before executing that
	@Before("execution(public void addAccount())") // point-cut expression
	public void beforeAddAccount() {
		System.out.println("\n=====>>> Executing @Before Advice |beforeAddAccount| on addAccount()\n");
	}
}
