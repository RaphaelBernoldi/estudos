package br.com.poc.model.enums;

public enum EnumStatusJobCruzeiro {

	  ATIVO("A")
	, INATIVO("I");
	
	private String desc;

	private EnumStatusJobCruzeiro(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
}
