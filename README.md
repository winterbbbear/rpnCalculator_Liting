## Rpn Calculator Using Stack data structure
- The project is commited in master branch, please clean and install mvn dependeny before running the demo.
- The main function is written in RpnCalculator.java class. When testing the examples in the pdf file, please run the main function in RpnCalculator.java file.
- There are also some test cases using powerMock framework inclueded in /test category.

### Requirements
- The calculator has a stack that can contain real numbers.
- The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and
operators.
- Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
- Available operators are +,
- -, *, /, sqrt, undo,
-  Operators pop their parameters off the stack, and push their results back onto the stack.
- The ‘clear’ operator removes all items from the stack.
- The ‘undo’ operator undoes the previous operation. “undo undo ” will undo the previo us two operations.
- sqrt performs a square root on the top item from the stack.
-  The ‘+’, ‘--’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from
the stack.
-  After processing an input string, the calculator displays the current contents of the stack as a space
separated list.
- Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or le
ss if it causes no loss of precision).
- All numbers should be formatted as plain decimal strings (ie . no engineering
- If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:operator <operator> (position: <pos>): insufficient parameters
- After displaying the warning, all further processing of the string terminates and the current state of the stack is display
ed.
