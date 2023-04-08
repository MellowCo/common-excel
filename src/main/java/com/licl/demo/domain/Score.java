package com.licl.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
  @ExcelProperty("积分类型")
  private String type;

  @ExcelProperty("兑换积分")
  private String score;
}
