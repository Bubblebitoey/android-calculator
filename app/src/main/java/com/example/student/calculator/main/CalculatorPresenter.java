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
		calculator.setResult(Integer.parseInt(calculator.getResult() + "" + num));
		view.setCalculatorResult(calculator.getResult());
	}

	public void onOpClick(int op) {
		if (op == OPERATOR_EQ) {
			calculate();
		} else {
			calculator.setOp(op);
			calculator.save();
			// view.setCalculatorResult(op);
		}
	}

	public void calculate() {
		int b = calculator.getResult();
		calculator.load();
		calculator.operate(b);
		view.setCalculatorResult(calculator.getResult());
	}

	public void onResetClick() {
		calculator.reset();
		view.setCalculatorResult(calculator.getResult());
	}

	public void onBackClick() {
		calculator.setResult(calculator.getResult() / 10);
	}
}
