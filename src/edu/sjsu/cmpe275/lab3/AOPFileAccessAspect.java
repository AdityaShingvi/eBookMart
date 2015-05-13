package edu.sjsu.cmpe275.lab3;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.annotation.*;

@Aspect
public class AOPFileAccessAspect {

	
	//Aspect for handling the cross cutting concern of Authentication
	@Before("execution(* edu.sjsu.cmpe275.lab3.BookController.*Books(*))")
	public void validateShare(JoinPoint join) throws Throwable {
		System.out.println("Before AOP - " + join.getArgs().toString());
		Object[] objects = join.getArgs();
		long uid;
		HttpServletRequest request = (HttpServletRequest)objects[0];
		try {
			uid = (Long) request.getSession().getAttribute("userid");
		} catch(NullPointerException e){
			System.out.println("User not logged in");
			uid = 0;
		}
	}
	
	@AfterThrowing("execution(* edu.sjsu.cmpe275.lab3.BookController.*(..))")
	public void handleException(JoinPoint joinPoint){
		System.out.println("In Exception" + joinPoint);
	}

	/*@Around("execution(* com.cmpe275.IFileServiceImpl.unshareFile(..))")
	public void validateUnShare(ProceedingJoinPoint jp) throws Throwable {}*/

	/*@Around("execution(* com.cmpe275.IFileServiceImpl.readFile(..))")
	public byte[] validateReadFile(ProceedingJoinPoint jp) throws Throwable {}*/

}