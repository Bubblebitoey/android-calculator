package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jittat on 30/3/2560.
 */
public class CalculatorTest {
	Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	public void shouldReturnZeroAfterReset() {
		calculator.reset();
		assertEquals(0, calculator.getResult());
	}

	@Test
	public void shouldReturnValueAfterSet() {
		calculator.reset();
		calculator.setResult(1234);
		assertEquals(1234, calculator.getResult());
	}

	@Test
	public void shouldAddTwoNumbers() {
		calculator.reset();
		calculator.setResult(1234);
		calculator.setOp(Calculator.OPERATOR_ADD);
		assertEquals(1334, calculator.operate(100));
	}

	@Test
	public void shouldAddThreeNumbers() {
		calculator.reset();
		calculator.setResult(1234);
		calculator.setOp(Calculator.OPERATOR_ADD);
		assertEquals(1834, calculator.operate(600));
	}

	@Test
	public void shouldSubtractTwoNumber() {
		calculator.reset();
		calculator.setResult(1000);
		calculator.setOp(Calculator.OPERATOR_SUB);
		assertEquals(901, calculator.operate(99));
	}

	@Test
	public void shouldMultiplyTwoNumber() {
		calculator.reset();
		calculator.setResult(100);
		calculator.setOp(Calculator.OPERATOR_MUL);
		assertEquals(1000, calculator.operate(10));
	}

	@Test
	public void shouldDivideTwoNumber() {
		calculator.reset();
		calculator.setResult(1250);
		calculator.setOp(Calculator.OPERATOR_DIV);
		assertEquals(5, calculator.operate(250));
	}

	@Test
	public void shouldReturnErrorWhenDivideByZero() {
		calculator.reset();
		calculator.setResult(1);
		calculator.setOp(Calculator.OPERATOR_DIV);
		assertEquals(1, calculator.operate(0));
	}

	@Test
	public void shouldKeepErrorStateUntilReset() {
		calculator.reset();
		calculator.setResult(1);
		calculator.setOp(Calculator.OPERATOR_DIV);
		assertEquals(1, calculator.operate(0));
	}


}
