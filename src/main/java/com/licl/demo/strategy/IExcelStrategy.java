package com.licl.demo.strategy;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.licl.demo.domain.ExcelField;
import com.licl.demo.domain.ExcelParam;

public interface IExcelStrategy {

  /**
   * 获取excel名称
   */
  String getExcelName();

  /**
   * 获取excel字段
   */
  List<ExcelField> getExcelFields();

  /**
   * 导出excel
   */
  void exportExcel(ExcelParam param, HttpServletResponse response);
}
