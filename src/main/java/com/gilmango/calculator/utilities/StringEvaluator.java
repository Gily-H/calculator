package com.gilmango.calculator.utilities;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class StringEvaluator {

  public static double calculateExpression(String expression) {
    Expression exp = new ExpressionBuilder(expression).build();

    return exp.evaluate();
  }

}
