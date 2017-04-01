package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenterTest {
	private CalculatorPresenter presenter;
	private Calculator calculator;
	
	@Mock
	CalculatorView view;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		calculator = new Calculator();
		presenter = new CalculatorPresenter(calculator, view);
	}
	
	@Test
	public void shouldShowZeroAfterReset() {
		presenter.onResetClick();
		verify(view).setCalculatorResult(0);
	}
	
	@Test
	public void shouldShowSingleDigitNumber() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		
		verify(view).setCalculatorResult(5);
	}
	
	@Test
	public void shouldShowTwoDigitNumber() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		presenter.onNumberClick(7);
		verify(view).setCalculatorResult(57);
	}
	
	@Test
	public void shouldDeleteLatestNumber() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		presenter.onNumberClick(7);
		presenter.onNumberClick(9);
		presenter.onBackClick();
		verify(view, atMost(2)).setCalculatorResult(57);
	}
	
	@Test
	public void shouldDeleteAll() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		presenter.onNumberClick(7);
		presenter.onNumberClick(9);
		verify(view).setCalculatorResult(0);
	}
	
	@Test
	public void shouldAdd() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		presenter.onNumberClick(7);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
		presenter.onNumberClick(9);
		presenter.onNumberClick(9);
		presenter.calculate();
		verify(view).setCalculatorResult(156);
	}
	
	@Test
	public void shouldAdd2Time() {
		presenter.onResetClick();
		presenter.onNumberClick(5);
		presenter.onNumberClick(7);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
		presenter.onNumberClick(9);
		presenter.onNumberClick(9);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
		presenter.onNumberClick(4);
		presenter.calculate();
		verify(view).setCalculatorResult(160);
	}
	
	@Test
	public void shouldSub() {
		presenter.onResetClick();
		presenter.onNumberClick(1);
		presenter.onNumberClick(4);
		presenter.onNumberClick(4);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_SUB);
		presenter.onNumberClick(4);
		presenter.onNumberClick(4);
		presenter.calculate();
		verify(view).setCalculatorResult(100);
	}
	
	@Test
	public void shouldMul() {
		presenter.onResetClick();
		presenter.onNumberClick(4);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_MUL);
		presenter.onNumberClick(4);
		presenter.calculate();
		verify(view).setCalculatorResult(16);
	}
	
	@Test
	public void shouldDiv() {
		presenter.onResetClick();
		presenter.onNumberClick(1);
		presenter.onNumberClick(0);
		presenter.onNumberClick(8);
		presenter.onOpClick(CalculatorPresenter.OPERATOR_DIV);
		presenter.onNumberClick(1);
		presenter.onNumberClick(2);
		presenter.calculate();
		verify(view).setCalculatorResult(9);
	}
}
