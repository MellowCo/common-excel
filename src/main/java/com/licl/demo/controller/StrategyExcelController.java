package com.licl.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.licl.demo.domain.ExcelField;
import com.licl.demo.domain.ExcelParam;
import com.licl.demo.factory.ExcelFactory;

/**
 * 策略导出模式
 */
@RequestMapping("/strategy")
@RestController
public class StrategyExcelController {

  @Resource
  private ExcelFactory excelFactory;

  /**
   * 获取 excel fields
   */
  @GetMapping("/fields")
  public List<ExcelField> getExcelFields(String excelName) {
    List<ExcelField> excelFields = excelFactory.getExcelStrategy(excelName).getExcelFields();
    return excelFields;
  }

  /**
   * 导出 excel
   */
  @PostMapping("/export")
  public void exportExcel(@RequestBody ExcelParam param, HttpServletResponse response) {
    excelFactory.getExcelStrategy(param.getExcelName()).exportExcel(param, response);
  }
}
