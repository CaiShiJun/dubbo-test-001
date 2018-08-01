package com.tingyun.util;

/**
 *
 * ClassName: DatabaseContextHolder <br/>
 * Function: 当前线程中使用的数据源标识 <br/>
 * date: 2017年3月15日 下午10:10:17 <br/>
 *
 * @author JohnFNash
 * @version
 * @since JDK 1.6
 */
public class DynamicDataSourceHolder {
    /** 数据源标识保存在线程变量中，避免多线程操作数据源时互相干扰 */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 设置数据源名称
     * 
     */
    public static void setDatasource(String datasource) {
        contextHolder.set(datasource);
    }

    /**
     * 获取数据源名称
     * @return 数据源名称
     */
    public static String getDatasource() {
        return contextHolder.get();
    }

    /**
     * 清除标志
     */
    public static void clearDatasource() {
        contextHolder.remove();
    }

}