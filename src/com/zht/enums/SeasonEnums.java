package com.zht.enums;

//定义 遍历 使用
public enum SeasonEnums {
	ONE(1, "spring"), TWO(2, "summer"), THREE(3, "autumn"), FOUR(4, "winner");

	private Integer retCode;// 返回的是值，key
	private String retMsg; // 返回的是消息，value

	private SeasonEnums(Integer retCode, String retMsg) {
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
	
	public static SeasonEnums forEachSeasonEnums(Integer index) {
		for (SeasonEnums element : values()) {
			if(element.getRetCode() == index) {
				return element;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
