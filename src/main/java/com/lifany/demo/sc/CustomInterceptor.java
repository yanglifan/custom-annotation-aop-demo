package com.lifany.demo.sc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Enhance the target method invocation with TdrEnabler.
 *
 * @author Lifan Yang
 */
public class CustomInterceptor implements MethodInterceptor {

	public CustomInterceptor() throws Exception {
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		CustomParam customParam = null;
		if (args.length == 1 && args[0] instanceof CustomParam) {
			customParam = (CustomParam) args[0];
		}

		if (customParam != null) customParam.setBeforeInvoke(true);

		Object result;
		try {
			result = invocation.proceed();
		} catch (Exception e) {
			if (customParam != null) customParam.setThrowException(true);
			throw e;
		}

		if (customParam != null) customParam.setAfterInvoke(true);

		return result;
	}
}
