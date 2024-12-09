package fr.ensicaen.tp1;

import org.mariuszgromada.math.mxparser.Expression;

public class Calculator {

    public static String calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Error";
        }
        Expression exp = new Expression(input);
        double result = exp.calculate();
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            return "Error";
        }
        return String.valueOf(result);
    }
}
