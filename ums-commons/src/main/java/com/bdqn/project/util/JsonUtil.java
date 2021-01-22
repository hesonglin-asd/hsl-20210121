package com.bdqn.project.util;

import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * <b>JSON 转换工具类</b>
 * @author hsl
 * @version 5.0.0-final
 */
public class JsonUtil {

	/**
	 * <b>将对象转换为 JSON 格式字符串</b>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String parseToJson(Object obj) throws Exception {
		// 创建 JsonMapper 对象
		JsonMapper jsonMapper = new JsonMapper();
		// 使用 JsonMapper 对象将所给定的对象转换为 JSON 格式数据
		return jsonMapper.writeValueAsString(jsonMapper);
	}

	/**
	 * <b>根据所给定类型将 JSON 转换为该对象</b>
	 * @param json
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	public static Object parseToObject(String json, Class objClass) throws Exception {
		// 创建 JsonMapper 对象
		JsonMapper jsonMapper = new JsonMapper();
		// 将 JSON 切换为对象
		return jsonMapper.readValue(json, objClass);
	}
}
