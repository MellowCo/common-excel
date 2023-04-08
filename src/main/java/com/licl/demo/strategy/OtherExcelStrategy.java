package com.licl.demo.strategy;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.licl.demo.domain.ExcelField;
import com.licl.demo.domain.ExcelParam;

@Component
public class OtherExcelStrategy implements IExcelStrategy {

    @Override
    public List<ExcelField> getExcelFields() {
        // 自定义获取 excel 字段
        return null;
    }

    @Override
    public void exportExcel(ExcelParam param, HttpServletResponse response) {
        // 获取 excel 数据
        String data = "其他Excel数据";

        System.out.println("导出字段: " + param.getExcelName());

        // 导出excel
        System.out.println("导出数据: " + data);
    }

    @Override
    public String getExcelName() {
        return "OTHER_EXCEL";
    }
}
