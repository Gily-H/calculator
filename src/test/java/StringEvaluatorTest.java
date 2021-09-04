import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.gilmango.calculator.utilities.StringEvaluator;
import org.junit.jupiter.api.Test;

public class StringEvaluatorTest {

  @Test
  public void calculate_expression_with_no_parenthesis() {
    // GIVEN
    String expression = "3*5+5-2";

    // WHEN
    double actual = StringEvaluator.calculateExpression(expression);
    double expected= 18;

    // THEN
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculate_expression_with_parenthesis() {
    // GIVEN
    String expression = "3*(5+5)-2";

    // WHEN
    double actual = StringEvaluator.calculateExpression(expression);
    double expected = 28;

    // THEN
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculate_expression_with_spaces() {
    // GIVEN
    String expression = "1 + 2 * 4 / 2";

    // WHEN
    double actual = StringEvaluator.calculateExpression(expression);
    double expected = 5;

    // THEN
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculate_expression_with_decimals_returns_value_with_decimal() {
    // GIVEN
    String expression = "(25.5*3)/(2.3*3.2)+99.9";

    // WHEN
    double expected = 110.29402173913044;   // note this number has been rounded

    // THEN
    assertThat(StringEvaluator.calculateExpression(expression)).isEqualTo(expected);
  }

  @Test
  public void calculate_expression_with_no_operators_returns_number() {
    // GIVEN
    String expression = "3489";

    // WHEN
    double actual = StringEvaluator.calculateExpression(expression);
    double expected = 3489;

    // THEN
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void expression_with_consecutive_operators_throws_illegalArgument_exception() {
    // GIVEN
    String expression = "10*/2";

    // THEN
    assertThatIllegalArgumentException()
        .isThrownBy(() -> StringEvaluator.calculateExpression(expression))
        .withMessageContaining("Invalid number of operands available");
  }

  @Test
  public void empty_expression_throws_illegalArgument_exception() {
    // GIVEN
    String expression = "";

    // THEN
    assertThatIllegalArgumentException()
        .isThrownBy(() -> StringEvaluator.calculateExpression(expression))
        .withMessage("Expression can not be empty");
  }

  @Test
  public void null_expression_throws_illegalArgument_exception() {
    String expression = null;

    // THEN
    assertThatIllegalArgumentException()
        .isThrownBy(() -> StringEvaluator.calculateExpression(expression))
        .withMessage("Expression can not be empty");
  }

  @Test
  public void divide_by_zero_throws_arithmetic_exception() {
    // GIVEN
    String expression = "1/0";

    // THEN
    assertThatExceptionOfType(ArithmeticException.class)
        .isThrownBy(() -> StringEvaluator.calculateExpression(expression))
        .withMessage("Division by zero!");
  }
}
