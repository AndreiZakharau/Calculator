package com.zakharau.calculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.zakharau.calculator.util.validator.ParserExample;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserExampleTest {

  private ParserExample parser;

  @BeforeEach
  void setUp() {
    parser = new ParserExample();
  }

  @Test
  void getExample() {

    String example = "34.5 + 12 - (-3.56) * 6.6 ghjkk bbhuihj";

    List<String> elements = parser.getExample(example);

    assertNotNull(elements);
    assertEquals(elements.size(), 7);
    assertEquals(elements.get(4), "(-3.56)");
  }

  @Test
  void isNotExample() {

    String example = "34.5 + 12 - (-3.56) * 6.6 ghjkk bbhuihj";

    boolean isNotExample = parser.isValid(example);

    assertFalse(isNotExample);
  }

  @Test
  void isExample() {

    String example = "34.5 + 12 - (-3.56) * 6.6";

    boolean isExample = parser.isValid(example);

    assertTrue(isExample);
  }

}