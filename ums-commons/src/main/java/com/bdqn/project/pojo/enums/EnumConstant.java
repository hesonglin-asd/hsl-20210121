package com.bdqn.project.pojo.enums;

import java.util.Properties;

/**
 * <b>枚举信息常量类</b>
 * @author hsl
 * @version 5.0.0-final
 */
class EnumConstant {
	private static Properties props = new Properties();

	static {
		try {
			props.load(EnumConstant.class.getClassLoader().getResourceAsStream("props/enums.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统响应码：系统响应成功</b>
	 */
	static final Integer RESP_CODE_SUCCESS = Integer.parseInt(props.getProperty("resp.code.success"));

	/**
	 * <b>系统响应码：系统响应异常</b>
	 */
	static final Integer RESP_CODE_EXCEPTION = Integer.parseInt(props.getProperty("resp.code.exception"));

	/**
	 * <b>系统响应码：系统业务处理错误</b>
	 */
	static final Integer RESP_CODE_ERROR = Integer.parseInt(props.getProperty("resp.code.error"));
}
