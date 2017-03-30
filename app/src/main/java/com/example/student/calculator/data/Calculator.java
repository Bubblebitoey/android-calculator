package com.example.student.calculator.data;

/**
 * Created by jittat on 30/3/2560.
 */

public class Calculator {
	private int a;
	private int result;
	private int op;
	private boolean isError = false;

	public static final int OPERATOR_ADD = 1;
	public static final int OPERATOR_SUB = 2;
	public static final int OPERATOR_MUL = 3;
	public static final int OPERATOR_DIV = 4;


	public Calculator() {
		reset();
	}

	public void reset() {
		result = 0;
	}

	public void save() {
		a = result;
		result = 0;
	}

	public void load() {
		result = a;
		a = 0;
	}

	public int setResult(int r) {
		result = r;
		return result;
	}

	public void setOp(int op) {
		if (op > 0 && op < 5) this.op = op;
	}

	public int operate(int a) {
		switch (op) {
			case OPERATOR_ADD:
				result += a;
				break;
			case OPERATOR_SUB:
				result -= a;
				break;
			case OPERATOR_MUL:
				result *= a;
				break;
			case OPERATOR_DIV:
				if (a != 0) result /= a;
				else isError = true;
				break;
			default:
				isError = true;
		}
		return result;
	}

	public boolean isError() {
		return isError;
	}

	public int getResult() {
		return result;
	}
}
