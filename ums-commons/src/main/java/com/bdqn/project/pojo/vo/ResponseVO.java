package com.bdqn.project.pojo.vo;

import com.bdqn.project.pojo.enums.RespCodeEnum;

import java.io.Serializable;

/**
 * <b>系统响应视图</b>
 * @param <E>
 * @author hsl
 * @version 5.0.0-final
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -228128204773274542L;
	private Integer code;                       // 系统响应码
	private E data;                             // 系统响应数据

	private ResponseVO(Integer code) {
		this.code = code;
	}

	private ResponseVO(Integer code, E data) {
		this.code = code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得响应成功视图对象</b>
	 * @return
	 */
	public static ResponseVO getSuccessResponseVO() {
		return new ResponseVO(RespCodeEnum.RESP_CODE_SUCCESS.getCode());
	}

	/**
	 * <b>获得响应成功视图对象</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getSuccessResponseVO(Object data) {
		return new ResponseVO(RespCodeEnum.RESP_CODE_SUCCESS.getCode(), data);
	}

	/**
	 * <b>获得响应异常视图对象</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getExceptionResponseVO(Object data) {
		return new ResponseVO(RespCodeEnum.RESP_CODE_EXCEPTION.getCode(), data);
	}

	/**
	 * <b>获得系统业务处理错误视图对象</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO getErrorResponseVO(Object data) {
		return new ResponseVO(RespCodeEnum.RESP_CODE_ERROR.getCode(), data);
	}
}
