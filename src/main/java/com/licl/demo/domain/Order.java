
package com.licl.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order {
  @ExcelProperty("客户名称")
  private String customername;

  @ExcelProperty("小区名称")
  private String communityname;
}
