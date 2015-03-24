package com.lifany.demo.sc;

import java.lang.reflect.Method;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * @author Lifan Yang
 */
public class CustomAdvisor extends AbstractBeanFactoryPointcutAdvisor {

	public Pointcut getPointcut() {
		return new StaticMethodMatcherPointcut() {
			public boolean matches(Method method, Class targetClass) {
				return method.getAnnotation(PointcutAnnotation.class) != null;
			}
		};
	}
}
