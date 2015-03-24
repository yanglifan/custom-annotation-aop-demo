package com.lifany.demo.sc;

public class CustomParam {
	private boolean beforeInvoke;
	private boolean afterInvoke;
	private boolean throwException;

	public boolean isBeforeInvoke() {
		return beforeInvoke;
	}

	public void setBeforeInvoke(boolean beforeInvoke) {
		this.beforeInvoke = beforeInvoke;
	}

	public boolean isAfterInvoke() {
		return afterInvoke;
	}

	public void setAfterInvoke(boolean afterInvoke) {
		this.afterInvoke = afterInvoke;
	}

	public boolean isThrowException() {
		return throwException;
	}

	public void setThrowException(boolean throwException) {
		this.throwException = throwException;
	}
}
