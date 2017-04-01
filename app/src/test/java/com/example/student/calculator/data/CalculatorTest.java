package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		calculator.setNumber(1234);
		assertEquals(1234, calculator.getResult());
	}
	
	@Test
	public void shouldAddTwoNumbers() {
		calculator.reset();
		calculator.setNumber(1234);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setNumber(100);
		calculator.calculate();
		assertEquals(1334, calculator.getResult());
	}
	
	public void shouldAddTwoNumbersByOP5() {
		calculator.reset();
		calculator.setNumber(1234);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setNumber(100);
		calculator.setOp(5);
		assertEquals(1334, calculator.getResult());
	}
	
	@Test
	public void shouldAddThreeNumbers() {
		calculator.reset();
		calculator.setNumber(1234);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setNumber(4321);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setNumber(1);
		calculator.calculate();
		assertEquals(5556, calculator.getResult());
	}
	
	@Test
	public void shouldSubtractThreeTime() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(1);
		calculator.calculate();
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(900);
		calculator.setOp(5);
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(9);
		calculator.calculate();
		assertEquals(90, calculator.getResult());
	}
	
	@Test
	public void shouldSubtractTwoNumbers() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(1);
		calculator.calculate();
		assertEquals(999, calculator.getResult());
	}
	
	@Test
	public void shouldMultiplyTwoNumber() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_MUL);
		calculator.setNumber(2);
		calculator.calculate();
		assertEquals(2000, calculator.getResult());
	}
	
	@Test
	public void shouldMultiplyThreeNumber() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_MUL);
		calculator.setNumber(2);
		calculator.calculate();
		calculator.setOp(Calculator.OPERATOR_MUL);
		calculator.setNumber(2);
		calculator.calculate();
		assertEquals(4000, calculator.getResult());
	}
	
	@Test
	public void shouldDivideTwoNumber() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_DIV);
		calculator.setNumber(250);
		calculator.calculate();
		assertEquals(4, calculator.getResult());
	}
	
	@Test
	public void shouldChangeOP() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_DIV);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(250);
		calculator.calculate();
		assertEquals(750, calculator.getResult());
	}
	
	@Test
	public void shouldReturnErrorWhenDivideByZero() {
		calculator.reset();
		calculator.setNumber(1);
		calculator.setOp(Calculator.OPERATOR_DIV);
		calculator.setNumber(0);
		calculator.calculate();
		// should error
		assertTrue(calculator.isError());
		// and result will be 0
		assertEquals(0, calculator.getResult());
	}
	
	@Test
	public void shouldKeepErrorStateUntilReset() {
		calculator.setNumber(1);
		calculator.setOp(Calculator.OPERATOR_DIV);
		calculator.setNumber(0);
		calculator.calculate();
		assertTrue(calculator.isError());
		calculator.reset();
		assertFalse(calculator.isError());
	}
	
	@Test
	public void shouldSet2DigitNumbers() {
		calculator.reset();
		calculator.setNumber(1);
		calculator.setNumber(12);
		calculator.setNumber(123);
		calculator.setOp(Calculator.OPERATOR_ADD);
		calculator.setNumber(1);
		calculator.setNumber(10);
		calculator.setNumber(100);
		calculator.calculate();
		assertEquals(223, calculator.getResult());
	}
	
	@Test
	public void shouldShowResultEveryTime() {
		calculator.reset();
		calculator.setNumber(4);
		assertEquals(4, calculator.getResult());
		calculator.setNumber(46);
		assertEquals(46, calculator.getResult());
		calculator.setNumber(461);
		assertEquals(461, calculator.getResult());
		calculator.setOp(Calculator.OPERATOR_ADD);
		assertEquals(461, calculator.getResult());
	}
	
	private void print() {
		System.out.println(calculator.toString());
	}
}
