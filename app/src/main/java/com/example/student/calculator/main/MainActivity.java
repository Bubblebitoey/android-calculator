package com.example.student.calculator.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.student.calculator.R;
import com.example.student.calculator.data.Calculator;

public class MainActivity extends AppCompatActivity implements CalculatorView {
	
	TextView resultTextView;
	CalculatorPresenter presenter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViewHolders();
		
		if (presenter == null) {
			Calculator calculator = new Calculator();
			presenter = new CalculatorPresenter(calculator, this);
		}
		presenter.onResetClick();
	}
	
	private void initViewHolders() {
		resultTextView = (TextView) findViewById(R.id.textview_calculator_result);
	}
	
	// view implementation
	
	public void setCalculatorResult(int result) {
		resultTextView.setText(result);
	}
	
	@Override
	public int getResult() {
		return Integer.valueOf(String.valueOf(resultTextView.getText()));
	}
	
	// event handlers
	
	public void onNumberClick(View view) {
		int[][] idNumMap = {{R.id.button_number_0, 0}, {R.id.button_number_1, 1}, {R.id.button_number_2, 2}, {R.id.button_number_3, 3}, {R.id.button_number_4, 4}, {R.id.button_number_5, 5}, {R.id.button_number_6, 6}, {R.id.button_number_7, 7}, {R.id.button_number_8, 8}, {R.id.button_number_9, 9},};
		
		for (int[] idNum : idNumMap) {
			if (view.getId() == idNum[0]) {
				presenter.onNumberClick(idNum[1]);
			}
		}
	}
	
	public void onOpClick(View view) {
		switch (view.getId()) {
			case R.id.button_op_add:
				presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
				break;
			case R.id.button_op_sub:
				presenter.onOpClick(CalculatorPresenter.OPERATOR_SUB);
				break;
			case R.id.button_op_mul:
				presenter.onOpClick(CalculatorPresenter.OPERATOR_MUL);
				break;
			case R.id.button_op_div:
				presenter.onOpClick(CalculatorPresenter.OPERATOR_DIV);
				break;
			case R.id.button_op_eq:
				presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);
				break;
		}
	}
	
	public void onResetClick(View view) {
		presenter.onResetClick();
	}
	
	public void onBackClick(View view) {
		presenter.onBackClick();
	}
}
