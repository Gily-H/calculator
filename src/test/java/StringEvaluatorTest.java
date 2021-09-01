import static org.assertj.core.api.Assertions.assertThat;

import com.gilmango.calculator.utilities.StringEvaluator;
import org.junit.jupiter.api.Test;

public class StringEvaluatorTest {

  @Test
  public void hasHigherPrecedenceTest() {
    char lower = '+';
    char lower2 = '-';
    char higher = '*';
    char higher2 = '/';

    assertThat(StringEvaluator.hasHigherPrecedence(lower, higher)).isFalse();
    assertThat(StringEvaluator.hasHigherPrecedence(lower, lower2)).isFalse();
    assertThat(StringEvaluator.hasHigherPrecedence(higher, lower)).isTrue();
    assertThat(StringEvaluator.hasHigherPrecedence(higher, higher2)).isFalse();
  }
}
