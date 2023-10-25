package com.zakharau.calculator.util.validator;

import java.io.File;
import org.springframework.stereotype.Component;

@Component
public class FailValidator implements Validation<String> {

  public boolean isValid(String filePath) {
    if (filePath == null || filePath.isEmpty()) {
      throw new IllegalArgumentException("Incorrect file path");
    }

    File file = new File(filePath);

    if (!file.exists() || !file.isFile()) {
      throw new IllegalArgumentException("File does not exist or is not a file");
    }

    if (!filePath.endsWith(".txt")) {
      throw new IllegalArgumentException("File extension should be .txt");
    }

    return true;
  }

}
