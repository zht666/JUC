package com.zht.enums;

//定义 遍历 使用
public enum CountryEnums {
	ONE(1, "韩"), TWO(2, "魏"), THREE(3, "赵"), FOUR(4, "齐"), FIVE(5, "楚"), SIX(6, "燕");

	private Integer retCode;// 返回的是值，key
	private String retMsg; // 返回的是消息，value

	private CountryEnums(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	public static CountryEnums forEachCountryEnums(Integer index) {
		for (CountryEnums element : values()) {
			if(element.getRetCode() == index) {
				return element;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
