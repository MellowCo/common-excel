package com.licl.demo.factory;

import com.licl.demo.strategy.IExcelStrategy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExcelFactory {
    @Resource
    public List<IExcelStrategy> excelStrategyList;

    private final Map<String, IExcelStrategy> strategyMap = new HashMap<>();

    @PostConstruct
    public void registered() {
        /**
         * 通过excelName来区分不同的策略，通过 spring 将所有的策略注入到 strategyMap 中
         */
        excelStrategyList.forEach(strategy -> strategyMap.put(strategy.getExcelName(), strategy));
    }

    public IExcelStrategy getExcelStrategy(String excelName) {
        if (!strategyMap.containsKey(excelName)) {
            throw new RuntimeException("excelStrategy not found");
        }

        return strategyMap.get(excelName);
    }
}
