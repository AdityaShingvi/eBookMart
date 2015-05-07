package edu.sjsu.cmpe275.lab3;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.annotation.*;

@Aspect
public class AOPFileAccessAspect {

	@Before("execution(* edu.sjsu.cmpe275.lab3.BookController.getBooks(..))")
	public void validateShare() throws Throwable {
		System.out.println("Before AOP");
	//	jp.proceed();
		System.out.println("After AOP");
	}

	/*@Around("execution(* com.cmpe275.IFileServiceImpl.unshareFile(..))")
	public void validateUnShare(ProceedingJoinPoint jp) throws Throwable {}*/

	/*@Around("execution(* com.cmpe275.IFileServiceImpl.readFile(..))")
	public byte[] validateReadFile(ProceedingJoinPoint jp) throws Throwable {}*/

}