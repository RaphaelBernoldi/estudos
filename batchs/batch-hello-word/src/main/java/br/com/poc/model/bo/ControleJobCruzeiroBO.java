package br.com.poc.model.bo;

import br.com.poc.model.enums.EnumStatusJobCruzeiro;

public class ControleJobCruzeiroBO {

	private String name;
	
	private EnumStatusJobCruzeiro status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumStatusJobCruzeiro getStatus() {
		return status;
	}

	public void setStatus(EnumStatusJobCruzeiro status) {
		this.status = status;
	}
}
