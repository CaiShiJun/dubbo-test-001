package com.tingyun.util;

/**
 *
 * ClassName: DynamicDataSourceInterceptor <br/>
 * Function: 数据源动态切换拦截器. <br/>
 * date: 2017年3月15日 下午10:28:17 <br/>
 *
 * @author JohnFNash
 * @version
 * @since JDK 1.6
 */
public class DynamicDataSourceInterceptor {
    /** 切换到数据源1 */
    public void setDS1() {
        DynamicDataSourceHolder.setDatasource("dataSourceDbcp");
    }

    /** 切换到数据源2 */
    public void setDS2() {
        DynamicDataSourceHolder.setDatasource("dataSourceC3p0");
    }

    /** 切换到数据源2 */
    public void setDS3() {
        DynamicDataSourceHolder.setDatasource("dataSourceHikari");
    }
}