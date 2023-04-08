package com.licl.demo.domain;

import lombok.Data;

@Data
public class ExcelTask {
  /**
   * excel名称
   */
  private String excelName;

  /**
   * 下载地址
   */
  private String downloadUrl;

  /**
   * 操作人
   */
  private String operator;

  /**
   * 操作人ip
   */
  private String operatorIp;

  /**
   * 开始时间
   */
  private String creationTime;

  /**
   * 结束时间
   */
  private String endTime;

  /**
   * 状态
   */
  private String status;

  /**
   * 请求信息
   */
  private String requestInfo;

  /**
   * 异常信息
   */
  private String exceptionInfo;

  /**
   * 导出列
   */
  private String exportColumns;

}
