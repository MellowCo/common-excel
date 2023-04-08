/*
 * @Author: licl
 * @Date: 2023-04-06 14:33:20
 * @LastEditTime: 2023-04-06 16:10:08
 * @LastEditors: licl
 * @Description: 
 */
package com.licl.demo.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.licl.demo.domain.Score;

@Component
public class ScoreExcelStrategy extends AbstractExcelStrategy<Score> {

  @Override
  public List<Score> getExcelData() {
    // 获取excel数据
    List<Score> scoreExcelData = new ArrayList<Score>();

    scoreExcelData.add(new Score("A", "20分"));
    scoreExcelData.add(new Score("B", "100分"));

    return scoreExcelData;
  }

  @Override
  public String getExcelName() {
    return "SCORE_EXCEL";
  }
}
