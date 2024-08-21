package com.airwallex.calculator.impl;

import com.airwallex.calculator.api.UserInput;
import com.airwallex.calculator.operate.AbstractOperator;
import com.airwallex.calculator.operate.digital.DigitalOperator;
import com.airwallex.calculator.factory.OperatorFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.*;


/**
 * implementation of UserInput api
 *
 * @author litingsheng
 * @date 2024/08/21
 */
public class DefaultUserInputImpl implements UserInput {

	private static final String REGEX_DIGIT_PATTERN = "^-*\\d+$";

	/**
	 * the input scanner
	 */
	private Scanner scanner;

	/**
	 * the input cursor
	 */
	private int position;

	public DefaultUserInputImpl(InputStream in) {
		this.scanner = new Scanner(in);
	}

	@Override
	public List<AbstractOperator> getUserInput() {
		List<AbstractOperator> userEntries = new ArrayList<>();
		String userEntered = scanner.nextLine();
		if (StringUtils.isNotEmpty(userEntered)) {
			String[] strings = userEntered.split(" ");
			for (String string : strings) {
				Optional<AbstractOperator> userEnter = this.constructUserInput(string);
				userEnter.ifPresent(userEntries::add);
			}
		}
		return userEntries;
	}

	@Override
	public int increaseScannerPosition(int step){
		position +=step;
		return position;
	}

	@Override
	public int getScannerPosition(){
		return position;
	}

	public Optional<AbstractOperator> constructUserInput(String userEntered) {
		Optional<AbstractOperator> userEntry = Optional.empty();
		
		if (StringUtils.isNotBlank(userEntered)) {
			if (userEntered.matches(REGEX_DIGIT_PATTERN)) {
				userEntry = Optional.of(getDigitalUserInput(userEntered));
			}
			else {
				userEntry = getOperatorUserInput(userEntered);
			}
		}
		return userEntry;
	}

	public Optional<AbstractOperator> getOperatorUserInput(String userEntered) {
		if(userEntered == null){
			return Optional.empty();
		}
		try {
			return OperatorFactory.getOperator(userEntered);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public AbstractOperator getDigitalUserInput(String userEntered) {
		if(userEntered == null){
			return null;
		}
		try {
			return new DigitalOperator(userEntered);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
