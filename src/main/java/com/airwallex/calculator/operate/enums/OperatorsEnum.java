package com.airwallex.calculator.operate.enums;

import com.airwallex.calculator.error.OperatorErrorCode;


public enum OperatorsEnum {

	/**
	 * addition operator enum
	 */
	ADDITION("+"),

	/**
	 * subtraction operator enum
	 */
	SUBTRACTION("-"),

	/**
	 * multiplication operator enum
	 */
	MULTIPLICATION("*"),

	/**
	 * division operator enum
	 */
	DIVISION("/"),

	/**
	 * sqrt operator enum
	 */
	SQUARE_ROOT("sqrt"),

	/**
	 * undo operator enum
	 */
	UNDO("undo"),

	/**
	 * clear operator enum
	 */
	CLEAR("clear");

	OperatorsEnum(String code) {
		this.code = code;
	}
	
	private String code;

	
	public String getCode() {
		return this.code;
	}

	public static OperatorsEnum checkIsValidOperator(String userEntered) {
		for (OperatorsEnum operator : OperatorsEnum.values()) {
			if (operator.getCode().equalsIgnoreCase(userEntered)) {
				return operator;
			}
		}
		System.err.println(OperatorErrorCode.ILLEGAL_ARGUMENT.getCode());
		return null;
	}
}
