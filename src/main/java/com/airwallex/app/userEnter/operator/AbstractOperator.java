package com.airwallex.app.userEnter.operator;

import com.airwallex.app.api.Calculate;

public interface AbstractOperator {

    void calculate (Calculate calculate);

    String getOperatorName();
}
