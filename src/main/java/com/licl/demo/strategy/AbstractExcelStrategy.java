package com.licl.demo.strategy;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.licl.demo.domain.ExcelField;
import com.licl.demo.domain.ExcelParam;

public abstract class AbstractExcelStrategy<T> implements IExcelStrategy {

  abstract List<T> getExcelData();

  @Override
  public final void exportExcel(ExcelParam param, HttpServletResponse response) {
    List<T> excelData = getExcelData();
    // 处理需要导出的字段
    System.out.println("需要导出的字段: " + Arrays.toString(param.getFields()));

    try {
      // 具体导出excel的逻辑
      // 获取泛型的class
      ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
      Class<?> TClass = (Class<?>) type.getActualTypeArguments()[0];
      EasyExcel.write(response.getOutputStream(), TClass).sheet("模板").doWrite(excelData);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public final List<ExcelField> getExcelFields() {
    // 获取泛型的class
    ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
    Class<?> TClass = (Class<?>) type.getActualTypeArguments()[0];

    List<ExcelField> excelFields = new ArrayList<>();

    // 获取所有字段
    Field[] fields = TClass.getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(ExcelProperty.class)) {
        System.out.println(field.getName());
        ExcelProperty excelProperty = AnnotationUtils.findAnnotation(field, ExcelProperty.class);
        excelFields.add(new ExcelField(excelProperty == null ? "" : excelProperty.value()[0], field.getName()));
      }
    }

    return excelFields;
  }
}
