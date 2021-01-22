package com.bdqn.project.pojo.enums;

/**
 * <b>系统响应码枚举信息</b>
 * @author hsl
 * @version 5.0.0-final
 */
public enum RespCodeEnum {
	RESP_CODE_SUCCESS(EnumConstant.RESP_CODE_SUCCESS, "系统响应成功"),
	RESP_CODE_EXCEPTION(EnumConstant.RESP_CODE_EXCEPTION, "系统响应异常"),
	RESP_CODE_ERROR(EnumConstant.RESP_CODE_ERROR, "系统业务处理错误");

	private Integer code;                       // 响应码
	private String remark;                      // 响应码说明

	private RespCodeEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
