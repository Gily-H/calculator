package com.gilmango.calculator.utilities;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringEvaluator {

  public static String convertToPostFix(String expression) {
    StringBuilder builder = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    char[] letters = expression.toCharArray();

    for (char letter : letters) {
      if (Character.isDigit(letter) || letter == '.') {
        builder.append(letter);
      } else {
        if (!stack.isEmpty() || !hasHigherPrecedence(letter, stack.peek())) {  // high prec just push on stack
          builder.append(stack.pop());  // lower prec pop previous operator
        }
        stack.push(letter);
      }
    }

    return builder.toString();
  }


  public static boolean hasHigherPrecedence(char operator, char operatorToCompare) {
    boolean isHigher = false;

    if (operatorToCompare == '+' || operatorToCompare == '-')
      isHigher = operator == '*' || operator == '/';

    return isHigher;
  }

}
