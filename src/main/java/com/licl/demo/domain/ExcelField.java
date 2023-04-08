package com.licl.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelField {

  /**
   * 导出的标题
   */
  private String title;

  /**
   * 导出的字段名
   */
  private String field;
}
