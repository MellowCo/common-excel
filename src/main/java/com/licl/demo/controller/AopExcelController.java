package com.licl.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.licl.demo.annotation.ExcelExport;
import com.licl.demo.domain.ExcelParam;
import com.licl.demo.domain.Order;

@RestController
@RequestMapping("/aop")
public class AopExcelController {
  /**
   * 导出 excel
   */
  @PostMapping("/export")
  @ExcelExport(Order.class)
  public List<Order> exportExcelAop(@RequestBody ExcelParam param, HttpServletResponse response) {

    // 模拟从数据库中获取数据
    List<Order> orderExcelData = new ArrayList<Order>();
    orderExcelData.add(new Order("小区1", "客户1"));
    orderExcelData.add(new Order("小区2", "客户2"));

    return orderExcelData;
  }
}
