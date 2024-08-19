package com.airwallex.calculator.operate.factory;



import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.function.ClearOperator;
import com.airwallex.calculator.operate.function.UndoOperator;
import com.airwallex.calculator.operate.math.*;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.util.Optional;

public class OperatorFactory {

	public static Optional<AbstractOperator> getOperator(final String userEntered) {
		Optional<AbstractOperator> userEntry = Optional.empty();
		
		try {
			OperatorsEnum operator = OperatorsEnum.fromString(userEntered);
			switch (operator) {
				case ADDITION:
					userEntry = Optional.of(new AdditionOperator());
					break;
				case SUBTRACTION:
					userEntry = Optional.of(new SubtractionOperator());
					break;
				case MULTIPLICATION:
					userEntry = Optional.of(new MultiplicationOperator());
					break;
				case DIVISION:
					userEntry = Optional.of(new DivisionOperator());
					break;
				case SQUAREROOT:
					userEntry = Optional.of(new SquareRootOperator());
					break;
				case CLEAR:
					userEntry = Optional.of(new ClearOperator());
					break;
				case UNDO:
					userEntry = Optional.of(new UndoOperator());
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return userEntry;
	}
}
