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
	public void shouldSubtractThreeNumbersByOPAndNum() {
		calculator.reset();
		calculator.setNumber(1000);
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(1);
		calculator.calculate();
		calculator.setOp(Calculator.OPERATOR_SUB);
		calculator.setNumber(900);
		calculator.setOp(5);
		
		assertEquals(99, calculator.getResult());
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
	
	private void print() {
		System.out.println(calculator.toString());
	}
}
