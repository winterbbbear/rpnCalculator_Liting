package com.airwallex.app.impl;

import com.airwallex.app.api.UserInput;
import com.airwallex.app.userInput.operator.AbstractOperator;
import com.airwallex.app.userInput.digital.DigitalOperator;
import com.airwallex.app.userInput.factory.OperatorFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.*;


public class DefaultUserInputImpl implements UserInput {

	private static final String REGEX_DIGIT_PATTERN = "^-*\\d+$";

	private Scanner scanner;

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
				if (userEnter.isPresent()) {
					userEntries.add(userEnter.get());
				}
			}
		}
		return userEntries;
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

	protected AbstractOperator getDigitalUserInput(String userEntered) {
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
