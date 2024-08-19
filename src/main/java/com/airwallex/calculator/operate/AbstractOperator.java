package com.airwallex.calculator.operate;

import com.airwallex.calculator.api.Calculate;

public interface AbstractOperator {

    void calculate (Calculate calculate);

    String getOperatorName();
}
