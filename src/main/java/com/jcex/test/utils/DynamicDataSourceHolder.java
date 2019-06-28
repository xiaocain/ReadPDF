package com.jcex.test.utils;

/**
 * 动态数据源（设置数据源名称）
 *
 */
public class DynamicDataSourceHolder {
	
	private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	/**
	 * 设置数据源(用完之后要记得调用{@code removeDataSource}方法，删除与线程绑定的信息)
	 */
	public static void setDataSource(String dataSourceName) {
		threadLocal.set(dataSourceName);
    }

	/**
	 * 获取数据源
	 */
    public static String getDataSource() {
        return threadLocal.get();
    }

    /**
	 * 移除数据源
	 */
    public static void removeDataSource() {
    	threadLocal.remove();
    }

}
