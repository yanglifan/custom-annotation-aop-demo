package com.lifany.demo.sc;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDrivenTest {

    ApplicationContext appContext;

    @Before
    public void setup() {
        appContext = new ClassPathXmlApplicationContext("annotationDrivenTestsBeans.xml");
    }

    @Test
    public void testDoSomething() {
        FoobarService foobarService = (FoobarService) appContext.getBean("foobarService");

		CustomParam customParam = new CustomParam();
        foobarService.doSomething(customParam);

		assertTrue("AOP process before target invocation.", customParam.isBeforeInvoke());
		assertTrue("AOP process after target invocation.", customParam.isAfterInvoke());
    }

	@Test
    public void testDoSomethingWithException() {
        FoobarService foobarService = (FoobarService) appContext.getBean("foobarService");
		CustomParam customParam = new CustomParam();
        try {
            foobarService.doSomethingWithException(customParam);
        } catch (Exception e) {
            System.out.println("It's ok. This exception is for UT.");
			assertTrue("SC proccess when throw exception.", customParam.isThrowException());
        }

		assertTrue("AOP process before target invocation.", customParam.isBeforeInvoke());
    }
}
