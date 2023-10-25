package com.zakharau.calculator.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadModel extends ActionModel{

  @NotBlank(message = "Field example shouldn't be empty, null, contain only figures and signs of action")
  private String example;
  private String inputFile;
}
