package com.licl.demo.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.licl.demo.domain.Order;

@Component
public class OrderExcelStrategy extends AbstractExcelStrategy<Order> {

  @Override
  public List<Order> getExcelData() {
    // 获取excel数据
    List<Order> orderExcelData = new ArrayList<Order>();

    orderExcelData.add(new Order("小区1", "客户1"));
    orderExcelData.add(new Order("小区2", "客户2"));

    return orderExcelData;
  }

  @Override
  public String getExcelName() {
    return "ORDER_EXCEL";
  }
}
