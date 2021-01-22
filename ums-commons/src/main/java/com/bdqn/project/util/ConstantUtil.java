package com.bdqn.project.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author hsl
 * @version 5.0.0-final
 */
public class ConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("props/ums.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：默认当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页信息：默认每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));

	/**
	 * <b>校验正则表达式：手机号码</b>
	 */
	public static final String REGEX_CELLPHONE = props.getProperty("regex.cellphone");
}
