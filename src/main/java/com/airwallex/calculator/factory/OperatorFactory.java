package com.airwallex.calculator.factory;



import com.airwallex.calculator.error.OperatorErrorCode;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.function.ClearOperator;
import com.airwallex.calculator.operate.function.UndoOperator;
import com.airwallex.calculator.operate.math.*;
import com.airwallex.calculator.operate.enums.OperatorsEnum;

import java.util.Optional;

/**
 * OperatorFactory to construct all types of calculator
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class OperatorFactory {

	public static Optional<AbstractOperator> getOperator(final String userEntered) {
		Optional<AbstractOperator> userEntry = Optional.empty();
		
		try {
			OperatorsEnum operator = OperatorsEnum.checkIsValidOperator(userEntered);
			if (operator == null) {
				System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getDescription());
 				return userEntry;
			}
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
				case SQUARE_ROOT:
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
