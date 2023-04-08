package com.licl.demo.aop;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.licl.demo.annotation.ExcelExport;
import com.licl.demo.domain.ExcelField;
import com.licl.demo.domain.ExcelParam;
import com.licl.demo.enums.ExportType;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExcelAop {

  @Around(value = "@annotation(excelExport)")
  public Object around(ProceedingJoinPoint joinPoint, ExcelExport excelExport) throws Throwable {

    Object[] args = joinPoint.getArgs();
    HttpServletResponse response = null;
    ExcelParam excelParam = null;

    for (Object arg : args) {
      if (arg instanceof HttpServletResponse) {
        response = (HttpServletResponse) arg;
      } else if (arg instanceof ExcelParam) {
        excelParam = (ExcelParam) arg;
      }
    }

    if (response == null || excelParam == null) {
      throw new RuntimeException("HttpServletResponse 或 ExcelParam 不存在");
    }

    response.setCharacterEncoding("utf-8");

    if (ExportType.COLUMN.equals(excelParam.getExportType())) {
      // 返回 excel 列名
      List<ExcelField> excelFields = getExcelFields(excelExport);
      response.getWriter().write("该excel列名为: " + excelFields.toString());
    } else {
      // 具体导出excel的逻辑
      List<?> excelData = (List<?>) joinPoint.proceed();
      EasyExcel.write(response.getOutputStream(), excelExport.value()).sheet("模板").doWrite(excelData);
    }

    return null;
  }

  private List<ExcelField> getExcelFields(ExcelExport excelExport) {
    Class<?> clazz = excelExport.value();
    Field[] fields = clazz.getDeclaredFields();

    List<ExcelField> excelFields = new ArrayList<>();

    for (Field field : fields) {
      if (field.isAnnotationPresent(ExcelProperty.class)) {
        ExcelProperty excelProperty = AnnotationUtils.findAnnotation(field, ExcelProperty.class);
        String title = excelProperty == null ? "" : excelProperty.value()[0];
        String name = field.getName();

        excelFields.add(new ExcelField(title, name));
      }
    }

    return excelFields;
  }
}
