package calculator.domain;

import calculator.domain.operator.OperatorType;

import java.util.List;

public class Calculator {
    private final int START_POINT = 1;
    private final List<String> elements;
    private int point;


    public Calculator(List<String> elements) {
        this.elements = elements;
    }

    public int calculate() {
        int result = Digit.of(elements.get(point)).getNum();
        point = START_POINT;
        while (point < elements.size()) {
            validateCalculate();
            result = OperatorType.of(getOperator()).calculate(result, getNextDigit().getNum());
            moveNextPoint();
        }
        return result;
    }

    private String getOperator() {
        return elements.get(point);
    }

    private Digit getNextDigit() {
        return Digit.of(elements.get(point + 1));
    }

    private void moveNextPoint() {
        point += 2;
    }

    private void validateCalculate() {
        if ((point + 1) == elements.size()) {
            throw new IllegalArgumentException("비정상적인 연산입니다.");
        }
    }
}
