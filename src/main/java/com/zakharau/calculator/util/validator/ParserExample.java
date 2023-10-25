package com.zakharau.calculator.util.validator;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ParserExample implements Validation<String> {

  public List<String> getExample(String example) {

    return Pattern.compile("[0-9.()+\\-*:]+")
        .matcher(example)
        .results()
        .map(MatchResult::group)
        .collect(Collectors.toList());
  }

  public boolean isValid(String example) {

    String regex = "^[^\\p{L}\\Q{!@#$%&,;?[]|<>~'/=}\\E]*$";
    return example.matches(regex);
  }
}

