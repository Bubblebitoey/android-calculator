package com.example.student.calculator.data;

import java.util.*;

/**
 * Created by jittat on 30/3/2560.
 */

public class Calculator {
	public static final int OPERATOR_ADD = 1;
	public static final int OPERATOR_SUB = 2;
	public static final int OPERATOR_MUL = 3;
	public static final int OPERATOR_DIV = 4;
	private int a, op, b;
	private boolean isError = false;
	
	public void setNumber(int result) {
		pullDown();
		this.b = result;
	}
	
	public void setOp(int op) {
		if (op == 5 || isBothExist()) {
			calculate();
		} else {
			pullDown();
		}
		
		this.op = op;
	}
	
	/**
	 * force calculate {@link #a}, {@link #op}, {@link #b} <br>
	 * all int variable must be 0, except <b>b</b>
	 */
	public void calculate() {
		b = operation(a, this.op, b);
		a = 0;
		op = 0;
	}
	
	public boolean isError() {
		return isError;
	}
	
	public int getResult() {
		if (isBothExist()) calculate();
		return b;
	}
	
	public void reset() {
		a = b = op = 0;
		isError = false;
	}
	
	private int operation(int a, int op, int b) {
		try {
			switch (op) {
				case OPERATOR_ADD:
					return a + b;
				case OPERATOR_SUB:
					return a - b;
				case OPERATOR_MUL:
					return a * b;
				case OPERATOR_DIV:
					return a / b;
			}
		} catch (Exception e) {
			isError = true;
		}
		return 0;
	}
	
	/**
	 * if <b>b</b> exist, move <b>b</b> to <b>a</b>
	 */
	private void pullDown() {
		if (b != 0) {
			a = b;
			b = 0;
		}
	}
	
	private boolean isAExist() {
		return a != 0;
	}
	
	private boolean isBExist() {
		return b != 0;
	}
	
	private boolean isBothExist() {
		return isAExist() && isBExist();
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "Calculator{a=%-6d, op=%-2d, b=%-6d, %-6s}", a, op, b, isError ? "ERROR": "NOT");
	}
}
