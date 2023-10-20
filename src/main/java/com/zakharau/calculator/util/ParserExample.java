package com.zakharau.calculator.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ParserExample {

  public LinkedList<String> getExample(String example) {

    return (LinkedList<String>) Pattern.compile("[0-9.()+\\-*:]+")
        .matcher(example)
        .results()
        .map(MatchResult::group)
        .collect(Collectors.toList());
  }

  public boolean isNotExample(String example) {

    String regex = "^[^\\p{L}\\Q{!@#$%&,;?[]|<>~'/=}\\E]*$";
    return example.matches(regex);
  }
}
