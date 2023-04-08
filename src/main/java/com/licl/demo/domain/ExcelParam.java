package com.licl.demo.domain;

import com.licl.demo.enums.ExportType;

import lombok.Data;

@Data
public class ExcelParam {
  private String[] fields;
  private String excelName;
  private ExportType exportType;
}
