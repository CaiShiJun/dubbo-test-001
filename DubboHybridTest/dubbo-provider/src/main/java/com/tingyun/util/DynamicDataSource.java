package com.tingyun.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *
 * ClassName: DynamicDataSource <br/>
 * Function: 扩展Spring的AbstractRoutingDataSource抽象类，实现动态数据源. <br/>
 * date: 2017年3月15日 下午10:23:52 <br/>
 *
 * @author JohnFNash
 * @version
 * @since JDK 1.6
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 从自定义的位置获取数据源标识
        System.out.println("从自定义的位置获取数据源标识："+DynamicDataSourceHolder.getDatasource());
        return DynamicDataSourceHolder.getDatasource();
    }

}