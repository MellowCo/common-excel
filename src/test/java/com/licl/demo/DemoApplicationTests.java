package com.licl.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.licl.demo.factory.ExcelFactory;
import com.licl.demo.strategy.IExcelStrategy;
import com.licl.demo.strategy.ScoreExcelStrategy;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	ExcelFactory excelFactory;

	@Test
	void testExcelStrategy() {
		IExcelStrategy scoreExcelStrategy = new ScoreExcelStrategy();

		scoreExcelStrategy.getExcelFields();

	}

}
