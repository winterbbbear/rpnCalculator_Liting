package com.airwallex.app.userInput.operator;

import com.airwallex.app.api.Calculate;

public interface AbstractOperator {

    void calculate (Calculate calculate);

    String getOperatorName();
}
