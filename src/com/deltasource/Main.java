package com.deltasource;

/**
 * Context:
 * A phrase consists of an opening clause(Uppercase alphabetic letter), optional internal phrase
 * and a closing clause(Lowercase alphabetic letter).
 * A valid expression must consist only of phrases, which are all properly closed using the same
 * alphabetic letter('a' closes 'A', 'b' closes 'B', etc..).
 * <p>
 * Task:
 * Write a function that receives an expression, which consists only of the clauses('a', 'A', 'b', 'B',
 * 'c', 'C') as a string or array of characters and returns a boolean representing if the expression is
 * valid or invalid.
 * <p>
 * Examples: input - output
 * AaBb - true
 * BCAacb - true
 * BCcAab - true
 * ACABbBbaca - true
 * AabB - false
 * BCAcaB - false
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("AaBb - " + isValidExpression("AaBb"));
        System.out.println("BCAacb - " + isValidExpression("BCAacb"));
        System.out.println("BCcAab - " + isValidExpression("BCcAab"));
        System.out.println("ACABbBbaca - " + isValidExpression("ACABbBbaca"));
        System.out.println("AabB - " + isValidExpression("AabB"));
        System.out.println("BCAcaB - " + isValidExpression("BCAcaB"));
        System.out.println("BBb - " + isValidExpression("BBb"));
        System.out.println("BBbb - " + isValidExpression("BBbb"));
        System.out.println("AaA - " + isValidExpression("AaA"));
        System.out.println("AsdAaa - " + isValidExpression("AsdAaa"));
    }

    static boolean isValidExpression(String expression) {
        if (expressionChecker(expression, "A", "a")) return false;
        if (expressionChecker(expression, "B", "b")) return false;
        if (expressionChecker(expression, "C", "c")) return false;

        return true;
    }

    static boolean expressionChecker(String expression, String openingClause, String closingClause) {
        while (expression.contains(openingClause) && expression.contains(closingClause)) {
            if (expression.indexOf(openingClause) > expression.indexOf(closingClause)) return true;
            expression = expression.replaceFirst(openingClause, "");
            expression = expression.replaceFirst(closingClause, "");
        }
        if (expression.indexOf(openingClause) != expression.indexOf(closingClause)) return true;

        return false;
    }
}