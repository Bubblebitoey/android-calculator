package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenter {
	private CalculatorView view;
	private Calculator calculator;
	
	public static final int OPERATOR_ADD = Calculator.OPERATOR_ADD;
	public static final int OPERATOR_SUB = Calculator.OPERATOR_SUB;
	public static final int OPERATOR_MUL = Calculator.OPERATOR_MUL;
	public static final int OPERATOR_DIV = Calculator.OPERATOR_DIV;
	public static final int OPERATOR_EQ = 5;
	
	
	public CalculatorPresenter(Calculator calculator, CalculatorView view) {
		this.calculator = calculator;
		this.view = view;
	}
	
	public void onNumberClick(int num) {
		int newNum = 0;
		if (calculator.getState() == Calculator.State.op) newNum = Integer.parseInt("" + num);
		else newNum = Integer.parseInt(calculator.getResult() + "" + num);
		calculator.setNumber(newNum);
		showResult();
	}
	
	public void onOpClick(int op) {
		calculator.setOp(op);
		// calculator.setNumber(0);
		showResult();
	}
	
	public void calculate() {
		calculator.calculate();
		showResult();
	}
	
	public void onResetClick() {
		calculator.reset();
		showResult();
	}
	
	public void onBackClick() {
		calculator.setNumber(calculator.getResult() / 10);
		showResult();
	}
	
	private void showResult() {
		view.setCalculatorResult(calculator.getResult());
	}
}
