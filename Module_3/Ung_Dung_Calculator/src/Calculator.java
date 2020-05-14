public class Calculator {
    public float calculate(float operand1, float operand2, String operator) {
        float result = 0.0f;
        if (operator.equals("add")) {
            result = operand1 + operand2;
        } else if (operator.equals("sub")) {
            result = operand1 - operand2;
        } else if (operator.equals("multi")) {
            result = operand1 * operand2;
        } else {
            try {
                result = operand1 / operand2;
                if (operand2 == 0) {
                    throw new ArithmeticException("Exception by zero !!!");
                }
            } catch (ArithmeticException ex2) {
                ex2.printStackTrace();
            }
        }
        return result;
    }
}
