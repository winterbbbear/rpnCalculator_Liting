package com.airwallex.calculator.operate;

import com.airwallex.calculator.api.Calculate;

/**
 * Interface of all operation implements.
 *
 * @author litingsheng
 * @date 2024/08/20
 */
public interface AbstractOperator {

    /**
     * Implements operation including digital operators as addition, division,
     * multiplication,square root and subtraction. The function also implements
     * functional operation such as clear and undo.
     *
     * @param  calculate calculation object
     * @return
     */
    void calculate (Calculate calculate);


    /**
     * Get detailed operatorName of the operator
     *
     * @return operatorName
     */
    String getOperatorName();
}
